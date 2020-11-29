package com.example.bloodbank;

import android.app.Activity;
import android.content.Context;
import android.icu.text.Transliterator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class Adapter extends ArrayAdapter<Requests> {

    private Activity context;
    private List<Requests> list;

    public Adapter(Activity context,List<Requests> list) {
        super(context, R.layout.request_sample, list);
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position,  View convertView,ViewGroup parent) {

        LayoutInflater layoutInflater=context.getLayoutInflater();
        View view=layoutInflater.inflate(R.layout.request_sample,null,true);
        Requests requests=list.get(position);

        TextView t1=view.findViewById(R.id.sampleName);
        TextView t2=view.findViewById(R.id.sampleAddress);
        TextView t3=view.findViewById(R.id.sampleBloodg);
        TextView t4=view.findViewById(R.id.sampleDate);

        t1.setText("Name:"+requests.getName());
        t2.setText("Address:"+requests.getAddress());
        t3.setText("Blood Group:"+requests.getBlood_Group());
        t4.setText("Phone:"+requests.getDate());


        return view;
    }
}
