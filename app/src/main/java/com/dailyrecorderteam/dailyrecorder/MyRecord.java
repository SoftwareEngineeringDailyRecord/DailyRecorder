package com.dailyrecorderteam.dailyrecorder;

import org.litepal.crud.DataSupport;

import java.io.Serializable;

public abstract class MyRecord extends DataSupport implements Serializable {

    static public final int CALORIE_RECORD = 1;
    static public final int BIGDAY_RECORD = 2;
    static public final int TODO_RECORD = 3;

    private int id;

    private long time;

    private int year;

    private int month;

    private int day;

    private int hour;

    private int minute;

    private int second;

    private int type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
