package com.example.apprenti.blablawild;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class ViewSearchItineraryResultsListActivity extends AppCompatActivity {

    private ListView mListViewResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_search_itinerary_results_list);

        String depart = getIntent().getStringExtra("depart");
        String arrivee = getIntent().getStringExtra("arrivee");

        setTitle(depart + " >> " + arrivee);

        mListViewResults = (ListView) findViewById(R.id.listViewSearchResults);

        afficherResults();

    }

    private List<TripResultModel> genererResultat(){
        List<TripResultModel> tripResultModels = new ArrayList<>();

        tripResultModels.add(new TripResultModel("Bruce", "21/02/2017-15:30", 15));
        tripResultModels.add(new TripResultModel("Clark", "21/02/2017-16:00", 20));
        tripResultModels.add(new TripResultModel("Bary", "21/02/2017-16:30", 16));
        tripResultModels.add(new TripResultModel("Lex", "21/02/2017-17:00", 40));
        return tripResultModels;
    }

    private void afficherResults() {
        List<TripResultModel> tripResultModels = genererResultat();

        TripResultAdapter adapter = new TripResultAdapter(ViewSearchItineraryResultsListActivity.this, tripResultModels);
        mListViewResults.setAdapter(adapter);

    }

}