package com.blueoceanpay.bean;

/**
 * Created by Kevin on 2019/9/18.
 */

public class PayRspBean {



    private int code;
    private String message;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * app : {"_input_charset":"UTF-8","body":"DEMO","currency":"HKD","forex_biz":"FP","it_b_pay":"30m","notify_url":"https:\/\/api.tlinx.hk\/mct1\/paystatus\/notify\/payment\/AlipayHKOL","out_trade_no":"***********************","partner":"**************","payment_inst":"ALIPAYCN","payment_type":1,"product_code":"NEW_WAP_OVERSEAS_SELLER","refer_url":"http:\/\/api.hk.blueoceanpay.com\/alipay\/order\/entry","seller_id":"************","service":"mobile.securitypay.pay","subject":"DEMO","total_fee":33,"sign":"*********************************","sign_type":"RSA"}
         * appid : *******
         * attach :
         * bank_type :
         * body : DEMO
         * cash_fee : 0
         * cash_fee_type :
         * create_time : 1568804516
         * detail :
         * discount : 0
         * fee_type : HKD
         * id : 1361062
         * is_subscribe : N
         * mch_name : BlueOcean Pay
         * nonce_str : **********
         * out_trade_no : **********************
         * pay_amount : 3300
         * provider : alipay
         * qrcode :
         * refundable : 0
         * sn : *************************
         * time_end : 0
         * total_fee : 3300
         * total_refund_fee : 0
         * trade_state : NOTPAY
         * trade_type : APP
         * transaction_id : ******************
         * wallet : CN
         * sign : ********************
         */
        private String app_format;
        private String app;
        private int appid;
        private String attach;
        private String bank_type;
        private String body;
        private String cash_fee;
        private String cash_fee_type;
        private String create_time;
        private String detail;
        private String discount;
        private String fee_type;
        private String id;
        private String is_subscribe;
        private String mch_name;
        private String nonce_str;
        private String out_trade_no;
        private String pay_amount;
        private String provider;
        private String qrcode;
        private int refundable;
        private String sn;
        private int time_end;
        private String total_fee;
        private int total_refund_fee;
        private String trade_state;
        private String trade_type;
        private String transaction_id;
        private String wallet;
        private String sign;

        public String getAdapter() {
            return adapter;
        }

        public void setAdapter(String adapter) {
            this.adapter = adapter;
        }

        private String adapter;

        public String getApp() {
            return app;
        }

        public void setApp(String app) {
            this.app = app;
        }

        public int getAppid() {
            return appid;
        }

        public void setAppid(int appid) {
            this.appid = appid;
        }

        public String getAttach() {
            return attach;
        }

        public void setAttach(String attach) {
            this.attach = attach;
        }

        public String getBank_type() {
            return bank_type;
        }

        public void setBank_type(String bank_type) {
            this.bank_type = bank_type;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public String getCash_fee() {
            return cash_fee;
        }

        public void setCash_fee(String cash_fee) {
            this.cash_fee = cash_fee;
        }

        public String getCash_fee_type() {
            return cash_fee_type;
        }

        public void setCash_fee_type(String cash_fee_type) {
            this.cash_fee_type = cash_fee_type;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public String getDiscount() {
            return discount;
        }

        public void setDiscount(String discount) {
            this.discount = discount;
        }

        public String getFee_type() {
            return fee_type;
        }

        public void setFee_type(String fee_type) {
            this.fee_type = fee_type;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getIs_subscribe() {
            return is_subscribe;
        }

        public void setIs_subscribe(String is_subscribe) {
            this.is_subscribe = is_subscribe;
        }

        public String getMch_name() {
            return mch_name;
        }

        public void setMch_name(String mch_name) {
            this.mch_name = mch_name;
        }

        public String getNonce_str() {
            return nonce_str;
        }

        public void setNonce_str(String nonce_str) {
            this.nonce_str = nonce_str;
        }

        public String getOut_trade_no() {
            return out_trade_no;
        }

        public void setOut_trade_no(String out_trade_no) {
            this.out_trade_no = out_trade_no;
        }

        public String getPay_amount() {
            return pay_amount;
        }

        public void setPay_amount(String pay_amount) {
            this.pay_amount = pay_amount;
        }

        public String getProvider() {
            return provider;
        }

        public void setProvider(String provider) {
            this.provider = provider;
        }

        public String getQrcode() {
            return qrcode;
        }

        public void setQrcode(String qrcode) {
            this.qrcode = qrcode;
        }

        public int getRefundable() {
            return refundable;
        }

        public void setRefundable(int refundable) {
            this.refundable = refundable;
        }

        public String getSn() {
            return sn;
        }

        public void setSn(String sn) {
            this.sn = sn;
        }

        public int getTime_end() {
            return time_end;
        }

        public void setTime_end(int time_end) {
            this.time_end = time_end;
        }

        public String getTotal_fee() {
            return total_fee;
        }

        public void setTotal_fee(String total_fee) {
            this.total_fee = total_fee;
        }

        public int getTotal_refund_fee() {
            return total_refund_fee;
        }

        public void setTotal_refund_fee(int total_refund_fee) {
            this.total_refund_fee = total_refund_fee;
        }

        public String getTrade_state() {
            return trade_state;
        }

        public void setTrade_state(String trade_state) {
            this.trade_state = trade_state;
        }

        public String getTrade_type() {
            return trade_type;
        }

        public void setTrade_type(String trade_type) {
            this.trade_type = trade_type;
        }

        public String getTransaction_id() {
            return transaction_id;
        }

        public void setTransaction_id(String transaction_id) {
            this.transaction_id = transaction_id;
        }

        public String getWallet() {
            return wallet;
        }

        public void setWallet(String wallet) {
            this.wallet = wallet;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public String getApp_format() {
            return app_format;
        }

        public void setApp_format(String app_format) {
            this.app_format = app_format;
        }
    }

    @Override
    public String toString() {
        return "PayRspBean{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
