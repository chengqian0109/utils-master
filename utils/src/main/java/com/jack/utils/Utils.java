package com.jack.utils;

import android.app.Application;

/**
 * @author chengqian
 * Created on 2019-04-08
 */
public class Utils {
    /**
     * 应用程序上下文
     */
    private static Application sApplication;

    /**
     * 初始化
     *
     * @param app 应用程序入口
     */
    public static void init(Application app) {
        if (app == null) {
            throw new IllegalArgumentException("app must not be null");
        }
        sApplication = app;
    }

    /**
     * 获取应用程序上下文
     */
    public static Application getApplication() {
        if (sApplication == null) {
            throw new IllegalArgumentException("You should invoke Utils#init(app) first!");
        }
        return sApplication;
    }
}
