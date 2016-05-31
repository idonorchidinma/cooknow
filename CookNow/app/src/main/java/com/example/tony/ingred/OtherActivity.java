package com.example.tony.ingred;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import com.example.tony.cooknow.R;

import android.view.Menu;
import android.view.MenuItem;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


public class OtherActivity extends AppCompatActivity {

    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        Document document = null;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();
             document = db.parse(new URL("http://api.nal.usda.gov" +
                    "/ndb/search/?format=xml&q=new%20york%20steak&sor" +
                    "t=r&max=500&offset=0&api_key=TcTyjU1OVTG8qup5D2godYBOBziTS8dBwjNlTXp8").openStream());
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }


        Element rootElement = document.getDocumentElement();​
        NodeList items = rootElement.getChildNodes();
        for (int i = 0; i < items.getLength(); i++) {
            NodeList foodItem = items.item(i).getChildNodes();
            //System.out.println(foodItem.item(foodItem.getLength()-1).toString());
            System.out.println(foodItem.getLength());
            if (foodItem.getLength() == 7) {
                System.out.println("=====");
                System.out.println(foodItem.item(3).toString());
                System.out.println(foodItem.item(3).getNodeName());
                System.out.println(foodItem.item(3).getTextContent());
                System.out.println("=====");
                }
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
