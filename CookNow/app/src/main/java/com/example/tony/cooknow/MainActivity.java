package com.example.tony.cooknow;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TabHost;


/**
 * Created by Tony on 5/24/2016.
 */
@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost = (TabHost)findViewById(android.R.id.tabhost);

        TabHost.TabSpec inventoryTab = tabHost.newTabSpec("Inventory");
        TabHost.TabSpec recipeTab = tabHost.newTabSpec("Recipes");
        TabHost.TabSpec favoriteTab = tabHost.newTabSpec("Favorites");
        TabHost.TabSpec historyTab = tabHost.newTabSpec("History");
        TabHost.TabSpec searchTab = tabHost.newTabSpec("Search");

        inventoryTab.setIndicator("Inventory");
        recipeTab.setIndicator("Recipes");
        favoriteTab.setIndicator("Favorites");
        historyTab.setIndicator("History");
        searchTab.setIndicator("Search");

        inventoryTab.setContent(new Intent(this, InventoryActivity.class));
        recipeTab.setContent(new Intent(this, RecipeActivity.class));
        favoriteTab.setContent(new Intent(this, FavoriteActivity.class));
        historyTab.setContent(new Intent(this, HistoryActivity.class));
        searchTab.setContent(new Intent(this, SearchActivity.class));

        tabHost.addTab(inventoryTab);
        tabHost.addTab(recipeTab);
        tabHost.addTab(favoriteTab);
        tabHost.addTab(historyTab);
        tabHost.addTab(searchTab);
    }

}
