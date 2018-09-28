package com.jack.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * 关闭IO流的工具类
 *
 * @author chengqian
 * Created on 2018/6/28
 */
public class IOUtils {
    /**
     * 关闭IO流
     *
     * @param closeables closeable
     */
    public static void close(Closeable... closeables) {
        if (closeables == null) {
            return;
        }
        try {
            for (Closeable closeable : closeables) {
                if (closeable != null) {
                    closeable.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
