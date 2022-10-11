package com.example.adivinaelnumero;

import android.content.Context;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrarGanador extends AppCompatActivity {
    Button botonRegistrar;
    EditText dniIngresado;
    EditText nombreIngresado;

    int intentos = 0;

    String dni = dniIngresado.getText().toString();
    String nombre = nombreIngresado.getText().toString();
    boolean alta = OperacionesDB.Alta(this, dni,nombre,intentos);
    CharSequence textOk = "Datos del usuario registrados correctamente";
    CharSequence textNok = "Datos del usuario no se pudieron registrar";
    if(alta)
    {
        Toast.makeText(this,textOk,Toast.LENGTH_SHORT);
    }
    else
    {
        Toast.makeText(this,textNok,Toast.LENGTH_SHORT);
    }
}
