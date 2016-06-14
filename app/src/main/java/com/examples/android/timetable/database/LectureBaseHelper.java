package com.examples.android.timetable.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.examples.android.timetable.database.CrimeDbSchema.*;

/**
 * Created by Deepanshu on 13-06-2016.
 */
public class LectureBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "timeTable.db";

    public LectureBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + LectureTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                LectureTable.Cols.DAY + ", " +
                LectureTable.Cols.START_TIME + ", " +
                LectureTable.Cols.END_TIME + ", " +
                LectureTable.Cols.LECTURE_NAME +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
