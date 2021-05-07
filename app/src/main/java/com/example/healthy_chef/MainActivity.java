package com.example.healthy_chef;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b_logout;
    EditText et_email, et_name;

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //et_email = (EditText) findViewById(R.id.et_email);
        //et_name = (EditText) findViewById(R.id.et_name);
        b_logout = (Button) findViewById(R.id.b_logout);

        b_logout.setOnClickListener(this);

        bottomNavigationView = findViewById(R.id.bottomNavigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_home:
                    Toast.makeText(MainActivity.this, "Home!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.action_compose:
                    Toast.makeText(MainActivity.this, "Compose!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.action_profile:
                    Toast.makeText(MainActivity.this, "Profile!", Toast.LENGTH_SHORT).show();
                default:
                    break;
            }
            return true;
            }
        });
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