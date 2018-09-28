package com.jack.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 与网络相关的工具类
 *
 * @author chengqian
 * Created on 2018/6/30
 */
public class NetworkUtils {
    /**
     * IP正常验证程式
     */
    private static Pattern IP_PATTERN = Pattern.compile("((?:(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))\\.){3}(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d))))");

    private NetworkUtils() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 判断网络是否连接
     *
     * @param context 上下文
     * @return true已连接，false未连接
     */
    public static boolean isConnected(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (null != connectivity) {
            NetworkInfo info = connectivity.getActiveNetworkInfo();
            if (null != info && info.isConnected()) {
                return info.isConnected();
            }
        }
        return false;
    }

    /**
     * 获取本地外网IP地址
     *
     * @return 返回的IPv4地址
     */
    public static String getNetIp() {
        URL infoUrl = null;
        InputStream inStream = null;
        String ipLine = getRandomIp();
        HttpURLConnection httpConnection = null;
        try {
            // 两个可用的获取IP地址的网址
            // http://ip.chinaz.com/getip.aspx 和 http://city.ip138.com/ip2city.asp
            infoUrl = new URL("http://pv.sohu.com/cityjson?ie=utf-8");
            URLConnection connection = infoUrl.openConnection();
            httpConnection = (HttpURLConnection) connection;
            int responseCode = httpConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                inStream = httpConnection.getInputStream();
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(inStream, "utf-8"));
                StringBuilder strber = new StringBuilder();
                String line = null;
                while ((line = reader.readLine()) != null) {
                    strber.append(line + "\n");
                }
                Matcher matcher = IP_PATTERN.matcher(strber.toString());
                if (matcher.find()) {
                    ipLine = matcher.group();
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inStream.close();
                httpConnection.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        Log.i("ip", "ip地址：" + ipLine);
        return ipLine;
    }

    /**
     * 随机生成IP地址
     *
     * @return 生成随机的IP地址
     */
    private static String getRandomIp() {
        // IPv4范围
        int[][] range = {
                // 36.56.0.0-36.63.255.255
                {607649792, 608174079},
                // 61.232.0.0-61.237.255.255
                {1038614528, 1039007743},
                // 106.80.0.0-106.95.255.255
                {1783627776, 1784676351},
                // 121.76.0.0-121.77.255.255
                {2035023872, 2035154943},
                // 123.232.0.0-123.235.255.255
                {2078801920, 2079064063},
                // 139.196.0.0-139.215.255.255
                {-1950089216, -1948778497},
                // 171.8.0.0-171.15.255.255
                {-1425539072, -1425014785},
                // 182.80.0.0-182.92.255.255
                {-1236271104, -1235419137},
                // 210.25.0.0-210.47.255.255
                {-770113536, -768606209},
                // 222.16.0.0-222.95.255.255
                {-569376768, -564133889}};
        Random random = new Random();
        int index = random.nextInt(10);
        String ip = num2ip(range[index][0] + new Random().nextInt(range[index][1] - range[index][0]));
        return ip;
    }

    /**
     * 将十进制转换成ip地址
     *
     * @param ip 十进制IP地址
     * @return 字符串类型IP地址
     */
    private static String num2ip(int ip) {
        int[] b = new int[4];
        String x = "";
        b[0] = ((ip >> 24) & 0xff);
        b[1] = ((ip >> 16) & 0xff);
        b[2] = ((ip >> 8) & 0xff);
        b[3] = (ip & 0xff);
        x = Integer.toString(b[0]) + "." + Integer.toString(b[1]) + "." + Integer.toString(b[2]) + "." + Integer.toString(b[3]);
        return x;
    }
}
