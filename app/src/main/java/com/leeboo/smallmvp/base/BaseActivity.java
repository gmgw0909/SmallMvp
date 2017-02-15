package com.leeboo.smallmvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.leeboo.smallmvp.utils.ToastUtil;


/**
 * BaseActivity
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void showToast(String message){
        ToastUtil.showToast(this, message);
    }
}
