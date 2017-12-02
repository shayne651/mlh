package com.example.shayne.mlh;

import android.content.Context;
import android.print.PrintDocumentAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.List;

/**
 * Created by shayne on 2017-12-02.
 */

public class GradeArrayAdapter extends ArrayAdapter<Grades> {

    private List<Grade> grades;
    private Context context;

    public GradeArrayAdapter(Context context, List<Grade> data){
        super(context, R.layout.activity_list_item);
        this.context = context;
        grades = data;
    }

    @Override
    public View getView(int position, View reusable, ViewGroup parent){
        Grade grade = grades.get(position);

        if (reusable == null){
            LayoutInflater inf = LayoutInflater.from(context);
            reusable = inf.inflate(R.layout.activity_list_item, parent, false);
        }
        TextView txtName = (TextView)reusable.findViewById(R.id.txtTitle);
        TextView txtCode = (TextView)reusable.findViewById(R.id.txtCode);

        txtName.setText(grade.getName());

        return reusable;
    }

}
