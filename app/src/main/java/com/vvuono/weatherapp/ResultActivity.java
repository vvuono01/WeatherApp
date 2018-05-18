package com.vvuono.weatherapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.vvuono.weatherapp.data.OpenWeatherData;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResultActivity extends AppCompatActivity {
    @BindView(R.id.tv_weather) TextView weatherText;
    @BindView(R.id.tv_description) TextView descriptionText;
    @BindView(R.id.tv_temp) TextView tempText;
    @BindView(R.id.tv_wind_speed) TextView windSpeedText;
    @BindView(R.id.tv_pressure) TextView pressureText;
    @BindView(R.id.tv_humdity) TextView humidityText;
    @BindView(R.id.tv_sunrise) TextView sunriseText;
    @BindView(R.id.tv_location) TextView locationText;

    private OpenWeatherData weatherData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String resultStr = intent.getStringExtra(SearchActivity.RESULTS_KEY);
        Gson gson = new Gson();
        weatherData = gson.fromJson(resultStr, OpenWeatherData.class);
        weatherData.setContext(this);

        weatherText.setText(weatherData.getWeatherString());
        descriptionText.setText(weatherData.getWeatherDescription());
        tempText.setText(weatherData.getTemperatureString());
        windSpeedText.setText(weatherData.getWindSpeedString());
        pressureText.setText(weatherData.getPressureString());
        humidityText.setText(weatherData.getHumidityString());
        locationText.setText(weatherData.getLocationString());
    }
}
