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
}
