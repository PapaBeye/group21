package edu.vcu.beyep.group21test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

import android.view.animation.AnimationUtils;
import android.view.animation.Animation;
import android.widget.ImageView;

public class splashWelcome extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 4000; // timeout 4s
    public  static ProgressBar pb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_welcome);

        ImageView  splash_screen_logo = findViewById(R.id.splash_screen_logo);

        Animation splash_animation = AnimationUtils.loadAnimation(this, R.anim.splash_screen_logo_anim);
        splash_screen_logo.startAnimation(splash_animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent splashIntent = new Intent(splashWelcome.this, homeScreen.class);
                startActivity(splashIntent);
                finish();
            }
        },SPLASH_TIME_OUT);
    }

}

