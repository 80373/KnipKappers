package com.knip80373;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/knip.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());
        setContentView(R.layout.activity_splash);

        Animation a = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        a.reset();
        TextView tv = (TextView) findViewById(R.id.splashtext);
        tv.clearAnimation();
        tv.startAnimation(a);

        final Animation b = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        b.reset();



        Thread background = new Thread() {
            public void run() {

                try {
                    // sleep for 1 seconds
                    sleep(1 * 1000);


                    //redirect to new main
                    Intent i = new Intent(getBaseContext(), MainActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                    //Remove activity
                    finish();

                } catch (Exception e) {

                }
            }
        };


        background.start();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }



}