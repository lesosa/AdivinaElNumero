package com.example.adivinaelnumero;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import java.util.ArrayList;

public class AdminDb  extends SQLiteOpenHelper{

    Context context;
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME = "ADIVINAR_NUM.db";

    public AdminDb(@Nullable Context context, SQLiteDatabase.CursorFactory factory ) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db){
        db.execSQL("Create table ganadores (dni integer primary key, nombre text, intentos int)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int version, int version2) {
        db.execSQL("drop table if exists ganadores");
        db.execSQL("Create table ganadores (dni integer primary key, nombre text, intentos integer)");
    }


    public Cursor llenarLista(){
        ArrayList<String> lista= new ArrayList<>();
        SQLiteDatabase database= this.getWritableDatabase();
        Cursor data=database.rawQuery("SELECT * FROM ganadores ORDER BY intentos DESC", null);
        return data;

    }



}
