package com.leeboo.smallmvp.base;


import com.leeboo.smallmvp.netsetting.CookieManger;
import com.leeboo.smallmvp.netsetting.GsonConverterFactory;

import java.security.cert.CertificateException;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * 创建者：  LeeBoo
 * 描述     网络Request基类
 */
public class BaseRequest {

    public static Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    public static CallAdapter.Factory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();

    public BaseRequest() {
    }

    public static OkHttpClient getClient() {
        SSLSocketFactory sslSocketFactory;
        try {
            // Create a trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
                @Override
                public void checkClientTrusted(
                        java.security.cert.X509Certificate[] chain,
                        String authType) throws CertificateException {
                }

                @Override
                public void checkServerTrusted(
                        java.security.cert.X509Certificate[] chain,
                        String authType) throws CertificateException {
                }

                @Override
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return new java.security.cert.X509Certificate[0];
                }
            }};

            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustAllCerts,
                    new java.security.SecureRandom());
            // Create an ssl socket factory with our all-trusting manager
            sslSocketFactory = sslContext
                    .getSocketFactory();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //开启打印连接日志
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT);
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //设置cookie持久化 设置请求头 Https
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .cookieJar(new CookieManger())
                .sslSocketFactory(sslSocketFactory)
                //                .hostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER)
                .addInterceptor(httpLoggingInterceptor)
//                .addInterceptor(new Interceptor() {
//                    @Override
//                    public okhttp3.Response intercept(Chain chain) throws IOException {
//                        Request request = chain.request()
//                                .newBuilder()
//                                .addHeader("token", SPUtils.getString("token"))
//                                .build();
//                        return chain.proceed(request);
//                    }
//                })
                .build();

        return httpClient;
    }

}
