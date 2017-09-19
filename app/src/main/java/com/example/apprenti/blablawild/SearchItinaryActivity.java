package com.example.apprenti.blablawild;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SearchItinaryActivity extends AppCompatActivity {
    static EditText date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_itinary);
        date = (EditText) findViewById(R.id.textView6);

        Button rechercher = (Button) findViewById(R.id.button);
        rechercher.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                EditText depart = (EditText) findViewById(R.id.textView2);
                String dep = depart.getText().toString();
                EditText arrivee = (EditText) findViewById(R.id.textView4);
                String arr = arrivee.getText().toString();
                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
                Date date1 = null;
                try {
                    date1 = sdf.parse(date.getText().toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                if (depart.getText().toString().trim().length() == 0 || arrivee.getText().toString().trim().length() == 0 || date.getText().toString().trim().length() == 0 ) {
                    Toast.makeText(SearchItinaryActivity.this, R.string.toast, Toast.LENGTH_SHORT).show();
                } else {
                    Intent resultat = new Intent(SearchItinaryActivity.this, ViewSearchItineraryResultsListActivity.class);
                    SearchRequestModel search = new SearchRequestModel(dep, arr, date1);
                    resultat.putExtra("search", search);
                    startActivity(resultat);
                }
            }
        });
    }

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
            date.setText(day + "/" + (month + 1) + "/" + year);

        }
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

}