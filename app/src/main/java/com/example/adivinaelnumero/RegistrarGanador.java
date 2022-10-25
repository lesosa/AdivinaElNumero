package com.example.adivinaelnumero;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class RegistrarGanador extends AppCompatActivity {

    Button buttonRegistrar;
    EditText etDni;
    EditText etNom;
    TextView txtVResultadoIntent;
    int dni;
    int intentos;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ganador);

        intentos = getIntent().getIntExtra("NroIntentos",intentos);

        etNom= (EditText) findViewById(R.id.txtNombre);
        etNom.setVisibility(View.VISIBLE);

        etDni= (EditText) findViewById(R.id.txtDni);
        etNom.setVisibility(View.VISIBLE);

        txtVResultadoIntent = (TextView) findViewById(R.id.txtVResultadoIntentos);
        txtVResultadoIntent.setVisibility(View.VISIBLE);
        txtVResultadoIntent.setText(Integer.toString(intentos));


        CharSequence textOk = "Datos del usuario registrados correctamente";
        CharSequence textNok = "Datos del usuario no se pudieron registrar";

        buttonRegistrar = (Button) findViewById(R.id.buttonRegistrar);
        buttonRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                dni=(Integer.parseInt(etDni.getText().toString()));
                guardarPuntaje();
            }
        });


    }

    public void guardarPuntaje() {
        AdminDb admin= new AdminDb(this,null);
        SQLiteDatabase db= admin.getWritableDatabase();

        boolean loEncontro = admin.buscarYActualizar(dni, intentos);

        if(loEncontro)
        {
            Toast.makeText(RegistrarGanador.this, "Score actualizado",Toast.LENGTH_SHORT).show();
            Intent i = new Intent(RegistrarGanador.this, MainActivity.class);
            startActivity(i);

        }
        else
            {
                String usuario = etNom.getText().toString();
                if(!usuario.isEmpty())
                {

                    ContentValues registro= new ContentValues();
                    registro.put("dni", dni);
                    registro.put("nombre", usuario);
                    registro.put("intentos", intentos);
                    db.insert("ganadores", null, registro);
                    db.close();

                    Toast.makeText(RegistrarGanador.this, "Usuario agregado",Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(RegistrarGanador.this, MainActivity.class);
                    startActivity(i);//se sale
                }
                else
                {
                    Toast.makeText(RegistrarGanador.this, "Debe ingresar un nombre de usuario",Toast.LENGTH_LONG).show();
                }
            }
        }
}
