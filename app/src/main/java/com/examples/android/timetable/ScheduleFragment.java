package com.examples.android.timetable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

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

    private static final int REQUEST_DAY = 0;
    private static final int CHECK_SUCCESS = 1;

    public static final String DIALOG_NEW_LECTURE = "new_lecture";

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

        day = getToday();

        heading = (TextView) v.findViewById(R.id.heading);

        mRecyclerView = (RecyclerView) v.findViewById(R.id.lecture_view);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        updateSchedule(day);
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateSchedule(day);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_menu, menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case R.id.menu_item_new_lecture:
                FragmentManager manager = getFragmentManager();
                AddLectureFragment dialog = AddLectureFragment.newInstance(day);
                dialog.setTargetFragment(ScheduleFragment.this, CHECK_SUCCESS);
                dialog.show(manager, DIALOG_NEW_LECTURE);
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
            day = data.getStringExtra(WeekDays.DAY);
            updateSchedule(day);
        }else if (requestCode == CHECK_SUCCESS) {
            Toast.makeText(getContext(),"Lecture Sucessfully added!!",Toast.LENGTH_SHORT).show();
            updateSchedule(day);
        }
    }

    private void updateSchedule(String weekDay){
        heading.setText(weekDay);

        myDataset = new Lecture(getActivity()).getLectures(weekDay);

        mAdapter = new MyAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);
    }

    public static String getToday(){
        String today = Calendar.getInstance().getDisplayName(Calendar.DAY_OF_WEEK,Calendar.LONG, Locale.UK);
        if (today.equals("Saturday")||today.equals("Sunday")){
            today = "Monday";
        }
        return today;
    }
}
