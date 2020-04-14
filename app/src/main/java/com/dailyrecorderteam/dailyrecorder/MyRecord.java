package com.dailyrecorderteam.dailyrecorder;

import org.litepal.crud.DataSupport;

public abstract class MyRecord extends DataSupport {

    private int id;

    private long time;

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
}
