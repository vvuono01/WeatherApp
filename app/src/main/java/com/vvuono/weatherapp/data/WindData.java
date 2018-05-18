package com.vvuono.weatherapp.data;

public class WindData {
    private final String[] DIRECTIONS = {
        "N", "NNE", "NE", "ENE", "E", "ESE", "SE", "SSE", "S", "SSW", "SW", "WSW", "W", "WNW", "NW", "NNW"
    };
    private float speed;
    private float deg;

    public float getSpeed() {
        return speed;
    }

    public float getDeg() {
        return deg;
    }

    public String getDirection() {
        int directionIndex = Math.round((deg / 22.5f) + 0.5f);
        return DIRECTIONS[(directionIndex % 16)];
    }
}
