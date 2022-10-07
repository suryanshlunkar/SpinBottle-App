package com.example.spinbottle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView bot;
    private TextView label;
    private Random rand = new Random();
    private int lstDr;
    private boolean spn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bot = findViewById(R.id.bottle);
        label = findViewById(R.id.label);
    }

        public void spinBottle (View v){
            // check if the bottled has stopped spinning
            if (!spn) {

                // generate a random number from 1-1800
                int num = rand.nextInt(1800);

                // set the pivot to the centre of the image
                float pX = bot.getWidth() / 2;
                float pY = bot.getHeight() / 2;

                // pass parameters in RoatateAnimation function
                Animation rot = new RotateAnimation(lstDr, num, pX, pY);

                // set rotate duration 2500 millisecs
                rot.setDuration(2500);

                // rotation will persist after finishing
                rot.setFillAfter(true);
                rot.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        spn = true;
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        spn = false;
                        String out = select();
                        label.setText(out);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                    }
                });


                // change the last direction
                lstDr = num;

                // start the animation
                bot.startAnimation(rot);
            }
        }

        public  String select(){
        int option = rand.nextInt(6);
        String out;
        if(option == 1){
            out = "Make a prank call";
        }
        else if(option==2){
            out="Tell your deepest secret";
        }
        else if(option==3){
            out="What is your biggest fear";
        }
        else if(option==4){
          out="What is your most embarrassing moment?";
        }
        else if(option==5){
            out="Aap bach gye";
        }
        else{
            out="Reveal your snapchat memory";
        }
        return out;
    }
    }
