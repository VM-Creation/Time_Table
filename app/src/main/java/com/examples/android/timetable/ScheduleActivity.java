package com.examples.android.timetable;

import android.support.v4.app.Fragment;

public class ScheduleActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return ScheduleFragment.newInstance();
    }
}
