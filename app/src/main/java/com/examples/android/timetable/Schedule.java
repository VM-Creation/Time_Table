package com.examples.android.timetable;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Schedule extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    List<Lecture> myDataset = new ArrayList<>();

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

        mRecyclerView = (RecyclerView) findViewById(R.id.lecture_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        //mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        //Delete after add button is enabled
        /*Lecture lec1;
        lec1 = new Lecture();

        lec1.setLectureDay("Monday");
        lec1.setStartTime("08:30 AM");
        lec1.setEndTime("09:25 AM");
        lec1.setLectureName("Mon1");
        new Lecture(this).addLecture(lec1);

        lec1.setLectureDay("Tuesday");
        lec1.setStartTime("08:30 AM");
        lec1.setEndTime("09:25 AM");
        lec1.setLectureName("Tue1");
        new Lecture(this).addLecture(lec1);

        lec1.setLectureDay("Tuesday");
        lec1.setStartTime("09:25 AM");
        lec1.setEndTime("10:20 AM");
        lec1.setLectureName("Tue2");
        new Lecture(this).addLecture(lec1);

        lec1.setLectureDay("Wednesday");
        lec1.setStartTime("10:30 AM");
        lec1.setEndTime("11:25 AM");
        lec1.setLectureName("Wed1");
        new Lecture(this).addLecture(lec1);

        lec1.setLectureDay("Thursday");
        lec1.setStartTime("08:30 AM");
        lec1.setEndTime("09:25 AM");
        lec1.setLectureName("Thu1");
        new Lecture(this).addLecture(lec1);

        lec1.setLectureDay("Friday");
        lec1.setStartTime("02:30 PM");
        lec1.setEndTime("03:25 PM");
        lec1.setLectureName("FRI1");
        new Lecture(this).addLecture(lec1);*/

        myDataset = new Lecture(this).getLectures(day);

        // specify an adapter
        mAdapter = new MyAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);

    }
}
