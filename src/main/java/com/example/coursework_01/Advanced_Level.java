package com.example.coursework_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Advanced_Level extends AppCompatActivity {
    TextView tvCar1, tvCar2, tvCar3, edText1, edText2, edText3, txtTimer;
    Random random;
    Button butAdvance;
    ImageView carImg1, carImg2, carImg3, back2;
    int coAns = 0;
    int val = 0;
    int[] ans;
    List<String> cars;
    boolean img;


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

    public void Reset() {
        val = 0;
        coAns = 0;
        ans[0] = 0;
        ans[1] = 0;
        ans[2] = 0;
        tvCar1.setText("");
        tvCar2.setText("");

        edText1.setEnabled(true);
        edText1.setBackgroundColor(Color.TRANSPARENT);
        edText1.setText("");

        edText2.setEnabled(true);
        edText2.setBackgroundColor(Color.TRANSPARENT);
        edText2.setText("");

        edText3.setEnabled(true);
        edText3.setBackgroundColor(Color.TRANSPARENT);
        edText3.setText("");

        random = new Random();
        carImageList[0] = random.nextInt(image.length);
        carImageList[1] = random.nextInt(image.length);
        carImageList[2] = random.nextInt(image.length);

        carImg1.setImageResource(image[carImageList[0]]);
        carImg2.setImageResource(image[carImageList[1]]);
        carImg3.setImageResource(image[carImageList[2]]);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced__level);

        butAdvance = findViewById(R.id.button_smt);
        tvCar1 = findViewById(R.id.tv_Car1);
        tvCar2 = findViewById(R.id.tv_Car2);
        edText1 = findViewById(R.id.edText1);
        edText2 = findViewById(R.id.edText2);
        edText3 = findViewById(R.id.edText3);
        carImg1 = findViewById(R.id.imageView_car1);
        carImg2 = findViewById(R.id.imageView_car2);
        carImg3 = findViewById(R.id.imageView_car3);

        ans = new int[3];
        cars = Arrays.asList(getResources().getStringArray(R.array.cars));

        Reset();

        butAdvance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (butAdvance.getText().equals("Next")) {
                    Reset();
                } else {

                    val = val + 1;

                    if (ans[0] == 0) {
                        if (edText1.getText().toString().equals(cars.get(carImageList[0]))) {
                            edText1.setInputType(InputType.TYPE_NULL);
                            edText1.setBackgroundColor(Color.parseColor("#00FF00"));
                            val = val + 1;
                            ans[0] = 1;
                        } else {
                            edText1.setBackgroundColor(Color.parseColor("#FF0000"));
                        }
                    }
                    if (ans[1] == 0) {
                        if (edText1.getText().toString().equals(cars.get(carImageList[1]))) {
                            edText2.setInputType(InputType.TYPE_NULL);
                            edText2.setBackgroundColor(Color.parseColor("#00FF00"));
                            coAns = coAns + 1;
                            ans[1] = 1;
                        } else {
                            edText2.setBackgroundColor(Color.parseColor("#FF0000"));
                        }
                    }
                    if (ans[2] == 0) {
                        if (edText3.getText().toString().equals(cars.get(carImageList[2]))) {
                            edText3.setInputType(InputType.TYPE_NULL);
                            edText3.setBackgroundColor(Color.parseColor("#00FF00"));
                            coAns = coAns + 1;
                            ans[2] = 1;
                        } else {
                            edText3.setBackgroundColor(Color.parseColor("#FF0000"));
                        }
                    }


                    if (coAns >= 3) {

                        tvCar1.setText("CORRECT");
                        tvCar1.setTextColor(Color.parseColor("#186A3B"));
                        butAdvance.setText("Next");
                        tvCar2.setText("Points : " + coAns);

                    } else if (val >= 3) {

                        tvCar1.setText("WRONG");
                        tvCar1.setTextColor(Color.parseColor("#FF5733"));
                        tvCar2.setText("Points : " + coAns);

                        if (ans[0] == 0) {

                            edText1.setEnabled(false);
                            edText2.setBackgroundColor(Color.parseColor("#FFFF00"));
                            edText1.setText(cars.get(carImageList[0]));

                        }
                        if (ans[1] == 0) {

                            edText1.setEnabled(false);
                            edText2.setBackgroundColor(Color.parseColor("#FFFF00"));
                            edText3.setText(cars.get(carImageList[1]));

                        }
                        if (ans[2] == 0) {

                            edText3.setEnabled(false);
                            edText3.setBackgroundColor(Color.parseColor("#FFFF00"));
                            edText3.setText(cars.get(carImageList[2]));

                        }

                        butAdvance.setText("Next");

                        butAdvance.setText("Next");
                    }
                }

            }

        });

        back2 = findViewById(R.id.imgNew_back);

        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        txtTimer = findViewById(R.id.txtTimer2);
        new CountDownTimer(20000, 1000) {

            public void onTick(long msf) {
                txtTimer.setText("remaining: " + msf / 1000);
            }

            public void onFinish() {
                txtTimer.setText("done!");
            }
        }.start();
    }
}
