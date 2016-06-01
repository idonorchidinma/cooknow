package com.example.tony.cooknow;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tb_laota.volleydemo.R;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * This activity displays the search results with the given input from the user.
 * The results are obtained by querying the National Food Database with the given API.
 *
 * @author Henry
 * @version May 31, 2016
 */
public class SearchResultsActivity extends AppCompatActivity {

    // The listview of items
    private ListView myItemList;

    private ArrayList<String> myItemResults;

    private TextView myLoadText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        //Connects listview in layout to this class.
        myItemList = (ListView) findViewById(R.id.ITEM_LIST);
        myLoadText = (TextView) findViewById(R.id.loadingText);
        myItemResults = new ArrayList<>();


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1 ,myItemResults);
        String userInput = getIntent().getExtras().getString("input");
        GetSearchResults getResults = new GetSearchResults(myItemResults, arrayAdapter, myLoadText, userInput);
        getResults.execute("ignore this");
    }

    private class GetSearchResults extends AsyncTask<String, Void, String> {

        //The array list of search results
        ArrayList<String> myArrayList;
        ArrayAdapter<String> myArrayAdapter;

        String urlFirst = "http://api.nal.usda.gov/ndb/search/?format=xml&q=";
        String urlQuery;
        String urlLast = "&sort=r&max=500&offset=0&api_key=TcTyjU1OVTG8qup5D2godYBOBziTS8dBwjNlTXp8";

        //disable this text when done loading
        TextView myLoadingText;

        public GetSearchResults(ArrayList theArrayList, ArrayAdapter<String> theArrayAdapter, TextView theLoadText, String theInput) {
            myArrayList = theArrayList;
            myArrayAdapter = theArrayAdapter;
            myLoadingText = theLoadText;
            // Gets the user query
            urlQuery = theInput;

        }

        @Override
        protected String doInBackground(String[] params) {
            Document document = null;
            String fullQuery = urlFirst+urlQuery+urlLast;
            try {
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                document = db.parse(new URL(fullQuery).openStream());
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            }

            Element rootElement = document.getDocumentElement();

            NodeList items = rootElement.getChildNodes();
            for (int i = 0; i < items.getLength(); i++) {
                NodeList foodItem = items.item(i).getChildNodes();
                if (foodItem.getLength() == 7) {
                    //Print to console
                    System.out.println(foodItem.item(3).getTextContent());
                    //Add to array list
                    myArrayList.add(foodItem.item(3).getTextContent());
                }
            }

            return "ignore this too";
        }

        @Override
        protected void onPostExecute(String message) {
            //Populates listview
            myItemList.setAdapter(myArrayAdapter);
            //Disables Loading text
            myLoadText.setVisibility(View.GONE);
        }
    }
}
