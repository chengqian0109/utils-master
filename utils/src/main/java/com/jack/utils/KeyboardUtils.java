package com.jack.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * 键盘工具类
 *
 * @author chengqian
 * Created on 2018/06/28
 */
public class KeyboardUtils {
    /**
     * 动态隐藏软键盘
     *
     * @param activity Activity
     */
    public static void hideSoftKeyboard(Activity activity) {
        View view = activity.getWindow().peekDecorView();
        if (view != null) {
            InputMethodManager manager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            manager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    /**
     * 动态显示软键盘
     *
     * @param activity Activity
     * @param editText 需要获取焦点弹出软键盘的EditText
     */
    public static void showSoftKeyboard(Activity activity, EditText editText) {
        activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
    }
}
