package com.example.adivinaelnumero;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.widget.Toast;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;
import java.lang.Math;
public class Juego extends AppCompatActivity
{
    TextView respuesta;
    Button botonVerifica;
    int[] nroGenerado;
    int[] nroIngresado;
    EditText textoIngresado;
    boolean verif;
    int textoANroIngresado; //utilizado para parsear el texto ingresado en el edittext
    int resulto;
    int[] resultado;
    ArrayList<String> listaIntentosFallidos=new ArrayList<>();
    ListView listIF;


    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        respuesta=(TextView) findViewById(R.id.txtRes);
        getNro();

        listIF = (ListView) findViewById(R.id.historialVerificaciones);

        botonVerifica = (Button) findViewById(R.id.buttonVerificar);
        botonVerifica.setOnClickListener(new View.OnClickListener(){ //verifica eL nro ingresado
            @Override
            public void onClick(View view)
            {
                textoIngresado = (EditText) findViewById(R.id.nroIngresado);//lee el nro ingresado
                textoANroIngresado = (Integer.parseInt(textoIngresado.getText().toString()));
                cumpleNroIngresado(textoANroIngresado);
                if(verif == true)
                {
                    calculoRes();
                    if(resulto==0)
                    {
                        Toast.makeText(Juego.this, "Ganaste!", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        listaIntentosFallidos.add("B: " + resultado[0] + " - R: "+ resultado[1]);
                        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(Juego.this, android.R.layout.simple_list_item_1, listaIntentosFallidos);
                        listIF.setAdapter(adaptador);

                    }
                }
            }
        });

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

    public void cumpleNroIngresado (int nroIngresado2)
    {
        verif = true;
        if(nroIngresado2<1023 || nroIngresado2>9876)//Se pasa del limite
        {
            Toast.makeText(Juego.this, "Ingreso un numero invalido. \n El nro debe poseer 4 digitos. \n El rango es entre (1023-9876). \n Intente nuevamente", Toast.LENGTH_LONG).show();
            verif = false;
        }
        else
        {
            nroIngresado=descomposicion(nroIngresado2).clone(); //Se descompone y se pasa al vector nroIngresado
            if(verificoRepeticion(nroIngresado) == true)
            {
                Toast.makeText(Juego.this, "Ingreso un numero invalido. \n No puede haber digitos repetidos. \n Intente nuevamente", Toast.LENGTH_LONG).show();
                verif = false;
            }
        }
    }

    public int[] comparoNumero(int[] nroGenerado, int[] nroCargado){
        int bien = calculoBien(nroGenerado,nroCargado);
        int regular = calculoRegular(nroGenerado,nroCargado);
        int[] resultado;
        resultado = new int[] {bien,regular};
        return resultado;
    }
    public int calculoBien(int[] ng, int[] nc) {
        int bien=0;
        for(int i=0; i<(ng.length);i++)
        {
            if(ng [i] == nc[i])
            {
                bien++;
            }
        }
        return bien;
    }
    public int calculoRegular(int[] ng, int[] nc)
    {
        if(ng[0]==nc[1]||ng[0]==nc[2]||ng[0]==nc[3]){
            if(ng[1]==nc[0]||ng[1]==nc[2]||ng[1]==nc[3]) {
                if (ng[2] == nc[0] || ng[2] == nc[1] || ng[2] == nc[3]) {
                    if (ng[3] == nc[0] || ng[3] == nc[1] || ng[3] == nc[2])
                        return 4;
                    else
                        return 3;
                }
                else
                    return 2;
            }
            else
                return 1;
        }
        else
            return 0;
    }
    public void calculoRes()
    {
        resulto = 0;
        resultado = comparoNumero(nroGenerado, nroIngresado);
        if (resultado[0] == 4)
            resulto = 0;//logica win
        else
            resulto = 1;//logica lost
    }

}
