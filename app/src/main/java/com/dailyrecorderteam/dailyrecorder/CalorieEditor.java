package com.dailyrecorderteam.dailyrecorder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class CalorieEditor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.calorieeditorlayout);
    }
}
