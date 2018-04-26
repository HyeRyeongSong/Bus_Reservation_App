package com.example.hyeryeongsong.bus_reservation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignInActivity extends AppCompatActivity
{
    DBHandler controller;

    EditText editID;
    EditText editPW;

    String id = "";
    String pw = "";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin_screen);

        controller = new DBHandler(getApplicationContext());

        editID = (EditText) findViewById(R.id.id_edit);
        editPW = (EditText) findViewById(R.id.pw_edit);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 2) {
            if (resultCode == RESULT_OK) {
                id = data.getStringExtra("id");
                pw = data.getStringExtra("pw");
                Log.d("id_1", "id_1: " + id);
                Log.d("pw_1", "pw_1: " + pw);
                controller.insert_user(id, pw);
            }
        }
    }


    public void login_b_clicked(View v)
    {
        id = editID.getText().toString();
        pw = editPW.getText().toString();

        if(controller.select_user(id, pw))
        {
            Intent intent = new Intent(this, MajorActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this,"No such user exists",Toast.LENGTH_SHORT).show();

        }
    }

    public void signup_b_clicked(View v)
    {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivityForResult(intent, 2);
    }
}