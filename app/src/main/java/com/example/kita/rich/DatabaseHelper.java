package com.example.kita.rich;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


    public class DatabaseHelper extends SQLiteOpenHelper  {

        public DatabaseHelper(Context context) {
            super(context, "Loginproduct1.db", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("Create table user(Name text primary key, password text,vozrast text,ves text, rost text, rez text)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop table if exists user");
        }
        public boolean insert(String Name,String password,String vozrast, String ves,String rost,String rez){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("Name",Name);
            contentValues.put("password",password);
            contentValues.put("vozrast",vozrast);
            contentValues.put("ves",ves);
            contentValues.put("rost",rost);
            contentValues.put("rez",rez);
            Long ins = db.insert("user",null,contentValues);
            if (ins == -1)return false;
            else return true;
        }
        public Boolean chkName (String Name ){
                SQLiteDatabase db = this.getReadableDatabase();
                Cursor cursor = db.rawQuery("Select * from user where Name =?",new String[]{Name});
                if (cursor.getCount()>0)return false;
                else return  true;
        }
        public  Boolean Namepassword (String Name, String password){
            SQLiteDatabase db = this.getReadableDatabase();
           Cursor cursor = db.rawQuery("select * from user where Name=? and password=?",new String[]{Name , password});
            if(cursor.getCount()>0)return true;
            else return false;
        }
    }

