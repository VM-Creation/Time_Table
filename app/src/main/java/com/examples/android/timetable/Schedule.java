package com.examples.android.timetable;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Schedule extends AppCompatActivity {
    private static final String DAY = "com.examples.android.timetable.weekday";
    private String day;

    TextView heading;

    public static Intent newIntent(Context packageContext, String weekday) {
        Intent i = new Intent(packageContext, Schedule.class);
        i.putExtra(DAY, weekday);
        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        day = getIntent().getStringExtra(DAY);
        //Toast.makeText(Schedule.this, day, Toast.LENGTH_LONG).show();

        heading = (TextView)findViewById(R.id.heading);
        heading.setText(day);

    }
}
