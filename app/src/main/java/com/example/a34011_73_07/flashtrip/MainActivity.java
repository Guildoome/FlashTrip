package com.example.a34011_73_07.flashtrip;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;

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

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
    }
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
    }

    // Listview Group expanded listener
    expListView.setOnGroupExpandListener(new OnGroupExpandListener() {

        @Override
        public void onGroupExpand(int groupPosition) {
            Toast.makeText(getApplicationContext(),
                    listDataHeader.get(groupPosition) + " Expanded",
                    Toast.LENGTH_SHORT).show();
        }
    }
    // Listview Group collasped listener
    expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

        @Override
        public void onGroupCollapse(int groupPosition) {
            Toast.makeText(getApplicationContext(),
                    listDataHeader.get(groupPosition) + " Collapsed",
                    Toast.LENGTH_SHORT).show();

        }
    }

    // Listview on child click listener
    expListView.setOnChildClickListener(new OnChildClickListener() {

        @Override
        public boolean onChildClick(ExpandableListView parent, View v,
        int groupPosition, int childPosition, long id){
            // TODO Auto-generated method stub
            Toast.makeText(
                    getApplicationContext(),
                    listDataHeader.get(groupPosition)
                            + " : "
                            + listDataChild.get(
                            listDataHeader.get(groupPosition)).get(
                            childPosition), Toast.LENGTH_SHORT)
                    .show();
            return false;
        }
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
    SwipeMenuCreator creator = new SwipeMenuCreator() {

        @Override
        public void create(SwipeMenu menu) {
            // create "open" item
            SwipeMenuItem openItem = new SwipeMenuItem(
                    getApplicationContext());
            // set item background
            openItem.setBackground(new ColorDrawable(Color.rgb(0xC9, 0xC9,
                    0xCE)));
            // set item width
            openItem.setWidth(20);
            // set item title
            openItem.setTitle("Infos");
            // set item title fontsize
            openItem.setTitleSize(18);
            // set item title font color
            openItem.setTitleColor(Color.WHITE);
            // add to menu
            menu.addMenuItem(openItem);

            // create "delete" item
            SwipeMenuItem goTo = new SwipeMenuItem(
                    getApplicationContext());
            // set item background
            goTo.setBackground(new ColorDrawable(Color.rgb(0xF9,
                    0x3F, 0x25)));
            // set item width
            goTo.setWidth(20);
            // set a icon
            goTo.setIcon(R.drawable.ic_action_name);
            // add to menu
            menu.addMenuItem(goTo);
        }
    };

// set creator
    listDataChild.setMenuCreator(creator);
    listDataChild.setOnMenuItemClickListener(new OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
            switch (index) {
                case 0:
                    // open
                    break;
                case 1:
                    // delete
                    break;
            }
            // false : close the menu; true : not close the menu
            return false;
        }
    });
}