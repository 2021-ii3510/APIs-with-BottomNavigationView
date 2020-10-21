package fr.isep.ii3510.apiillustration.ui.volley;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import fr.isep.ii3510.apiillustration.R;

public class VolleyFragment extends Fragment {

    public VolleyFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_volley, container, false);
        final TextView jokeIdTextView = viewGroup.findViewById(R.id.volley_joke_id_textView);
        final TextView jokeContentTextView = viewGroup.findViewById(R.id.volley_joke_textView);

        String url = "https://api.icndb.com/jokes/random";
        RequestQueue queue = Volley.newRequestQueue(getContext());
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject value = response.getJSONObject("value");
                    jokeIdTextView.setText(getString(R.string.joke_id) + " " + value.getString("id"));
                    jokeContentTextView.setText(getString(R.string.joke_content) + " " + value.getString("joke"));
                    Log.d("Volley response", value.getString("joke"));
                } catch (JSONException e) {
                    Log.d("Volley response", "An error occurred.");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Volley response", "An error occurred.");
            }
        });

        queue.add(request);

        return viewGroup;
    }
}