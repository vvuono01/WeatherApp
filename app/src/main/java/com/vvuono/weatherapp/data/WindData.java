package com.vvuono.weatherapp.data;

public class WindData {
    private float speed;
    private float deg;

    public float getSpeed() {
        return speed;
    }

    public float getDeg() {
        return deg;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("WindData{");
        sb.append("speed=").append(speed);
        sb.append(", deg=").append(deg);
        sb.append('}');
        return sb.toString();
    }
}
