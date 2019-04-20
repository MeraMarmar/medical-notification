package com.example.mdecinenotofication;

public class Medecine {
    String nameOfmedicine, date, hour, minute,second , numoftaken;

    public String getHour() {
        return hour;
    }

    public String getMinute() {
        return minute;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public String getSecond() {
        return second;
    }

    public Medecine(String nameOfmedicine, String date,String hour, String minute,String second , String numoftaken) {
        this.nameOfmedicine = nameOfmedicine;
        this.date = date;
        this.hour = hour;
        this.minute=minute;
        this.second=second;
        this.numoftaken = numoftaken;

    }

    public void setNameOfmedicine(String nameOfmedicine) {
        this.nameOfmedicine = nameOfmedicine;
    }

    public void setDate(String date) {
        this.date = date;
    }



    public void setNumoftaken(String numoftaken) {
        this.numoftaken = numoftaken;
    }

    public String getNameOfmedicine() {
        return nameOfmedicine;
    }

    public String getDate() {
        return date;
    }



    public String getNumoftaken() {
        return numoftaken;
    }
}
