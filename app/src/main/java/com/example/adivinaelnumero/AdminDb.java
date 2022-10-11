package com.example.adivinaelnumero;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminDb  extends SQLiteOpenHelper{
    public AdminDb(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context,name,factory,version);
    }
    public void onCreate(SQLiteDatabase db){
        db.execSQL("Create table ganadores (dni text primary key, nombre text, intentos integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int version, int version2) {
        db.execSQL("drop table if exists ganadores");
        db.execSQL("Create table ganadores (dni integer primary key, nombre text, intentos integer)");
    }



}
