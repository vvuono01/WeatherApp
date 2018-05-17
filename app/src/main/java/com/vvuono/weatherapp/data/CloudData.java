package com.vvuono.weatherapp.data;

public class CloudData {
    private int all;

    public int getAll() {
        return all;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CloudData{");
        sb.append("all=").append(all);
        sb.append('}');
        return sb.toString();
    }
}
