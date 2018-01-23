package com.example.hyeryeongsong.bus_reservation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
    }
}
