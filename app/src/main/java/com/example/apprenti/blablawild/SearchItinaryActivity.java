package com.example.apprenti.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SearchItinaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_itinary);

        Button rechercher= (Button)findViewById(R.id.button);
        rechercher.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                EditText depart = (EditText) findViewById(R.id.textView2);
                EditText arrivee = (EditText) findViewById(R.id.textView4);

                if(depart.getText().toString().trim().length() == 0 || arrivee.getText().toString().trim().length() == 0) {
                    Toast.makeText(SearchItinaryActivity.this,R.string.toast,Toast.LENGTH_SHORT).show();
                } else {
                    Intent resultat = new Intent(SearchItinaryActivity.this, ViewSearchItineraryResultsListActivity.class);
                    resultat.putExtra("depart", depart.getText().toString());
                    resultat.putExtra("arrivee", arrivee.getText().toString());
                    startActivity(resultat);
                }
            }
        });
    }
}