package com.example.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * Created by auzan on 3/7/2019.
 * Github: @auzanassdq
 */
public class EarthquakeAdapter extends BaseAdapter {

    private static final String LOCATION_SEPARATOR = " of ";
    private final Context context;
    private ArrayList<Earthquake> earthquakes;

    EarthquakeAdapter(Context context) {
        this.context = context;
        earthquakes = new ArrayList<>();
    }

    void setEarthquakes(ArrayList<Earthquake> earthquakes){
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
    public View getView(int i, View view, ViewGroup parent) {
        String primaryLocation;
        String locationOffset;

        if (view == null){
            view = LayoutInflater.from(context).inflate(
                    R.layout.earthquake_list_item, parent, false);
        }

        Earthquake earthquake = (Earthquake) getItem(i);
        String originalLocation = earthquake.getLocation();

        if (originalLocation.contains(LOCATION_SEPARATOR)) {
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        } else {
            locationOffset = context.getString(R.string.near_the);
            primaryLocation = originalLocation;
        }

        TextView magnitudeView = view.findViewById(R.id.magnitude);
        String formattedMagnitude = formatMagnitude(earthquake.getMagnitude());

        TextView primaryLocationView = view.findViewById(R.id.primary_location);
        TextView locationOffsetView = view.findViewById(R.id.location_offset);

        Date dateObject = new Date(earthquake.getTimeInMilliseconds());

        TextView dateView = view.findViewById(R.id.date);
        String formattedDate = formatDate(dateObject);

        TextView timeView = view.findViewById(R.id.time);
        String formattedTime = formatTime(dateObject);


        magnitudeView.setText(formattedMagnitude);
        primaryLocationView.setText(primaryLocation);
        locationOffsetView.setText(locationOffset);
        dateView.setText(formattedDate);
        timeView.setText(formattedTime);

        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();
        int magnitudeColor = getMagnitudeColor(earthquake.getMagnitude());
        magnitudeCircle.setColor(magnitudeColor);

        return view;
    }

    private String formatMagnitude(double magnitude){
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }

    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy", Locale.US);
        return dateFormat.format(dateObject);
    }

    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a", Locale.US);
        return timeFormat.format(dateObject);
    }

    private int getMagnitudeColor(double magnitude){
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }

        return ContextCompat.getColor(context, magnitudeColorResourceId);
    }

}
