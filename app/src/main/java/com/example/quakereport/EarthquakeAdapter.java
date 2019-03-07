package com.example.quakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by auzan on 3/7/2019.
 * Github: @auzanassdq
 */
public class EarthquakeAdapter extends BaseAdapter {

    private final Context context;
    private ArrayList<Earthquake> earthquakes;

    public EarthquakeAdapter(Context context) {
        this.context = context;
        earthquakes = new ArrayList<>();
    }

    public void setEarthquakes(ArrayList<Earthquake> earthquakes){
        this.earthquakes = earthquakes;
    }

    @Override
    public int getCount() {
        return earthquakes.size();
    }

    @Override
    public Object getItem(int position) {
        return earthquakes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.earthquake_list_item, viewGroup, false);
        }

        Earthquake earthquake = (Earthquake) getItem(i);

        TextView txtMagnitude = view.findViewById(R.id.tv_magnitude);
        TextView txtLocation = view.findViewById(R.id.tv_location);
        TextView txtDate = view.findViewById(R.id.tv_date);

        txtMagnitude.setText(earthquake.getMagnitude());
        txtLocation.setText(earthquake.getLocation());
        txtDate.setText(earthquake.getDate());

        return view;
    }
}
