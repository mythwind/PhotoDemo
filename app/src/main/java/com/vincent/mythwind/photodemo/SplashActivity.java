package com.vincent.mythwind.photodemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.vincent.mythwind.photodemo.utils.MLog;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_splash);
        if (!(getIntent() == null || getIntent().getExtras() == null)) {
            Bundle extras = getIntent().getExtras();
            MLog.err("SplashActivity", "getExtras not empty");
            // e.a(getApplicationContext());
            String string = extras.getString("url");
            String string2 = extras.getString("text");
            String string3 = extras.getString("title");
            String string4 = extras.getString("version");
            String string5 = extras.getString("purchase");
            Integer num = null;
            try {
                num = Integer.valueOf(string4);
            } catch (NumberFormatException e) {
            }
            if (!(string2 == null || string3 == null || string4 == null || num == null)) {
                //e.a(string, string2, string3, num, string5);
            }
        }



        startActivity(new Intent(this, MainActivity.class));
        finish();


    }
}
