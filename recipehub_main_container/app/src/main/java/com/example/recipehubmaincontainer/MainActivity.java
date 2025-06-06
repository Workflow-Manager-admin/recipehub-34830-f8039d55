package com.example.recipehubmaincontainer;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout categoryTabs;
    private BottomNavigationView bottomNavBar;
    private RecyclerView recipeRecyclerView;
    private RecipeAdapter recipeAdapter;

    // PUBLIC_INTERFACE
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupCategoryTabs();
        setupBottomNavigation();

        setupRecipeRecyclerView(); // <-- Setup and bind mock recipes
    }

    private void setupRecipeRecyclerView() {
        recipeRecyclerView = findViewById(R.id.recipeList);

        // Use a 2-column grid
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recipeRecyclerView.setLayoutManager(layoutManager);

        // Add spacing for grid items
        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.recipe_grid_spacing); // fallback if dimens not defined: 16
        recipeRecyclerView.addItemDecoration(
                new RecipeGridSpacingItemDecoration(2, spacingInPixels, true)
        );

        // Bind mock data
        recipeAdapter = new RecipeAdapter(this, getMockRecipes());
        recipeRecyclerView.setAdapter(recipeAdapter);
    }

    // PUBLIC_INTERFACE
    private List<Recipe> getMockRecipes() {
        return Arrays.asList(
                new Recipe(
                        "Classic Pancakes",
                        "Fluffy and delicious pancakes, perfect for breakfast.",
                        "Breakfast",
                        "https://images.unsplash.com/photo-1504674900247-0877df9cc836" // Placeholder URL
                ),
                new Recipe(
                        "Chicken Caesar Salad",
                        "A healthy salad with grilled chicken and Caesar dressing.",
                        "Lunch",
                        "https://images.unsplash.com/photo-1519864600265-abb23847ef90"
                ),
                new Recipe(
                        "Spaghetti Bolognese",
                        "Rich tomato sauce with beef served over spaghetti.",
                        "Dinner",
                        "https://images.unsplash.com/photo-1504674900247-0877df9cc836"
                ),
                new Recipe(
                        "Chocolate Chip Cookies",
                        "Crispy on the edges, chewy in the middle.",
                        "Desserts",
                        "https://images.unsplash.com/photo-1519864600265-abb23847ef90"
                ),
                new Recipe(
                        "Veggie Omelette",
                        "Loaded with fresh vegetables and cheese.",
                        "Breakfast",
                        "https://images.unsplash.com/photo-1504674900247-0877df9cc836"
                ),
                new Recipe(
                        "Avocado Toast",
                        "Classic avocado toast, simple and tasty.",
                        "Lunch",
                        "https://images.unsplash.com/photo-1519864600265-abb23847ef90"
                )
        );
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
