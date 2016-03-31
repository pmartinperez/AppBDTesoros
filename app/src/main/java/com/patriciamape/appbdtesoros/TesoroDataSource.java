package com.patriciamape.appbdtesoros;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Patri on 04/02/2016.
 */
public class TesoroDataSource {

    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;

    private int idIntent;
    private String[] allColumnsTesoros = { MySQLiteHelper.COLUMN_ID,
            MySQLiteHelper.COLUMN_NOMBRE, MySQLiteHelper.COLUMN_ESTRELLAS };
    //private String[] selectionArgs = { String.valueOf(idIntent) };
    String selection = MySQLiteHelper.COLUMN_ID  + " = ?";//WHERE id = ?

    private String[] allColumnsPistas = { MySQLiteHelper.COLUMN_IDP,
            MySQLiteHelper.COLUMN_NOMBREP, MySQLiteHelper.COLUMN_PREGUNTA, MySQLiteHelper.COLUMN_SOLUCION,
            MySQLiteHelper.COLUMN_RESPUESTA,MySQLiteHelper.COLUMN_ID };
    String selectionPistas = MySQLiteHelper.COLUMN_ID  + " = ?";//WHERE id = ?

    private String[] collumnHerramienta = { MySQLiteHelper.COLUMN_IDH };

    public TesoroDataSource(Context context) {
        dbHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();

    }


    public void close() {
        dbHelper.close();
    }


    public List<Tesoro> getAllTesoros() {
        List<Tesoro> tesoros = new ArrayList<Tesoro>();

        Cursor cursor = database.query(MySQLiteHelper.TABLE_TESOROS,
                allColumnsTesoros, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Tesoro tesoro = cursorToTesoro(cursor);
            tesoros.add(tesoro);
            cursor.moveToNext();
        }
        // Cerramos el cursor!!
        cursor.close();
        return tesoros;
    }

    public Tesoro cursorToTesoro(Cursor cursor) {
        Tesoro tesoro = new Tesoro();
        tesoro.setId(cursor.getInt(0));
        tesoro.setNombre(cursor.getString(1));
        tesoro.setEstrellas(cursor.getInt(2));
        return tesoro;
    }

    public Cursor seleccionarID(int id){
        this.idIntent = id;
        Cursor cursor = database.query(
                MySQLiteHelper.TABLE_TESOROS,  //Nombre de la tabla
                allColumnsTesoros,  //Lista de Columnas a consultar
                selection,  //Columnas para la clausula WHERE
                new String[]{String.valueOf(idIntent)},  //Valores a comparar con las columnas del WHERE
                null,  //Agrupar con GROUP BY
                null,  //Condición HAVING para GROUP BY
                null  //Clausula ORDER BY
        );

        //Cursor cursor2 = database.rawQuery("select _id, nombre, estrellas from tesoros where _id = ?", new String[]{String.valueOf(idIntent)});

        return cursor;
    }


    public List<Tesoro> getTesoro(Cursor cursor){
        List<Tesoro> tesoros = new ArrayList<Tesoro>();

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Tesoro tesoro = cursorToTesoro(cursor);
            tesoros.add(tesoro);
            cursor.moveToNext();
        }
        cursor.close();
        return tesoros;
    }

    public List<Pista> getAllPistasByID(int idTesoro) {
        List<Pista> pistas = new ArrayList<Pista>();

        Cursor cursor = database.query(MySQLiteHelper.TABLE_PISTAS,
                allColumnsPistas,
                selectionPistas,
                new String[]{String.valueOf(idTesoro)},
                null,
                null,
                null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Pista pista = cursorToPista(cursor);
            pistas.add(pista);
            cursor.moveToNext();
        }
        // Cerramos el cursor!!
        cursor.close();
        return pistas;
    }

    public Pista cursorToPista(Cursor cursor) {
        Pista pista = new Pista();
        pista.setIdPista(cursor.getInt(0));
        pista.setNombrePista(cursor.getString(1));
        pista.setPregunta(cursor.getString(2));
        pista.setSolucion(cursor.getString(3));
        pista.setRespuesta(cursor.getInt(4));
        pista.setId(cursor.getInt(5));
        return pista;
    }

    public List<Pista> getPista(Cursor cursor){
        List<Pista> pistas = new ArrayList<Pista>();

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Pista pista = cursorToPista(cursor);
            pistas.add(pista);
            cursor.moveToNext();
        }
        cursor.close();
        return pistas;
    }

    public List<Pista> getPistasByID(int idPista) {
        List<Pista> pistas = new ArrayList<Pista>();

        Cursor cursor = database.query(MySQLiteHelper.TABLE_PISTAS,
                allColumnsPistas,
                "_idPista = ?",
                new String[]{String.valueOf(idPista)},
                null,
                null,
                null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Pista pista = cursorToPista(cursor);
            pistas.add(pista);
            cursor.moveToNext();
        }
        // Cerramos el cursor!!
        cursor.close();
        return pistas;
    }

    public String getHerramienta(int idPista) {
        String nombreHerramienta = "";

        Cursor cursor = database.query(MySQLiteHelper.TABLE_PISTAS_HERRAMIENTAS,
                collumnHerramienta,
                "_idPista = ?",
                new String[]{String.valueOf(idPista)},
                null,
                null,
                null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            nombreHerramienta = cursor.getString(0);
            cursor.moveToNext();
        }
        // Cerramos el cursor!!
        cursor.close();
        return nombreHerramienta;
    }




}

