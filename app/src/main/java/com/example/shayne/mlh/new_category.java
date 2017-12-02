package com.example.shayne.mlh;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class new_category extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_category);
        Intent show = getIntent();
    }

    public void save(View view)
    {
        TextView txtName = (TextView)findViewById(R.id.name_val);
        TextView txtWeight = (TextView)findViewById((R.id.weight_val));
        Intent ret = new Intent();
        setResult(Activity.RESULT_OK,ret.putExtra("category_name", txtName.getText()));
        ret.putExtra("weight_value", txtWeight.getText());
        finish();
    }
    public void cancel(View view)
    {
        finish();
    }
}
