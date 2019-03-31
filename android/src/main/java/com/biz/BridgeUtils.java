package com.biz;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

/**
 * Created by zhanhl on 2019/3/31 11:12 AM
 */
public class BridgeUtils {

    // H5端存储数据在原生，替代local storage功能
    public static void putCache(String data) {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(data);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if (jsonObject == null) {
            return;
        }

        Iterator it = jsonObject.keys();
        while (it.hasNext()) {
            String key = (String) it.next();
            String value = jsonObject.optString(key);
            SPUtils.putString(key, value);
        }
    }

    public static String getCache(String key) {
        return SPUtils.getString(key);
    }

}
