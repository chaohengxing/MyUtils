package com.chx.myutils;

import android.app.Application;

import com.chx.myutils.utils.CrashHandler;

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

        CrashHandler.getInstance().init(this);
    }
}
