package com.examples.android.timetable;

/**
 * Created by Deepanshu on 09-07-2016.
 */
public class ChangeTimeFormat {
    public String set(int hour, int min){
        String time;
        if(hour>12){
            time = (hour-12) + ":" + min + " PM";
        }else if(hour<12) {
            time = hour + ":" + min + " AM";
        }else {
            time = hour + ":" + min + " PM";
        }
        return time;
    }
}
