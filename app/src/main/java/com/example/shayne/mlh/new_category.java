package com.example.shayne.mlh;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.ParseException;

import static java.lang.Integer.parseInt;

public class new_category extends AppCompatActivity {
    private int weight = 0;
    EditText weightEditor;
    EditText nameEditor;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_category);
        Intent show = getIntent();
        weightEditor = (EditText)findViewById(R.id.weight_val);
        nameEditor = (EditText)findViewById(R.id.name_val);
        save  = (Button)findViewById(R.id.save_button);
        save.setClickable(false);
        weightEditor.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                isValidData();
            }
        });
        nameEditor.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                isValidData();
            }
        });
    }

    public void save(View view)
    {
        TextView txtName = (TextView)findViewById(R.id.name_val);
        Intent ret = new Intent();
        setResult(Activity.RESULT_OK,ret.putExtra("category_name", txtName.getText().toString()));
        ret.putExtra("weight_value", weight);
        finish();
    }
    public void cancel(View view)
    {
        finish();
    }

    private boolean isValidWeight(TextView textView) {
        if (textView.length() < 1) return false;
        try {
            weight = java.lang.Integer.parseInt(textView.getText().toString());
        } catch (java.lang.NumberFormatException e) {
            return false;
        }  catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    private boolean isValidData() {
        if (nameEditor.getText().length() > 0 && isValidWeight(weightEditor)){
            save.setClickable(true);
            return true;
        } else {
            save.setClickable(false);
            return false;
        }
    }
}