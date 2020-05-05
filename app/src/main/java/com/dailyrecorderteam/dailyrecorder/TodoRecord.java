package com.dailyrecorderteam.dailyrecorder;

public class TodoRecord extends MyRecord {

    private String event;

    private long doTime;

    private String tag;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public long getDoTime() {
        return doTime;
    }

    public void setDoTime(long doTime) {
        this.doTime = doTime;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    @Override
    public long getTime() {
        return super.getTime();
    }

    @Override
    public void setTime(long time) {
        super.setTime(time);
    }

    @Override
    public int getYear() {
        return super.getYear();
    }

    @Override
    public void setYear(int year) {
        super.setYear(year);
    }

    @Override
    public int getMonth() {
        return super.getMonth();
    }

    @Override
    public void setMonth(int month) {
        super.setMonth(month);
    }

    @Override
    public int getDay() {
        return super.getDay();
    }

    @Override
    public void setDay(int day) {
        super.setDay(day);
    }

    @Override
    public int getHour() {
        return super.getHour();
    }

    @Override
    public void setHour(int hour) {
        super.setHour(hour);
    }

    @Override
    public int getSecond() {
        return super.getSecond();
    }

    @Override
    public void setSecond(int second) {
        super.setSecond(second);
    }

    @Override
    public int getMinute() {
        return super.getMinute();
    }

    @Override
    public void setMinute(int minute) {
        super.setMinute(minute);
    }

    @Override
    public int getType() {
        return super.getType();
    }

    @Override
    public void setType(int type) {
        super.setType(type);
    }
}
