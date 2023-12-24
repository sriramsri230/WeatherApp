package com.example.indiasateliteweather;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.myapplication.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class AboutPageViewerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_page_viewer);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("India Satellite Map");
        actionBar.setSubtitle("Indian Maps Only");

        BottomNavigationView bottomNavigationView =findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.about);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int itemId = item.getItemId();

                if (itemId == R.id.about) {
                    startActivity(new Intent(getApplicationContext(), AboutPageViewerActivity.class));
                    overridePendingTransition(0, 0);
                }
                else if (itemId == R.id.map) {
                    startActivity(new Intent(getApplicationContext(), MapDisplayActivity.class));
                    overridePendingTransition(0, 0);
                }

                return false;
            }
        });

    }
}