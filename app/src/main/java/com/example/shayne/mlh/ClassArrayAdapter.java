package com.example.shayne.mlh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by shayne on 2017-12-02.
 */

public class ClassArrayAdapter extends ArrayAdapter<Class> {

    private List<Class> classes;
    private Context context;

    public ClassArrayAdapter(Context context, List<Class> data){
        super(context, R.layout.activity_list_item,data);
        this.context = context;
        classes = data;
    }

    @Override
    public View getView(int position, View reusable, ViewGroup parent){
        Class clas = classes.get(position);
        View p = reusable;

        if (reusable == null){
            LayoutInflater inf = LayoutInflater.from(getContext());
            p = inf.inflate(R.layout.activity_list_item, null);
        }
        TextView txtName = (TextView)p.findViewById(R.id.txtTitle);
        txtName.setText(clas.getName());

        return p;
    }
}
