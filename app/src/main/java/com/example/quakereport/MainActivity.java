package com.example.quakereport;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        addItem();

    }

    private void addItem() {
        ArrayList<Earthquake> earthquakes = new ArrayList<>();

        earthquakes.add(new Earthquake("7.2", "San Francisco", "Feb 24, 2016"));
        earthquakes.add(new Earthquake("8.2", "Jakarta", "Feb 24, 2016"));
        earthquakes.add(new Earthquake("6.5", "Bandung", "Feb 24, 2016"));
        earthquakes.add(new Earthquake("4.5", "Bogor", "Feb 24, 2016"));
        earthquakes.add(new Earthquake("5.7", "Palu", "Feb 24, 2016"));
        earthquakes.add(new Earthquake("7.3", "Yogya", "Feb 24, 2016"));
        earthquakes.add(new Earthquake("8.6", "Semarang", "Feb 24, 2016"));

        adapter.setEarthquakes(earthquakes);
    }

}
