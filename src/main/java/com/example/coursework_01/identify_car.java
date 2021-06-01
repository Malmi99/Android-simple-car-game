package com.example.coursework_01;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;


public class identify_car extends AppCompatActivity {

    ImageView imgv,imgvHome;
    Random random;
    Button bttn;
    Spinner spi;
    int loadImage;
    TextView textView,tv1,tv2;

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


        setContentView(R.layout.activity_identify_car);
        imgv = findViewById(R.id.imageView_new);
        spi =  findViewById(R.id.spinner);
        String[] carsArray = getResources().getStringArray(R.array.cars_idenify_names);
        ArrayAdapter<String> carListAdapter = new ArrayAdapter<String>(identify_car.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.cars));
        carListAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spi.setAdapter(carListAdapter);

        random = new Random();
        loadImage = random.nextInt(image.length);
        imgv.setImageResource(image[loadImage]);
        imgvHome = findViewById(R.id.imageView_home);
        bttn=findViewById(R.id.button_ok);
        imgvHome.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
        });
        tv1=findViewById(R.id.tvAns);
        tv2=findViewById(R.id.tvCor);
        bttn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int selectedItem = spi.getSelectedItemPosition();


                if (selectedItem == loadImage) {
                    tv1.setText("YOUR CHOICE IS  CORRECT !! ");
                    tv1.setTextColor(Color.parseColor("#186A3B"));

                } else {
                    tv1.setText("YOUR CHOICE IS WRONG !!");
                    tv1.setTextColor(Color.parseColor("#FF5733"));

                }



            }
        });
        textView = findViewById(R.id.tvTimer);
        new CountDownTimer(20000, 1000) {

            public void onTick(long msf) {
                textView.setText("remaining: " + msf / 1000);
            }

            public void onFinish() {
                textView.setText("done!");
            }
        }.start();

    }
}