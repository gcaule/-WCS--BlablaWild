package com.example.apprenti.blablawild;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by apprenti on 13/09/17.
 */

public class TripResultAdapter extends ArrayAdapter<TripResultModel> {

    public TripResultAdapter(Context context, List<TripResultModel> tripResultModels) {
        super(context, 0, tripResultModels);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.trip_item, parent, false);
        }

        TripResultModelViewHolder viewHolder = (TripResultModelViewHolder) convertView.getTag();
        if (viewHolder == null) {
            viewHolder = new TripResultModelViewHolder();
            viewHolder.firstName = convertView.findViewById(R.id.firstName);
            viewHolder.departureTime = convertView.findViewById(R.id.departureTime);
            viewHolder.viewPrice = convertView.findViewById(R.id.viewPrice);
            convertView.setTag(viewHolder);
        }

        TripResultModel tripResultModel = getItem(position);
        viewHolder.firstName.setText(tripResultModel.getFirstName());
        viewHolder.departureTime.setText(tripResultModel.getDepartureTime().toString());
        viewHolder.viewPrice.setText(String.valueOf(tripResultModel.getViewPrice()));

        return convertView;
    }

    private class TripResultModelViewHolder {
        public TextView firstName;
        public TextView departureTime;
        public TextView viewPrice;

    }

}