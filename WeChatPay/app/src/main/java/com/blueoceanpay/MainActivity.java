package com.blueoceanpay;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.blueoceanpay.api.RetrofitFactory;
import com.blueoceanpay.bean.PayReqBean;
import com.blueoceanpay.bean.PayRspBean;
import com.blueoceanpay.utils.SignInfo;
import com.google.gson.Gson;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_pay_sum;
    private Button bt_alipay, bt_value;
    private static final String AppKey = "";//商户Key
    private static final String AppId = "";//商户id
    private static final String TAG = "MainActivity";
    private static final String Payment = "wechat.app";//微信app支付
    private static final String Wallet = "CN";//钱包 CN/HK
    private static final int SDK_PAY_FLAG = 1;
    private String orderInfo;//发起支付宝支付参数
    private IWXAPI api;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        api = WXAPIFactory.createWXAPI(this, Constants.APP_ID);//填写自己的APPID
        et_pay_sum = findViewById(R.id.et_pay_sum);
        bt_alipay = findViewById(R.id.bt_alipay);
        bt_value = findViewById(R.id.bt_value);
        bt_alipay.setOnClickListener(this);
        bt_value.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_value:
                String money = et_pay_sum.getText().toString();
                getPayInfo(money);
                break;
            case R.id.bt_alipay:
                WxChatPay(orderInfo);
                break;
        }
    }

    /**
     * 请求支付信息
     *
     * @param money
     */
    private void getPayInfo(String money) {
        final PayReqBean payReqBean = new PayReqBean();
        payReqBean.setAppid(AppId);//商户id
        payReqBean.setPayment(Payment);//微信app支付
        payReqBean.setSub_appid(Constants.APP_ID);//AppID
        payReqBean.setTotal_fee(money);//支付金额 单位分
        // payReqBean.setWallet(Wallet);//钱包 CN/HK  微信支付不需要传
//        payReqBean.setStore_id("");  //选填
        payReqBean.setBody("测试商品");
        payReqBean.setSign(SignInfo.createSign(SignInfo.getParametersMap(payReqBean), AppKey));
        Gson gson = new Gson();
        String route = gson.toJson(payReqBean);//通过Gson将Bean转化为Json字符串形式
        Log.d(TAG, "请求报文" + route);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), route);
        RetrofitFactory.getInstence().getAPiService().pay(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PayRspBean>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: " + e.toString());
                        showAlert(MainActivity.this, "接口请求失败" + e.toString());

                    }

                    @Override
                    public void onNext(final PayRspBean payRspBean) {
                        showAlert(MainActivity.this, "获取原微信支付参数" + payRspBean.getData().getApp());//接口返回微信的支付参数
                        orderInfo = payRspBean.getData().getApp();
                    }
                });
    }


    private static void showAlert(Context ctx, String info) {
        showAlert(ctx, info, null);
    }

    private static void showAlert(Context ctx, String info, DialogInterface.OnDismissListener onDismiss) {
        new AlertDialog.Builder(ctx)
                .setMessage(info)
                .setPositiveButton("确认", null)
                .setOnDismissListener(onDismiss)
                .show();
    }

    void WxChatPay(String orderInfo) {
        api.registerApp(Constants.APP_ID);//填写自己的APPID，注册本身APP
        PayReq req = new PayReq();//PayReq就是订单信息对象
        try {
            JSONObject jsonObj = new JSONObject(orderInfo);
            //给req对象赋值
            req.appId = jsonObj.get("appid").toString();//APPID
            req.partnerId = jsonObj.get("partnerid").toString();//    商户号
            req.prepayId = jsonObj.get("prepayid").toString();//  预付款ID
            req.nonceStr = jsonObj.get("noncestr").toString();//随机数
            req.timeStamp = jsonObj.get("timestamp").toString();//时间戳
            req.packageValue = jsonObj.get("package").toString();//固定值Sign=WXPay
            req.sign = jsonObj.get("sign").toString();//签名
            api.sendReq(req);//将订单信息对象发送给微信服务器，即发送支付请求
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

}
