package com.example.adivinaelnumero;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Score extends AppCompatActivity
{
    Button btnVolverPrincipal;
    ArrayList<Puntaje> puntajeList;
    Cursor data;
    Puntaje punt;
    TwoColumn_ListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        ListView lv = (ListView) findViewById(R.id.listaPunt);
        btnVolverPrincipal= (Button) findViewById(R.id.buttonVolverPrincipal);

        btnVolverPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        ArrayList<Score> list;
        AdminDb admin= new AdminDb(this, null);
        puntajeList = new ArrayList<>();

        data = admin.llenarLista();  // crear getListContents

        int numRows = data.getCount();
        if (numRows == 0) {
            Toast.makeText(this, "No hay datos cargados", Toast.LENGTH_LONG).show();
        } else {
            int i = 0;
            while (data.moveToNext()) {
                punt = new Puntaje(data.getInt(0), data.getString(1), data.getInt(2));
                puntajeList.add(i, punt);
            }
            if (!puntajeList.isEmpty()) {
                adapter = new TwoColumn_ListAdapter(this, R.layout.single_item, puntajeList);

                lv.setAdapter(adapter);

            }
        }
    }
}
