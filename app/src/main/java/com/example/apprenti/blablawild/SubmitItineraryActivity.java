package com.example.apprenti.blablawild;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SubmitItineraryActivity extends AppCompatActivity {

    final FirebaseDatabase itinéraires = FirebaseDatabase.getInstance();
    DatabaseReference ref = itinéraires.getReference("Itineraires");

    static EditText dateDepart;
    static EditText heure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_itinerary);

        dateDepart = findViewById(R.id.departureDate);
        heure = findViewById(R.id.departureTime);

        final DatabaseReference itinérairesRefs = ref.child("itinéraires");

        Button soumettre = findViewById(R.id.soumettre);
        soumettre.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                EditText depart = findViewById(R.id.departure);
                String dep = depart.getText().toString();
                EditText arrivee = findViewById(R.id.destination);
                String arr = arrivee.getText().toString();
                EditText prix = findViewById(R.id.prix);
                String pri = prix.getText().toString();
                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
                Date dateDepart = null;
                try {
                    dateDepart = sdf.parse(String.valueOf(SubmitItineraryActivity.dateDepart.getText()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                EditText heure = findViewById(R.id.departureTime);
                String heureDepart = heure.getText().toString();

                if (depart.getText().toString().trim().length() == 0 ||
                        arrivee.getText().toString().trim().length() == 0 ||
                        SubmitItineraryActivity.dateDepart.getText().toString().trim().length() == 0 ||
                        prix.getText().toString().trim().length() == 0 ||
                        heure.getText().toString().trim().length() == 0 ) {
                    Toast.makeText(SubmitItineraryActivity.this, R.string.toast, Toast.LENGTH_SHORT).show();
                } else {

                    itinérairesRefs.push().setValue(new ItineraryModel(dateDepart, pri, dep, arr, heureDepart));
                }
            }
        });
    }


    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current dateDepart as the default dateDepart in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the dateDepart chosen by the user
            dateDepart.setText(day + "/" + (month + 1) + "/" + year);
        }
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new SubmitItineraryActivity.DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }


    public static class TimePickerFragment extends DialogFragment
            implements TimePickerDialog.OnTimeSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {

            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            return new TimePickerDialog(getActivity(), this, hour, minute, DateFormat.is24HourFormat(getActivity()));
        }

        @Override
        public void onTimeSet(TimePicker view, int hourofDay, int minute) {
            heure.setText(Integer.toString(hourofDay) + ":" + Integer.toString(minute));
        }
    }

    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new SubmitItineraryActivity.TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

}