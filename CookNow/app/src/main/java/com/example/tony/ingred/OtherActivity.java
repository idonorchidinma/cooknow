package com.example.tony.ingred;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import com.example.tb_laota.volleydemo.*;

import android.view.Menu;
import android.view.MenuItem;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


public class OtherActivity extends AppCompatActivity {

    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        Document document = null;
        Document doc = db.parse(new URL("http://api.nal.usda.gov/ndb/search/?format=xml&q=new%20york%20steak&sort=r&max=500&offset=0&api_key=TcTyjU1OVTG8qup5D2godYBOBziTS8dBwjNlTXp8").openStream());

        try {
            document =  DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("http://api.nal.usda.gov/ndb/list?format=json&lt=g&sort=n&api_key=xoNloOitF8uXEhuREu11T7y64Lz1tntsZGHcZwPs&location=Denver+CO");
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
            System.out.println(foodItem.item(foodItem.getLength()-1).toString());
            System.out.println(foodItem.getLength());
            for (int j = 0; j < foodItem.getLength(); j ++) {
                System.out.println(foodItem.item(j).getLastChild().getTextContent());
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
