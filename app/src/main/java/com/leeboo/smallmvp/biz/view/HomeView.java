package com.leeboo.smallmvp.biz.view;

import com.leeboo.smallmvp.base.BaseView;
import com.leeboo.smallmvp.bean.ContentInfo;

import java.util.List;

/**
 * LoginView
 */

public interface HomeView extends BaseView {

    void onSuccess(List<ContentInfo> contentInfos);

    void onError(String result);
}
