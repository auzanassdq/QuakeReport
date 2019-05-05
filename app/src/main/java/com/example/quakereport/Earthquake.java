package com.example.quakereport;

/**
 * Created by auzan on 3/3/2019.
 * Github: @auzanassdq
 */
public class Earthquake {

    private String mUrl;
    private double mMagnitude;
    private String mLocation;
    private long mTimeInMilliseconds;

    public Earthquake(double magnitude, String location, long mTimeInMilliseconds, String url) {
        this.mMagnitude = magnitude;
        this.mLocation = location;
        this.mTimeInMilliseconds = mTimeInMilliseconds;
        this.mUrl = url;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    public double getMagnitude() {
        return mMagnitude;
    }

    public String getLocation() {
        return mLocation;
    }

    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }
}
