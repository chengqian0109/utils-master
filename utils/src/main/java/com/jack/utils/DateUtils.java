package com.jack.utils;

import android.annotation.SuppressLint;
import android.text.TextUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 与时间日期有关的工具类
 *
 * @author chengqian
 * Created on 2018/11/23
 */
public class DateUtils {
    /**
     * 获取格式化日期
     *
     * @param date 日期对象
     * @return 格式化时间
     */
    public static String getMonthDay(Date date) {
        if (date == null) {
            return "";
        }
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat format = new SimpleDateFormat("MM-dd");
        return format.format(date);
    }

    /**
     * 获取格式化日期：2018-12-12
     *
     * @param date 日期对象
     * @return 格式化时间
     */
    public static String getDate(Date date) {
        if (date == null) {
            return "";
        }
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    /**
     * 获取指定日期的格式化字符串
     *
     * @param date 日期
     */
    public static String getAccurateTime(Date date) {
        if (date == null) {
            return "";
        }
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        return format.format(date);
    }

    /**
     * 获取指定日期的格式化字符串，格式如下：
     * 2018-12-12
     * 12:34:56
     *
     * @param timeStamp 时间戳
     */
    @SuppressLint("SimpleDateFormat")

    public static String getShowTime(String timeStamp) {
        try {
            if (TextUtils.isEmpty(timeStamp)) {
                return "";
            }
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
            Date date = new Date(Long.parseLong(timeStamp) * 1000);
            return dateFormat.format(date) + "\n" + timeFormat.format(date);
        } catch (Exception e) {
            LogUtils.e("时间转化方法异常：" + e.getMessage());
        }
        return timeStamp;
    }

    /**
     * 获取格式化时间，如：2017-12-12
     *
     * @param timeStamp 时间戳
     * @return 格式化的时间
     */
    public static String getDate(String timeStamp) {
        try {
            if (TextUtils.isEmpty(timeStamp)) {
                return "";
            }
            @SuppressLint("SimpleDateFormat")
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date(Long.parseLong(timeStamp) * 1000);
            return format.format(date);
        } catch (Exception e) {
            LogUtils.e("时间转化方法异常：" + e.getMessage());
        }
        return timeStamp;
    }

    /**
     * 获取格式化时间，如：12:30
     *
     * @param timeStamp 时间戳
     * @return 格式化的时间
     */
    public static String getTime(String timeStamp) {
        try {
            if (TextUtils.isEmpty(timeStamp)) {
                return "";
            }
            @SuppressLint("SimpleDateFormat")
            SimpleDateFormat format = new SimpleDateFormat("HH:mm");
            Date date = new Date(Long.parseLong(timeStamp) * 1000);
            return format.format(date);
        } catch (Exception e) {
            LogUtils.e("时间转化方法异常：" + e.getMessage());
        }
        return timeStamp;
    }

    /**
     * 获取格式化时间，如：2017-12-20 12:30:00
     *
     * @param timeStamp 时间戳
     * @return 格式化的时间
     */
    public static String getAccurateTime(String timeStamp) {
        try {
            if (TextUtils.isEmpty(timeStamp)) {
                return "";
            }
            @SuppressLint("SimpleDateFormat")
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date(Long.parseLong(timeStamp) * 1000);
            return format.format(date);
        } catch (Exception e) {
            LogUtils.e("时间转化方法异常：" + e.getMessage());
        }
        return timeStamp;
    }
}
