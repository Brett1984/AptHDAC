package com.ingi.apthdac.common;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    public Context getContext() {
        return this;
    }
}
