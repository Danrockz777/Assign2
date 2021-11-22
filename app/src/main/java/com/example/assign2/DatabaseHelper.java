package com.example.assign2;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public  static final String DATABASE_NAME="login.db";

    public DatabaseHelper(@Nullable Context context){
        super(context,DATABASE_NAME,null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE user(ID INTEGER PRIMARY KEY AUTOINCREMENT, "+"username TEXT,password TEXT)");//put in sqlite statement
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS user");
    }

    //User sign up
    public boolean insert(String username,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        //content values to put data into database
        ContentValues contentValues= new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        db.insert("user",null, contentValues);
        long result=db.insert("user",null,contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }

    public boolean checkUsername(String username){
        SQLiteDatabase db = this.getReadableDatabase();
        //cursor to read data from database
        Cursor cursor=db.rawQuery("SELECT * FROM user WHERE username = ?",
                new String[]{username});
        if(cursor.getCount()>0)
            return  true;
        else
            return  false;
    }

    public boolean checkLogin(String username, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor= db.rawQuery("SELECT * FROM user WHERE username = ? AND password = ?",
                new String[]{username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
}