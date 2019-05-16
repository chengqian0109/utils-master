package com.jack.utils;

import android.app.Application;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.util.DisplayMetrics;

/**
 * @author chengqian
 * Created on 2019-04-08
 */
public class Utils {
    /**
     * 应用程序上下文
     */
    private static Application sApp;

    /**
     * 初始化
     *
     * @param app 应用程序入口
     */
    public static void init(Application app) {
        if (app == null) {
            throw new IllegalArgumentException("app must not be null");
        }
        sApp = app;
    }

    /**
     * 获取应用程序上下文
     */
    public static Application getApp() {
        if (sApp == null) {
            throw new IllegalArgumentException("You must invoke Utils#init(app) first!");
        }
        return sApp;
    }

    /**
     * 获取指定字符串
     *
     * @param strId 字符串ID
     */
    public static String getString(@StringRes int strId) {
        if (sApp == null) {
            throw new IllegalArgumentException("You must invoke Utils#init(app) first!");
        }
        return getResources().getString(strId);
    }

    /**
     * 获取格式化的指定字符串
     *
     * @param strId      字符串ID
     * @param formatArgs 格式化参数
     */
    public static String getString(@StringRes int strId, Object... formatArgs) {
        if (sApp == null) {
            throw new IllegalArgumentException("You must invoke Utils#init(app) first!");
        }
        return getResources().getString(strId, formatArgs);
    }

    /**
     * 获取应用资源对象
     */
    public static Resources getResources() {
        if (sApp == null) {
            throw new IllegalArgumentException("You must invoke Utils#init(app) first!");
        }
        return sApp.getResources();
    }

    /**
     * 获取指定颜色值
     *
     * @param colorId 颜色资源ID
     */
    public static int getColor(@ColorRes int colorId) {
        if (sApp == null) {
            throw new IllegalArgumentException("You must invoke Utils#init(app) first!");
        }
        return ContextCompat.getColor(sApp, colorId);
    }

    /**
     * 获取指定图片资源
     *
     * @param drawableId 图片资源ID
     */
    public static Drawable getDrawable(@ColorRes int drawableId) {
        if (sApp == null) {
            throw new IllegalArgumentException("You must invoke Utils#init(app) first!");
        }
        return ContextCompat.getDrawable(sApp, drawableId);
    }

    /**
     * 获取屏幕宽度
     */
    public static int getScreenWidth() {
        if (sApp == null) {
            throw new IllegalArgumentException("You must invoke Utils#init(app) first!");
        }
        return getDisplayMetrics().widthPixels;
    }

    /**
     * 获取屏幕宽度
     */
    public static int getScreenHeight() {
        if (sApp == null) {
            throw new IllegalArgumentException("You must invoke Utils#init(app) first!");
        }
        return getDisplayMetrics().heightPixels;
    }

    /**
     * 获取屏幕宽高矩阵
     */
    public static DisplayMetrics getDisplayMetrics() {
        if (sApp == null) {
            throw new IllegalArgumentException("You must invoke Utils#init(app) first!");
        }
        return getResources().getDisplayMetrics();
    }
}
