package fr.isep.ii3510.apiillustration.ui.retrofit;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import fr.isep.ii3510.apiillustration.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFragment extends Fragment {
    public RetrofitFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_retrofit, container, false);
        TextView jokeIdTextView = viewGroup.findViewById(R.id.retrofit_joke_id);
        TextView jokeContentTextView = viewGroup.findViewById(R.id.retrofit_joke_content);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.icndb.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ChuckNorrisService service = retrofit.create(ChuckNorrisService.class);
        service.randomJoke().enqueue(new Callback<Joke>() {
            @Override
            public void onResponse(Call<Joke> call, Response<Joke> response) {
                jokeIdTextView.setText(getString(R.string.joke_id) + " " + response.body().getValue().getId());
                jokeContentTextView.setText(getString(R.string.joke_content) + " " + response.body().getValue().getJoke());
            }

            @Override
            public void onFailure(Call<Joke> call, Throwable t) {
                Log.d("Retrofit", "An error occurred");
            }
        });

        return viewGroup;
    }
}