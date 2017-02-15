package com.leeboo.smallmvp.biz.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.leeboo.smallmvp.R;
import com.leeboo.smallmvp.base.BaseActivity;
import com.leeboo.smallmvp.biz.presenter.LoginPresenter;



public class LoginActivity extends BaseActivity {
    LoginPresenter loginPresenter;
    SwipeRefreshLayout demo_swiperefreshlayout;
    RecyclerView demo_recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        demo_swiperefreshlayout = (SwipeRefreshLayout) findViewById(R.id.demo_swiperefreshlayout);
        demo_recycler=(RecyclerView)this.findViewById(R.id.demo_recycler);
        loginPresenter = new LoginPresenter(this);
        loginPresenter.onCreate();
//        loginPresenter.attachView(loginView);
    }
}

