package com.jack.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.annotation.IntDef;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 花样吐司
 *
 * @author chengqian
 * Created on 2019-04-08
 */
public class FancyToast extends Toast {
    /**
     * Construct an empty Toast object.  You must call {@link #setView} before you
     * can call {@link #show}.
     *
     * @param context The context to use.  Usually your {@link Application}
     * or {@link Activity} object.
     */
    public static final int SUCCESS = 1;
    public static final int WARNING = 2;
    public static final int ERROR = 3;
    public static final int INFO = 4;
    public static final int CONFUSING = 5;
    public static final int DEFAULT = 6;

    public FancyToast(Context context) {
        super(context);
    }

    /**
     * 创建吐司
     *
     * @param context  上下文
     * @param message  消息内容
     * @param duration 持续时间
     * @param type     吐司类型 {@link Type}
     * @param useImg   是否显示图片
     */
    public static Toast makeText(Context context, CharSequence message, int duration, @Type int type, boolean useImg) {
        Toast toast = new Toast(context);
        toast.setDuration(duration);
        View layout = LayoutInflater.from(context).inflate(R.layout.layout_fancy_toast, null, false);
        TextView l1 = (TextView) layout.findViewById(R.id.toast_text);
        LinearLayout linearLayout = (LinearLayout) layout.findViewById(R.id.toast_type);
        ImageView img = (ImageView) layout.findViewById(R.id.toast_icon);
        ImageView img1 = (ImageView) layout.findViewById(R.id.imageView4);
        l1.setText(message);
        img1.setVisibility(useImg ? View.VISIBLE : View.GONE);
        if (type == SUCCESS) {
            linearLayout.setBackgroundResource(R.drawable.success_shape);
            img.setImageResource(R.drawable.ic_check_black_24dp);
        } else if (type == WARNING) {
            linearLayout.setBackgroundResource(R.drawable.warning_shape);
            img.setImageResource(R.drawable.ic_pan_tool_black_24dp);
        } else if (type == ERROR) {
            linearLayout.setBackgroundResource(R.drawable.error_shape);
            img.setImageResource(R.drawable.ic_clear_black_24dp);
        } else if (type == INFO) {
            linearLayout.setBackgroundResource(R.drawable.info_shape);
            img.setImageResource(R.drawable.ic_info_outline_black_24dp);
        } else if (type == CONFUSING) {
            linearLayout.setBackgroundResource(R.drawable.default_shape);
            img.setVisibility(View.GONE);
        } else if (type == DEFAULT) {
            linearLayout.setBackgroundResource(R.drawable.confusing_shape);
            img.setImageResource(R.drawable.ic_refresh_black_24dp);
        }
        toast.setView(layout);
        return toast;
    }

    /**
     * 创建吐司
     *
     * @param context    上下文
     * @param message    消息内容
     * @param duration   持续时间
     * @param type       吐司类型 {@link Type}
     * @param drawableId 右上角吐司图标
     */
    public static Toast makeText(Context context, CharSequence message, int duration, @Type int type, int drawableId) {
        Toast toast = new Toast(context);
        @SuppressLint("InflateParams")
        View layout = LayoutInflater.from(context).inflate(R.layout.layout_fancy_toast, null, false);
        TextView l1 = (TextView) layout.findViewById(R.id.toast_text);
        LinearLayout linearLayout = (LinearLayout) layout.findViewById(R.id.toast_type);
        ImageView img = (ImageView) layout.findViewById(R.id.toast_icon);
        l1.setText(message);
        if (type == SUCCESS) {
            linearLayout.setBackgroundResource(R.drawable.success_shape);
            img.setImageResource(drawableId);
        } else if (type == WARNING) {
            linearLayout.setBackgroundResource(R.drawable.warning_shape);
            img.setImageResource(drawableId);
        } else if (type == ERROR) {
            linearLayout.setBackgroundResource(R.drawable.error_shape);
            img.setImageResource(drawableId);
        } else if (type == INFO) {
            linearLayout.setBackgroundResource(R.drawable.info_shape);
            img.setImageResource(drawableId);
        } else if (type == CONFUSING) {
            linearLayout.setBackgroundResource(R.drawable.default_shape);
            img.setVisibility(View.GONE);
        } else if (type == DEFAULT) {
            linearLayout.setBackgroundResource(R.drawable.confusing_shape);
            img.setImageResource(drawableId);
        }
        toast.setView(layout);
        return toast;
    }

    @Retention(RetentionPolicy.SOURCE)
    @Target(ElementType.PARAMETER)
    @IntDef({SUCCESS, WARNING, ERROR, INFO, DEFAULT, CONFUSING})
    public @interface Type {

    }
}
