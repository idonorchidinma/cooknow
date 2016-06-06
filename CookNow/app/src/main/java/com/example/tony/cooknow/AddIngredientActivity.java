package com.example.tony.cooknow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tony.ingred.IngredArray;
import com.example.tony.ingredientTree.DairyType;
import com.example.tony.ingredientTree.FruitType;
import com.example.tony.ingredientTree.Ingredient;
import com.example.tony.ingredientTree.MeatType;
import com.example.tony.ingredientTree.OtherType;
import com.example.tony.ingredientTree.VegeType;

import java.util.ArrayList;


public class AddIngredientActivity extends AppCompatActivity {

    /** The button for ADDING AN INGREDIENT. */
    private Button myAddButton;

    // The edittext where the user types their ingredient.
    EditText userInput;



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

        //Disable MULTI-LINE input
        userInput = (EditText) findViewById(R.id.INGREDIENT_EDITTEXT);
        userInput.setSingleLine();
        userInput.setImeActionLabel("OK", KeyEvent.ACTION_DOWN);
        userInput.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    myAddButton.performClick();
                    return true;
                }
                return false;
            }
        });

        myAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ingredName;
                String ingredType;
                int ingredQuantity;

                // This toasts a message.
                //Toast.makeText(AddIngredientActivity.this, "An Ingredient has TOTALLY not been added!", Toast.LENGTH_SHORT).show();
                // This creates a new INTENT to switch to another activity
                Intent searchResultsIntent = new Intent(AddIngredientActivity.this, SearchResultsActivity.class);
                // Passing relevant search input to new Intent
                String passingInput = userInput.getText().toString().replaceAll(" ", "+");
                searchResultsIntent.putExtra("input", passingInput);
                // This starts the intent backToMenu
                startActivity(searchResultsIntent);


                ingredName = ((EditText)findViewById(R.id.INGREDIENT_EDITTEXT)).getText().toString();
                ingredType = ((Spinner)findViewById(R.id.TYPE_SELECTOR_SPINNER)).getSelectedItem().toString();
                ingredQuantity = Integer.parseInt(((EditText)findViewById(R.id.INGREDIENT_QUANTITY_EDITTEXT)).getText().toString());

                addToInventory(ingredName, ingredType, ingredQuantity);
            }
        });
    }

    private void addToInventory(String ingredName, String ingredType, int ingredQuantity) {
        System.out.println("1. " + ingredName);
        System.out.println("2. " + ingredType);
        System.out.println("3. " + ingredQuantity);
        Ingredient theIngredient = null;

        if (ingredType.equals("Dairy")) {
            theIngredient = new DairyType(ingredName, ingredQuantity);
        } else if (ingredType.equals("Meat")) {
            theIngredient = new MeatType(ingredName, ingredQuantity);
        } else if (ingredType.equals("Vegetables")) {
            theIngredient = new VegeType(ingredName, ingredQuantity);
        } else if (ingredType.equals("Fruits")) {
            theIngredient = new FruitType(ingredName, ingredQuantity);
        } else if (ingredType.equals("Other")) {
            theIngredient = new OtherType(ingredName, ingredQuantity);
        }

        IngredArray.allIngredients.add(theIngredient);


    }
}
