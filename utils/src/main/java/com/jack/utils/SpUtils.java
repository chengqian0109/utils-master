package com.jack.utils;

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
public class SpUtils {

    private static String CONFIG = "config";
    /**
     * SharedPreferences对象
     */
    private static SharedPreferences sp;

    /**
     * 保存字符串
     *
     * @param key   键
     * @param value 值
     */
    public static void putString(String key, String value) {
        if (sp == null) {
            sp = Utils.getApplication().getSharedPreferences(CONFIG, Context.MODE_PRIVATE);
        }
        sp.edit().putString(key, value).apply();
    }

    /**
     * 保存布尔类型数据
     *
     * @param key   键
     * @param value 值
     */
    public static void putBoolean(String key, boolean value) {
        if (sp == null) {
            sp = Utils.getApplication().getSharedPreferences(CONFIG, Context.MODE_PRIVATE);
        }
        sp.edit().putBoolean(key, value).apply();
    }

    /**
     * 保存整型数据
     *
     * @param key   键
     * @param value 值
     */
    public static void putInt(String key, int value) {
        if (sp == null) {
            sp = Utils.getApplication().getSharedPreferences(CONFIG, Context.MODE_PRIVATE);
        }
        sp.edit().putInt(key, value).apply();
    }

    /**
     * 保存长整型数据
     *
     * @param key   键
     * @param value 值
     */
    public static void putLong(String key, long value) {
        if (sp == null) {
            sp = Utils.getApplication().getSharedPreferences(CONFIG, Context.MODE_PRIVATE);
        }
        sp.edit().putLong(key, value).apply();
    }

    /**
     * 保存浮点型数据
     *
     * @param key   键
     * @param value 值
     */
    public static void putFloat(String key, float value) {
        if (sp == null) {
            sp = Utils.getApplication().getSharedPreferences(CONFIG, Context.MODE_PRIVATE);
        }
        sp.edit().putFloat(key, value).apply();
    }

    /**
     * 保存字符串map集合
     *
     * @param map 要保存的字符串Map集合
     */
    public static void putStringMap(Map<String, String> map) {
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
        if (sp == null) {
            sp = Utils.getApplication().getSharedPreferences(CONFIG, Context.MODE_PRIVATE);
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
        if (sp == null) {
            sp = Utils.getApplication().getSharedPreferences(CONFIG, Context.MODE_PRIVATE);
        }
        return sp.getBoolean(key, defValue);
    }

    /**
     * 获取整型数据
     *
     * @param key      键
     * @param defValue 默认值
     * @return 整数值
     */
    public static int getInt(String key, int defValue) {
        if (sp == null) {
            sp = Utils.getApplication().getSharedPreferences(CONFIG, Context.MODE_PRIVATE);
        }
        return sp.getInt(key, defValue);
    }

    /**
     * 获取长整型数据
     *
     * @param key      键
     * @param defValue 默认值
     * @return 长整数值
     */
    public static long getLong(String key, long defValue) {
        if (sp == null) {
            sp = Utils.getApplication().getSharedPreferences(CONFIG, Context.MODE_PRIVATE);
        }
        return sp.getLong(key, defValue);
    }

    /**
     * 获取Float浮点型数据
     *
     * @param key      键
     * @param defValue 默认值
     * @return float浮点值
     */
    public static float getFloat(String key, float defValue) {
        if (sp == null) {
            sp = Utils.getApplication().getSharedPreferences(CONFIG, Context.MODE_PRIVATE);
        }
        return sp.getFloat(key, defValue);
    }
}
