package com.blueoceanpay.api;


import com.blueoceanpay.bean.PayRspBean;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;


/**
 * Created by Administrator on 2018/6/13.
 */

public interface ApiService {


    //统一支付
//  @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/payment/pay")
    Observable<PayRspBean> pay(@Body RequestBody bean);





}