package com.jack.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.WindowManager;

/**
 * 跟UI相关的工具类
 *
 * @author chengqian
 * Created on 2018/6/30
 */
public class UiUtils {
    /**
     * 获取当前应用程序的Resources对象
     *
     * @param context 上下文
     * @return Resources对象
     */
    private static Resources getResources(Context context) {
        return context.getResources();
    }

    /**
     * 根据资源id获取Drawable对象
     *
     * @param context    上下文
     * @param drawableId Drawable资源id
     * @return 获取到的Drawable对象
     */
    public static Drawable getDrawable(Context context, int drawableId) {
        return ContextCompat.getDrawable(context, drawableId);
    }

    /**
     * 根据资源id获取字符串
     *
     * @param context  上下文
     * @param stringId 字符串资源Id
     * @return 获取到的字符串
     */
    public static String getString(Context context, int stringId) {
        return context.getString(stringId);
    }

    /**
     * 将xml文件转化为View对象
     *
     * @param layoutId 布局文件的id
     * @return 转化而成的View对象
     */
    public static View inflate(Context context, int layoutId) {
        return View.inflate(context, layoutId, null);
    }

    /**
     * 根据资源id获取指定颜色值
     *
     * @param context 上下文
     * @param colorId 颜色资源id
     * @return 颜色值
     */
    @ColorInt
    public static int getColor(Context context, int colorId) {
        return ContextCompat.getColor(context, colorId);
    }

    /**
     * 根据资源id获取颜色选择器
     *
     * @param context         上下文
     * @param colorSelectorId 颜色选择器资源id
     * @return 颜色状态列表
     */
    public static ColorStateList getColorList(Context context, int colorSelectorId) {
        return ContextCompat.getColorStateList(context, colorSelectorId);
    }

    /**
     * 设置Activity的背景透明度
     *
     * @param activity 要设置背景透明度的Activity
     * @param bgAlpha  1为不透明
     */
    public static void setBackgroundAlpha(Activity activity, float bgAlpha) {
        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
        lp.alpha = bgAlpha;
        activity.getWindow().setAttributes(lp);
    }

    /**
     * 获取状态栏高度的方法
     *
     * @param context 上下文
     * @return 状态栏高度，像素值
     */
    public static int getStatusBarHeight(Context context) {
        int statusBarHeight = -1;
        // 获取status_bar_height资源的ID
        int resourceId = getResources(context).getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            // 根据资源ID获取响应的尺寸值
            statusBarHeight = getResources(context).getDimensionPixelSize(resourceId);
        }
        return statusBarHeight;
    }
}
