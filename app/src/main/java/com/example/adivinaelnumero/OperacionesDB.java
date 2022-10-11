package com.example.adivinaelnumero;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class OperacionesDB {

    public static boolean Alta(Context c, String dni, String nombre, int intentos){
        boolean r= false;
        AdminDb admin= new AdminDb(c,"ganadores",null,1);
        SQLiteDatabase db= admin.getWritableDatabase();
        ContentValues registro= new ContentValues();
        registro.put("dni",dni);
        registro.put("nombre",nombre);
        registro.put("intentos",intentos);
        try {
            db.insert("ganadores", null, registro);
            db.close();
            r = true;
        } catch (Exception e) {

        }
        return r;

    }
}
