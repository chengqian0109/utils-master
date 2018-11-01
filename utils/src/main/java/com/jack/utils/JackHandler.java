package com.jack.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;

/**
 * 弱引用Handler类，防止内存泄漏
 *
 * @author chengqian
 * Created on 2018/10/12
 */
public abstract class JackHandler<T extends Context> extends Handler {
    /**
     * 外部Activity的弱引用
     */
    private WeakReference<T> mContext;

    /**
     * 根据需要进行相关操作
     */
    protected abstract void doSomething(T context, Message msg);

    public JackHandler(T context) {
        mContext = new WeakReference<>(context);
    }

    @Override
    public void handleMessage(Message msg) {
        if (mContext != null) {
            T t = mContext.get();
            if (t != null && msg != null) {
                doSomething(t, msg);
            }
        }
    }
}
