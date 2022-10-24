package com.example.adivinaelnumero;

public class Puntaje
{
    private int intentos;
    private String nombre;
    private int dni;

    public Puntaje(int dni, String n, int p)
    {
        intentos=p;
        nombre=n;
        this.dni=dni;
    }

    public int getScore() {
        return intentos;
    }

    public String getNombre(){
        return nombre;
    }

    public int getDni() {
        return dni;
    }
}
