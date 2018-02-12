package com.example.hyeryeongsong.bus_reservation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by HyeRyeongSong on 2018. 2. 8..
 */

public class SignUpActivity extends Activity
{
    DBHandler controller;

    EditText editID;
    EditText editPW;
    EditText editPWC;

    String id;
    String pw;
    String pwc;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_screen);

        controller = new DBHandler(getApplicationContext());

        editID = findViewById(R.id.id_edit);
        editPW = findViewById(R.id.pw_edit);
        editPWC = findViewById(R.id.pwc_edit);

    }

    void ok_b_clicked(View v)
    {
        Intent returnIntent = new Intent();
        id = editID.getText().toString();
        pw = editPW.getText().toString();
        pwc = editPWC.getText().toString();

        if(pw == pwc)
        {
            returnIntent.putExtra("id", id);
            returnIntent.putExtra("pw", pw);
            setResult(Activity.RESULT_OK, returnIntent);
            finish();
        }
        else
        {
            Toast.makeText(this,"do the password confirmation again",Toast.LENGTH_SHORT).show();
        }

    }

    void cancel_b_clicked(View v)
    {
        Intent returnIntent = new Intent();
        setResult(Activity.RESULT_OK,returnIntent);
        finish();

    }

}
