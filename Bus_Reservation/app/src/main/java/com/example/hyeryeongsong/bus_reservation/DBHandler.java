package com.example.hyeryeongsong.bus_reservation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by HyeRyeongSong on 2018. 2. 2..
 */

public class DBHandler
{
    DBOpenHelper helper;
    SQLiteDatabase db;

    //Create DB
    public DBHandler(Context context) {
        helper = new DBOpenHelper(context, "reserve.db",null,1);
    }

    //open DB
    public static DBHandler open(Context context) {
        return new DBHandler(context);
    }

    //close DB
    public void close() {
        db.close();
    }


    public void init_insert(int init){
        db = helper.getWritableDatabase();

        for (int i = 1; i<=init ; i++) {
            ContentValues values = new ContentValues();

            values.put("seatnum",i);
            values.put("reserved",0);

            db.insert("busReservation",null,values);
        }

        select_all();
    }

    //select data from DB
    public Cursor select_all(){
        Log.d("DB","select all");

        db = helper.getReadableDatabase();
        Cursor c = db.query("busReservation", null, null, null, null, null, null);

        while(c.moveToNext()) {
            Log.d("DB", "Idx : " + c.getInt(c.getColumnIndex("idx")) +
                    "   /seatnum : " + c.getInt(c.getColumnIndex("seatnum")) +
                    "   /reserved : " + c.getInt(c.getColumnIndex("reserved")));
        }

        c = db.query("busReservation", null, null, null, null, null, null);

        return c;
    }

    public Cursor select_seat(int seatnum) {
        db = helper.getReadableDatabase();
        Cursor c = db.query("busReservation", null, null, null, null, null, null);

        c.moveToNext();

        while(c.getInt(c.getColumnIndex("seatnum")) != seatnum) {
            c.moveToNext();
        }

        return c;
    }

    public int countData() {
        db = helper.getReadableDatabase();

        Cursor c = db.query("busReservation", null, null, null, null, null, null);

        return c.getCount();
    }

    //update data in DB
    public void update_reserved(int seatnum, int reserved){
        db = helper.getWritableDatabase();

        db.execSQL("Update busReservation set reserved = " + reserved + " where seatnum = " + seatnum);

        Log.d("DB", "update complete");
    }

    //delete data from DB
    public void delete (int id) {
        db = helper.getWritableDatabase();
        db.delete("busReservation","id=?",new String[]{String.valueOf(id)});

        Log.i("DB","Delete complete");
    }

    //insert user data to DB
    public void insert_user(String id, String pw) {
        db = helper.getWritableDatabase();

        db.execSQL("insert into userInformation values(" + id + ", " + pw +");");
    }

    //update user data in DB
    public void update_user(String id, String pw) {
        db = helper.getWritableDatabase();

        db.execSQL("Update userInformation set id = " + pw + " where id = " + id);
    }

    //delete user data from DB
    public void delete_user (String id) {
        db = helper.getWritableDatabase();
        db.delete("userInformation", "id=?", new String[]{String.valueOf(id)});
    }

    //check id&pw for the signin user from DB
    public boolean select_user(String id, String pw) {
        db = helper.getReadableDatabase();
        Cursor c = db.query("userInformation", null, null, null, null, null, null);

        c.moveToNext();

        while(c.getString(c.getColumnIndex("id")) != id) {
            c.moveToNext();
        }

        if(c.getString(c.getColumnIndex("pw")) == pw)
            return true;

        return false;
    }


}
