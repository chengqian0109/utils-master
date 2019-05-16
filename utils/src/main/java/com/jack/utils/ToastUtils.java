package com.jack.utils;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 吐司工具类
 *
 * @author chengqian
 * Created on 2019-04-08
 */
public class ToastUtils {

    private ToastUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    private static Toast sToast;

    private static Handler sHandler = new Handler(Looper.getMainLooper());

    /**
     * true：弹出新吐司;false：只修改文本内容
     */
    private static boolean sIsJumpWhenMore = true;
    /**
     * 自定义吐司布局资源ID
     */
    @LayoutRes
    private static int sLayoutId = -1;

    /**
     * 吐司的位置
     */
    private static int sGravity = Gravity.CENTER;

    /**
     * 吐司的x轴偏移量
     */
    private static int sXOffset = 0;

    /**
     * 吐司的y轴偏移量
     */
    private static int sYOffset = 0;

    /**
     * 吐司初始化
     *
     * @param isJumpWhenMore 当连续弹出吐司时，是要弹出新吐司还是只修改文本内容
     *                       true：弹出新吐司;false：只修改文本内容
     *                       如果为false的话可用来做显示任意时长的吐司
     * @param layoutId       自定义吐司的布局资源ID
     */
    public static void init(boolean isJumpWhenMore, @LayoutRes int layoutId, int gravity, int xOffset, int yOffset) {
        ToastUtils.sIsJumpWhenMore = isJumpWhenMore;
        sLayoutId = layoutId;
        sGravity = gravity;
        sXOffset = xOffset;
        sYOffset = yOffset;
    }

    /**
     * 安全地显示短时吐司
     *
     * @param text 文本
     */
    public static void showShort(final CharSequence text) {
        sHandler.post(() -> showToast(text, Toast.LENGTH_SHORT));
    }

    /**
     * 安全地显示短时吐司
     *
     * @param resId 资源Id
     */
    public static void showShort(final @StringRes int resId) {
        sHandler.post(() -> showToast(resId, Toast.LENGTH_SHORT));
    }

    /**
     * 安全地显示短时吐司
     *
     * @param resId 资源Id
     * @param args  参数
     */
    public static void showShort(final @StringRes int resId, final Object... args) {
        sHandler.post(() -> showToast(resId, Toast.LENGTH_SHORT, args));
    }

    /**
     * 安全地显示短时吐司
     *
     * @param format 格式
     * @param args   参数
     */
    public static void showShort(final String format, final Object... args) {
        sHandler.post(() -> showToast(format, Toast.LENGTH_SHORT, args));
    }

    /**
     * 安全地显示长时吐司
     *
     * @param text 文本
     */
    public static void showLong(final CharSequence text) {
        sHandler.post(() -> showToast(text, Toast.LENGTH_LONG));
    }

    /**
     * 安全地显示长时吐司
     *
     * @param resId 资源Id
     */
    public static void showLong(final @StringRes int resId) {
        sHandler.post(() -> showToast(resId, Toast.LENGTH_LONG));
    }

    /**
     * 安全地显示长时吐司
     *
     * @param resId 资源Id
     * @param args  参数
     */
    public static void showLong(final @StringRes int resId, final Object... args) {
        sHandler.post(() -> showToast(resId, Toast.LENGTH_LONG, args));
    }

    /**
     * 安全地显示长时吐司
     *
     * @param format 格式
     * @param args   参数
     */
    public static void showLong(final String format, final Object... args) {
        sHandler.post(() -> showToast(format, Toast.LENGTH_LONG, args));
    }

    /**
     * 显示短时吐司
     *
     * @param text 文本
     */
    public static void shortShow(CharSequence text) {
        showToast(text, Toast.LENGTH_SHORT);
    }

    /**
     * 显示短时吐司
     *
     * @param resId 资源Id
     */
    public static void shortShow(@StringRes int resId) {
        showToast(resId, Toast.LENGTH_SHORT);
    }

    /**
     * 显示短时吐司
     *
     * @param resId 资源Id
     * @param args  参数
     */
    public static void shortShow(@StringRes int resId, Object... args) {
        showToast(resId, Toast.LENGTH_SHORT, args);
    }

    /**
     * 显示短时吐司
     *
     * @param format 格式
     * @param args   参数
     */
    public static void shortShow(String format, Object... args) {
        showToast(format, Toast.LENGTH_SHORT, args);
    }

    /**
     * 显示长时吐司
     *
     * @param text 文本
     */
    public static void longShow(CharSequence text) {
        showToast(text, Toast.LENGTH_LONG);
    }

    /**
     * 显示长时吐司
     *
     * @param resId 资源Id
     */
    public static void longShow(@StringRes int resId) {
        showToast(resId, Toast.LENGTH_LONG);
    }

    /**
     * 显示长时吐司
     *
     * @param resId 资源Id
     * @param args  参数
     */
    public static void longShow(@StringRes int resId, Object... args) {
        showToast(resId, Toast.LENGTH_LONG, args);
    }

    /**
     * 显示长时吐司
     *
     * @param format 格式
     * @param args   参数
     */
    public static void longShow(String format, Object... args) {
        showToast(format, Toast.LENGTH_LONG, args);
    }

    /**
     * 显示吐司
     *
     * @param resId    资源Id
     * @param duration 显示时长
     */
    private static void showToast(@StringRes int resId, int duration) {
        showToast(Utils.getString(resId), duration);
    }

    /**
     * 显示吐司
     *
     * @param resId    资源Id
     * @param duration 显示时长
     * @param args     参数
     */
    private static void showToast(@StringRes int resId, int duration, Object... args) {
        showToast(String.format(Utils.getString(resId), args), duration);
    }

    /**
     * 显示吐司
     *
     * @param format   格式
     * @param duration 显示时长
     * @param args     参数
     */
    private static void showToast(String format, int duration, Object... args) {
        showToast(String.format(format, args), duration);
    }

    /**
     * 显示吐司
     *
     * @param text     文本
     * @param duration 显示时长
     * @throws Resources.NotFoundException 布局资源sLayoutId未找到，或布局中TextView定义的id名称不是tv_toast_msg
     */
    @SuppressLint({"ShowToast", "ResourceType"})
    private static void showToast(CharSequence text, int duration) throws Resources.NotFoundException {
        if (sIsJumpWhenMore) {
            cancelToast();
        }
        if (sToast == null) {
            if (sLayoutId > 0) {
                View contentView = View.inflate(Utils.getApp(), sLayoutId, null);
                TextView tvMsg = contentView.findViewById(R.id.tv_toast_msg);
                tvMsg.setText(text);
                sToast = new Toast(Utils.getApp());
                sToast.setView(contentView);
                sToast.setDuration(duration);
            } else {
                sToast = Toast.makeText(Utils.getApp(), text, duration);
            }
            sToast.setGravity(sGravity, sXOffset, sYOffset);
        } else {
            sToast.setText(text);
            sToast.setDuration(duration);
        }
        sToast.show();
    }

    /**
     * 取消吐司显示
     */
    private static void cancelToast() {
        if (sToast != null) {
            sToast.cancel();
            sToast = null;
        }
    }
}
