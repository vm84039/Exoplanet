package com.planetdata;

public class TimelineData {
    private int year;
    private int small;
    private int medium;
    private int large;

    // Constructor
    public TimelineData(int year, int small, int medium, int large) {
        this.year = year;
        this.small = small;
        this.medium = medium;
        this.large = large;
    }

    // Getters
    public int getYear() {
        return year;
    }

    public int getSmall() {
        return small;
    }

    public int getMedium() {
        return medium;
    }

    public int getLarge() {
        return large;
    }

    public static String singular(int num) {
        if (num == 1) {
            return "planet";
        } else {
            return "planets";
        }
    }

    @Override
    public String toString() {
        return "Year: " + year + ", Small: " + small + ", Medium: " + medium + ", Large: " + large;
    }
}
