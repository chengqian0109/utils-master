package com.jack.utils;

import android.text.TextUtils;
import android.util.Log;

/**
 * 日志打印工具类
 *
 * @author chengqian
 * Created on 2018/6/28
 */
public class LogUtils {
    /**
     * 日志输出级别NONE
     */
    private static final int LEVEL_NONE = 0;
    /**
     * 日志输出级别V
     */
    private static final int LEVEL_VERBOSE = 1;
    /**
     * 日志输出级别D
     */
    private static final int LEVEL_DEBUG = 2;
    /**
     * 日志输出级别I
     */
    private static final int LEVEL_INFO = 3;
    /**
     * 日志输出级别W
     */
    private static final int LEVEL_WARN = 4;
    /**
     * 日志输出级别E
     */
    private static final int LEVEL_ERROR = 5;

    /**
     * 日志输出时的TAG
     */
    private static String mTag = "LogUtils";
    /**
     * 是否允许输出log
     */
    private static int sLogLevel = LEVEL_ERROR;

    /**
     * 以级别为 d 的形式输出LOG
     */
    public static void v(String msg) {
        if (sLogLevel <= LEVEL_VERBOSE) {
            Log.v(mTag, msg);
        }
    }

    /**
     * 以级别为 d 的形式输出LOG
     */
    public static void d(String msg) {
        if (sLogLevel <= LEVEL_DEBUG) {
            Log.d(mTag, msg);
        }
    }

    /**
     * 以级别为 i 的形式输出LOG
     */
    public static void i(String msg) {
        if (sLogLevel <= LEVEL_INFO) {
            Log.i(mTag, msg);
        }
    }

    /**
     * 以级别为 w 的形式输出LOG
     */
    public static void w(String msg) {
        if (sLogLevel <= LEVEL_WARN) {
            Log.w(mTag, msg);
        }
    }

    /**
     * 以级别为 w 的形式输出Throwable
     */
    public static void w(Throwable tr) {
        if (sLogLevel <= LEVEL_WARN) {
            Log.w(mTag, "", tr);
        }
    }

    /**
     * 以级别为 w 的形式输出LOG信息和Throwable
     */
    public static void w(String msg, Throwable tr) {
        if (sLogLevel <= LEVEL_WARN && null != msg) {
            Log.w(mTag, msg, tr);
        }
    }

    /**
     * 以级别为 e 的形式输出LOG
     */
    public static void e(String msg) {
        if (sLogLevel <= LEVEL_ERROR) {
            Log.e(mTag, msg);
        }
    }

    /**
     * 以级别为 e 的形式输出Throwable
     */
    public static void e(Throwable tr) {
        if (sLogLevel <= LEVEL_ERROR) {
            Log.e(mTag, "", tr);
        }
    }

    /**
     * 以级别为 e 的形式输出LOG信息和Throwable
     */
    public static void e(String msg, Throwable tr) {
        if (sLogLevel <= LEVEL_ERROR && !TextUtils.isEmpty(msg)) {
            Log.e(mTag, msg, tr);
        }
    }

    /**
     * 设置仅打印错误级别的日志
     *
     * @param isErrorLevel true表示仅打印错误级别的日志
     */
    public static void setLogErrorOnly(boolean isErrorLevel) {
        if (isErrorLevel) {
            sLogLevel = LEVEL_ERROR;
        }
    }
}
