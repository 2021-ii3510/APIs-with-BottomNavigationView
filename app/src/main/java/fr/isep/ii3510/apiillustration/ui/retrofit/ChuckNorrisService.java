package fr.isep.ii3510.apiillustration.ui.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ChuckNorrisService {
    @GET("jokes/random")
    Call<Joke> randomJoke();
}
