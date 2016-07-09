package com.examples.android.timetable;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

/**
 * Created by Deepanshu on 08-07-2016.
 */
public class AddLectureFragment extends DialogFragment {
    TextInputEditText lecName;
    TimePicker lecStartTime, lecEndTime;
    String lectureDay, lectureName, lectureStartTime, lectureEndTime;

    private static final String ARG_DAY = "day";

    public static AddLectureFragment newInstance(String day) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_DAY, day);
        AddLectureFragment fragment = new AddLectureFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        lectureDay = getArguments().getString(ARG_DAY);

        View v = LayoutInflater.from(getActivity())
                .inflate(R.layout.dialog_add_lecture,null);

        lecName = (TextInputEditText) v.findViewById(R.id.lec_name);
        lecStartTime = (TimePicker) v.findViewById(R.id.lec_start_time);
        lecEndTime = (TimePicker) v.findViewById(R.id.lec_end_time);

        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle("New Lecture")
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        lectureName = lecName.getText().toString();
                        if (Build.VERSION.SDK_INT >= 23) {
                            lectureStartTime = lecStartTime.getHour() + ":" + lecStartTime.getMinute();
                            lectureEndTime = lecEndTime.getHour() + ":" + lecEndTime.getHour();
                        }else {
                            lectureStartTime = lecStartTime.getCurrentHour() + ":" + lecStartTime.getCurrentMinute();
                            lectureEndTime = lecEndTime.getCurrentHour() + ":" + lecEndTime.getCurrentHour();
                        }
                        Toast.makeText(getContext(),lectureDay+" "+lectureName+" "+lectureStartTime+" "+lectureEndTime,Toast.LENGTH_SHORT).show();
                        Lecture newLecture;
                        newLecture = new Lecture();

                        newLecture.setLectureDay(lectureDay);
                        newLecture.setStartTime(lectureStartTime);
                        newLecture.setEndTime(lectureEndTime);
                        newLecture.setLectureName(lectureName);
                        new Lecture(getContext()).addLecture(newLecture);

                        Intent intent = new Intent();
                        getTargetFragment()
                                .onActivityResult(getTargetRequestCode(), Activity.RESULT_OK, intent);
                    }
                })
                .create();
    }
}
