package com.example.shayne.mlh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private GradeArrayAdapter contact;
    private ListView gradeL;
    private ArrayList<Class> classes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gradeL = (ListView)findViewById(R.id.gradeList);
        java.lang.Float[] grades = {0.2f};
        Grade gr = DataKt.newGrade("dis",.2f,grades);
        Grade gr2 = DataKt.newGrade("ex",.2f,grades);
        ArrayList<Grade> gra= new ArrayList<Grade>();
        gra.add(gr);
        gra.add(gr2);
        Class cas = new Class("dis",gra);
        Class cas2 = new Class("s",gra);
        classes = new ArrayList<Class>();
        classes.add(cas);
        classes.add(cas2);

        updateClassList();
    }

    private void updateClassList(){
        ClassArrayAdapter ad = new ClassArrayAdapter(this,classes);
        gradeL.setAdapter(ad);
    }

    public void newCourse(View view){
        Intent intent = new Intent(MainActivity.this, AddClass.class);
    }


}
