package com.flutter_webview_plugin.bridge;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * JsBridge  回调给H5的数据格式
 * Created by zhanhl on 2017/11/26.
 */

public class JsBridgeResult {
    private int code;
    private String msg;
    private String data;

    private String toJsonString() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.putOpt("code", code);
            jsonObject.putOpt("msg", msg);
            jsonObject.putOpt("data", data);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

    public static String generateSuccessResult(String data) {
        JsBridgeResult jsBridgeResult = new JsBridgeResult();
        jsBridgeResult.code = 1;
        jsBridgeResult.msg = "succ";
        jsBridgeResult.data = data;

        return jsBridgeResult.toJsonString();
    }

    public static String generateParamFailResult(String params) {
        JsBridgeResult jsBridgeResult = new JsBridgeResult();
        jsBridgeResult.code = 0;
        jsBridgeResult.msg = "invalid params, " + params;
        jsBridgeResult.data = "";

        return jsBridgeResult.toJsonString();
    }

    public static String generateFailResult(String data) {
        JsBridgeResult jsBridgeResult = new JsBridgeResult();
        jsBridgeResult.code = 0;
        jsBridgeResult.msg = "fail";
        jsBridgeResult.data = data;

        return jsBridgeResult.toJsonString();
    }
}
