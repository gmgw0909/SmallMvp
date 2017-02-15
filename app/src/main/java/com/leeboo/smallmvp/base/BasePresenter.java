package com.leeboo.smallmvp.base;


import android.content.Intent;


/**
 * BasePresenter
 */

public interface BasePresenter {
    void onCreate();

    void onStart();

    void onStop();

    void pause();

    void attachView(BaseView view);

    void attachIncomingIntent(Intent intent);
}
