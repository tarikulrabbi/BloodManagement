package com.rabbi.tarikul.travelsofbangladesh;


import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends AppCompatActivity {

    private Timer timer;
    private ProgressBar progressBar;
    private int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        progressBar=(ProgressBar)findViewById(R.id.progressBar);
        progressBar.setProgress(0);

        progressBar.setProgressTintList(ColorStateList.valueOf(Color.RED));

        final long period = 20;
        timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //this repeats every 100 ms
                if (i<100){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                        }
                    });
                    progressBar.setProgress(i);
                    i++;
                }else{
                    //closing the timer
                    timer.cancel();
                    Intent intent = new Intent(SplashScreen.this,AlartDialog.class);
                    startActivity(intent);
                    // close this activity
                    finish();
                }
            }
        }, 0, period);
    }

        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(5000);
                    Intent intent = new Intent(getApplicationContext(),AlartDialog.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
    }
