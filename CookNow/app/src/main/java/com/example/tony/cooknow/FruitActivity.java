package com.example.tony.cooknow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FruitActivity extends AppCompatActivity {

    private TextView myPlaceholderText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit);
        myPlaceholderText = (TextView) findViewById(R.id.PLACEHOLDERTEXT);
        myPlaceholderText.append("akjfhsakjda");
        setTitle("Fruit Inventory");
    }
}
