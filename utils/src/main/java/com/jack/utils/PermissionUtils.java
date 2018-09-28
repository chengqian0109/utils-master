package com.jack.utils;

import android.Manifest;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.tbruyelle.rxpermissions2.RxPermissions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;

/**
 * 基于RxPermissions的权限申请工具类
 *
 * @author chengqian
 * Created on 2018/07/23
 */
public class PermissionUtils {
    /**
     * 权限，包含一部分组权限，其他单个权限请使用 {@link Manifest.permission}
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public static final class Permission {
        /**
         * 存储权限
         */
        public static final String[] STORAGE = {
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE
        };
        /**
         * 位置权限
         */
        public static final String[] LOCATION = {
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
        };
        /**
         * 电话权限
         */
        public static final String[] PHONE = {
                Manifest.permission.CALL_PHONE,
                Manifest.permission.READ_PHONE_STATE,
                Manifest.permission.READ_CALL_LOG,
                Manifest.permission.WRITE_CALL_LOG,
                Manifest.permission.USE_SIP,
                Manifest.permission.PROCESS_OUTGOING_CALLS
        };
        /**
         * 日历权限
         */
        public static final String[] CALENDAR = {
                Manifest.permission.READ_CALENDAR,
                Manifest.permission.WRITE_CALENDAR
        };
        /**
         * 联系人权限
         */
        public static final String[] CONTACTS = {
                Manifest.permission.READ_CONTACTS,
                Manifest.permission.WRITE_CONTACTS,
                Manifest.permission.GET_ACCOUNTS
        };
        /**
         * 短信权限
         */
        public static final String[] SMS = {
                Manifest.permission.SEND_SMS,
                Manifest.permission.RECEIVE_SMS,
                Manifest.permission.READ_SMS,
                Manifest.permission.RECEIVE_WAP_PUSH,
                Manifest.permission.RECEIVE_MMS
        };
    }

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
     * @param activity       必须是FragmentActivity
     * @param permissionList 请求的权限集合
     */
    public static Disposable requestPermissions(FragmentActivity activity, PermissionCallback callback, List<String> permissionList) {
        if (activity != null && callback != null && permissionList != null && permissionList.size() != 0) {
            // 再次进行权限申请操作时清零
            sAllowedPermissionCount = 0;
            sShouldShowRequestPermissionRationaleCount = 0;
            sDoNotAskAgainPermissionCount = 0;
            String[] permissions = new String[permissionList.size()];
            for (int i = 0; i < permissionList.size(); i++) {
                permissions[i] = permissionList.get(i);
            }
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
                        callback.onGuideUserToSettings();
                    } else if (sShouldShowRequestPermissionRationaleCount != 0) {
                        // 已禁止的权限都没有勾选不再询问，弹窗重新提醒申请
                        callback.onRequestPermissionAgain();
                    } else {
                        // 权限已全部允许
                        callback.onAllPermissionAllowed();
                    }
                }
            });
        }
        return null;
    }

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
                        callback.onGuideUserToSettings();
                    } else if (sShouldShowRequestPermissionRationaleCount != 0) {
                        // 已禁止的权限都没有勾选不再询问，弹窗重新提醒申请
                        callback.onRequestPermissionAgain();
                    } else {
                        // 权限已全部允许
                        callback.onAllPermissionAllowed();
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
        if (fragment != null && callback != null && permissions != null && permissions.length != 0) {
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
                        callback.onGuideUserToSettings();
                    } else if (sShouldShowRequestPermissionRationaleCount != 0) {
                        // 已禁止的权限都没有勾选不再询问，弹窗重新提醒申请
                        callback.onRequestPermissionAgain();
                    } else {
                        // 权限已全部允许
                        callback.onAllPermissionAllowed();
                    }
                }
            });
        }
        return null;
    }

    /**
     * 请求权限
     *
     * @param fragment       必须是v4包下的Fragment
     * @param permissionList 请求的权限集合
     */
    public static Disposable requestPermissions(Fragment fragment, PermissionCallback callback, List<String> permissionList) {
        if (fragment != null && callback != null && permissionList != null && permissionList.size() > 0) {
            // 再次进行权限申请操作时清零
            sAllowedPermissionCount = 0;
            sShouldShowRequestPermissionRationaleCount = 0;
            sDoNotAskAgainPermissionCount = 0;
            String[] permissions = new String[permissionList.size()];
            for (int i = 0; i < permissionList.size(); i++) {
                permissions[i] = permissionList.get(i);
            }
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
                        callback.onGuideUserToSettings();
                    } else if (sShouldShowRequestPermissionRationaleCount != 0) {
                        // 已禁止的权限都没有勾选不再询问，弹窗重新提醒申请
                        callback.onRequestPermissionAgain();
                    } else {
                        // 权限已全部允许
                        callback.onAllPermissionAllowed();
                    }
                }
            });
        }
        return null;
    }

    /**
     * 根据本类中的 {@link Permission} 定义的权限组将权限进行整合
     *
     * @param permissionGroup 权限组 {@link Permission}
     * @return 要申请的权限集合
     */
    public static List<String> getPermissions(String[]... permissionGroup) {
        List<String> permissionList = new ArrayList<>();
        if (permissionGroup != null && permissionGroup.length != 0) {
            for (String[] arrays : permissionGroup) {
                permissionList.addAll(Arrays.asList(arrays));
            }
        }
        return permissionList;
    }

    /**
     * 添加指定权限到指定集合
     *
     * @param permissionList 权限要存储的集合
     * @param permissions    要添加的权限（可变参数）
     * @return 所有要申请的权限集合
     */
    public static List<String> addPermissions(@Nullable List<String> permissionList, String... permissions) {
        permissionList = permissionList == null ? new ArrayList<>() : permissionList;
        if (permissions != null && permissions.length != 0) {
            for (String permission : permissions) {
                permissionList.add(permission);
            }
        }
        return permissionList;
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
