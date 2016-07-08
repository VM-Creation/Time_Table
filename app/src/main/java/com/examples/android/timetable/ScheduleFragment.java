package com.examples.android.timetable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/**
 * Created by Deepanshu on 07-07-2016.
 */
public class ScheduleFragment extends Fragment {

    public static ScheduleFragment newInstance() {
        return new ScheduleFragment();
    }

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    Button add;

    private static final int REQUEST_DAY = 0;

    List<Lecture> myDataset = new ArrayList<>();

    private String day;

    TextView heading;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.schedule, container, false);

        day = Calendar.getInstance().getDisplayName(Calendar.DAY_OF_WEEK,Calendar.LONG, Locale.UK);

        heading = (TextView) v.findViewById(R.id.heading);

        mRecyclerView = (RecyclerView) v.findViewById(R.id.lecture_view);
        mLayoutManager = new LinearLayoutManager(getActivity());
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
        updateSchedule(day);
        add = (Button) v.findViewById(R.id.add_button);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = WeekDays.newIntent(getContext());
                startActivityForResult(intent,REQUEST_DAY);
            }
        });
        return v;
    }

    /*@Override
    public void onResume() {
        super.onResume();
        updateSchedule(day);
    }*/

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_menu, menu);

        /*MenuItem addlecture = menu.findItem(R.id.menu_item_new_lecture);
        MenuItem showWeekdays = menu.findItem(R.id.menu_item_show_weekdays);*/

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case R.id.menu_item_new_lecture:

                return true;
            case R.id.menu_item_show_weekdays:
                Intent intent = WeekDays.newIntent(getContext());
                startActivityForResult(intent,REQUEST_DAY);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) {
            return;
        }
        if (requestCode == REQUEST_DAY) {
            String day = data.getStringExtra(WeekDays.DAY);
            updateSchedule(day);
        }
    }

    private void updateSchedule(String weekDay){
        heading.setText(weekDay);

        myDataset = new Lecture(getActivity()).getLectures(weekDay);

        mAdapter = new MyAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);
    }
}
