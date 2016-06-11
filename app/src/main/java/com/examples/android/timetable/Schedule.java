package com.examples.android.timetable;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Schedule extends AppCompatActivity {
    private static final String DAY = "com.examples.android.timetable.weekday";

    public static Intent newIntent(Context packageContext, String weekday) {
        Intent i = new Intent(packageContext, Schedule.class);
        i.putExtra(DAY, weekday);
        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
    }
}
