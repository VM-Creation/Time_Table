package com.examples.android.timetable;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class WeekDays extends AppCompatActivity {

    TextView today,monday,tuesday,wednesday,thrusday,friday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_days);

        today = (TextView) findViewById(R.id.today);
        today.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = Schedule.newIntent(WeekDays.this, "");
                startActivity(intent);
            }
        });
        monday = (TextView) findViewById(R.id.monday);
        monday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = Schedule.newIntent(WeekDays.this, "Monday");
                startActivity(intent);
            }
        });
        tuesday = (TextView) findViewById(R.id.tuesday);
        tuesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = Schedule.newIntent(WeekDays.this, "Tuesday");
                startActivity(intent);
            }
        });
        wednesday = (TextView) findViewById(R.id.wednesday);
        wednesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = Schedule.newIntent(WeekDays.this, "Wednesday");
                startActivity(intent);
            }
        });
        thrusday = (TextView) findViewById(R.id.thrusday);
        thrusday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = Schedule.newIntent(WeekDays.this, "Thrusday");
                startActivity(intent);
            }
        });
        friday = (TextView) findViewById(R.id.friday);
        friday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = Schedule.newIntent(WeekDays.this, "Friday");
                startActivity(intent);
            }
        });
    }
}
