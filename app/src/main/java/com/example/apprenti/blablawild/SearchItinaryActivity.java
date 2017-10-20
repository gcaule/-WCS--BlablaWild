package com.example.apprenti.blablawild;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class SearchItinaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_itinerary);

        final EditText editDeparture = findViewById(R.id.textView2);
        final EditText editDestination = findViewById(R.id.textView4);
        final EditText editDate = findViewById(R.id.textView6);
        Button buttonSearch = findViewById(R.id.button);

        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String departure = editDeparture.getText().toString();
                String destination = editDestination.getText().toString();
                String date = editDate.getText().toString();

                if (departure.isEmpty() || destination.isEmpty()) {
                    Toast formIsEmpty = Toast.makeText(getApplicationContext(), getResources().getString(R.string.toast), Toast.LENGTH_SHORT);
                    formIsEmpty.show();
                } else {
                    // Aller sur la page des résultats avec utilisation de Parcelable
                    Intent intent = new Intent(SearchItinaryActivity.this,
                            ViewSearchItineraryResultsListActivity.class);
                    SearchRequestModel searchRequest = new SearchRequestModel(departure, destination, date);
                    intent.putExtra("searchRequest", searchRequest);

                    SearchItinaryActivity.this.startActivity(intent);
                }
            }
        });

        final Calendar myCalendar = Calendar.getInstance();
        final DatePickerDialog.OnDateSetListener dateListener = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel(editDate, myCalendar);
            }
        };

        editDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(SearchItinaryActivity.this,
                        dateListener,
                        myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)
                ).show();
            }
        });
    }

    private void updateLabel(EditText editText, Calendar myCalendar) {
        String myFormat = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.FRANCE);
        editText.setText(sdf.format(myCalendar.getTime()));
    }
}