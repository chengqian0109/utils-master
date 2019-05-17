package com.jack.utils;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * 获取设备相关信息的工具类
 *
 * @author chengqian
 * Created on 2018/9/27
 */
public class DeviceUtils {

    private static final String TAG = "DeviceUtils";

    /**
     * 获取手机唯一设备串号IMEI
     *
     * @return 唯一设备串号IMEI，获取不成功时返回空字符串
     */
    @SuppressLint("HardwareIds")
    public static String getIMEI() {
        String imei = "";
        try {
            TelephonyManager telephonyManager = (TelephonyManager) Utils.getApp().getSystemService(Context.TELEPHONY_SERVICE);
            if (ActivityCompat.checkSelfPermission(Utils.getApp(), Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
                if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.O) {
                    imei = telephonyManager.getDeviceId();
                } else {
                    imei = telephonyManager != null ? telephonyManager.getImei() : null;
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "getIMEI: " + e.getMessage());
        }
        return imei;
    }

    /**
     * 获取手机IMSI号
     *
     * @return 手机IMSI号，获取不成功时返回空字符串
     */
    @SuppressLint("HardwareIds")
    public static String getIMSI() {
        String imsi = "";
        try {
            TelephonyManager telephonyManager = (TelephonyManager) Utils.getApp().getSystemService(Context.TELEPHONY_SERVICE);
            if (ActivityCompat.checkSelfPermission(Utils.getApp(), Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
                imsi = telephonyManager.getSubscriberId();
                return imsi;
            }
        } catch (Exception e) {
            Log.e(TAG, "getIMSI: " + e.getMessage());
        }
        return imsi;
    }

    /**
     * 获取电话号码
     * 注：并非一定可以获取到电话号码
     *
     * @return 电话号码
     */
    @SuppressLint("HardwareIds")
    public static String getPhoneNumber() {
        String phoneNumber = "";
        try {
            TelephonyManager telephonyManager = (TelephonyManager) Utils.getApp().getSystemService(Context.TELEPHONY_SERVICE);
            if (ActivityCompat.checkSelfPermission(Utils.getApp(), Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED
                    && ActivityCompat.checkSelfPermission(Utils.getApp(), Manifest.permission.READ_SMS) == PackageManager.PERMISSION_GRANTED) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    if (ActivityCompat.checkSelfPermission(Utils.getApp(), Manifest.permission.READ_PHONE_NUMBERS) == PackageManager.PERMISSION_GRANTED) {
                        phoneNumber = telephonyManager.getLine1Number();
                        return phoneNumber;
                    }
                    return "";
                } else {
                    phoneNumber = telephonyManager.getLine1Number();
                    return phoneNumber;
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "getPhoneNumber: " + e.getMessage());
        }
        return phoneNumber;
    }

    /**
     * 获取网络运营商编号
     *
     * @return 网络运营商编号，如中国移动为46000或46002，中国联通为46001，中国电信为46003，
     * 测试发现与{@link DeviceUtils#getSimOperator()}返回结果一致
     */
    public static String getNetworkOperator() {
        String networkOperator = "";
        try {
            TelephonyManager telephonyManager = (TelephonyManager) Utils.getApp().getSystemService(Context.TELEPHONY_SERVICE);
            if (ActivityCompat.checkSelfPermission(Utils.getApp(), Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
                networkOperator = telephonyManager.getNetworkOperator();
                return networkOperator;
            }
        } catch (Exception e) {
            Log.e(TAG, "getNetworkOperator: " + e.getMessage());
        }
        return networkOperator;
    }

    /**
     * 获取网络运营商名称
     *
     * @return 网络运营商名称
     */
    public static String getNetworkOperatorName() {
        String networkOperatorName = "";
        try {
            TelephonyManager telephonyManager = (TelephonyManager) Utils.getApp().getSystemService(Context.TELEPHONY_SERVICE);
            if (ActivityCompat.checkSelfPermission(Utils.getApp(), Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
                networkOperatorName = telephonyManager.getNetworkOperatorName();
                return networkOperatorName;
            }
        } catch (Exception e) {
            Log.e(TAG, "getNetworkOperatorName: " + e.getMessage());
        }
        return networkOperatorName;
    }

    /**
     * 获SIM运营商编码
     *
     * @return SIM运营商编码，经测试与{@link DeviceUtils#getNetworkOperator()}返回结果相同
     */
    public static String getSimOperator() {
        String simOperator = "";
        try {
            TelephonyManager telephonyManager = (TelephonyManager) Utils.getApp().getSystemService(Context.TELEPHONY_SERVICE);
            if (ActivityCompat.checkSelfPermission(Utils.getApp(), Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
                simOperator = telephonyManager.getSimOperator();
                return simOperator;
            }
        } catch (Exception e) {
            Log.e(TAG, "getSimOperator: " + e.getMessage());
        }
        return simOperator;
    }

    /**
     * 获取SIM运营商名称
     *
     * @return SIM运营商名称，返回可能为空值
     */
    public static String getSimOperatorName() {
        String simOperatorName = "";
        try {
            TelephonyManager telephonyManager = (TelephonyManager) Utils.getApp().getSystemService(Context.TELEPHONY_SERVICE);
            if (ActivityCompat.checkSelfPermission(Utils.getApp(), Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
                simOperatorName = telephonyManager.getSimOperatorName();
                return simOperatorName;
            }
        } catch (Exception e) {
            Log.e(TAG, "getSimOperatorName: " + e.getMessage());
        }
        return simOperatorName;
    }

    /**
     * 获取SIM卡序列号
     *
     * @return SIM卡序列号
     */
    @SuppressLint("HardwareIds")
    public String getSimSerialNumber() {
        String simSerialNumber = "";
        try {
            TelephonyManager telephonyManager = (TelephonyManager) Utils.getApp().getSystemService(Context.TELEPHONY_SERVICE);
            if (ActivityCompat.checkSelfPermission(Utils.getApp(), Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
                simSerialNumber = telephonyManager.getSimSerialNumber();
                return simSerialNumber;
            }
        } catch (Exception e) {
            Log.e(TAG, "getSimSerialNumber: " + e.getMessage());
        }
        return simSerialNumber;
    }

    /**
     * 获取SIM卡所属国家ISO编码
     *
     * @return SIM卡说国家ISO编码，如中国返回为cn
     */
    public static String getSimCountryIso() {
        String simCountryIso = "";
        try {
            TelephonyManager telephonyManager = (TelephonyManager) Utils.getApp().getSystemService(Context.TELEPHONY_SERVICE);
            if (ActivityCompat.checkSelfPermission(Utils.getApp(), Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
                simCountryIso = telephonyManager.getSimCountryIso();
                return simCountryIso;
            }
        } catch (Exception e) {
            Log.e(TAG, "getSimCountryIso: " + e.getMessage());
        }
        return simCountryIso;
    }
}
