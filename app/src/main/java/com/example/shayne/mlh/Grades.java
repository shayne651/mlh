package com.example.shayne.mlh;

/**
 * Created by shayne on 2017-12-02.
 */

public class Grades {
    float GPA;
    int year;
    int sem;
    String title;

    public Grades(float GPA, int sem,int year, String title){
        this.GPA = GPA;
        this.sem = sem;
        this.year = year;
        this.title = title;
    }

    public String getTitle(){return title;}
}
