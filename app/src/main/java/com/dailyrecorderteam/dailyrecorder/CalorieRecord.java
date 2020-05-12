package com.dailyrecorderteam.dailyrecorder;

public class CalorieRecord extends MyRecord {

    private String food;

    private int weight;   //g

    private int calorie;

    public CalorieRecord() {}

    public CalorieRecord(String food, int weight, int calorie){
        this.food = food;
        this.weight = weight;
        this.calorie = calorie;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getCalorie() {
        return calorie;
    }

    public void setCalorie(int calorie) {
        this.calorie = calorie;
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
