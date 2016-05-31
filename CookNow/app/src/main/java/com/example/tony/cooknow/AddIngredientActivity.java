package com.example.tony.cooknow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;


public class AddIngredientActivity extends AppCompatActivity {

    /** The button for ADDING AN INGREDIENT. */
    private Button myAddButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ingredient);
        setTitle("Add an Ingredient");

        Spinner dropdown = (Spinner)findViewById(R.id.TYPE_SELECTOR_SPINNER);
        String[] items = new String[]{"Dairy", "Fruits", "Vegetables", "Meat", "Other"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        myAddButton = (Button) findViewById(R.id.ADD_INGREDIENT_BUTTON);
        myAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // This toasts a message.
                Toast.makeText(AddIngredientActivity.this, "An Ingredient has TOTALLY not been added!", Toast.LENGTH_SHORT).show();
                // This creates a new INTENT to switch to another activity
                Intent backToMenu = new Intent(AddIngredientActivity.this, InventoryActivity.class);
                // This makes it so that PRESSING BACK on the phone WILL NOT go back to AddIngredientActivity
                backToMenu.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                // This starts the intent backToMenu
                startActivity(backToMenu);
            }
        });
    }
}
