package com.example.pleasemap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper{
    public DatabaseHelper(@Nullable Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table user(username text primary key, password text, firstname text, surname text)");
        db.execSQL("Create table car(registration text, username text, make text, model text, colour text, PRIMARY KEY(registration), FOREIGN KEY(username) REFERENCES user(username))");
        db.execSQL("Create table bar(registration text, username text, make text, PRIMARY KEY(registration), FOREIGN KEY(username) REFERENCES user(username))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists user");
    }
    public boolean insert(String username, String fName, String sName, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("firstname",fName);
        contentValues.put("surname",sName);
        contentValues.put("password",password);
        long ins = db.insert("user", null, contentValues);
        if(ins ==-1) return false;
        else return true;
    }
    public Boolean checkUsername(String username){
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where username=?", new String[]{username});
        if(cursor.getCount()>0) return false;
        else return true;
    }

    public Boolean checkPassword(String username, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where username=? and password=?", new String[]{username, password});
        if (cursor.getCount()>0) return true;
        else return false;
    }

    public boolean insertCar(String username, String Registration, String Make, String Model, String Colour){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("registration",Registration);
        contentValues.put("make",Make);
        contentValues.put("model",Model);
        contentValues.put("colour",Colour);
        long ins = db.insert("car", null, contentValues);
        if(ins ==-1) return false;
        else return true;
    }
    public Boolean checkRegistration(String registration){
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from car where registration=?", new String[]{registration});
        if(cursor.getCount()>0) return false;
        else return true;
    }
    public Boolean checkDeregistration(String registration, String username){
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from car where registration=? AND username=?", new String[]{registration, username});
        if(cursor.getCount()>0) return false;
        else return true;
    }
    public boolean dropCar(String registration){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("DELETE FROM car WHERE registration=?", new String[]{registration});
        if(cursor.getCount()>0) return false;
        else return true;
    }
    public boolean PurchaseTicket(String address, String username, String date){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("address",address);
        contentValues.put("username",username);
        contentValues.put("date",date);
        long ins = db.insert("ticket", null, contentValues);
        if(ins ==-1) return false;
        else return true;
    }
    public Cursor ShowTicket(String username){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from ticket where username=?", new String[]{username});
        if (cursor.getCount()>0) return cursor;
        else return cursor;
    }
    public boolean binsert(String username, String Registration, String Make){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("registration",Registration);
        contentValues.put("make",Make);
        long ins = db.insert("car", null, contentValues);
        if(ins ==-1) return false;
        else return true;
    }
    public boolean updateUsername(String CurrentUsername, String NewUsername){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("UPDATE user SET username = ? WHERE username = ?;", new String[]{NewUsername, CurrentUsername});
        if(cursor.getCount()>0) return false;
        else return true;
    }
    public Cursor ShowCar(String username){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from car where username=?", new String[]{username});
        return cursor;
    }
    public Boolean BlowFar(String username){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from car where username = ?", new String[]{username});
        if (cursor.getCount()>0) return true;
        else return false;
    }
    public boolean updatePassword(String Username, String NewPassword){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("UPDATE user SET password = ? WHERE username = ?;", new String[]{NewPassword, Username});
        if(cursor.getCount()>0) return false;
        else return true;
    }
}
