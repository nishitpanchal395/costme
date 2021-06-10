package com.nishitpanchal395.costme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences=getSharedPreferences(MainActivity3.SHOP_INFO,MODE_PRIVATE);
        Boolean bv= sharedPreferences.getBoolean(MainActivity3.SHOP_INFO_BOOL,false);


        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(3000);

                    if(bv){
                        Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                        startActivity(intent);
                        finish();
                    }

                    else{

                    Intent intent=new Intent(MainActivity.this,MainActivity3.class);
                    startActivity(intent);
                    finish();}
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        thread.start();


    }
}