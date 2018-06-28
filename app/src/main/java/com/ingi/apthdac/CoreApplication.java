package com.ingi.apthdac;

import android.app.Application;

import lombok.Getter;

public class CoreApplication extends Application {
    @Getter private SharedPreferencesManager sharedPreferencesManager;

    @Override
    public void onCreate() {
        super.onCreate();
        sharedPreferencesManager = new SharedPreferencesManager(this);
    }
}
