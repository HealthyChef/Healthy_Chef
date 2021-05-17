package com.example.healthy_chef;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.parceler.Parcels;

public class DetailActivity extends AppCompatActivity {

    TextView tvTitle;
    TextView tvSummary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvTitle = findViewById(R.id.tvTitle);
        tvSummary = findViewById(R.id.tvSummary);

        Recipe recipe = Parcels.unwrap(getIntent().getParcelableExtra("recipe"));
        tvTitle.setText(recipe.getTitle());
        tvSummary.setText(recipe.getSummary());
    }
}