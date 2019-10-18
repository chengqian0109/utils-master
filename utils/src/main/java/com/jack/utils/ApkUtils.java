package com.jack.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.FileProvider;

import java.io.File;
import java.util.List;

/**
 * 获取版本名称、版本号、兼容Android 7.0及以上新版本直接安装的工具类
 *
 * @author chengqian
 * Created on 2018/6/28
 */
public class ApkUtils {
    /**
     * 获取当前程序的版本名称
     *
     * @return 版本名称
     */
    public static String getVersionName() {
        // 包的管理者 获取应用程序清单文件中所有信息
        // 初始化PackageManager
        PackageManager pm = Utils.getApp().getPackageManager();
        // 根据应用程序的包名 获取应用程序的信息
        try {
            PackageInfo packageInfo = pm.getPackageInfo(Utils.getApp().getPackageName(), 0);
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取当前程序的版本号
     *
     * @return 版本号
     */
    public static long getVersionCode() {
        // 包的管理者 获取应用程序清单文件中所有信息
        // 初始化PackageManager
        PackageManager pm = Utils.getApp().getPackageManager();
        // 根据应用程序的包名 获取应用程序的信息
        try {
            PackageInfo packageInfo = pm.getPackageInfo(Utils.getApp().getPackageName(), 0);
            if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.O_MR1) {
                return packageInfo.versionCode;
            }
            return packageInfo.getLongVersionCode();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 安装apk
     *
     * @param context               Context Activity上下文
     * @param apkPath               apkPath 安装包路径
     * @param fileProviderAuthority FileProvider在清单文件中配置的authority授权
     */
    public static void installApk(Activity context, String apkPath, String fileProviderAuthority) {
        File apkFile = new File(apkPath);
        Intent install = new Intent(Intent.ACTION_VIEW);
        install.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            // 判断版本是否在7.0以上
            // 在AndroidManifest.xml中声明的的android:authorities值
            Uri apkUri = FileProvider.getUriForFile(context,
                    fileProviderAuthority, apkFile);
            install.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            install.setDataAndType(apkUri,
                    "application/vnd.android.package-archive");
            context.startActivity(install);
        } else {
            install.setDataAndType(Uri.fromFile(apkFile),
                    "application/vnd.android.package-archive");
            context.startActivity(install);
        }
        context.finish();
    }

    /**
     * 检验指定的安装包是否已安装
     *
     * @param packageName apk的包名
     * @return apk是否安装
     */
    @SuppressLint("SdCardPath")
    public static boolean isApkInstalled(String packageName) {
        return new File("/data/data/" + packageName).exists();
    }

    /**
     * 获取当前应用程序包名
     */
    public static String getPackageName() {
        return Utils.getApp().getPackageName();
    }

    /**
     * 判断Activity是否在前台运行
     * @param activity Activity
     * @return true表示在前台运行
     */
    public static boolean isRunningForeground(Activity activity) {
        ActivityManager activityManager = (ActivityManager)
                activity.getSystemService(Context.ACTIVITY_SERVICE);
        String packageName = activity.getPackageName();
        List<ActivityManager.RunningAppProcessInfo> appProcesses = activityManager
                .getRunningAppProcesses();
        if (appProcesses == null)
            return false;
        for (ActivityManager.RunningAppProcessInfo appProcess : appProcesses) {
            if (appProcess.processName.equals(packageName)
                    && appProcess.importance == ActivityManager
                    .RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                return true;
            }
        }
        return false;
    }
}
