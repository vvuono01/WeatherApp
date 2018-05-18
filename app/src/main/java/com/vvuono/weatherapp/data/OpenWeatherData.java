package com.vvuono.weatherapp.data;

import android.content.Context;

import com.vvuono.weatherapp.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class OpenWeatherData {
    private final DateFormat SUNRISE_FORMAT = new SimpleDateFormat("h:mm a", Locale.US);

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
                wind.getDirection(),
                Math.round(wind.getSpeed()));
    }

    public String getTemperatureString() {
        return Integer.toString(Math.round(main.getTemp()));
    }

    public String getWindSpeedString() {
        return context.getResources().getString(R.string.wind_speed_value, Math.round(wind.getSpeed()));
    }

    public String getPressureString() {
        return context.getResources().getString(R.string.pressure_value, Math.round(main.getPressure()));
    }

    public String getHumidityString() {
        return context.getResources().getString(R.string.humidity_value, main.getHumidity());
    }

    public String getSunriseString() {
        Calendar sunrise = Calendar.getInstance();
        sunrise.setTimeInMillis(sys.getSunrise());

        return context.getResources().getString(R.string.sunrise_value, SUNRISE_FORMAT.format(sunrise.getTime()));
    }

    public String getLocationString() {
        return context.getResources().getString(R.string.city_value, name);
    }

    private String capitalizedString(String string) {
        char[] chars = string.toCharArray();
        chars[0] = Character.toUpperCase(chars[0]);
        return new String(chars);
    }
}
