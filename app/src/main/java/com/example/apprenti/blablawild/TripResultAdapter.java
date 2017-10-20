package com.example.apprenti.blablawild;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.Query;

import java.text.SimpleDateFormat;

/**
 * @author greg
 * @since 6/21/13
 *
 * This class is an example of how to use FirebaseListAdapter. It uses the <code>Chat</code> class to encapsulate the
 * data for each individual chat message
 */

public class TripResultAdapter extends FirebaseListAdapter<ItineraryModel> {

    public TripResultAdapter(Query ref, Activity activity, int layout) {
        super(ref, ItineraryModel.class, layout, activity);
    }

    @Override
    protected void populateView(View v, ItineraryModel itineraryModel) {

        String date = new SimpleDateFormat("dd/MM/yyyy").format(itineraryModel.getDepartureDate());

        ((TextView)v.findViewById(R.id.departureTime)).setText(itineraryModel.getDepartureTime() + " / " + date);
        ((TextView)v.findViewById(R.id.viewPrice)).setText(itineraryModel.getPrice() + " €");
    }
}