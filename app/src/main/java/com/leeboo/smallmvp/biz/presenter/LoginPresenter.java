package com.leeboo.smallmvp.biz.presenter;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;

import com.leeboo.smallmvp.api.AppNetRequest;
import com.leeboo.smallmvp.base.BasePresenter;
import com.leeboo.smallmvp.base.BaseResponseBean;
import com.leeboo.smallmvp.base.BaseView;
import com.leeboo.smallmvp.bean.UserInfo;
import com.leeboo.smallmvp.biz.view.LoginView;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;


/**
 * LoginPresenter
 */

public class LoginPresenter implements BasePresenter {
    private Context context;
    private LoginView loginView;
    private UserInfo userInfo;
    private ProgressDialog progressDialog;

    public void showProgressDialog(String message) {
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(message);
        progressDialog.show();
    }

    private void dismissProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    public LoginPresenter(Context context) {
        this.context = context;
    }

    @Override
    public void onCreate() {
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void attachView(BaseView view) {
        loginView = (LoginView) view;
    }

    @Override
    public void attachIncomingIntent(Intent intent) {

    }

    public void doLogin(String username, String password) {
        AppNetRequest.getLoginApi().login(username, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<BaseResponseBean<UserInfo>>() {
                    @Override
                    public void call(BaseResponseBean<UserInfo> response) {
                        if (response != null && response.data != null) {
                            userInfo = response.data;
                            loginView.onSuccess(userInfo);
                        } else {
                            loginView.onError("data==null");
                        }
                        dismissProgressDialog();
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        loginView.onError(throwable.getMessage());
                        dismissProgressDialog();
                    }
                });
    }
}
