package com.vvuono.weatherapp;

import org.junit.Test;

import static org.junit.Assert.*;

public class ZipCodeValidatorTest {
    @Test
    public void emptyZipCode_IsNotValid() throws Exception {
        String zipCode = "";
        SearchActivity searchActivity = new SearchActivity();
        boolean result = searchActivity.isZipCodeValid(zipCode);
        assertThat(result, is(false));
    }

    @Test
    public void fourDigitZipCode_IsNotValid() throws Exception {
        String zipCode = "1234";
        SearchActivity searchActivity = new SearchActivity();
        boolean result = searchActivity.isZipCodeValid(zipCode);
        assertThat(result, is(false));
    }

    @Test
    public void fiveDigitZipCode_IsValid() throws Exception {
        String zipCode = "12345";
        SearchActivity searchActivity = new SearchActivity();
        boolean result = searchActivity.isZipCodeValid(zipCode);
        assertThat(result, is(true));
    }
}