package com.examples.android.timetable;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;

public class Schedule extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    ArrayList<String> myDataset = new ArrayList<>();

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

        myDataset.add("one");
        myDataset.add("two");
        myDataset.add("three");
        myDataset.add("four");
        myDataset.add("five");
        myDataset.add("six");
        myDataset.add("seven");
        myDataset.add("eight");
        myDataset.add("nine");
        myDataset.add("ten");
        myDataset.add("eleven");
        myDataset.add("twelve");
        myDataset.add("thirteen");
        myDataset.add("seven");
        myDataset.add("eight");
        myDataset.add("nine");
        myDataset.add("ten");
        myDataset.add("eleven");
        myDataset.add("twelve");
        myDataset.add("thirteen");

        // specify an adapter
        mAdapter = new RecyclerViewAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);

    }
}
