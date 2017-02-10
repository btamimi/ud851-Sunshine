package com.example.android.sunshine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private static final String FORECAST_SHARE_HASHTAG = " #SunshineApp";
    private TextView tvWeather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        tvWeather = (TextView) findViewById(R.id.tv_weather);

        // COMPLETED (2) Display the weather forecast that was passed from MainActivity
        Intent receivedIntent = getIntent();
        if(receivedIntent!= null && receivedIntent.hasExtra(Intent.EXTRA_TEXT)){
            String weatherString = receivedIntent.getStringExtra(Intent.EXTRA_TEXT);
            tvWeather.setText(weatherString);
        }
    }
}