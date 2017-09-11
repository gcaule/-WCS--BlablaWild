package com.example.apprenti.blablawild;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ViewSearchItineraryResultsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_search_itinerary_results_list);

        String depart = getIntent().getStringExtra("depart");
        String arrivee = getIntent().getStringExtra("arrivee");

        setTitle(depart + " >> " + arrivee);
    }
}