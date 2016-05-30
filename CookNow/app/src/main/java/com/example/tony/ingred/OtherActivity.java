package com.example.tony.ingred;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.tb_laota.volleydemo.*;
import com.example.tony.AppController;
import com.example.tony.Item;
import com.example.tony.ItemAdapter;

import android.view.Menu;
import android.view.MenuItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class OtherActivity extends AppCompatActivity {
    //Change to FOOD API LINK
    private static final String url = "http://api.androidhive.info/json/movies.json";
    private ProgressDialog dialog;
    private List<Item> array = new ArrayList<Item>();

    private ListView listView;
    private ItemAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        listView = (ListView)findViewById(R.id.list_item);
        adapter = new ItemAdapter(this, array);

        listView.setAdapter(adapter);
        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading...");
        dialog.show();


        //create volley req for obj

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                hideDialog();

                for(int i = 0; i<response.length(); i++){
                    try{

                        JSONObject obj = response.getJSONObject(i);
                        Item item = new Item();
                        item.setTitle(obj.getString("title"));
                        item.setImage(obj.getString("image"));
                        item.setRate(((Number) obj.get("rating")).doubleValue());
                        item.setYear(obj.getInt ("releaseYear"));

                        //genre is json array

                        JSONArray genreArray = obj.getJSONArray("genre");
                        ArrayList<String> genre = new ArrayList<String>();

                        for(int j = 0; i<genreArray.length(); j++){
                            genre.add((String) genreArray.get(j));
                        }

                        item.setGenre(genre);
                        //add to array

                        array.add(item);

                    }catch (JSONException ex){
                        ex.printStackTrace();
                    }
                }
                adapter.notifyDataSetChanged();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        AppController.getmInstance().addToRequestQueue(jsonArrayRequest);
    }

    public void hideDialog(){

        if(dialog!=null){

            dialog.dismiss();
            dialog=null;
        }
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
}
