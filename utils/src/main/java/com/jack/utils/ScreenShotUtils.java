package com.jack.utils;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import java.util.LinkedList;
import java.util.List;

/**
 * 截屏监听工具类
 *
 * @author chengqian
 * Created on 2019-10-18
 */
public class ScreenShotUtils {

    private static final String TAG = "ScreenShotUtils";

    private static final String[] MEDIA_PROJECTIONS = {
            MediaStore.Images.ImageColumns.DATA,
            MediaStore.Images.ImageColumns.DATE_TAKEN
    };

    /**
     * 截屏依据中的路径判断关键字
     */
    private static final String[] KEYWORDS = {
            "screenshot", "screen_shot", "screen-shot", "screen shot",
            "screencapture", "screen_capture", "screen-capture", "screen capture",
            "screencap", "screen_cap", "screen-cap", "screen cap", "截屏"
    };

    /**
     * 已回调过的路径
     */
    private final List<String> sHasCallbackPaths = new LinkedList<>();

    private Context mContext;

    private OnScreenShotListener mListener;

    private long mStartListenTime;

    private MediaContentObserver mInternalObserver;
    private MediaContentObserver mExternalObserver;

    private ScreenShotUtils(Context context) {
        mContext = context;
    }

    public static ScreenShotUtils newInstance(Context context) {
        return new ScreenShotUtils(context);
    }

    /**
     * 启动监听
     */
    public void startListener() {
        sHasCallbackPaths.clear();

        // 记录开始监听的时间戳
        mStartListenTime = System.currentTimeMillis();

        if (mInternalObserver == null) {
            mInternalObserver = new MediaContentObserver(null);
            mContext.getContentResolver().registerContentObserver(
                    MediaStore.Images.Media.INTERNAL_CONTENT_URI,
                    false,
                    mInternalObserver
            );
        }
        if (mExternalObserver == null) {
            mExternalObserver = new MediaContentObserver(null);
            mContext.getContentResolver().registerContentObserver(
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                    false,
                    mExternalObserver
            );
        }
    }

    /**
     * 停止监听
     */
    public void stopListener() {
        if (mInternalObserver != null) {
            mContext.getContentResolver().unregisterContentObserver(mInternalObserver);
            mInternalObserver = null;
        }
        if (mExternalObserver != null) {
            mContext.getContentResolver().unregisterContentObserver(mExternalObserver);
            mExternalObserver = null;
        }
        // 清空数据
        mStartListenTime = 0;
        sHasCallbackPaths.clear();
    }

    /**
     * 处理媒体数据库的内容改变
     */
    private void handleContentChange(Uri contentUri) {
        Cursor cursor = null;
        try {
            // 数据改变时查询数据库中最后加入的一条数据
            cursor = mContext.getContentResolver().query(
                    contentUri,
                    MEDIA_PROJECTIONS,
                    null,
                    null,
                    MediaStore.Images.ImageColumns.DATE_ADDED + " desc limit 1"
            );

            if (cursor == null) {
                Log.e(TAG, "Deviant logic.");
                return;
            }
            if (!cursor.moveToFirst()) {
                Log.d(TAG, "Cursor no data.");
                return;
            }

            // 获取各列的索引
            int dataIndex = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            int dateTakenIndex = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATE_TAKEN);
            // 获取行数据
            String data = cursor.getString(dataIndex);
            long dateTaken = cursor.getLong(dateTakenIndex);

            // 处理获取到的第一行数据
            handleMediaRowData(data, dateTaken);

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
    }

    /**
     * 处理获取到的一行数据
     */
    private void handleMediaRowData(String data, long dateTaken) {
        if (checkScreenShot(data, dateTaken)) {

            if (mListener != null && !checkCallback(data)) {
                mListener.onShot(data);
            }
        } else {
            // 如果在观察区间媒体数据库有数据改变，又不符合截屏规则，则输出到 log 待分析
            Log.w(TAG, "Media content changed, but not screenshot: path = " + data
                    + " date = " + dateTaken);
        }
    }

    /**
     * 判断指定的数据行是否符合截屏条件
     */
    private boolean checkScreenShot(String data, long dateTaken) {
        //时间
        if (dateTaken < mStartListenTime || (System.currentTimeMillis() - dateTaken) > 10 * 1000) {
            return false;
        }
        //路径
        if (TextUtils.isEmpty(data)) {
            return false;
        }
        data = data.toLowerCase();
        // 判断图片路径是否含有指定的关键字之一, 如果有, 则认为当前截屏了
        for (String keyWork : KEYWORDS) {
            if (data.contains(keyWork)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断是否已回调过, 某些手机ROM截屏一次会发出多次内容改变的通知;
     * 删除一个图片也会发通知, 同时防止删除图片时误将上一张符合截屏规则
     * 的图片当做是当前截屏.
     */
    private boolean checkCallback(String imagePath) {
        if (sHasCallbackPaths.contains(imagePath)) {
            return true;
        }
        // 大概缓存15~20条记录便可
        if (sHasCallbackPaths.size() >= 20) {
            for (int i = 0; i < 5; i++) {
                sHasCallbackPaths.remove(0);
            }
        }
        sHasCallbackPaths.add(imagePath);
        return false;
    }

    public void setListener(OnScreenShotListener listener) {
        mListener = listener;
    }

    public interface OnScreenShotListener {
        void onShot(String imagePath);
    }

    /**
     * 媒体内容观察者(观察媒体数据库的改变)
     */
    private class MediaContentObserver extends ContentObserver {

        MediaContentObserver(Handler handler) {
            super(handler);
        }

        @Override
        public void onChange(boolean selfChange, Uri uri) {
            super.onChange(selfChange, uri);
            handleContentChange(uri);
        }
    }
}
