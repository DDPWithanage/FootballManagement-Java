package net.codejava;

import java.io.Serializable;

public class Date implements Serializable {
    private int day;
    private int month;
    private int year;

    //Default Constructor
    public Date() {

    }

    //Parameterized constructor
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    //Getters
    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    //Setters
    //Set day for date variable in Football club class
    public void setDay(int day) {
        if (day <= 30 && day > 0) {
            this.day = day;
        } else {
            System.out.print("Invalid number for date");
        }
        this.day = day;
    }

    //Set month for date variable in Football club class
    public void setMonth(int month) {
        if (month <= 12 && month > 0) {
            this.month = month;
        } else {
            System.out.print("Invalid number for month");
        }
        this.month = month;
    }

    //Set year for date variable in Football club class
    public void setYear(int year) {
        this.year = year;
    }

    //Create toString method for add validation
    @Override
    public String toString() {
        return "Date : " + String.format("%02d", day) + "/" + String.format("%02d", month) + "/" + String.format("%04d", year);
    }
}
