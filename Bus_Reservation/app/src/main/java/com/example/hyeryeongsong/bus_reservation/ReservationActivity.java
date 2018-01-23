package com.example.hyeryeongsong.bus_reservation;

import android.app.Activity;
import android.content.Intent;
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
    //define variables for this Activity
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

        //make an ArrayList for checking if it's reserved or not
        reserve = new ArrayList<Integer>();

        //initialize all seat (not reserved yet)
        reserve.add(1);
        reserve.add(1);
        reserve.add(1);
        reserve.add(1);
        reserve.add(1);
        reserve.add(1);

        //connect button in .xml with .java
        button11 = (Button) findViewById(R.id.r_btn11);
        button12 = (Button) findViewById(R.id.r_btn12);
        button21 = (Button) findViewById(R.id.r_btn21);
        button22 = (Button) findViewById(R.id.r_btn22);
        button31 = (Button) findViewById(R.id.r_btn31);
        button32 = (Button) findViewById(R.id.r_btn32);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == 1) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                // The user picked a contact.
                // The Intent's data Uri identifies which contact was selected.
                // Do something with the contact here (bigger example below)
                int seatNum = data.getIntExtra("seatNum",-1);
                Log.d("seatNum","seatNum : " + seatNum);

                int color = -1;
                Log.d("color", "color : " + color);

                if(seatNum >= 10) {
                    //it's reserved
                    seatNum -= 10;
                    color = 0xFFFF0000;
                } else if (seatNum >= 0) {
                    //it's not reserved
                    color = 0xFF0000FF;
                } else {
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

    //******************************************************************************************************
    // Button controllors
    // R_B == Reservation Button
    // R_B11 ~ R_B32 is the seat

    public void R_B11_clicked(View v) {
        int seatNum = 0;

        if(reserve.get(seatNum) == 0) {
            Toast.makeText(this,"This seat is already reserved",Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, InfoActivity.class);

            intent.putExtra("num", 11);
            startActivityForResult(intent, 1);
        }
    }

    public void R_B12_clicked(View v) {
        int seatNum = 1;

        if(reserve.get(seatNum) == 0) {
            Toast.makeText(this,"This seat is already reserved",Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, InfoActivity.class);

            intent.putExtra("num", 12);
            startActivityForResult(intent, 1);
        }
    }

    public void R_B21_clicked(View v) {
        int seatNum = 2;

        if(reserve.get(seatNum) == 0) {
            Toast.makeText(this,"This seat is already reserved",Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, InfoActivity.class);

            intent.putExtra("num", 21);
            startActivityForResult(intent, 1);
        }
    }

    public void R_B22_clicked(View v) {
        int seatNum = 3;

        if(reserve.get(seatNum) == 0) {
            Toast.makeText(this,"This seat is already reserved",Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, InfoActivity.class);

            intent.putExtra("num",22);
            startActivityForResult(intent,1);
        }
    }

    public void R_B31_clicked(View v) {
        int seatNum = 4;

        if(reserve.get(seatNum) == 0) {
            Toast.makeText(this,"This seat is already reserved",Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, InfoActivity.class);

            intent.putExtra("num", 31);
            startActivityForResult(intent, 1);
        }
    }

    public void R_B32_clicked(View v) {
        int seatNum = 5;

        if(reserve.get(seatNum) == 0) {
            Toast.makeText(this,"This seat is already reserved",Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, InfoActivity.class);

            intent.putExtra("num", 32);
            startActivityForResult(intent, 1);
        }
    }

    //**********************************************************************************************
    //This function is for change the button's contribution
    //if specific seat is reserved, then change its color from blue to red
    public void Reserve_seat(int num, int color) {
        switch (num) {
            case 0:
                button11.setBackgroundColor(color);
                reserve.set(num,0);
                break;
            case 1:
                button12.setBackgroundColor(color);
                reserve.set(num,0);
                break;
            case 2:
                button21.setBackgroundColor(color);
                reserve.set(num,0);
                break;
            case 3:
                button22.setBackgroundColor(color);
                reserve.set(num,0);
                break;
            case 4:
                button31.setBackgroundColor(color);
                reserve.set(num,0);
                break;
            case 5:
                button32.setBackgroundColor(color);
                reserve.set(num,0);
                break;
        }
    }
}

