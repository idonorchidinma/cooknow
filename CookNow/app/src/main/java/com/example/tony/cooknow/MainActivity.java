package com.example.tony.cooknow;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Sets up activity
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // CONNECTS BUTTONS IN XML LAYOUT FILE TO THIS JAVA CLASS
        myDairyButton = (Button)findViewById(R.id.DAIRY_BUTTON);
        myMeatButton = (Button)findViewById(R.id.MEAT_BUTTON);
        myFruitButton = (Button)findViewById(R.id.FRUIT_BUTTON);
        myVegetablesButton = (Button)findViewById(R.id.VEGETABLES_BUTTON);
        myButtonX = (Button)findViewById(R.id.BUTTON_X);
        myOtherButton = (Button)findViewById(R.id.OTHER_BUTTON);

        // ADDS BUTTON LISTENERS TO BUTTONS
        myDairyButton.setOnClickListener(new ActivityOnClickListener(new DairyActivity()));
        myMeatButton.setOnClickListener(new ActivityOnClickListener(new MeatActivity()));
        myFruitButton.setOnClickListener(new ActivityOnClickListener(new FruitActivity()));
        myVegetablesButton.setOnClickListener(new ActivityOnClickListener(new VegetablesActivity()));
        myButtonX.setOnClickListener(new TestListener());
        myOtherButton.setOnClickListener(new TestListener2());


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "PLACEHOLDER for adding ingredient", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            Intent newIntent = new Intent(MainActivity.this, myActivity.getClass());
            startActivity(newIntent);
        }
    }

    private class TestListener implements View.OnClickListener {

        @Override
        public void onClick(final View theButton) {
            Toast.makeText(MainActivity.this,"THE BUTON X WAS PRESSED",
                    Toast.LENGTH_SHORT).show();
        }
    }

    private class TestListener2 implements View.OnClickListener {

        @Override
        public void onClick(final View theButton) {
            Toast.makeText(MainActivity.this,"THE OTHER BUTTON WAS PRESSED",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
