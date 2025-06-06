package com.example.recipehubmaincontainer;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TabLayout categoryTabs;
    private BottomNavigationView bottomNavBar;

    // PUBLIC_INTERFACE
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupCategoryTabs();
        setupBottomNavigation();
        // Future: Setup RecyclerView, Search Logic, Fragments/Nav for Details, etc.
    }

    // PUBLIC_INTERFACE
    private void setupCategoryTabs() {
        categoryTabs = findViewById(R.id.categoryTabs);
        categoryTabs.addTab(categoryTabs.newTab().setText(getString(R.string.breakfast)));
        categoryTabs.addTab(categoryTabs.newTab().setText(getString(R.string.lunch)));
        categoryTabs.addTab(categoryTabs.newTab().setText(getString(R.string.dinner)));
        categoryTabs.addTab(categoryTabs.newTab().setText(getString(R.string.desserts)));
        // Add more as needed

        categoryTabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // TODO: Filter recipes by category
                Toast.makeText(MainActivity.this, "Selected: " + tab.getText(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) { }

            @Override
            public void onTabReselected(TabLayout.Tab tab) { }
        });
    }

    // PUBLIC_INTERFACE
    private void setupBottomNavigation() {
        bottomNavBar = findViewById(R.id.bottomNavBar);
        bottomNavBar.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.nav_home) {
                    // TODO: Show main recipe grid
                    Toast.makeText(MainActivity.this, getString(R.string.home), Toast.LENGTH_SHORT).show();
                    return true;
                } else if (id == R.id.nav_favorites) {
                    // TODO: Show favorites
                    Toast.makeText(MainActivity.this, getString(R.string.favorites), Toast.LENGTH_SHORT).show();
                    return true;
                } else if (id == R.id.nav_collections) {
                    // TODO: Show recipe collections
                    Toast.makeText(MainActivity.this, getString(R.string.collections), Toast.LENGTH_SHORT).show();
                    return true;
                } else if (id == R.id.nav_profile) {
                    // TODO: Show user profile/settings
                    Toast.makeText(MainActivity.this, getString(R.string.profile), Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }
        });
    }
}
