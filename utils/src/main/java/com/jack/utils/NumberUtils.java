package com.jack.utils;

import android.text.TextUtils;

import java.text.DecimalFormat;

/**
 * 数字有关工具类
 *
 * @author chengqian
 * Created on 2018/12/1
 */
public class NumberUtils {
    /**
     * 将字符串格式化为带两位小数的字符串
     *
     * @param str 字符串
     */
    public static String format2Decimals(String str) {
        if (TextUtils.isEmpty(str)) {
            return "0.00";
        }
        try {
            DecimalFormat df = new DecimalFormat("#.00");
            if (df.format(stringToDouble(str)).startsWith(".")) {
                return "0" + df.format(stringToDouble(str));
            } else {
                return df.format(stringToDouble(str));
            }
        } catch (Exception e) {
            LogUtils.e("方法异常：" + e.getMessage());
        }
        return str;
    }

    /**
     * 将字符串格式化为带两位小数的字符串
     *
     * @param str 字符串
     */
    public static String format1Decimals(String str) {
        if (TextUtils.isEmpty(str)) {
            return "0.0";
        }
        try {
            DecimalFormat df = new DecimalFormat("#.0");
            if (df.format(stringToDouble(str)).startsWith(".")) {
                return "0" + df.format(stringToDouble(str));
            } else {
                return df.format(stringToDouble(str));
            }
        } catch (Exception e) {
            LogUtils.e("方法异常：" + e.getMessage());
        }
        return str;
    }

    /**
     * 字符串转换成double ,转换失败将会 return 0;
     *
     * @param str 字符串
     */
    private static double stringToDouble(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        } else {
            try {
                return Double.parseDouble(str);
            } catch (NumberFormatException e) {
                return 0;
            }
        }
    }
}
