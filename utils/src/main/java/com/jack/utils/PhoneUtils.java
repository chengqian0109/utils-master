package com.jack.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.telephony.TelephonyManager;

/**
 * 拨打电话有关的工具类，可以实现判断当前设备是否支持打电话，包括平板，以及跳转拨号Activity
 *
 * @author chengqian
 * Created on 2018/5/25
 */
public class PhoneUtils {
    /**
     * 检查当前设置是否支持打电话功能
     *
     * @return true支持，false不支持
     */
    public static boolean isSupportCallPhone() {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) Utils.getApp().getSystemService(Context.TELEPHONY_SERVICE);
            if (telephonyManager.getPhoneType() == TelephonyManager.PHONE_TYPE_NONE) {
                return false;
            }
        } catch (Exception e) {
            LogUtils.e("方法异常：" + e.getMessage());
            return false;
        }
        return true;
    }

    /**
     * 打开打电话的Activity
     *
     * @param phone 电话号码
     */
    public static void call(String phone) {
        if (isSupportCallPhone()) {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            Utils.getApp().startActivity(intent);
        } else {
            FancyToastUtils.showError(R.string.not_support_phone_device);
        }
    }
}
