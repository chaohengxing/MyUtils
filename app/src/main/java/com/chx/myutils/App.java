package com.chx.myutils;

import android.app.Application;

/**
 * Created by chaohx on 2017/7/19.
 */

public class App extends Application {
    private static App instance;

    public static synchronized App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
