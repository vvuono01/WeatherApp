package com.vvuono.weatherapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.gson.Gson;
import com.vvuono.weatherapp.data.OpenWeatherData;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        String resultStr = intent.getStringExtra(SearchActivity.RESULTS_KEY);
        Gson gson = new Gson();
        OpenWeatherData result = gson.fromJson(resultStr, OpenWeatherData.class);
    }
}
