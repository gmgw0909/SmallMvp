package com.leeboo.smallmvp.biz.view;

import com.leeboo.smallmvp.base.BaseView;
import com.leeboo.smallmvp.bean.UserInfo;

/**
 * LoginView
 */

public interface HomeView extends BaseView {

    void onSuccess(UserInfo userInfo);

    void onError(String result);
}
