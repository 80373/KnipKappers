package com.knip80373;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by 80373 on 13/06/2018.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/knip.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}