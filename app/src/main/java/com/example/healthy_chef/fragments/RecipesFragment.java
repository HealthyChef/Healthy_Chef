package com.example.healthy_chef.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.RequestParams;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.example.healthy_chef.R;
import com.example.healthy_chef.Recipe;
import com.example.healthy_chef.RecipesAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Headers;

public class RecipesFragment extends Fragment {

    private static final String API_KEY = "fb54b8db6cad4ad8aa8364a39fbed489";
    public static final String RANDOM_RECIPE_URL = "https://api.spoonacular.com/recipes/random";
    public static final String TAG = "RecipesFragment";
    private RecyclerView rvRecipes;
    private RecipesAdapter adapter;
    private List<Recipe> allRecipes;

    public RecipesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvRecipes = view.findViewById(R.id.rvRecipes);
        allRecipes = new ArrayList<>();
        adapter = new RecipesAdapter(getContext(), allRecipes);
        rvRecipes.setAdapter(adapter);
        rvRecipes.setLayoutManager(new LinearLayoutManager(getContext()));
        fetchData();
    }

    private void fetchData() {
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.put("apiKey", API_KEY);
        params.put("number", 5);
        client.get(RANDOM_RECIPE_URL, params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Headers headers, JSON json) {
                Log.d(TAG, "onSuccess" + json.toString());
                JSONObject jsonObject = json.jsonObject;
                try {
                    JSONArray results = jsonObject.getJSONArray("recipes");
                    Log.i(TAG, "Results: " + results.toString());
                    allRecipes.addAll(Recipe.fromJsonArray(results));
                    adapter.notifyDataSetChanged();
                    Log.i(TAG, "Recipes: " + allRecipes.size());
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