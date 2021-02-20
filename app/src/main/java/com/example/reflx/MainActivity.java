package com.example.reflx;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.opengl.Visibility;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView scoreText;
    TextView timeText;
    int score;
    ImageView imageView00;
    ImageView imageView01;
    ImageView imageView02;
    ImageView imageView03;
    ImageView imageView10;
    ImageView imageView11;
    ImageView imageView12;
    ImageView imageView13;
    ImageView imageView20;
    ImageView imageView21;
    ImageView imageView22;
    ImageView imageView23;
    ImageView imageView30;
    ImageView imageView31;
    ImageView imageView32;
    ImageView imageView33;
    ImageView imageView40;
    ImageView imageView41;
    ImageView imageView42;
    ImageView imageView43;
    Handler handler;
    Runnable runnable;

     ImageView[] imageArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timeText=(TextView) findViewById(R.id.timeText) ;
        scoreText= (TextView) findViewById(R.id.scoreText);
         imageView00=findViewById(R.id.imageView00);
         imageView01=findViewById(R.id.imageView01);
         imageView02=findViewById(R.id.imageView02);
         imageView03=findViewById(R.id.imageView03);
         imageView10=findViewById(R.id.imageView10);
         imageView11=findViewById(R.id.imageView11);
         imageView12=findViewById(R.id.imageView12);
         imageView13=findViewById(R.id.imageView13);
         imageView20=findViewById(R.id.imageView20);
         imageView21=findViewById(R.id.imageView21);
         imageView22=findViewById(R.id.imageView22);
         imageView23=findViewById(R.id.imageView23);
         imageView30=findViewById(R.id.imageView30);
         imageView31=findViewById(R.id.imageView31);
         imageView32=findViewById(R.id.imageView32);
         imageView33=findViewById(R.id.imageView33);
         imageView40=findViewById(R.id.imageView40);
         imageView41=findViewById(R.id.imageView41);
         imageView42=findViewById(R.id.imageView42);
         imageView43=findViewById(R.id.imageView43);
        imageArray = new ImageView[]{imageView00, imageView01, imageView02, imageView03, imageView10, imageView11, imageView12, imageView13, imageView20, imageView21, imageView22, imageView23, imageView30, imageView31, imageView32, imageView33, imageView40, imageView41, imageView42, imageView43};
        score=0;
        hideImages();


        score = 0;

        new CountDownTimer(10000,1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                timeText.setText("Time: " + millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {

                timeText.setText("Time Off");
                handler.removeCallbacks(runnable);
                for (ImageView image : imageArray) {
                    image.setVisibility(View.INVISIBLE);
                }


                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);

                alert.setTitle("Restart?");
                alert.setMessage("Are you sure to restart game?");
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        //restart

                        Intent intent = getIntent();
                        finish();
                        startActivity(intent);

                    }
                });

                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Game Over!", Toast.LENGTH_SHORT).show();
                    }
                });

                alert.show();

            }
        }.start();

    }

    public void increaseScore (View view) {

        score++;
        //score = score + 1;

        scoreText.setText("Score: " + score);


    }

    public void hideImages() {

        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {

                for (ImageView image : imageArray) {
                    image.setVisibility(View.INVISIBLE);
                }

                Random random = new Random();
                int i = random.nextInt(19);
                imageArray[i].setVisibility(View.VISIBLE);

                handler.postDelayed(this,500);

            }
        };


        handler.post(runnable);


    }
}