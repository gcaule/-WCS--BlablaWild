package com.example.apprenti.blablawild;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ViewSearchItineraryResultsListActivity extends AppCompatActivity {

    final FirebaseDatabase itinéraires = FirebaseDatabase.getInstance();
    DatabaseReference ref = itinéraires.getReference("Itineraires");

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_view_search_itinerary_results_list);

            SearchRequestModel searchRequest = getIntent().getParcelableExtra("searchRequest");
            String departure = searchRequest.getDeparture();
            String destination = searchRequest.getDestination();
            String date = searchRequest.getDate();

            Toast.makeText(this, date, Toast.LENGTH_LONG).show();

            setTitle(departure + " >> " + destination);

        ListView list = findViewById(R.id.listViewSearchResults);

        DatabaseReference itinerairesRefs = ref.child("itinéraires");
        TripResultAdapter adapter = new TripResultAdapter(
                itinerairesRefs,
                ViewSearchItineraryResultsListActivity.this, R.layout.trip_item);
        list.setAdapter(adapter);
    }
}