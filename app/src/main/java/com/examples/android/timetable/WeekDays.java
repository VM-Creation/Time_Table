package com.examples.android.timetable;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class WeekDays extends AppCompatActivity {

    TextView today,monday,tuesday,wednesday, thursday,friday;
    public static final String DAY = "com.examples.android.timetable.weekday";

    public static Intent newIntent(Context packageContext) {
        Intent i = new Intent(packageContext, WeekDays.class);
        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_days);

        today = (TextView) findViewById(R.id.today);
        today.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendResult(Activity.RESULT_OK, ScheduleFragment.getToday());
            }
        });
        monday = (TextView) findViewById(R.id.monday);
        monday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendResult(Activity.RESULT_OK, "Monday");
            }
        });
        tuesday = (TextView) findViewById(R.id.tuesday);
        tuesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendResult(Activity.RESULT_OK, "Tuesday");
            }
        });
        wednesday = (TextView) findViewById(R.id.wednesday);
        wednesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendResult(Activity.RESULT_OK, "Wednesday");
            }
        });
        thursday = (TextView) findViewById(R.id.thursday);
        thursday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendResult(Activity.RESULT_OK, "Thursday");
            }
        });
        friday = (TextView) findViewById(R.id.friday);
        friday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendResult(Activity.RESULT_OK, "Friday");
            }
        });
    }

    private void sendResult(int resultCode, String weekDay) {
        Intent intent = new Intent();
        intent.putExtra(DAY,weekDay);
        setResult(resultCode,intent);
        finish();
    }
}
