package com.example.hyeryeongsong.bus_reservation;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by HyeRyeongSong on 2018. 1. 24..
 */

public class ReservationActivity extends Activity
{
    DBHandler controller;

    ArrayList<Integer> reserve;

    Button button11;
    Button button12;
    Button button21;
    Button button22;
    Button button31;
    Button button32;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reservation_screen);

        controller = new DBHandler(getApplicationContext());

        reserve = new ArrayList<Integer>();

        button11 = (Button) findViewById(R.id.r_btn11);
        button12 = (Button) findViewById(R.id.r_btn12);
        button21 = (Button) findViewById(R.id.r_btn21);
        button22 = (Button) findViewById(R.id.r_btn22);
        button31 = (Button) findViewById(R.id.r_btn31);
        button32 = (Button) findViewById(R.id.r_btn32);

        for(int i = 0 ; i < controller.countData(); i++) {
            Cursor c;
            c = controller.select_seat(i+1);
            reserve.add(c.getInt(c.getColumnIndex("reserved")));

            int color = -1;

            if(reserve.get(i) == 0) {
                color = 0xFF0000FF;
            } else
                color = 0xFFFF0000;

            if(color != -1)
                Reserve_seat(i,color);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                int seatNum = data.getIntExtra("seatNum",-1);
                reserve = data.getIntegerArrayListExtra("list");

                Log.d("seatNum","seatNum : " + seatNum);

                int color = -1;
                Log.d("color", "color : " + color);

                //it's reserved
                if(reserve.get(seatNum) == 1)
                {
                    color = 0xFFFF0000;
                }
                //it's not reserved
                else if (reserve.get(seatNum) == 0)
                {
                    color = 0xFF0000FF;
                }
                else
                {
                    Toast.makeText(this,"Wrong Reservation result",Toast.LENGTH_SHORT).show();
                }

                Log.d("seatColor", "color : " + color);

                if(color != -1)
                    Reserve_seat(seatNum, color);
                else {
                    Toast.makeText(this,"Wrong Reservation result",Toast.LENGTH_SHORT).show();
                }
            }
        }
    }


    public void R_B11_clicked(View v) {
        int seatNum = 1;

        if(reserve.get(seatNum-1) == 1) {
            Toast.makeText(this,"This seat is already reserved",Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, InfoActivity.class);

            intent.putExtra("seatNum", seatNum-1);
            intent.putIntegerArrayListExtra("list", reserve);

            startActivityForResult(intent, 1);
        }
    }

    public void R_B12_clicked(View v) {
        int seatNum = 2;

        if(reserve.get(seatNum-1) == 1) {
            Toast.makeText(this,"This seat is already reserved",Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, InfoActivity.class);

            intent.putExtra("seatNum", seatNum-1);
            intent.putIntegerArrayListExtra("list", reserve);

            startActivityForResult(intent, 1);
        }
    }

    public void R_B21_clicked(View v) {
        int seatNum = 3;

        if(reserve.get(seatNum-1) == 1) {
            Toast.makeText(this,"This seat is already reserved",Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, InfoActivity.class);

            intent.putExtra("seatNum", seatNum-1);
            intent.putIntegerArrayListExtra("list", reserve);

            startActivityForResult(intent, 1);
        }
    }

    public void R_B22_clicked(View v) {
        int seatNum = 4;

        if(reserve.get(seatNum-1) == 1) {
            Toast.makeText(this,"This seat is already reserved",Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, InfoActivity.class);

            intent.putExtra("seatNum", seatNum-1);
            intent.putIntegerArrayListExtra("list", reserve);

            startActivityForResult(intent,1);
        }
    }

    public void R_B31_clicked(View v) {
        int seatNum = 5;

        if(reserve.get(seatNum-1) == 1) {
            Toast.makeText(this,"This seat is already reserved",Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, InfoActivity.class);

            intent.putExtra("seatNum", seatNum-1);
            intent.putIntegerArrayListExtra("list", reserve);

            startActivityForResult(intent, 1);
        }
    }

    public void R_B32_clicked(View v) {
        int seatNum = 6;

        if(reserve.get(seatNum-1) == 1) {
            Toast.makeText(this,"This seat is already reserved",Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, InfoActivity.class);

            intent.putExtra("seatNum", seatNum-1);
            intent.putIntegerArrayListExtra("list", reserve);

            startActivityForResult(intent, 1);
        }
    }


    public void Reserve_seat(int num, int color) {
        switch (num) {
            case 0:
                button11.setBackgroundColor(color);
                break;
            case 1:
                button12.setBackgroundColor(color);
                break;
            case 2:
                button21.setBackgroundColor(color);
                break;
            case 3:
                button22.setBackgroundColor(color);
                break;
            case 4:
                button31.setBackgroundColor(color);
                break;
            case 5:
                button32.setBackgroundColor(color);
                break;
        }

    }
}

