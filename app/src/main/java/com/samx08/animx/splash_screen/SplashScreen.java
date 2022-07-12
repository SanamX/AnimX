package com.samx08.animx.splash_screen;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.samx08.animx.R;
import com.samx08.animx.create_account.Login;

public class SplashScreen extends AppCompatActivity {

    //Animation
    Animation logoanimation;
    ImageView logo;
    static int SPLASH_SCREEN=3000;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        //Hide The StausBar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Animation Hooks
        logoanimation= AnimationUtils.loadAnimation(this,R.anim.logoanim);
        logo=findViewById(R.id.app_logo);
        logo.setAnimation(logoanimation);

        //Handler
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, Login.class);

                Pair[] pairs = new Pair[1];
                pairs[0]=new Pair<View,String>(logo,"logo_transaction");


                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SplashScreen.this,pairs);
                startActivity(intent,options.toBundle());

            }
        },SPLASH_SCREEN);



    }
}
