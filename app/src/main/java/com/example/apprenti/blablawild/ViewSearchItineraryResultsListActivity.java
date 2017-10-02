package com.example.apprenti.blablawild;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ViewSearchItineraryResultsListActivity extends AppCompatActivity {

    private ListView mListViewResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_search_itinerary_results_list);

        SearchRequestModel search = getIntent().getExtras().getParcelable("search");
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");

        String arrivee2 = search.getDepart();
        String depart2 = search.getArrivee();

        Context context = getApplicationContext();
        CharSequence text = sdf.format(search.getDate());

        setTitle(arrivee2 + " >> " + depart2);

        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        mListViewResults = (ListView) findViewById(R.id.listViewSearchResults);

        List<TripResultModel> tripResultModels = new ArrayList<>();

        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy-hh:mm");

        try {
            tripResultModels.add(new TripResultModel("Bruce", sdf1.parse("21/02/2017-15:30"), 15));
            tripResultModels.add(new TripResultModel("Clark", sdf1.parse("21/02/2017-16:00"), 20));
            tripResultModels.add(new TripResultModel("Bary", sdf1.parse("21/02/2017-16:30"), 16));
            tripResultModels.add(new TripResultModel("Lex", sdf1.parse("21/02/2017-17:00"), 40));

        } catch (ParseException e) {
        }

        TripResultAdapter adapter = new TripResultAdapter(ViewSearchItineraryResultsListActivity.this, tripResultModels);
        mListViewResults.setAdapter(adapter);

    }
}