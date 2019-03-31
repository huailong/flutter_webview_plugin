package com.flutter_webview_plugin.bridge.handler;

/**
 * Js给Java的回调接口
 */
public interface JavaCallHandler {
    void onHandle(String handlerName, String jsResponseData);
}
