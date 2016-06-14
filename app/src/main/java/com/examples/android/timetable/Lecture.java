package com.examples.android.timetable;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.examples.android.timetable.database.LectureBaseHelper;
import com.examples.android.timetable.database.LectureCursorWrapper;

import java.util.ArrayList;
import java.util.List;

import static com.examples.android.timetable.database.CrimeDbSchema.LectureTable;

/**
 * Created by Deepanshu on 13-06-2016.
 */
public class Lecture {
    public String lectureDay;
    public String startTime;
    public String endTime;
    public String lectureName;

    private static Lecture sLecture;

    private Context mContext;
    private SQLiteDatabase mDatabase;

    public Lecture(Context context) {
        mContext = context;
        mDatabase = new LectureBaseHelper(mContext)
                .getWritableDatabase();
    }

    public Lecture() {
    }

    public void addLecture(Lecture lecture) {
        ContentValues values = getContentValues(lecture);

            mDatabase.insert(LectureTable.NAME, null, values);
    }

    public List<Lecture> getLectures(String day) {
        List<Lecture> lectures = new ArrayList<>();
        LectureCursorWrapper cursor = queryLectures(
                LectureTable.Cols.DAY + " = ?",
                new String[] { day }
        );
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                lectures.add(cursor.getLecture());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }
        return lectures;
    }

    private static ContentValues getContentValues(Lecture lecture) {
        ContentValues values = new ContentValues();
        values.put(LectureTable.Cols.DAY, lecture.getLectureDay());
        values.put(LectureTable.Cols.START_TIME, lecture.getStartTime());
        values.put(LectureTable.Cols.END_TIME, lecture.getEndTime());
        values.put(LectureTable.Cols.LECTURE_NAME, lecture.getLectureName());
        return values;
    }

    private LectureCursorWrapper queryLectures(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                LectureTable.NAME,
                null, // Columns - null selects all columns
                whereClause,
                whereArgs,
                null, // groupBy
                null, // having
                null // orderBy
        );
        return new LectureCursorWrapper(cursor);
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String sTime) {
        startTime = sTime;
    }

    public String getLectureDay() {
        return lectureDay;
    }

    public void setLectureDay(String lecDay) {
       lectureDay = lecDay;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String eTime) {
        endTime = eTime;
    }

    public String getLectureName() {
        return lectureName;
    }

    public void setLectureName(String lecName) {
        lectureName = lecName;
    }
}
