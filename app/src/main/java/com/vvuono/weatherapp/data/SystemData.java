package com.vvuono.weatherapp.data;

public class SystemData {
    private int type;
    private int id;
    private float message;
    private String country;
    private long sunrise;
    private long sunset;

    public int getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public float getMessage() {
        return message;
    }

    public String getCountry() {
        return country;
    }

    public long getSunrise() {
        return sunrise;
    }

    public long getSunset() {
        return sunset;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SystemData{");
        sb.append("type=").append(type);
        sb.append(", id=").append(id);
        sb.append(", message=").append(message);
        sb.append(", country='").append(country).append('\'');
        sb.append(", sunrise=").append(sunrise);
        sb.append(", sunset=").append(sunset);
        sb.append('}');
        return sb.toString();
    }
}
