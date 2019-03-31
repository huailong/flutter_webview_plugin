package com.flutter_webview_plugin.bridge.handler;

import com.flutter_webview_plugin.bridge.CallBackFunction;

/**
 * Java给Js的回调接口
 */
public interface JsHandler {
    void onHandle(String handlerName, String responseData, CallBackFunction function);

}
