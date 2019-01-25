package com.googlemapfcm.app;

public class LocationInformation {
    public String name;
    public double latitude;
    public double longitude;

    public LocationInformation() {
    }

    public LocationInformation(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
