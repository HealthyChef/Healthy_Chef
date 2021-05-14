package com.example.healthy_chef;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView tvRecipeName;
    TextView tvSummary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvRecipeName = findViewById(R.id.tvRecipeName);
        tvSummary = findViewById(R.id.tvSummary);

        String title = getIntent().getStringExtra("title");
        tvRecipeName.setText(title);
    }
}