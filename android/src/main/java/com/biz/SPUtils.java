package com.biz;

import android.content.Context;
import android.content.SharedPreferences;

/**
 *
 * Created by zhanhl on 2019/3/31 11:09 AM
 */
public class SPUtils {
    private static Context sContext;

    public static void bindContext(Context context) {
        sContext = context.getApplicationContext();
    }

    private static final String SP_FILE_NAME = "E8BB9FB9D937BF6399C97CA28CF439EE";

    public static String getString(String key) {
        return getString(key, "");
    }

    public static String getString(String key, String defaultValue) {
        SharedPreferences sharedPreferences = sContext
                .getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE);

        return sharedPreferences.getString(key, defaultValue);
    }

    public static void putString(String key, String value) {
        SharedPreferences sharedPreferences = sContext
                .getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE);

        final String oldValue = sharedPreferences.getString(key, "");
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if ("".equals(value)) {
            value = null;
        }
        editor.putString(key, value);
        editor.apply();

        if (!oldValue.equals(value)) {
            // TODO 值发生变化，需要通知改变？
        }
    }
}
