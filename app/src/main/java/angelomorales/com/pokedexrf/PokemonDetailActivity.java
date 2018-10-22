package angelomorales.com.pokedexrf;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

import java.util.List;

import angelomorales.com.pokedexrf.models.Pokemon;
import angelomorales.com.pokedexrf.networking.GetPokemonClientService;
import angelomorales.com.pokedexrf.networking.PokemonClientReference;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokemonDetailActivity extends AppCompatActivity{

    private TextView mNameTextView;
    private TextView mWeightTextView;
    private TextView mHeightTextView;
    //private TextView mAttackTextView;
    //private TextView mSPTextView;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_detail);

        final String pokemonName = getIntent().getStringExtra(PokemonListActivity.POKEMON_EXTRA);

        mNameTextView = (TextView)findViewById(R.id.pokemon_name);
        mHeightTextView = (TextView)findViewById(R.id.pokemon_height);
        mWeightTextView = (TextView)findViewById(R.id.pokemon_weight);
        //mAttackTextView = (TextView)findViewById(R.id.pokemon_attack);
        //mSPTextView = (TextView)findViewById(R.id.pokemon_sp);
        mImageView = (ImageView)findViewById(R.id.pokemon_photo);

        GetPokemonClientService service = PokemonClientReference.getRetrofitInstance().create(GetPokemonClientService.class);
        Call<Pokemon> call = service.getPokemon(pokemonName);

        call.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                Pokemon pokemon = response.body();

                Picasso.Builder builder = new Picasso.Builder( PokemonDetailActivity.this);
                builder.downloader(new OkHttp3Downloader(PokemonDetailActivity.this));
                builder.build().load(pokemon.sprites.frontDefault);

                mNameTextView.setText("Name: " + pokemon.name);
                mHeightTextView.setText("Height: " + pokemon.height);
                mWeightTextView.setText("Weight: "  +pokemon.weight);
              //  mAttackTextView.setText("Attack: " + pokemon.attack);
               // mSPTextView.setText("Special: " + pokemon.sp);
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                Toast.makeText(PokemonDetailActivity.this, "Error getting the data", Toast.LENGTH_SHORT);

            }
        });
    }
}
