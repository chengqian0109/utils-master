package com.jack.utils;

import android.support.annotation.StringRes;
import android.widget.Toast;

/**
 * 花样吐司工具类
 *
 * @author chengqian
 * Created on 2019-04-08
 */
public class FancyToastUtils {
    /**
     * 显示成功的短吐司
     *
     * @param message 提示消息
     */
    public static void showSuccess(CharSequence message) {
        FancyToast.makeText(Utils.getApp(), message, Toast.LENGTH_SHORT, FancyToast.SUCCESS, false).show();
    }

    /**
     * 显示成功的短吐司
     *
     * @param stringId 字符串资源ID
     */
    public static void showSuccess(@StringRes int stringId) {
        FancyToast.makeText(Utils.getApp(), Utils.getString(stringId),
                Toast.LENGTH_SHORT, FancyToast.SUCCESS, false).show();
    }

    /**
     * 显示成功的短吐司
     *
     * @param stringId 资源Id
     * @param args     参数
     */
    public static void showSuccess(@StringRes int stringId, final Object... args) {
        String string = Utils.getString(stringId, args);
        FancyToast.makeText(Utils.getApp(), string, Toast.LENGTH_SHORT, FancyToast.SUCCESS, false).show();
    }

    /**
     * 显示成功的长吐司
     *
     * @param message 提示消息
     */
    public static void showSuccessLong(String message) {
        FancyToast.makeText(Utils.getApp(), message, Toast.LENGTH_LONG, FancyToast.SUCCESS, false).show();
    }

    /**
     * 显示成功的长吐司
     *
     * @param stringId 字符串资源ID
     */
    public static void showSuccessLong(@StringRes int stringId) {
        FancyToast.makeText(Utils.getApp(), Utils.getString(stringId),
                Toast.LENGTH_LONG, FancyToast.SUCCESS, false).show();
    }

    /**
     * 显示成功的长吐司
     *
     * @param stringId 资源Id
     * @param args     参数
     */
    public static void showSuccessLong(@StringRes int stringId, final Object... args) {
        String string = Utils.getString(stringId, args);
        FancyToast.makeText(Utils.getApp(), string, Toast.LENGTH_LONG, FancyToast.SUCCESS, false).show();
    }

    /**
     * 显示警告的短吐司
     *
     * @param message 提示消息
     */
    public static void showWarning(String message) {
        FancyToast.makeText(Utils.getApp(), message, Toast.LENGTH_SHORT, FancyToast.WARNING, false).show();
    }

    /**
     * 显示警告的短吐司
     *
     * @param stringId 字符串资源ID
     */
    public static void showWarning(@StringRes int stringId) {
        FancyToast.makeText(Utils.getApp(), Utils.getString(stringId),
                Toast.LENGTH_SHORT, FancyToast.WARNING, false).show();
    }

    /**
     * 显示警告的短吐司
     *
     * @param stringId 资源Id
     * @param args     参数
     */
    public static void showWarning(@StringRes int stringId, final Object... args) {
        String string = Utils.getString(stringId, args);
        FancyToast.makeText(Utils.getApp(), string, Toast.LENGTH_SHORT, FancyToast.WARNING, false).show();
    }

    /**
     * 显示警告的长吐司
     *
     * @param message 提示消息
     */
    public static void showWarningLong(String message) {
        FancyToast.makeText(Utils.getApp(), message, Toast.LENGTH_LONG, FancyToast.WARNING, false).show();
    }

    /**
     * 显示警告的长吐司
     *
     * @param stringId 字符串资源ID
     */
    public static void showWarningLong(@StringRes int stringId) {
        FancyToast.makeText(Utils.getApp(), Utils.getString(stringId),
                Toast.LENGTH_LONG, FancyToast.WARNING, false).show();
    }

    /**
     * 显示警告的长吐司
     *
     * @param stringId 资源Id
     * @param args     参数
     */
    public static void showWarningLong(final @StringRes int stringId, final Object... args) {
        String string = Utils.getString(stringId, args);
        FancyToast.makeText(Utils.getApp(), string, Toast.LENGTH_LONG, FancyToast.WARNING, false).show();
    }

    /**
     * 显示错误的短吐司
     *
     * @param message 提示消息
     */
    public static void showError(String message) {
        FancyToast.makeText(Utils.getApp(), message, Toast.LENGTH_SHORT, FancyToast.ERROR, false).show();
    }

    /**
     * 显示错误的短吐司
     *
     * @param stringId 字符串资源ID
     */
    public static void showError(@StringRes int stringId) {
        FancyToast.makeText(Utils.getApp(), Utils.getString(stringId),
                Toast.LENGTH_SHORT, FancyToast.ERROR, false).show();
    }

    /**
     * 显示错误的短吐司
     *
     * @param stringId 资源Id
     * @param args     参数
     */
    public static void showError(@StringRes int stringId, final Object... args) {
        String string = Utils.getString(stringId, args);
        FancyToast.makeText(Utils.getApp(), string, Toast.LENGTH_SHORT, FancyToast.ERROR, false).show();
    }

    /**
     * 显示错误的长吐司
     *
     * @param message 提示消息
     */
    public static void showErrorLong(String message) {
        FancyToast.makeText(Utils.getApp(), message, Toast.LENGTH_LONG, FancyToast.ERROR, false).show();
    }

    /**
     * 显示错误的长吐司
     *
     * @param stringId 字符串资源ID
     */
    public static void showErrorLong(@StringRes int stringId) {
        FancyToast.makeText(Utils.getApp(), Utils.getString(stringId),
                Toast.LENGTH_LONG, FancyToast.ERROR, false).show();
    }

    /**
     * 显示错误的长吐司
     *
     * @param stringId 资源Id
     * @param args     参数
     */
    public static void showErrorLong(final @StringRes int stringId, final Object... args) {
        String string = Utils.getString(stringId, args);
        FancyToast.makeText(Utils.getApp(), string, Toast.LENGTH_LONG, FancyToast.ERROR, false).show();
    }

    /**
     * 显示通知的短吐司
     *
     * @param message 提示消息
     */
    public static void showInfo(String message) {
        FancyToast.makeText(Utils.getApp(), message, Toast.LENGTH_SHORT, FancyToast.INFO, false).show();
    }

    /**
     * 显示通知的短吐司
     *
     * @param stringId 字符串资源ID
     */
    public static void showInfo(@StringRes int stringId) {
        FancyToast.makeText(Utils.getApp(), Utils.getString(stringId),
                Toast.LENGTH_SHORT, FancyToast.INFO, false).show();
    }

    /**
     * 显示通知的短吐司
     *
     * @param stringId 资源Id
     * @param args     参数
     */
    public static void showInfo(@StringRes int stringId, final Object... args) {
        String string = Utils.getString(stringId, args);
        FancyToast.makeText(Utils.getApp(), string, Toast.LENGTH_SHORT, FancyToast.INFO, false).show();
    }

    /**
     * 显示通知的长吐司
     *
     * @param message 提示消息
     */
    public static void showInfoLong(String message) {
        FancyToast.makeText(Utils.getApp(), message, Toast.LENGTH_LONG, FancyToast.INFO, false).show();
    }

    /**
     * 显示通知的长吐司
     *
     * @param stringId 字符串资源ID
     */
    public static void showInfoLong(@StringRes int stringId) {
        FancyToast.makeText(Utils.getApp(), Utils.getString(stringId),
                Toast.LENGTH_LONG, FancyToast.INFO, false).show();
    }

    /**
     * 显示通知的长吐司
     *
     * @param stringId 资源Id
     * @param args     参数
     */
    public static void showInfoLong(final @StringRes int stringId, final Object... args) {
        String string = Utils.getString(stringId, args);
        FancyToast.makeText(Utils.getApp(), string, Toast.LENGTH_LONG, FancyToast.INFO, false).show();
    }

    /**
     * 显示重试的短吐司
     *
     * @param message 提示消息
     */
    public static void showConfusing(String message) {
        FancyToast.makeText(Utils.getApp(), message, Toast.LENGTH_SHORT, FancyToast.CONFUSING, false).show();
    }

    /**
     * 显示重试的短吐司
     *
     * @param stringId 字符串资源ID
     */
    public static void showConfusing(@StringRes int stringId) {
        FancyToast.makeText(Utils.getApp(), Utils.getString(stringId),
                Toast.LENGTH_SHORT, FancyToast.CONFUSING, false).show();
    }

    /**
     * 显示重试的短吐司
     *
     * @param stringId 资源Id
     * @param args     参数
     */
    public static void showConfusing(@StringRes int stringId, final Object... args) {
        String string = Utils.getString(stringId, args);
        FancyToast.makeText(Utils.getApp(), string, Toast.LENGTH_SHORT, FancyToast.CONFUSING, false).show();
    }

    /**
     * 显示重试的长吐司
     *
     * @param message 提示消息
     */
    public static void showConfusingLong(String message) {
        FancyToast.makeText(Utils.getApp(), message, Toast.LENGTH_LONG, FancyToast.CONFUSING, false).show();
    }

    /**
     * 显示重试的长吐司
     *
     * @param stringId 字符串资源ID
     */
    public static void showConfusingLong(@StringRes int stringId) {
        FancyToast.makeText(Utils.getApp(), Utils.getString(stringId),
                Toast.LENGTH_LONG, FancyToast.CONFUSING, false).show();
    }

    /**
     * 显示重试的长吐司
     *
     * @param stringId 资源Id
     * @param args     参数
     */
    public static void showConfusingLong(final @StringRes int stringId, final Object... args) {
        String string = Utils.getString(stringId, args);
        FancyToast.makeText(Utils.getApp(), string, Toast.LENGTH_LONG, FancyToast.CONFUSING, false).show();
    }

    /**
     * 显示默认的短吐司
     *
     * @param message 提示消息
     */
    public static void showDefault(String message) {
        FancyToast.makeText(Utils.getApp(), message, Toast.LENGTH_SHORT, FancyToast.DEFAULT, false).show();
    }

    /**
     * 显示默认的短吐司
     *
     * @param stringId 字符串资源ID
     */
    public static void showDefault(@StringRes int stringId) {
        FancyToast.makeText(Utils.getApp(), Utils.getString(stringId),
                Toast.LENGTH_SHORT, FancyToast.DEFAULT, false).show();
    }

    /**
     * 显示默认的短吐司
     *
     * @param stringId 资源Id
     * @param args     参数
     */
    public static void showDefault(@StringRes int stringId, final Object... args) {
        String string = Utils.getString(stringId, args);
        FancyToast.makeText(Utils.getApp(), string, Toast.LENGTH_SHORT, FancyToast.DEFAULT, false).show();
    }

    /**
     * 显示默认的长吐司
     *
     * @param message 提示消息
     */
    public static void showDefaultLong(String message) {
        FancyToast.makeText(Utils.getApp(), message, Toast.LENGTH_LONG, FancyToast.DEFAULT, false).show();
    }

    /**
     * 显示默认的长吐司
     *
     * @param stringId 字符串资源ID
     */
    public static void showDefaultLong(@StringRes int stringId) {
        FancyToast.makeText(Utils.getApp(), Utils.getString(stringId),
                Toast.LENGTH_LONG, FancyToast.DEFAULT, false).show();
    }

    /**
     * 显示默认的长吐司
     *
     * @param stringId 资源Id
     * @param args     参数
     */
    public static void showDefaultLong(final @StringRes int stringId, final Object... args) {
        String string = Utils.getString(stringId, args);
        FancyToast.makeText(Utils.getApp(), string, Toast.LENGTH_LONG, FancyToast.DEFAULT, false).show();
    }
}
