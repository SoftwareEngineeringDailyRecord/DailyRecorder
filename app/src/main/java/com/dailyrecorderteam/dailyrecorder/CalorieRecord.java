package com.dailyrecorderteam.dailyrecorder;

public class CalorieRecord extends MyRecord {

    private String food;

    private int weight;   //g

    private int calorie;

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
}
