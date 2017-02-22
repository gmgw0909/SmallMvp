package com.leeboo.smallmvp.biz.presenter;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;

import com.leeboo.smallmvp.api.AppNetRequest;
import com.leeboo.smallmvp.base.BasePresenter;
import com.leeboo.smallmvp.base.BaseResponseBean;
import com.leeboo.smallmvp.base.BaseView;
import com.leeboo.smallmvp.bean.ContentInfo;
import com.leeboo.smallmvp.biz.view.HomeView;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;


/**
 * LoginPresenter
 */

public class HomePresenter implements BasePresenter {
    private Context context;
    private HomeView homeView;
    private List<ContentInfo> contentInfos;
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

    public HomePresenter(Context context) {
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
        homeView = (HomeView) view;
    }

    @Override
    public void attachIncomingIntent(Intent intent) {

    }

    public void getData(String user_id) {
        AppNetRequest.getHomeApi().home(user_id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<BaseResponseBean<List<ContentInfo>>>() {
                    @Override
                    public void call(BaseResponseBean<List<ContentInfo>> response) {
                        if (response != null && response.data != null) {
                            contentInfos = response.data;
                            homeView.onSuccess(contentInfos);
                        } else {
                            homeView.onError("data==null");
                        }
                        dismissProgressDialog();
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        homeView.onError(throwable.getMessage());
                        dismissProgressDialog();
                    }
                });
    }
}
