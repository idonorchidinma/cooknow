package com.example.tony.cooknow;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class InventoryActivity extends AppCompatActivity {

    /** The button that brings to the list menu containing dairy.*/
    private Button myDairyButton;

    /** The button that brings to the list menu containing meat.*/
    private Button myMeatButton;

    /** The button that brings to the list menu containing fruit.*/
    private Button myFruitButton;

    /** The button that brings to the list menu containing vegetables.*/
    private Button myVegetablesButton;

    private Button myOtherButton;

    /** Test button. */
    private Button myButtonX;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Sets up activity
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ActionBar actionBar = getActionBar();
//        actionBar.setIcon(R.drawable.ic_list_black_24dp);
//        actionBar.setDisplayUseLogoEnabled(true);
//        actionBar.setDisplayHomeAsUpEnabled(true);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(R.drawable.ic_list_black_48dp);
        setSupportActionBar(toolbar);
        setTitle("Inventory");

        // CONNECTS BUTTONS IN XML LAYOUT FILE TO THIS JAVA CLASS
        myDairyButton = (Button)findViewById(R.id.DAIRY_BUTTON);
        myMeatButton = (Button)findViewById(R.id.MEAT_BUTTON);
        myFruitButton = (Button)findViewById(R.id.FRUIT_BUTTON);
        myVegetablesButton = (Button)findViewById(R.id.VEGETABLES_BUTTON);
        myOtherButton = (Button)findViewById(R.id.OTHER_BUTTON);

        // ADDS BUTTON LISTENERS TO BUTTONS
        myDairyButton.setOnClickListener(new ActivityOnClickListener(new DairyActivity()));
        myMeatButton.setOnClickListener(new ActivityOnClickListener(new MeatActivity()));
        myFruitButton.setOnClickListener(new ActivityOnClickListener(new FruitActivity()));
        myVegetablesButton.setOnClickListener(new ActivityOnClickListener(new VegetablesActivity()));
        myOtherButton.setOnClickListener(new ActivityOnClickListener(new OtherActivity()));


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(InventoryActivity.this, "PLACEHOLDER for adding ingredient", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main_actions, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * This listener switches to a given activity.
     */
    private class ActivityOnClickListener implements View.OnClickListener {

        /** The activity to create an intent from */
        private Activity myActivity;

        /**
         * Creates an ActivityOnClickListener that starts a given activity.
         * @param theActivity the activity to start.
         */
        public ActivityOnClickListener(final Activity theActivity) {
            myActivity = theActivity;
        }

        @Override
        public void onClick(final View theButton) {
            Intent newIntent = new Intent(InventoryActivity.this, myActivity.getClass());
            startActivity(newIntent);
        }
    }

//    private class TestListener2 implements View.OnClickListener {
//
//        @Override
//        public void onClick(final View theButton) {
//            Toast.makeText(InventoryActivity.this,"THE OTHER BUTTON WAS PRESSED BY Tony",
//                    Toast.LENGTH_SHORT).show();
//        }
//    }
}
