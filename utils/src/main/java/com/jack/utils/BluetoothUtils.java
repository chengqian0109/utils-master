package com.jack.utils;

import android.bluetooth.BluetoothAdapter;

/**
 * 蓝牙工具类
 *
 * @author chengqian
 * Created on 2018/6/30
 */
public class BluetoothUtils {

    /**
     * 获取蓝牙是否可用
     *
     * @return 蓝牙已开启为true, 蓝牙不可用或未开启为false
     */
    public static boolean isBluetoothEnabled() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        return bluetoothAdapter != null && bluetoothAdapter.isEnabled();
    }
}
