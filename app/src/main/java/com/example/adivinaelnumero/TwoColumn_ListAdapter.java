package com.example.adivinaelnumero;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TwoColumn_ListAdapter extends ArrayAdapter<Puntaje>  {

    private LayoutInflater inflater;
    private ArrayList<Puntaje> puntajes;
    private int viewResourceID;
    TextView nombre;
    TextView score;
    TextView dni;
    private int count=0;
    public TwoColumn_ListAdapter(Context context, int textViewResourceID, ArrayList<Puntaje> puntajes ){
        super(context, textViewResourceID, puntajes);
        this.puntajes=puntajes;
        inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        viewResourceID=textViewResourceID;
    }

    public View getView(int position, View convertView, ViewGroup parents){
        convertView=inflater.inflate(viewResourceID, null);
        Puntaje p=puntajes.get(position);
        if(p!=null){
                View finalConvertView = convertView;
                nombre = (TextView) finalConvertView.findViewById(R.id.nombreList);
                score = (TextView) finalConvertView.findViewById(R.id.scoreList);
                dni=(TextView) finalConvertView.findViewById(R.id.dniList);
                nombre.setText(p.getNombre());
                score.setText(String.valueOf(p.getScore()));
                dni.setText(String.valueOf(p.getDni()));
        }
        return convertView;
    }
}
