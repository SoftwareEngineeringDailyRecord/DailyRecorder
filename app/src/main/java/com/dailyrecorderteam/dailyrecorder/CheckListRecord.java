package com.dailyrecorderteam.dailyrecorder;

public class CheckListRecord extends MyRecord {

    private String event;

    private int checkTime;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public int getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(int checkTime) {
        this.checkTime = checkTime;
    }
}
