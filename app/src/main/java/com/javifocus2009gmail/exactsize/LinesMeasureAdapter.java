package com.javifocus2009gmail.exactsize;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.text.InputType;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by jbenitez on 5/10/16.
 */

class LinesMeasureAdapter extends BaseAdapter {

    private Activity activity;
    private ArrayList<LineMeasure> lines;

    public LinesMeasureAdapter(Activity activity, ArrayList<LineMeasure> sitios) {
        this.activity = activity;
        this.lines = sitios;
    }


    @Override
    public int getCount() {
        return lines.size();
    }

    @Override
    public Object getItem(int position) {
        return lines.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View converView, ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.row, null, true);

        Button btn = (Button) view.findViewById(R.id.btnRemove);

        final EditText etQuanty = (EditText) view.findViewById(R.id.etQuanty);
        etQuanty.setInputType(InputType.TYPE_CLASS_NUMBER);

        final EditText etSize = (EditText) view.findViewById(R.id.etSize);
        etSize.setInputType(InputType.TYPE_CLASS_NUMBER);

        etQuanty.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                etQuanty.requestFocus();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lines.remove(position);
                notifyDataSetChanged();
                Toast.makeText(activity,
                                "Eliminada la fila " +String.valueOf(position+1), Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }}
