package com.jack.utils;

import android.util.Log;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;

/**
 * 检查文件的Md5工具类
 *
 * @author chengqian
 * Created on 2018/12/5
 */
public class CheckFileMd5Utils {

    private static final String TAG = "CheckFileMd5Utils";

    /**
     * 获取文件的MD5值
     *
     * @param filePath 文件路径
     * @return 文件的Md5值
     */
    public static String fileToMD5(String filePath) {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(filePath);
            byte[] buffer = new byte[1024];
            MessageDigest digest = MessageDigest.getInstance("MD5");
            int numRead = 0;
            while (numRead != -1) {
                numRead = inputStream.read(buffer);
                if (numRead > 0) {
                    digest.update(buffer, 0, numRead);
                }
            }
            byte[] md5Bytes = digest.digest();
            return convertHashToString(md5Bytes);
        } catch (Exception ignored) {
            return null;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e) {
                    Log.e(TAG, "file to md5 failed", e);
                }
            }
        }
    }

    /**
     * 哈希值转化为字符串
     *
     * @param md5Bytes md5字节数组
     * @return md5字符串
     */
    private static String convertHashToString(byte[] md5Bytes) {
        StringBuilder buf = new StringBuilder();
        for (byte md5Byte : md5Bytes) {
            buf.append(Integer.toString((md5Byte & 0xff) + 0x100, 16).substring(1));
        }
        return buf.toString().toUpperCase();
    }

}
