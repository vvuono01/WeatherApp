package com.vvuono.weatherapp.data;

import java.util.Arrays;

public class OpenWeatherData {
    private Coordinate coord;
    private SystemData sys;
    private WeatherData[] weather;
    private String base;
    private MainData main;
    private WindData wind;
    private CloudData clouds;
    private long dt;
    private int id;
    private String name;
    private int cod;

    public Coordinate getCoord() {
        return coord;
    }

    public SystemData getSys() {
        return sys;
    }

    public WeatherData[] getWeather() {
        return weather;
    }

    public String getBase() {
        return base;
    }

    public MainData getMain() {
        return main;
    }

    public WindData getWind() {
        return wind;
    }

    public CloudData getClouds() {
        return clouds;
    }

    public long getDt() {
        return dt;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCod() {
        return cod;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OpenWeatherData{");
        sb.append("coord=").append(coord);
        sb.append(", sys=").append(sys);
        sb.append(", weather=").append(Arrays.toString(weather));
        sb.append(", base='").append(base).append('\'');
        sb.append(", main=").append(main);
        sb.append(", wind=").append(wind);
        sb.append(", clouds=").append(clouds);
        sb.append(", dt=").append(dt);
        sb.append(", id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", cod=").append(cod);
        sb.append('}');
        return sb.toString();
    }
}
