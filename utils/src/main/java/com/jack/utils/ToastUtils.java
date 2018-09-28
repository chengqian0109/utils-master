package com.jack.utils;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Toast工具类：单例模式
 *
 * @author chengqian
 * Created on 2017/6/28
 */
public class ToastUtils {
    /**
     * 短吐司
     */
    private static Toast mShortToast;
    /**
     * 长吐司
     */
    private static Toast mLongToast;

    /**
     * 显示短吐司
     *
     * @param context 上下文
     * @param info    显示信息
     */
    public static void show(Context context, String info) {
        try {
            View view = View.inflate(context, R.layout.layout_toast, null);
            TextView tvMsg = (TextView) view.findViewById(R.id.tv_toast_msg);
            if (mShortToast != null) {
                mShortToast.cancel();
            }
            mShortToast = new Toast(context);
            mShortToast.setView(view);
            mShortToast.setGravity(Gravity.BOTTOM, 0, DensityUtils.dp2px(context, 80));
            mShortToast.setDuration(Toast.LENGTH_SHORT);
            tvMsg.setText(info);
            mShortToast.show();
        } catch (Exception e) {
            LogUtils.e("方法异常：" + e.getMessage());
        }
    }

    /**
     * 显示短吐司
     *
     * @param context 上下文
     * @param resId   显示信息对应的资源ID
     */
    public static void show(Context context, int resId) {
        View view = View.inflate(context, R.layout.layout_toast, null);
        TextView tvMsg = (TextView) view.findViewById(R.id.tv_toast_msg);
        if (mShortToast != null) {
            mShortToast.cancel();
        }
        mShortToast = new Toast(context);
        mShortToast.setView(view);
        mShortToast.setGravity(Gravity.BOTTOM, 0, DensityUtils.dp2px(context, 80));
        mShortToast.setDuration(Toast.LENGTH_SHORT);
        tvMsg.setText(resId);
        mShortToast.show();
    }

    /**
     * 显示长吐司
     *
     * @param context 上下文
     * @param info    显示信息
     */
    public static void showLong(Context context, String info) {
        try {
            View view = View.inflate(context, R.layout.layout_toast, null);
            TextView tvMsg = (TextView) view.findViewById(R.id.tv_toast_msg);
            if (mLongToast != null) {
                mLongToast.cancel();
            }
            mLongToast = new Toast(context);
            mLongToast.setView(view);
            mLongToast.setGravity(Gravity.BOTTOM, 0, DensityUtils.dp2px(context, 80));
            mLongToast.setDuration(Toast.LENGTH_LONG);
            tvMsg.setText(info);
            mLongToast.show();
        } catch (Exception e) {
            LogUtils.e("方法异常：" + e.getMessage());
        }
    }

    /**
     * 显示长吐司
     *
     * @param context 上下文
     * @param resId   资源id
     */
    public static void showLong(Context context, int resId) {
        try {
            View view = View.inflate(context, R.layout.layout_toast, null);
            TextView tvMsg = (TextView) view.findViewById(R.id.tv_toast_msg);
            if (mLongToast != null) {
                mLongToast.cancel();
            }
            mLongToast = new Toast(context);
            mLongToast.setView(view);
            mLongToast.setGravity(Gravity.BOTTOM, 0, DensityUtils.dp2px(context, 80));
            mLongToast.setDuration(Toast.LENGTH_LONG);
            tvMsg.setText(resId);
            mLongToast.show();
        } catch (Exception e) {
            LogUtils.e("方法异常：" + e.getMessage());
        }
    }
}
