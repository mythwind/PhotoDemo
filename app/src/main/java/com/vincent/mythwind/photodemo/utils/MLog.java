package com.vincent.mythwind.photodemo.utils;

import android.nfc.Tag;
import android.util.Log;

public class MLog {

    private static final String LOG_TAG = "wangss";
    private static final String LOG_PREFIX = "wangss---->";
    private static final int LOG_LEVEL = 6;
    private static final int LOG_INFO = 1;
    private static final int LOG_ERR = 5;

    public static final void info(String msg) {
        info(LOG_TAG, msg);
    }

    public static final void info(String tag, String msg) {
        if (LOG_LEVEL > LOG_INFO) {
            Log.i(tag, msg);
        }
    }

    public static final void err(String msg) {
        err(LOG_TAG, msg);
    }

    public static final void err(String tag, String msg) {
        if (LOG_LEVEL > LOG_INFO) {
            Log.e(tag, msg);
        }
    }

}
