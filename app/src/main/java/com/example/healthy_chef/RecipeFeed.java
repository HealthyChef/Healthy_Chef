package com.example.healthy_chef;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.RequestParams;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import okhttp3.Headers;

public class RecipeFeed extends AppCompatActivity {

    private static final String API_KEY = "fb54b8db6cad4ad8aa8364a39fbed489";
    public static final String RANDOM_RECIPE_URL = "https://api.spoonacular.com/recipes/random?apiKey" + API_KEY;
    public static final String TAG = "RecipeFeed";
    List<Recipe> recipes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_feed);

        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.put("number", 20);
        client.get(RANDOM_RECIPE_URL, params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Headers headers, JSON json) {
                Log.d(TAG, "onSuccess");
                JSONObject jsonObject = json.jsonObject;
                try {
                    JSONArray results = jsonObject.getJSONArray("recipes");
                    Log.i(TAG, "Results: " + results.toString());
                    recipes = Recipe.fromJsonArray(results);
                    Log.i(TAG, "Recipes: " + recipes.size());
                } catch (JSONException e) {
                    Log.e(TAG, "JSON exception", e);
                }
            }

            @Override
            public void onFailure(int i, Headers headers, String s, Throwable throwable) {
                Log.d(TAG, "onFailure");

            }
        });
    }
}