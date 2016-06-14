package com.examples.android.timetable.database;

/**
 * Created by Deepanshu on 13-06-2016.
 */
public class CrimeDbSchema {
    public static final class LectureTable {
        public static final String NAME = "lecture";
        public static final class Cols {
            public static final String DAY = "day";
            public static final String START_TIME = "startTime";
            public static final String END_TIME = "endTime";
            public static final String LECTURE_NAME = "lectureName";
        }
    }
}
