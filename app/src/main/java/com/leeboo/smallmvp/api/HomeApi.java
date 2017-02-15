package com.leeboo.smallmvp.api;

import com.leeboo.smallmvp.base.BaseResponseBean;
import com.leeboo.smallmvp.bean.ContentInfo;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 创建者：  LeeBoo
 * 创建时间：2016/10/26 12:54
 */
public interface HomeApi {

    /**
     * 首页
     */
    @GET("home")
    Observable<BaseResponseBean<List<ContentInfo>>> home(
            @Query("user_id") String password);
}
