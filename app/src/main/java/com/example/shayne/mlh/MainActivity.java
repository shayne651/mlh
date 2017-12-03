package com.example.shayne.mlh;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private GradeArrayAdapter contact;
    private ListView gradeL;
    private ArrayList<Class> classes;
    private String saveLocation = "classes.dat";
    private final int newClassReqCode = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        classes = new ArrayList<Class>();
        gradeL = (ListView)findViewById(R.id.gradeList);
        try {
            FileInputStream in = openFileInput(saveLocation);
            ObjectInputStream oin = new ObjectInputStream(in);
            while (oin != null) {
                classes.add((Class)oin.readObject());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        updateClassList();

        gradeL.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> l, View v, final int position, long id) {
                Class c = (Class) l.getItemAtPosition(position);
                classes.remove(c);
                updateClassList();
                return true;
            }
        });

        gradeL.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> l, View v, final int position, long id) {
                Intent in = new Intent(getBaseContext(), Categories.class);
                startActivity(in);
            }
        });
    }

    private void updateClassList(){
        ClassArrayAdapter ad = new ClassArrayAdapter(this,classes);
        gradeL.setAdapter(ad);
    }

    public void newCourse(View view){
        Intent intent = new Intent(MainActivity.this, AddClass.class);
        startActivityForResult(intent,newClassReqCode);
    }

    @Override
    public void onActivityResult(int requestCode,int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode == newClassReqCode) {
            if (resultCode == Activity.RESULT_OK) {
                String val = data.getStringExtra("name");
                classes.add(DataKt.newClass(val));
                updateClassList();
            }
        }
    }

    @Override
    public void onPause() {
        try {
            OutputStream outputStream = openFileOutput(saveLocation, Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(outputStream);
            for (Class c :classes) {
                oos.writeObject(c);
            };
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onPause();
    }


}
