package com.yqq.performanceoptimisation;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by Administrator on 2017/9/23 0023.
 */

public class YqqApplication extends Application {


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
    }



}
