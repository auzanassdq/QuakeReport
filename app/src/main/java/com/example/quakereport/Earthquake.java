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

    Earthquake(double magnitude, String location, long mTimeInMilliseconds, String url) {
        this.mMagnitude = magnitude;
        this.mLocation = location;
        this.mTimeInMilliseconds = mTimeInMilliseconds;
        this.mUrl = url;
    }

    String getUrl() {
        return mUrl;
    }

    public void setUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    double getMagnitude() {
        return mMagnitude;
    }

    String getLocation() {
        return mLocation;
    }

    long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }
}
