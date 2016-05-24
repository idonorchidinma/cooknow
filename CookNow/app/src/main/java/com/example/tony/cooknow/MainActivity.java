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

        TabHost.TabSpec tab1 = tabHost.newTabSpec("tab 1");
        TabHost.TabSpec tab2 = tabHost.newTabSpec("tab 2");
        TabHost.TabSpec tab3 = tabHost.newTabSpec("tab 3");
        TabHost.TabSpec tab4 = tabHost.newTabSpec("tab 4");
        TabHost.TabSpec tab5 = tabHost.newTabSpec("tab 5");

        tab1.setIndicator("Tab 1");
        tab2.setIndicator("Tab 2");
        tab3.setIndicator("Tab 3");
        tab4.setIndicator("Tab 4");
        tab5.setIndicator("Tab 5");

        tab1.setContent(new Intent(this, InventoryActivity.class));
        tab2.setContent(new Intent(this, RecipeActivity.class));
        tab3.setContent(new Intent(this, FavoriteActivity.class));
        tab4.setContent(new Intent(this, HistoryActivity.class));
        tab5.setContent(new Intent(this, SearchActivity.class));

        tabHost.addTab(tab1);
        tabHost.addTab(tab2);
        tabHost.addTab(tab3);
        tabHost.addTab(tab4);
        tabHost.addTab(tab5);
    }

}
