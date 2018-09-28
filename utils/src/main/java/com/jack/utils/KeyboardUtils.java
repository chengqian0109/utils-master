package com.jack.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * 键盘工具类
 * @author chengqian
 * Created on 2018/06/28
 */
public class KeyboardUtils {
    /**
     * 动态隐藏软键盘
     *
     * @param context 必须是Activity的Context
     */
    public static void hideSoftKeyboard(Context context) {
        Activity activity = (Activity) context;
        View view = activity.getWindow().peekDecorView();
        if (view != null) {
            InputMethodManager manager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            manager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    /**
     * 动态显示软键盘
     *
     * @param context  必须是Activity的Context
     * @param editText 需要获取焦点弹出软键盘的EditText
     */
    public static void showSoftKeyboard(Context context, EditText editText) {
        Activity activity = (Activity) context;
        activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
    }
}
