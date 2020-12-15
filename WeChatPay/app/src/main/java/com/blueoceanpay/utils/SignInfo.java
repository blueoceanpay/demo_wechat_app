package com.blueoceanpay.utils;


import android.util.Log;

import com.blueoceanpay.bean.SignBean;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by silver on 2017/12/14.
 */

public class SignInfo {
    /**
     * 支付签名算法sign
     *
     * @param parameters
     * @return
     */
    @SuppressWarnings("unchecked")
    public static String createSign(SortedMap<Object, Object> parameters, String key) {
        StringBuffer sb = new StringBuffer();
        Set es = parameters.entrySet();//所有参与传参的参数按照accsii排序（升序）
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            Object v = entry.getValue();
            if (null != v
                    && !"sign".equals(k) && !"key".equals(k)) {
                sb.append(k + "=" + v + "&");
            }
//            if(!"sign".equals(k) && !"key".equals(k)) {
//                if(null != v && !"".equals(v)){
//                    sb.append(k + "=" + v + "&");
//                }else{
//                    sb.append(k + "=" + "&");
//                }
//
//            }
        }
        sb.append("key=" + key);
        String sign = MD5Util.MD5Encode(sb.toString(), "UTF-8").toUpperCase();
        return sign;
    }

    public static SortedMap<Object, Object> getParametersMap(Object obj) {
        SignBean tmpObj = new SignBean();
        List<String> tmpNameList = new ArrayList<String>();
        for (Field field : tmpObj.getClass().getDeclaredFields()) {
            tmpNameList.add(field.getName());
            Log.d("SignInfo", "tmpObj.getName=" + field.getName());
        }
        SortedMap<Object, Object> parameters = new TreeMap<Object, Object>();
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Log.d("SignInfo", "field.getName=" + field.getName());
            try {
                if (field.get(obj) == null || tmpNameList.contains(field.getName())) {
                } else {
                    parameters.put(field.getName(), field.get(obj));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        Log.d("SignInfo", "getParametersMap: " + parameters.toString());
        return parameters;
    }
}
