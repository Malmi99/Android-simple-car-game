package com.example.coursework_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button bttn;
    Switch swt;
    TextView txtTime;
    boolean switchTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bttn = findViewById(R.id.button_identify_carmake);
        bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), identify_car.class);
                startActivity(i);
            }
            });
        bttn = findViewById(R.id.button_hints);
        bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Hints.class);
                startActivity(i);
            }
        });
        swt = findViewById(R.id.swt1);
        txtTime=findViewById(R.id.txtTimer1);
        swt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                switchTimer = true;
                if (isChecked == true);
                switchTimer = true;
                new CountDownTimer(20000, 1000) {

                    public void onTick(long msf) {
                        txtTime.setText(" remaining: " + msf / 1000);
                    }

                    public void onFinish() {
                        txtTime.setText("Done!");
                    }
                }.start();


            }
        });


        bttn = findViewById(R.id.button_identify_the_car_image);
        bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Identify_car_image.class);
                startActivity(i);
            }
        });
        bttn = findViewById(R.id.button_advancedlevel);
        bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Advanced_Level.class);
                startActivity(i);
            }
        });

        }}