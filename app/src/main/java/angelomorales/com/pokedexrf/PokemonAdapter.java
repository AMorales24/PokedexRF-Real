package angelomorales.com.pokedexrf;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import angelomorales.com.pokedexrf.models.Pokemon;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonHolder> {

    private List<String> mPokemonList;

    public PokemonAdapter(List<String> PokemonList) {
        mPokemonList = PokemonList;
    }

    @Override
    public PokemonHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View pokemonView = inflater.inflate(R.layout.list_item, parent, false);

        PokemonHolder PokemonHolder = new PokemonHolder(pokemonView);

        return PokemonHolder;
    }

    @Override
    public void onBindViewHolder(PokemonAdapter.PokemonHolder pokemonHolder, int position) {
        String pokemon = mPokemonList.get(position);

        TextView nameTextView = pokemonHolder.PokemonNameTextView;
        nameTextView.setText(pokemon);

    }

    @Override
    public int getItemCount() {
        return mPokemonList.size();
    }

    public class PokemonHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView PokemonNameTextView;


        public PokemonHolder(View itemView) {
            super(itemView);
            PokemonNameTextView = (TextView)itemView.findViewById(R.id.pokemon_name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            String pokemon = mPokemonList.get(getLayoutPosition());
            Intent intent = new Intent(itemView.getContext(), PokemonDetailActivity.class);
            intent.putExtra(PokemonListActivity.POKEMON_EXTRA, pokemon);
            itemView.getContext().startActivity(intent);
        }

    }



}
