package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int SPLASH_SCREEN=3000;
    Animation topAnimator,bottomAnimator;
    ImageView image;
    TextView logo,slogan,motivation,textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        topAnimator= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnimator= AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        image=findViewById(R.id.imageView2);
        logo=findViewById(R.id.textView);
        slogan=findViewById(R.id.textView2);
        motivation=findViewById(R.id.textView3);
        textView1=findViewById(R.id.textView10);


        image.setAnimation(topAnimator);
        logo.setAnimation(bottomAnimator);
        slogan.setAnimation(bottomAnimator);
        motivation.setAnimation(bottomAnimator);
        textView1.setAnimation(topAnimator);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this,login.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);
    }
}