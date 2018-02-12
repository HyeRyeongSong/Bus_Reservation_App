package com.example.hyeryeongsong.bus_reservation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by HyeRyeongSong on 2018. 1. 24..
 */

public class InfoActivity extends Activity
{
    DBHandler controller;

    ArrayList<Integer> reserve;
    int seatNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_screen);

        controller = new DBHandler(getApplicationContext());
        reserve = new ArrayList<Integer>();

        Intent intent = getIntent();
        seatNum = intent.getIntExtra("seatNum",-1);
        reserve = intent.getIntegerArrayListExtra("list");

        if(reserve.get(seatNum) == 1)
            finish();
    }

    //reserve
    public void ok_b_clicked(View v) {

        controller.update_reserved(seatNum+1, 1);

        reserve.add(seatNum, 1);

        Intent returnIntent = new Intent();
        returnIntent.putExtra("seatNum",seatNum);
        returnIntent.putExtra("list", reserve);
        setResult(Activity.RESULT_OK,returnIntent);

        finish();
    }

    //not reserve
    public void cancel_b_clicked(View v) {

        Intent returnIntent = new Intent();
        returnIntent.putExtra("seatNum",seatNum);
        returnIntent.putExtra("list", reserve);
        setResult(Activity.RESULT_OK,returnIntent);

        finish();
    }
}
