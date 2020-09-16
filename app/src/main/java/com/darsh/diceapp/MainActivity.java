package com.darsh.diceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView dice1 = findViewById(R.id.imgDice1);
        final ImageView dice2 = findViewById(R.id.imgDice2);
        final int [] images = {R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,R.drawable.dice4,R.drawable.dice5,R.drawable.dice6};
        final MediaPlayer mp = MediaPlayer.create(this,R.raw.dice_sound);

        Button btnRoll = findViewById(R.id.btnRollDice);
        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("RollButton", "Roll the dice button tapped!");
                Random r1 = new Random();
                Random r2 = new Random();
                Random r3 = new Random();
                Random r4 = new Random();
                int randomNum1 = r1.nextInt(6);
                int randomNum2 = r2.nextInt(6);
                int randomNum3 = r3.nextInt(6);
                int [] a = {randomNum1, randomNum2, randomNum3};
                int randomNum4 = r4.nextInt(3);
                int rnd = a[randomNum4];
                dice1.setImageResource(images[rnd]);
                randomNum1 = r1.nextInt(6);
                randomNum2 = r2.nextInt(6);
                randomNum3 = r3.nextInt(6);
                int [] b = {randomNum1, randomNum2, randomNum3};
                randomNum4 = r4.nextInt(3);
                rnd = b[randomNum4];
                dice2.setImageResource(images[rnd]);
                YoYo.with(Techniques.RubberBand)
                        .duration(500)
                        .repeat(0)
                        .playOn(findViewById(R.id.btnRollDice));
                YoYo.with(Techniques.Shake)
                        .duration(500)
                        .repeat(0)
                        .playOn(findViewById(R.id.imgDice1));
                YoYo.with(Techniques.Shake)
                        .duration(500)
                        .repeat(0)
                        .playOn(findViewById(R.id.imgDice2));
                mp.start();
            }
        });
    }
}