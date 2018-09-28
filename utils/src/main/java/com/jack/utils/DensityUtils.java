package com.jack.utils;

import android.content.Context;
import android.util.TypedValue;

/**
 * 单位转换的辅助类
 *
 * @author chengqian
 * Created on 2018/6/30
 */
public class DensityUtils {

    private DensityUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * dp转px
     *
     * @param context 上下文
     * @param dp dp值
     * @return 转化后的像素值
     */
    public static int dp2px(Context context, float dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources()
                .getDisplayMetrics());
    }

    /**
     * sp转px
     *
     * @param context 上下文
     * @param sp sp值
     * @return 转化后的像素值
     */
    public static int sp2px(Context context, float sp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, context.getResources()
                .getDisplayMetrics());
    }

    /**
     * px转dp
     *
     * @param context 上下文
     * @param px 像素值
     * @return 转化后的dp值
     */
    public static float px2dp(Context context, float px) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (px / scale);
    }

    /**
     * 获取屏幕像素密度
     *
     * @param context 上下文
     * @return 屏幕像素密度
     */
    public static float getDensity(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    /**
     * px转sp
     *
     * @param context 上下文
     * @param px 像素值
     * @return 转化后的sp值
     */
    public static float px2sp(Context context, float px) {
        return (px / context.getResources().getDisplayMetrics().scaledDensity);
    }
}
