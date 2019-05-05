package com.example.quakereport;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EarthquakeAdapter adapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new EarthquakeAdapter(this);

        listView = findViewById(R.id.list);
        listView.setAdapter(adapter);

        addItem();

    }

    private void addItem() {
        ArrayList<Earthquake> earthquakes = QueryUtils.extractEarthquakes();

        adapter.setEarthquakes(earthquakes);
    }

}
