package com.jack.demo;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;

import com.jack.utils.DeviceUtils;
import com.jack.utils.LogUtils;
import com.jack.utils.PermissionUtils;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> permissions = PermissionUtils.getPermissions(PermissionUtils.Permission.CALENDAR,
                PermissionUtils.Permission.PHONE, PermissionUtils.Permission.SMS, PermissionUtils.Permission.STORAGE,
                PermissionUtils.Permission.CONTACTS);

        PermissionUtils.requestPermissions(this, new PermissionUtils.PermissionCallback() {
            @Override
            public void onAllPermissionAllowed() {
                LogUtils.e("onAllPermissionAllowed：1 = " + checkSelfPermission(Manifest.permission.BLUETOOTH));
                LogUtils.e("onAllPermissionAllowed：2 = " + checkSelfPermission(Manifest.permission.CAMERA));
                LogUtils.e("onAllPermissionAllowed：3 = " + checkSelfPermission(Manifest.permission.READ_CALENDAR));
                LogUtils.e("onAllPermissionAllowed：4 = " + checkSelfPermission(Manifest.permission.READ_SMS));
                LogUtils.e("onAllPermissionAllowed：5 = " + checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE));
                LogUtils.e("onAllPermissionAllowed：6 = " + DeviceUtils.getPhoneNumber(MainActivity.this));
                LogUtils.e("onAllPermissionAllowed：7 = " + checkSelfPermission(Manifest.permission.WRITE_CONTACTS));
            }

            @Override
            public void onRequestPermissionAgain() {
                LogUtils.e("onRequestPermissionAgain：1 = " + checkSelfPermission(Manifest.permission.BLUETOOTH));
                LogUtils.e("onRequestPermissionAgain：2 = " + checkSelfPermission(Manifest.permission.CAMERA));
                LogUtils.e("onRequestPermissionAgain：3 = " + checkSelfPermission(Manifest.permission.READ_CALENDAR));
                LogUtils.e("onRequestPermissionAgain：4 = " + checkSelfPermission(Manifest.permission.READ_SMS));
                LogUtils.e("onRequestPermissionAgain：5 = " + checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE));
                LogUtils.e("onRequestPermissionAgain：6 = " + DeviceUtils.getPhoneNumber(MainActivity.this));
                LogUtils.e("onRequestPermissionAgain：7 = " + checkSelfPermission(Manifest.permission.WRITE_CONTACTS));
            }

            @Override
            public void onGuideUserToSettings() {
                LogUtils.e("onGuideUserToSettings：1 = " + checkSelfPermission(Manifest.permission.BLUETOOTH));
                LogUtils.e("onGuideUserToSettings：2 = " + checkSelfPermission(Manifest.permission.CAMERA));
                LogUtils.e("onGuideUserToSettings：3 = " + checkSelfPermission(Manifest.permission.READ_CALENDAR));
                LogUtils.e("onGuideUserToSettings：4 = " + checkSelfPermission(Manifest.permission.READ_SMS));
                LogUtils.e("onGuideUserToSettings：5 = " + checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE));
                LogUtils.e("onGuideUserToSettings：6 = " + DeviceUtils.getPhoneNumber(MainActivity.this));
                LogUtils.e("onGuideUserToSettings：7 = " + checkSelfPermission(Manifest.permission.WRITE_CONTACTS));
            }
        }, PermissionUtils.addPermissions(permissions, Manifest.permission.BLUETOOTH, Manifest.permission.CAMERA));
    }
}
