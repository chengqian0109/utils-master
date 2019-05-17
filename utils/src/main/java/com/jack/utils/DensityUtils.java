package com.jack.utils;

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
     * @param dp dp值
     * @return 转化后的像素值
     */
    public static int dp2px(float dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, Utils.getResources()
                .getDisplayMetrics());
    }

    /**
     * sp转px
     *
     * @param sp sp值
     * @return 转化后的像素值
     */
    public static int sp2px(float sp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, Utils.getResources()
                .getDisplayMetrics());
    }

    /**
     * px转dp
     *
     * @param px 像素值
     * @return 转化后的dp值
     */
    public static float px2dp(float px) {
        final float scale = Utils.getDisplayMetrics().density;
        return (px / scale);
    }

    /**
     * 获取屏幕像素密度
     *
     * @return 屏幕像素密度
     */
    public static float getDensity() {
        return Utils.getDisplayMetrics().density;
    }

    /**
     * px转sp
     *
     * @param px 像素值
     * @return 转化后的sp值
     */
    public static float px2sp(float px) {
        return (px / Utils.getDisplayMetrics().scaledDensity);
    }
}
