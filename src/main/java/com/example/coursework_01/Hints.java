package com.example.coursework_01;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Hints extends AppCompatActivity {
    List<String> Cars;
    String carsArray[];
    ImageView imageViewHint;
    Button btnSubmit;
    int loadedHintImage;
    EditText editTextDash;
    boolean isTimerSwitchOn = false;
    TextView textViewHint, textViewHintAns, textView2, textviewTimer3;
    int count = 0;
    String input = "";
    String current = "";
    CountDownTimer countDownTimer;
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
        setContentView(R.layout.activity_hints);
        Cars = Arrays.asList(getResources().getStringArray(R.array.cars));
        carsArray = getResources().getStringArray(R.array.cars);

        imageViewHint = findViewById(R.id.imageViewHint);
        btnSubmit = findViewById(R.id.btnSubmit);
        editTextDash = (EditText) findViewById(R.id.editTextDash);
        textViewHint = (TextView) findViewById(R.id.textViewhint);
        textViewHintAns = (TextView) findViewById(R.id.textViewhintans);
        textView2 = findViewById(R.id.textView2);
        textviewTimer3 = findViewById(R.id.textViewTimer3);

        Intent intent = getIntent();
        isTimerSwitchOn = intent.getExtras().getBoolean("switchValue");  //To get the boolean value from main activity

        if (isTimerSwitchOn) {    //Check weather switch is on or not
            switchTimer();
            start();
        } else {
            start();
        }

    }

    //To start the countdown in the text view
    public void switchTimer() {
        countDownTimer = new CountDownTimer(21000, 1000) {  //Create the countDownTimer
            @Override
            public void onTick(long millisUntilFinished) {
                String seconds = millisUntilFinished / 1000 + "";
                textviewTimer3.setText(seconds);
            }

            @Override
            public void onFinish() {
                textViewHintAns.setText("WRONG!");//method for when the timer finished
                textViewHintAns.setTextColor(Color.RED);
                nextbutton();
            }
        };
        countDownTimer.start();
        //start();//To Start the countdown
    }

    public void start() {
        Random random = new Random();
        loadedHintImage = random.nextInt(image.length);
        imageViewHint.setImageResource(image[loadedHintImage]);


        String finalWord = Cars.get(loadedHintImage);
        int word = carsArray[loadedHintImage].length();
        String[] marks = new String[word];

        textViewHint.setText("");
        for (int i = 0; i < word; i++) {
            marks[i] = "_";
            textViewHint.append(marks[i] + " ");
        }
        input = editTextDash.getText().toString();
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current = "";
                input = editTextDash.getText().toString().toLowerCase();
                if (input.length() != 1) {
                    textViewHintAns.setText("Invalid");
                } else if (!finalWord.contains(input)) {
                    textViewHintAns.setText("WRONG");
                    textViewHintAns.setTextColor(Color.YELLOW);
                    count++;
                    if (isTimerSwitchOn) {
                        countDownTimer.cancel();
                        switchTimer();//To pause the timer
                    }

                } else if (finalWord.contains(input)) {

                    for (int i = 0; i < finalWord.length(); i++) {
                        if (finalWord.charAt(i) == input.charAt(0)) {
                            marks[i] = "" + input.charAt(0);
                        }
                        current += marks[i];
                    }
                }
                textViewHint.setText("");
                for (int i = 0; i < marks.length; i++) {
                    textViewHint.append(marks[i] + " ");
                }


                if (current.equals(finalWord)) {
                    textViewHintAns.setText("CORRECT!");
                    textViewHintAns.setTextColor(Color.GREEN);

                    if (isTimerSwitchOn) {
                        countDownTimer.cancel();                   //To pause the timer
                    }
                    ;

                    // change label
                    nextbutton();

                }


                if (count == 3) {
                    textViewHintAns.setText("WRONG!");
                    textViewHintAns.setTextColor(Color.RED);
                    textView2.setText(finalWord);
                    textView2.setTextColor(Color.YELLOW);

                    if (isTimerSwitchOn) {
                        countDownTimer.cancel();                   //To pause the timer
                    }

                    nextbutton();
                    // change label

                }
            }
        });

    }

    public void nextbutton() {
        btnSubmit.setText("NEXT");
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Hints.class);
                intent.putExtra("switchValue", isTimerSwitchOn);
                startActivity(intent);
            }
        });
    }

    public void HomeClickHint(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}