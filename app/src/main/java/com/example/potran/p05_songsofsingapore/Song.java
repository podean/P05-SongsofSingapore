package com.example.potran.p05_songsofsingapore;

import android.database.sqlite.SQLiteDatabase;

import java.io.Serializable;

/**
 * Created by 127107 on 23/5/2017.
 */

public class Song implements Serializable {
    private int _id;
    private String title;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSingers(String singers) {
        this.singers = singers;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    private String singers;
    private int year;
    private int stars;

    public int get_id() {
        return _id;
    }

    public String getTitle() {
        return title;
    }

    public String getSingers() {
        return singers;
    }

    public int getYear() {
        return year;
    }

    public int getStars() {
        return stars;
    }

    public Song(String title, String singers, int year, int stars){
        this.title = title;
        this.singers = singers;

        this.stars = stars;
        this.year = year;

    }


}