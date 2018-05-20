package com.example.kita.rich;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class database extends SQLiteOpenHelper  {

    public database(Context context) {
        super(context, "Otchrt.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table user(Name text primary key, password text,vozrast text,ves text, rost text, rez text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");
    }
    public boolean otchet(String Data,String kall,String vozrast, String ves,String rost,String rez){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Data",Data);
        contentValues.put("kall",kall);
        Long ins = db.insert("user",null,contentValues);
        if (ins == -1)return false;
        else return true;
    }
    public Boolean kal (String Data ){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where Name =?",new String[]{Data});
        if (cursor.getCount()>0)return false;
        else return  true;
    }
    public  Boolean Namepassword (String Data, String kall){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user where Name=? and password=?",new String[]{Data , kall});
        if(cursor.getCount()>0)return true;
        else return false;
    }
}

