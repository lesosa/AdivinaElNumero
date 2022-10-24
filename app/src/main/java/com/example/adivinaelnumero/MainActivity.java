package com.example.adivinaelnumero;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    Button btnJugar;
    Button btnPuntajes;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Boton para ir a Jugar
        btnJugar = (Button) findViewById(R.id.buttonAJugar);
        btnJugar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Juego.class);
                startActivity(intent);
            }
        });

        btnPuntajes= (Button) findViewById(R.id.btnPuntajes);
        btnPuntajes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this, Score.class);
                startActivity(intent2);
            }
        });


    }

}