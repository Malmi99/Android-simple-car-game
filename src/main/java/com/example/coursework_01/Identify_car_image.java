package com.example.coursework_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Identify_car_image extends AppCompatActivity {
    TextView textViewCar, textViewCarAnswers,textView;
    Random random;
    Button btnNxt;
    ImageView carImage1,carImage2, carImage3, imv_home;
    int randomImage;
    Integer[] carImageList = new Integer[3];



    Integer[] image = {
            R.drawable.bmw,
            R.drawable.mercedes_benz,
            R.drawable.ferrari,
            R.drawable.bugatti,
            R.drawable.ford_mustang,
            R.drawable.lamborghini,
            R.drawable.ssc_tuatara,
            R.drawable.porsche_911,
            R.drawable.mclaren_720s,
            R.drawable.jaguar,
            R.drawable.bugatti_chiron,
            R.drawable.dodge_viper,
            R.drawable.dodge_challenger,
            R.drawable.laferrari,
            R.drawable.ds_e_tense,
            R.drawable.acura_nsx,
            R.drawable.volkswagen_arteon,
            R.drawable.premio,
            R.drawable.maserati_alfieri,
            R.drawable.ford_gt,
            R.drawable.audi,
            R.drawable.land_rover,
            R.drawable.camero,
            R.drawable.apex_ap,
            R.drawable.rimac_car,
            R.drawable.automobili_pininfarina_battista,
            R.drawable.artega_scalo_superelletra,
            R.drawable.mazda_furai,
            R.drawable.mitsubishi_lancer_evoluton

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identify_car_image);
        String[] carsArray = getResources().getStringArray(R.array.cars);
        random = new Random();
        textViewCar = findViewById(R.id.textview_CarImage);
        randomImage = random.nextInt(carsArray.length);
        textViewCar.setText(carsArray[randomImage]);

        carImage1 = findViewById(R.id.car_image1);
        carImage2 = findViewById(R.id.car_image2);
        carImage3 = findViewById(R.id.car_image3);


        carImageList[0] = randomImage;
        carImageList[1] = random.nextInt(image.length);
        carImageList[2] = random.nextInt(image.length);

        final List intList = Arrays.asList(carImageList);
        Collections.shuffle(intList);
        intList.toArray(carImageList);

        carImage1.setImageResource(image[carImageList[0]]);
        carImage2.setImageResource(image[carImageList[1]]);
        carImage3.setImageResource(image[carImageList[2]]);

        textViewCarAnswers = findViewById(R.id.textview_answers);

        carImage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (randomImage == carImageList[0]) {
                    textViewCarAnswers.setText("ANSWER IS CORRECT");
                    textViewCarAnswers.setTextColor(Color.parseColor("#186A3B"));

                } else {

                    textViewCarAnswers.setText("ANSWER IS INCORRECT");
                    textViewCarAnswers.setTextColor(Color.parseColor("#FF5733"));
                }
                disableButtons();
            }
        });


        carImage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (randomImage == carImageList[1]) {
                    textViewCarAnswers.setText("ANSWER IS CORRECT");
                    textViewCarAnswers.setTextColor(Color.parseColor("#186A3B"));

                } else {
                    textViewCarAnswers.setText("ANSWER IS INCORRECT");
                    textViewCarAnswers.setTextColor(Color.parseColor("#FF5733"));
                }
                disableButtons();

            }
        });

        carImage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (randomImage == carImageList[2]) {
                    textViewCarAnswers.setText("ANSWER IS CORRECT");
                    textViewCarAnswers.setTextColor(Color.parseColor("#186A3B"));

                } else {
                    textViewCarAnswers.setText("ANSWER IS INCORRECT");
                    textViewCarAnswers.setTextColor(Color.parseColor("#FF5733"));
                }
                disableButtons();
            }
        });

        imv_home = findViewById(R.id.imageview_newhome2);

        imv_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        btnNxt = findViewById(R.id.button_nxt);
        btnNxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Identify_car_image.class);
                startActivity(in);
            }
        });
        textView = findViewById(R.id.tvTimer2);
        new CountDownTimer(20000, 1000) {

            public void onTick(long msf) {
                textView.setText("remaining: " + msf / 1000);
            }

            public void onFinish() {
                textView.setText("done!");
            }
        }.start();
    }

    private void disableButtons(){
        carImage1.setEnabled(false);
        carImage2.setEnabled(false);
        carImage3.setEnabled(false);
    }


}
