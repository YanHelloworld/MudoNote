package com.mudo.utils;

import android.util.Log;

/**
 * Created by Mudo on 2015/12/18.
 */
public class LogHelper {


    public static void logv(String tag, String str) {

        Log.v(tag, str);
    }

    public static void logd(String tag, String str) {
        Log.v(tag, str);
    }

    public static void logi(String tag, String str) {
        Log.i(tag, str);
    }

    public static void logw(String tag, String str) {
        Log.w(tag, str);
    }

    public static void loge(String tag, String str) {
        Log.e(tag, str);
    }

}
