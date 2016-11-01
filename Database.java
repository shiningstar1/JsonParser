package com.example.jsonparse;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
 
public class Database extends SQLiteOpenHelper {
 
    public Database(Context context)
    {
        super(context, "HollywoodCustomer5.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
    String tableContact="create table hcontact8(name text,age text,address text,phno text)";
    db.execSQL(tableContact);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    public void insertData(String name, String age,String address,String phno)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues Contentvalues=new ContentValues();
        Contentvalues.put("name",name);
        Contentvalues.put("age",age);
        Contentvalues.put("address",address);
        Contentvalues.put("phno", phno);
        sqLiteDatabase.insert("hcontact8",null,Contentvalues);
    }
    public ArrayList fetchData()
    {
        ArrayList<String>stringArrayList=new ArrayList<String>();
        String fetchdata="select * from hcontact8";
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery(fetchdata, null);
        if(cursor.moveToFirst()){
           do
            {
                stringArrayList.add(cursor.getString(0));
                stringArrayList.add(cursor.getString(1));
                stringArrayList.add(cursor.getString(2));
                stringArrayList.add(cursor.getString(3));
             } while (cursor.moveToNext());
        }
    return stringArrayList;
    }
}
