package com.example.tony.ingred;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.tony.cooknow.R;
import com.example.tony.ingredientTree.Ingredient;

import java.util.ArrayList;


public class DairyActivity extends AppCompatActivity {
    //list of ingredients of type ingredient
    ArrayList<Ingredient> inventoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dairy);
    }

    public void addToList(String ingredName, String ingredType, int ingredQuantity) {

    }


}
