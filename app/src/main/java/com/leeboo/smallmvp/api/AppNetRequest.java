package com.leeboo.smallmvp.api;


import com.leeboo.smallmvp.base.BaseRequest;
import com.leeboo.smallmvp.utils.Constants;

import retrofit2.Retrofit;

/**
 * 创建者：  LeeBoo
 * 创建时间：2017/2/12 10:13
 * 类描述：  App的所有api创建
 */
public class AppNetRequest extends BaseRequest {

    //登录注册模块
    private static LoginApi loginApi;

    public static LoginApi getLoginApi() {
        if (loginApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(getClient())
                    .baseUrl(Constants.BASE_API)
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            loginApi = retrofit.create(LoginApi.class);
        }
        return loginApi;
    }

    /**
     * 一般app可能会有很多模块(为了模拟 不应该这么分模块的)
     */
    //首页模块
    private static HomeApi homeApi;

    public static HomeApi getHomeApi() {
        if (homeApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(getClient())
                    .baseUrl(Constants.BASE_API)
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            homeApi = retrofit.create(HomeApi.class);
        }
        return homeApi;
    }
}
