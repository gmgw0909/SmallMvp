package com.leeboo.smallmvp.api;

import com.leeboo.smallmvp.base.BaseResponseBean;
import com.leeboo.smallmvp.bean.UserInfo;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 创建者：  LeeBoo
 * 创建时间：2016/10/26 12:54
 */
public interface LoginApi {

    //登录

    /**
     * 登录账号
     */
    @GET("user")
    Observable<BaseResponseBean<UserInfo>> login(
            @Query("username") String username,
            @Query("password") String password);


}
