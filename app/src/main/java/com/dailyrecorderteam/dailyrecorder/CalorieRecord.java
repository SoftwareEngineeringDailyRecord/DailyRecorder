package com.dailyrecorderteam.dailyrecorder;

public class CalorieRecord extends MyRecord {

    private String food;

    private int weight;   //g

    private double calorie;

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

    public double getCalorie() {
        return calorie;
    }

    public void setCalorie(double calorie) {
        this.calorie = calorie;
    }
}
