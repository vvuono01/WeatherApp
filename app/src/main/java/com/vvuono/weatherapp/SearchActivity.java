package com.vvuono.weatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class SearchActivity extends AppCompatActivity {
    @BindView(R.id.et_zip_code) EditText zipCodeField;
    @BindView(R.id.b_search) Button searchButton;
    @BindView(R.id.tv_error) TextView errorText;

    public static final String RESULTS_KEY = "results";

    private final String TAG = "Search Screen";

    // For the purposes of this exercise, we will not consider ZIP+4 Codes
    private final int ZIP_CODE_LENGTH = 5;

    private final String OPENWEATHER_API_URL = "http://api.openweathermap.org/data/2.5/weather?zip=%d&appid=%s";
    private final String OPENWEATHER_API_KEY = "2cc471bc46cb7bd935f36d404a4c4d2a";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
    }

    @OnTextChanged(R.id.et_zip_code)
    public void onZipCodeChanged(Editable editable) {
        String zipCode = editable.toString();
        searchButton.setEnabled(isZipCodeValid(zipCode));
        errorText.setVisibility(GONE);
    }

    @OnClick(R.id.b_search)
    public void searchForZipCode(View view) {
        int zipCode = Integer.parseInt(zipCodeField.getText().toString());
        requestWeatherInformation(zipCode);
    }

    private boolean isZipCodeValid(String zipCode) {
        return zipCode.length() == ZIP_CODE_LENGTH;
    }

    private void requestWeatherInformation(int zipCode) {
        searchButton.setEnabled(false);
        errorText.setVisibility(GONE);

        String requestUrl = String.format(OPENWEATHER_API_URL, zipCode, OPENWEATHER_API_KEY);
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, requestUrl,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    searchButton.setEnabled(true);
                    Intent resultsIntent = new Intent(getApplicationContext(), ResultActivity.class);
                    resultsIntent.putExtra(RESULTS_KEY, response);
                    startActivity(resultsIntent);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    searchButton.setEnabled(true);
                    error.printStackTrace();

                    setErrorState(R.string.weather_call_failed);
                }
            }
        );
        queue.add(stringRequest);
    }

    private void setErrorState(@StringRes int errorMessage) {
        errorText.setVisibility(VISIBLE);
        errorText.setText(errorMessage);
    }
}
