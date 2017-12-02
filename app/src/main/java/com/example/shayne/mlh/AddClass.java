package com.example.shayne.mlh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AddClass extends MainActivity {

    TextView txtCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_class);
        txtCourse = (TextView)findViewById(R.id.inputCourse);
    }

    public void ButtonOnClick(View view){
        final Button button = (Button) findViewById(R.id.buttonAdd);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent ret = new Intent();
                ret.putExtra("name",txtCourse.getText().toString());
                finish();
            }
        });
    }
}
