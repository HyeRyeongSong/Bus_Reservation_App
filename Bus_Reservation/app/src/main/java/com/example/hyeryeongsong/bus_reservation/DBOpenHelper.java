package com.example.hyeryeongsong.bus_reservation;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by HyeRyeongSong on 2018. 2. 2..
 */

public class DBOpenHelper extends SQLiteOpenHelper
{

    public DBOpenHelper(Context context, String name,
                        SQLiteDatabase.CursorFactory factory, int version) {
        super(context,name,factory,version);
    }

    @Override
    public  void onCreate(SQLiteDatabase db) {
        String sql = "create table busReservation (" +
                "idx integer not null primary key autoincrement, " +
                "seatnum integer, " +
                "reserved integer)";

        String sql_user = "create table userInformation (" +
                "idx integer not null primary key autoincrement, " +
                "id text, " +
                "pw text)";


        Log.d("DB","created");

        db.execSQL(sql);
        db.execSQL(sql_user);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "drop table if exists busReservation";
        String sql_user = "drop table if exists userInformation";

        db.execSQL(sql);
        db.execSQL(sql_user);

        onCreate(db);
    }
}
