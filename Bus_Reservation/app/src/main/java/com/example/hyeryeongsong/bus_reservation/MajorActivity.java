package com.example.hyeryeongsong.bus_reservation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by HyeRyeongSong on 2018. 2. 8..
 */

public class MajorActivity extends Activity
{
    DBHandler controller;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.major_screen);

        controller = new DBHandler(getApplicationContext());

        if(controller.countData() == 0){
            controller.init_insert(6);
        }
    }

    void r_b_clicked(View v)
    {
        Intent intent = new Intent(this, ReservationActivity.class);
        startActivity(intent);
    }

    void admin_b_clicked(View v)
    {
    }

    void exit_b_clicked(View v)
    {
        finish();
    }

}
