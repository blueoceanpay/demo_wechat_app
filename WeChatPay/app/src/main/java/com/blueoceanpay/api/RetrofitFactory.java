package com.blueoceanpay.api;

import com.blueoceanpay.utils.SSLSocketClient;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Kevin on 2019/9/18.
 */

public class RetrofitFactory {
    private static RetrofitFactory mRetrofitFactory;
    private static ApiService mApiService;
    public String BASE_URL = "http://api.hk.blueoceanpay.com";
    public ApiService getAPiService() {
        return mApiService;
    }

    private RetrofitFactory() {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.sslSocketFactory(SSLSocketClient.getSSLSocketFactory());
        builder.hostnameVerifier(SSLSocketClient.getHostnameVerifier());
        Retrofit sRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        mApiService = sRetrofit.create(ApiService.class);



    }

    public static RetrofitFactory getInstence() {
        if (mRetrofitFactory == null) {
            synchronized (RetrofitFactory.class) {
                if (mRetrofitFactory == null) {
                    mRetrofitFactory = new RetrofitFactory();
                }
            }
        }
        return mRetrofitFactory;
    }
}
