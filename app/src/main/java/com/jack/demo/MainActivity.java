package com.jack.demo;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jack.utils.FancyToastUtils;
import com.jack.utils.PermissionUtils;
import com.jack.utils.StatusBarUtils;
import com.jack.utils.Utils;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Utils.init(getApplication());
        StatusBarUtils.setStatusBarLightMode(this);
        StatusBarUtils.setStatusBarColor(this, R.color.colorAccent,R.color.color_88000000);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void requestPermissions(View view) {
        List<String> permissions = PermissionUtils.getPermissions(PermissionUtils.Permission.CALENDAR,
                PermissionUtils.Permission.PHONE, PermissionUtils.Permission.SMS, PermissionUtils.Permission.STORAGE,
                PermissionUtils.Permission.CONTACTS);

        PermissionUtils.requestPermissions(this, new PermissionUtils.Callback() {
            @Override
            public void onAllPermissionAllowed() {
                FancyToastUtils.showSuccess("所有权限都允许了");
            }

            @Override
            public void onRequestPermissionAgain() {
                FancyToastUtils.showWarning("需要重新请求权限");
            }

            @Override
            public void onGuideUserToSettings() {
                FancyToastUtils.showError("需要用户设置权限");
            }
        }, PermissionUtils.addPermissions(permissions, Manifest.permission.BLUETOOTH, Manifest.permission.CAMERA));
    }

    public void showFancyToast(View view) {
        FancyToastUtils.showSuccess("哈哈哈");
    }
}
