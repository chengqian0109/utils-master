package com.jack.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.tbruyelle.rxpermissions2.RxPermissions;

import io.reactivex.disposables.Disposable;

/**
 * 基于RxPermissions的权限申请工具类
 *
 * @author chengqian
 * Created on 2018/07/23
 */
public class PermissionUtils {
    /**
     * 被禁止后可以显示权限申请弹窗的权限个数
     */
    private static int sShouldShowRequestPermissionRationaleCount = 0;

    /**
     * 所有已允许的权限个数
     */
    private static int sAllowedPermissionCount = 0;

    /**
     * 勾选不再询问的权限的请求个数
     */
    private static int sDoNotAskAgainPermissionCount = 0;

    /**
     * 请求权限
     *
     * @param activity    必须是FragmentActivity
     * @param permissions 请求的权限(个数可变)
     */
    public static Disposable requestPermissions(FragmentActivity activity, PermissionCallback callback, String... permissions) {
        if (activity != null && callback != null && permissions != null && permissions.length != 0) {
            // 再次进行权限申请操作时清零
            sAllowedPermissionCount = 0;
            sShouldShowRequestPermissionRationaleCount = 0;
            sDoNotAskAgainPermissionCount = 0;
            RxPermissions rxPermissions = new RxPermissions(activity);
            return rxPermissions.requestEach(permissions).subscribe(permission -> {
                // 会发出指定权限个数的订阅对象
                if (permission.granted) {
                    sAllowedPermissionCount += 1;
                    // 权限已允许
                } else if (permission.shouldShowRequestPermissionRationale) {
                    // 权限被禁止，但没有勾选不再询问
                    sShouldShowRequestPermissionRationaleCount += 1;
                } else {
                    // 勾选了不再询问，需要引导用户到应用详情去设置
                    sDoNotAskAgainPermissionCount += 1;
                }
                // 所有权限已申请完毕才进行相关弹窗操作
                if (sAllowedPermissionCount + sShouldShowRequestPermissionRationaleCount
                        + sDoNotAskAgainPermissionCount == permissions.length) {
                    if (sDoNotAskAgainPermissionCount != 0) {
                        // 至少一个勾选了不再询问，弹窗去设置
                        if (callback != null) {
                            callback.onGuideUserToSettings();
                        }
                    } else if (sShouldShowRequestPermissionRationaleCount != 0) {
                        // 已禁止的权限都没有勾选不再询问，弹窗重新提醒申请
                        if (callback != null) {
                            callback.onRequestPermissionAgain();
                        }
                    } else {
                        // 权限已全部允许
                        if (callback != null) {
                            callback.onAllPermissionAllowed();
                        }
                    }
                }
            });
        }
        return null;
    }

    /**
     * 请求权限
     *
     * @param fragment    必须是v4包下的Fragment
     * @param permissions 请求的权限(个数可变)
     */
    public static Disposable requestPermissions(Fragment fragment, PermissionCallback callback, String... permissions) {
        if (permissions != null && permissions.length != 0) {
            // 再次进行权限申请操作时清零
            sAllowedPermissionCount = 0;
            sShouldShowRequestPermissionRationaleCount = 0;
            sDoNotAskAgainPermissionCount = 0;
            RxPermissions rxPermissions = new RxPermissions(fragment);
            return rxPermissions.requestEach(permissions).subscribe(permission -> {
                // 会发出指定权限个数的对象
                if (permission.granted) {
                    sAllowedPermissionCount += 1;
                    // 权限已允许
                } else if (permission.shouldShowRequestPermissionRationale) {
                    // 权限被禁止，但没有勾选不再询问
                    sShouldShowRequestPermissionRationaleCount += 1;
                } else {
                    // 勾选了不再询问，需要引导用户到应用详情去设置
                    sDoNotAskAgainPermissionCount += 1;
                }
                // 所有权限已申请完毕才进行相关弹窗操作
                if (sAllowedPermissionCount + sShouldShowRequestPermissionRationaleCount
                        + sDoNotAskAgainPermissionCount == permissions.length) {
                    if (sDoNotAskAgainPermissionCount != 0) {
                        // 至少一个勾选了不再询问，弹窗去设置
                        if (callback != null) {
                            callback.onGuideUserToSettings();
                        }
                    } else if (sShouldShowRequestPermissionRationaleCount != 0) {
                        // 已禁止的权限都没有勾选不再询问，弹窗重新提醒申请
                        if (callback != null) {
                            callback.onRequestPermissionAgain();
                        }
                    } else {
                        // 权限已全部允许
                        if (callback != null) {
                            callback.onAllPermissionAllowed();
                        }
                    }
                }
            });
        }
        return null;
    }

    /**
     * 所有权限申请完毕的回调接口
     */
    public interface PermissionCallback {
        /**
         * 所有权限已允许
         */
        void onAllPermissionAllowed();

        /**
         * 可以再次申请权限
         */
        void onRequestPermissionAgain();

        /**
         * 引导用户去设置界面
         */
        void onGuideUserToSettings();
    }
}
