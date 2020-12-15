package com.blueoceanpay.bean;

/**
 * Created by Kevin on 2019/9/18.
 * 需要上传的参数
 */

public class PayReqBean extends Req {
    String appid;
    String payment;
    String total_fee;
    String wallet;
    String body;
    String sub_appid;
    String store_id;

    public String getSub_appid() {
        return sub_appid;
    }

    public void setSub_appid(String sub_appid) {
        this.sub_appid = sub_appid;
    }

    public String getStore_id() {
        return store_id;
    }

    public void setStore_id(String store_id) {
        this.store_id = store_id;
    }


    public String getWallet() {
        return wallet;
    }

    public void setWallet(String wallet) {
        this.wallet = wallet;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


    @Override
    public String getSign() {
        return super.getSign();
    }

    @Override
    public void setSign(String sign) {
        super.setSign(sign);
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(String fee) {
        this.total_fee = fee;
    }


}
