package com.examples.android.timetable.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.examples.android.timetable.Lecture;

import static com.examples.android.timetable.database.CrimeDbSchema.LectureTable;

/**
 * Created by Deepanshu on 13-06-2016.
 */
public class LectureCursorWrapper extends CursorWrapper {
    public LectureCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Lecture getLecture() {
        String dayString = getString(getColumnIndex(LectureTable.Cols.DAY));
        String startTimeString = getString(getColumnIndex(LectureTable.Cols.START_TIME));
        String endTimeString = getString(getColumnIndex(LectureTable.Cols.END_TIME));
        String lectureNameString = getString(getColumnIndex(LectureTable.Cols.LECTURE_NAME));

        Lecture Lecture = new Lecture();
        Lecture.setLectureDay(dayString);
        Lecture.setStartTime(startTimeString);
        Lecture.setEndTime(endTimeString);
        Lecture.setLectureName(lectureNameString);
        return Lecture;
    }
}
