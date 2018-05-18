package com.vvuono.weatherapp.data;

import android.content.Context;

import com.vvuono.weatherapp.R;

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

    private Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public String getWeatherString() {
        if (weather.length == 1) {
            return weather[0].getMain();
        }

        final StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < weather.length; i++) {
            sb.append(weather[i].getMain());
            if (weather.length > 2) {
                if (i <= weather.length - 2) {
                    sb.append(", ");
                    if (i == weather.length - 2) {
                        sb.append("and ");
                    }
                }
            } else if (i == 0) {
                sb.append(" and ");
            }
        }
        return sb.toString();
    }

    public String getWeatherDescription() {
        final StringBuilder weatherDescription = new StringBuilder("");
        weatherDescription.append(capitalizedString(weather[0].getDescription()));

        for (int i = 1; i < weather.length; i++) {
            if (weather.length > 2) {
                if (i <= weather.length - 2) {
                    weatherDescription.append(", ");
                    if (i == weather.length - 2) {
                        weatherDescription.append("and ");
                    }
                }
            } else {
                weatherDescription.append(" and ");
            }
            weatherDescription.append(weather[i].getDescription());
        }

        return context.getResources().getString(R.string.weather_description_text,
                weatherDescription.toString(),
                Math.round(main.getTempMax()),
                wind.getDeg(),
                Math.round(wind.getSpeed()));
    }

    private String capitalizedString(String string) {
        char[] chars = string.toCharArray();
        chars[0] = Character.toUpperCase(chars[0]);
        return new String(chars);
    }

    public String getTemperature() {
        return Integer.toString(Math.round(main.getTemp()));
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
