package com.example.healthy_chef;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.RequestParams;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.example.healthy_chef.fragments.RecipesFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Headers;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button b_logout;
    EditText et_email, et_name;

    private BottomNavigationView bottomNavigationView;
    final FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        RecyclerView rvRecipes = findViewById(R.id.rvRecipes);
        recipes = new ArrayList<>();
        final RecipesAdapter recipesAdapter = new RecipesAdapter(this, recipes);
        rvRecipes.setAdapter(recipesAdapter);
        rvRecipes.setLayoutManager(new LinearLayoutManager(this));
*/

        //et_email = (EditText) findViewById(R.id.et_email);
        //et_name = (EditText) findViewById(R.id.et_name);
        b_logout = (Button) findViewById(R.id.b_logout);
        b_logout.setOnClickListener(this);

        bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment = null;
                switch (menuItem.getItemId()) {
                    case R.id.action_home: //RecipesFragment
                        Toast.makeText(MainActivity.this, "Home!", Toast.LENGTH_SHORT).show();
                        fragment = new RecipesFragment();
                        break;
                    case R.id.action_compose:
                        // TODO: Update fragment - search? Change the id names later on.
                        Toast.makeText(MainActivity.this, "Compose!", Toast.LENGTH_SHORT).show();
                        fragment = new RecipesFragment();
                        break;
                    case R.id.action_profile:
                        // TODO: Update fragment - profile. Change the id names later on.
                        Toast.makeText(MainActivity.this, "Profile!", Toast.LENGTH_SHORT).show();
                        fragment = new RecipesFragment();
                    default:
                        break;
                    }
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
                return true;
            }
        });
        // Set default selection
        bottomNavigationView.setSelectedItemId(R.id.action_home);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.b_logout:
                startActivity(new Intent(this, Login.class));
                break;
        }
    }
}