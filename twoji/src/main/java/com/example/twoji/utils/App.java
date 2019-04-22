package com.example.twoji.utils;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * author:${张四佟}
 * date:2019/3/7 20:17
 * description
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
