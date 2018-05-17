package com.vvuono.weatherapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

public class SearchActivity extends AppCompatActivity {
    @BindView(R.id.et_zip_code) EditText zipCodeField;
    @BindView(R.id.b_search) Button searchButton;

    // For the purposes of this exercise, we will not consider ZIP+4 Codes
    private final int ZIP_CODE_LENGTH = 5;

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
    }

    @OnClick(R.id.b_search)
    public void searchForZipCode(View view) {
         // TODO: Call API
    }

    private boolean isZipCodeValid(String zipCode) {
        return zipCode.length() == ZIP_CODE_LENGTH;
    }
}
