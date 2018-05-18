package com.vvuono.weatherapp.data;

public class MainData {
    private float temp;
    private int humidity;
    private float pressure;
    private float temp_min;
    private float temp_max;

    public float getTemp() {
        return temp;
    }

    public int getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public float getTemp_min() {
        return temp_min;
    }

    public float getTempMax() {
        return temp_max;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MainData{");
        sb.append("temp=").append(temp);
        sb.append(", humidity=").append(humidity);
        sb.append(", pressure=").append(pressure);
        sb.append(", temp_min=").append(temp_min);
        sb.append(", temp_max=").append(temp_max);
        sb.append('}');
        return sb.toString();
    }
}
