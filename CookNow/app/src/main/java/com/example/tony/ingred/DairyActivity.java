package com.example.tony.ingred;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.tony.cooknow.R;
import com.example.tony.ingredientTree.Ingredient;

import java.util.ArrayList;


public class DairyActivity extends AppCompatActivity {
    //list of ingredients of type ingredient
    ListView myListView;
    ArrayList<String> myItemResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dairy);

        myItemResults = new ArrayList<>();

        myListView = (ListView) findViewById(R.id.DAIRY_LIST_VIEW);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1 , myItemResults);

    }




}
