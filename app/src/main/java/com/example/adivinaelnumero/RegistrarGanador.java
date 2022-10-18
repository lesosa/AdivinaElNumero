package com.example.adivinaelnumero;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrarGanador extends AppCompatActivity {

    Button buttonRegistrar;
    EditText dniIngresado;
    EditText nombreIngresado;
    TextView resultIntentos;
    String dni;
    String nombre;
    int intentos = 0;



    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ganador);
        intentos = getIntent().getIntExtra("Intentos",0);

        dni = dniIngresado.getText().toString();
        nombre = nombreIngresado.getText().toString();

        resultIntentos = findViewById(R.id.txtVResultadoIntentos);
        resultIntentos.setText(intentos);

        CharSequence textOk = "Datos del usuario registrados correctamente";
        CharSequence textNok = "Datos del usuario no se pudieron registrar";

        buttonRegistrar = (Button) findViewById(R.id.buttonRegistrar);
        buttonRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                boolean alta = OperacionesDB.Alta(RegistrarGanador.this, dni,nombre,intentos);
                if(alta)
                {
                    Toast.makeText(RegistrarGanador.this,textOk,Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(RegistrarGanador.this,textNok,Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
