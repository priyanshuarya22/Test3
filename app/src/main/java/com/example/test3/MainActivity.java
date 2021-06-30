package com.example.test3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //initialisation of views
    int i;
    CountDownTimer ct;
    TextView tv;
    Button b1, b2;
    SeekBar sb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //assigning views
        tv = findViewById(R.id.tv1);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        sb = findViewById(R.id.sb1);
        //setting listener for start button
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //checking if the timer is already running
                if(ct != null) {
                    ct.cancel();
                    i = 0;
                }
                //setting counter
                ct = new CountDownTimer(60000,1000) {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onTick(long millisUntilFinished) {
                        i++;
                        //setting counter in textview
                        tv.setText("" + i);
                        //setting progress in progress bar
                        sb.setProgress(i);
                    }

                    @Override
                    public void onFinish() {
                        //after 60 seconds resetting the counter to start again from 0
                        i = 0;
                    }
                };
                //starting the counter
                ct.start();
            }
        });
        //setting listener for stop button
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //stopping the listener
                if(ct != null) {
                    ct.cancel();
                    //setting counter to null to indicate the counter is stopped
                    ct = null;
                    i = 0;
                }
            }
        });
        //setting seek bar listener
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //checking if the user is giving input
                if(fromUser) {
                    tv.setText("" + progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}