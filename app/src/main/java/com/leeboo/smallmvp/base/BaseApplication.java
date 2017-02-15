package com.leeboo.smallmvp.base;

import android.app.Application;

/**
 * 创建者：  LeeBoo
 * 创建时间：2016/7/12 10:32
 */
public class BaseApplication extends Application {


    private static BaseApplication myApp = null;

    public static BaseApplication getMyApplication() {
        return myApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myApp = this;
    }
}
