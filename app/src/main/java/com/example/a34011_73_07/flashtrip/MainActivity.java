package com.example.a34011_73_07.flashtrip;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class MainActivity extends Activity {
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((Button)findViewById(R.id.flasher))
                .setOnClickListener(new View.OnClickListener()
                                    {
                                        public void onClick(View v)
                                        {
                                            Intent i = new Intent(MainActivity.this, QrScan.class);
                                            startActivity(i);
                                        }
                                    }
                );
        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

// Listview Group click listener
        expListView.setOnGroupClickListener(new OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {

            }
        });
        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {

            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(
                        getApplicationContext(),
                        listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();

                final String selected = (String) listAdapter.getChild(
                        groupPosition, childPosition);
               /* Intent i = new Intent(MainActivity.this, Description.class);
                startActivity(i);*/
                Intent intent;
                switch(selected){
                    case "Accueil":
                        intent = new Intent(MainActivity.this, Accueil.class);
                        startActivity(intent);
                        break;

                    case "Restaurant":
                        intent = new Intent(MainActivity.this, Resto.class);
                        startActivity(intent);
                        break;

                    case "Développement logiciel":
                        intent = new Intent(MainActivity.this, Dl.class);
                        startActivity(intent);
                        break;

                    case "Concepteur développeur informatique":
                        intent = new Intent(MainActivity.this, Cdi.class);
                        startActivity(intent);
                        break;

                }
                return false;

            }
        });
    }


    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Administration");
        listDataHeader.add("Services");
        listDataHeader.add("Formations");

        // Adding child data
        List<String> Administration = new ArrayList<String>();
        Administration.add("Accueil");


        List<String> Services = new ArrayList<String>();
        Services.add("Restaurant");


        List<String> Formations = new ArrayList<String>();
        Formations.add("Développement logiciel");
        Formations.add("Concepteur développeur informatique");


        listDataChild.put(listDataHeader.get(0), Administration);
        listDataChild.put(listDataHeader.get(1), Services);
        listDataChild.put(listDataHeader.get(2), Formations);
    }

}