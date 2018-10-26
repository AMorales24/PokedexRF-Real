package angelomorales.com.pokedexrf;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PokemonListActivity extends AppCompatActivity {

    public static final String POKEMON_EXTRA = "com.angelomorales.PokedexRF.POKEMON_EXTRA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_list);


        List<String> pokemonList = new ArrayList<>();

        pokemonList.add("pikachu");
        pokemonList.add("bulbasaur");
        pokemonList.add("charizard");
        pokemonList.add("gengar");
        pokemonList.add("haunter");

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.poke_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(PokemonListActivity.this));
        PokemonAdapter adapter = new PokemonAdapter(pokemonList);
        recyclerView.setAdapter(adapter);
    }
}
