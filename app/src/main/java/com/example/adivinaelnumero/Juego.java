package com.example.adivinaelnumero;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.content.res.ColorStateList;
import android.graphics.Color;

import androidx.appcompat.app.AppCompatActivity;
import java.lang.Math;
public class Juego extends AppCompatActivity {
    TextView respuesta;
    int[] nroGenerado;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        respuesta=(TextView) findViewById(R.id.txtRes);
        getNro();

    }

    //generar el número
    public void getNro()
    {
        int aux= (int)(Math.random() * 8853 + 1023);
        int[] NroAleatorio= descomposicion(aux).clone(); //descompone el numero generado en un vector
        while( verificoRepeticion(NroAleatorio)){ //si existe repeticiones en ese nro lo vuelve a generar
            aux= (int)(Math.random() * 8853 + 1023);
            NroAleatorio= descomposicion(aux).clone();
        }

        nroGenerado=NroAleatorio.clone(); //cumple las condiciones entonces lo copia
        respuesta.setVisibility(View.VISIBLE);
        respuesta.setText(Integer.toString(aux));


    }
    public int[] descomposicion(int nro){
        int resto, um, cen, dec, uni;
        int[] nrodesc;
        //descompongo la unidad de mil
        um= (nro - (nro % 1000)) /1000;
        resto= nro % 1000;
        //descompongo la centena
        cen= ( resto - (resto % 100)) /100;
        resto= resto % 100;
        //descomongo la decena
        dec= ( resto - (resto % 10)) /10;
        //descompongo la unidad
        uni=resto % 10;
        nrodesc= new int[] {um, cen, dec, uni};
        return nrodesc;
    }

    public boolean verificoRepeticion(int[] nrods){
        if(nrods[0]==nrods[1]||nrods[0]==nrods[2]||nrods[0]==nrods[3])
            return true;
        else if(nrods[1]==nrods[2]||nrods[1]==nrods[3])
            return true;
            else if(nrods[2]==nrods[3])
                return true;
            else
                return false;
    }//cierra verificaRepeticion
}
