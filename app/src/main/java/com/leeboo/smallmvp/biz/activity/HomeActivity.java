package com.leeboo.smallmvp.biz.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.leeboo.smallmvp.R;
import com.leeboo.smallmvp.base.BaseActivity;
import com.leeboo.smallmvp.bean.UserInfo;
import com.leeboo.smallmvp.biz.presenter.LoginPresenter;
import com.leeboo.smallmvp.biz.view.LoginView;

public class HomeActivity extends BaseActivity {
    LoginPresenter loginPresenter;
    EditText etName;
    EditText etPsw;
    Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginPresenter = new LoginPresenter(this);
        loginPresenter.onCreate();
        loginPresenter.attachView(loginView);

        etName = (EditText) findViewById(R.id.et_username);
        etPsw = (EditText) findViewById(R.id.et_password);
        btLogin = (Button) findViewById(R.id.btn_login);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString();
                String psw = etPsw.getText().toString();
                if (TextUtils.isEmpty(name)) {
                    showToast("请填入账号");
                    return;
                }
                if (TextUtils.isEmpty(psw)) {
                    showToast("请填入密码");
                    return;
                }
                loginPresenter.showProgressDialog("登录中...");
                loginPresenter.doLogin(name, psw);
            }
        });
    }

    private LoginView loginView = new LoginView() {
        @Override
        public void onSuccess(UserInfo userInfo) {
            showToast(userInfo.toString());
        }

        @Override
        public void onError(String result) {
            showToast(result);
        }
    };
}

