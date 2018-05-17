package com.vvuono.weatherapp.data;

public class Coordinate {
    private float lon;
    private float lat;

    public float getLon() {
        return lon;
    }

    public float getLat() {
        return lat;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Coordinate{");
        sb.append("lon=").append(lon);
        sb.append(", lat=").append(lat);
        sb.append('}');
        return sb.toString();
    }
}
