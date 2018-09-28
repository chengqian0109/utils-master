package com.jack.utils;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import java.util.Map;
import java.util.Set;

/**
 * 存取SharedPreferences配置信息的工具类
 *
 * @author chengqian
 * Created on 2018/9/25
 */
public class SPUtils {

    private static String CONFIG = "config";
    /**
     * SharedPreferences对象
     */
    private static SharedPreferences sp;

    /**
     * 必须初始化默认保存文件名为config
     */
    private static Context sAppContext;

    /**
     * 设置应用程序上下文
     *
     * @param appContext Application上下文
     */
    public static void setAppContext(Application appContext) {
        sAppContext = appContext;
    }

    /**
     * 保存字符串数据
     *
     * @param key   键
     * @param value 值
     */
    public static void saveString(String key, String value) {
        checkNonNull();
        if (sp == null) {
            sp = sAppContext.getSharedPreferences(CONFIG, Context.MODE_PRIVATE);
        }
        sp.edit().putString(key, value).apply();
    }

    /**
     * 保存布尔类型数据
     *
     * @param key   键
     * @param value 值
     */
    public static void saveBoolean(String key, boolean value) {
        checkNonNull();
        if (sp == null) {
            sp = sAppContext.getSharedPreferences(CONFIG, Context.MODE_PRIVATE);
        }
        sp.edit().putBoolean(key, value).apply();
    }

    /**
     * 保存字符串map集合
     *
     * @param map 要保存的字符串Map集合
     */
    public static void saveStringMap(Map<String, String> map) {
        checkNonNull();
        if (map != null) {
            Set<Map.Entry<String, String>> entries = map.entrySet();
            for (Map.Entry<String, String> entry : entries) {
                sp.edit().putString(entry.getKey(), entry.getValue()).apply();
            }
        }
    }

    /**
     * 读取字符串
     *
     * @param key      键
     * @param defValue 默认值
     * @return 字符串
     */
    public static String getString(String key, String defValue) {
        checkNonNull();
        if (sp == null) {
            sp = sAppContext.getSharedPreferences(CONFIG, Context.MODE_PRIVATE);
        }
        return sp.getString(key, defValue);
    }

    /**
     * 获取布尔类型数据
     *
     * @param key      键
     * @param defValue 默认值
     * @return 布尔值
     */
    public static boolean getBoolean(String key, boolean defValue) {
        checkNonNull();
        if (sp == null) {
            sp = sAppContext.getSharedPreferences(CONFIG, Context.MODE_PRIVATE);
        }
        return sp.getBoolean(key, defValue);
    }

    /**
     * 检查配置是否为空
     */
    private static void checkNonNull() throws NullPointerException {
        if (sAppContext == null) {
            throw new NullPointerException("If you want to use SPUtils class," +
                    "you must invoke SPUtils.setAppContext(Application) method " +
                    "in Application#onCreate() method or other method first(Once time OK).");
        }
    }
}
