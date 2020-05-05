package com.dailyrecorderteam.dailyrecorder;

import java.util.Calendar;

public class TimeOperator {
    /**
     *
     * @param year
     * @param month
     * @param day
     * @param hour
     * @param minute
     * @param second
     * @return long， 如2000年4月25日8点14分33秒为20000425081433 No.1.1
     */
    public static long toLongtime(int year, int month, int day, int hour, int minute, int second){
        long result = year;
        result = result*100 + month;
        result = result*100 + day;
        result = result*100 + hour;
        result = result*100 + minute;
        result = result*100 + second;
        return result;
    }

    /**
     *
     * @param time
     * @return 年份 No.1.2
     */
    public static int getYear(long time){

        return (int)(time/10000000000L);

    }

    /**
     *
     * @param time
     * @return 月份 No.1.3
     */
    public static int getMonth(long time){

        return (int)(time/100000000L)%100;
    }

    /**
     *
     * @param time
     * @return 日期 No.1.4
     */
    public static int getDay(long time){

        return (int)(time/1000000L)%100;
    }

    /**
     *
     * @param time
     * @return 时间（24小时制） No.1.5
     */
    public static int getHour(long time){

        return (int)(time/10000L)%100;
    }

    /**
     *
     * @param time
     * @return 分钟 No.1.6
     */
    public static int getMinute(long time){

        return (int)(time/100L)%100;
    }

    /**
     *
     * @param time
     * @return 秒数 No.1.7
     */
    public static int getsecond(long time){

        return (int)(time)%100;
    }

    /**
     *
     * @return 现在的时间，用上述形式做好 No.1.8
     */
    public static long getNowTime(){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DATE);
        return toLongtime(year, month, day, 0,0,0);
    }
}
