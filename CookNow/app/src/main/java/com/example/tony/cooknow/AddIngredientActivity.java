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

import com.example.tb_laota.volleydemo.R;

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
                // This toasts a message.
                //Toast.makeText(AddIngredientActivity.this, "An Ingredient has TOTALLY not been added!", Toast.LENGTH_SHORT).show();
                // This creates a new INTENT to switch to another activity
                Intent searchResultsIntent = new Intent(AddIngredientActivity.this, SearchResultsActivity.class);
                // Passing relevant search input to new Intent
                String passingInput = userInput.getText().toString().replaceAll(" ", "+");
                searchResultsIntent.putExtra("input", passingInput);
                // This starts the intent backToMenu
                startActivity(searchResultsIntent);
            }
        });
    }
}
