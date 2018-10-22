package angelomorales.com.pokedexrf.networking;

import angelomorales.com.pokedexrf.models.Pokemon;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GetPokemonClientService {
    @GET("api/v2/pokemon/{name}")
    Call<Pokemon> getPokemon(@Path("name") String name);
}
