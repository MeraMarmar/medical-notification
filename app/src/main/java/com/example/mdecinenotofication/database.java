package com.example.mdecinenotofication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class database extends SQLiteOpenHelper {


    public database( Context context) {
        super(context,"login.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
         db.execSQL("Create table user(name text primary key,password text ,nameOfmedicine text ,date text ,hour text ,minute text,second text,numoftaken text ,iftaken text )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       db.execSQL("drop table if exists user");
    }
    public boolean insert(String name ,String password){
      SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        contentValues.put("password",password);
        long ins=db.insert("user",null,contentValues);
        if(ins==-1)return false;
        else  return true;
    }
    public boolean insertdataofmedecine(String nameOfmedicine ,String  date ,String hour ,String minute ,String second ,String numoftaken){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("nameOfmedicine",nameOfmedicine);
        contentValues.put("date",date);
        contentValues.put("hour",hour);
        contentValues.put("minute",minute);
        contentValues.put("second",second);
        contentValues.put("numoftaken",numoftaken);
        long ins=db.insert("user",null,contentValues);
        if(ins==-1)return false;
        else  return true;
    }
    public boolean updateDataofmed(String nameOfmedicine ,String  date ,String hour ,String minute ,String second ,String numoftaken){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("nameOfmedicine",nameOfmedicine);
        contentValues.put("date",date);
        contentValues.put("hour",hour);
        contentValues.put("minute",minute);
        contentValues.put("second",second);
        contentValues.put("numoftaken",numoftaken);
        db.update("user",contentValues,"nameOfmedicine=?",new String[]{nameOfmedicine});
        return true;
    }
    public ArrayList<Medecine> getAllData(){
        ArrayList<Medecine> arrayList=new ArrayList();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery("select *from user",null);
        res.moveToFirst();
        while (res.isAfterLast()==false){
            String nameOfmedicine ,  date , hour ,minute , second , numoftaken ;
            nameOfmedicine = res.getString(res.getColumnIndex("nameOfmedicine"));
            hour = res.getString(res.getColumnIndex("hour"));
            minute = res.getString(res.getColumnIndex("minute"));
            second = res.getString(res.getColumnIndex("second"));
            numoftaken = res.getString(res.getColumnIndex("numoftaken"));
            date = res.getString(res.getColumnIndex("date"));
            arrayList.add (new Medecine( nameOfmedicine ,  date ,hour, minute,second , numoftaken));
            res.moveToNext();
        }
        return arrayList;
    }
    public Medecine getMedecineByName(String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select *from user where nameOfmedicine = '" + name + "'", null);
        res.moveToFirst();
        String nameOfmedicine ,  date , hour ,minute , second , numoftaken ;
        nameOfmedicine = res.getString(res.getColumnIndex("nameOfmedicine"));
        hour = res.getString(res.getColumnIndex("hour"));
        minute = res.getString(res.getColumnIndex("minute"));
        second = res.getString(res.getColumnIndex("second"));
        numoftaken = res.getString(res.getColumnIndex("numoftaken"));
        date = res.getString(res.getColumnIndex("date"));
        return (new Medecine(nameOfmedicine ,  date ,hour, minute,second , numoftaken));
    }
    public boolean updateData(String id,String name,String price,String potion,String nameOfcompany,String quntity,String kind,String date){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        contentValues.put("price",price);
        contentValues.put("potion",potion);
        contentValues.put("nameOfcompany",nameOfcompany);
        contentValues.put("quntity",quntity);
        contentValues.put("kind",kind);
        contentValues.put("date",date);
        contentValues.put("name",name);
        db.update("mytable",contentValues,"id=?",new String[]{id});
        return true;
    }
}
