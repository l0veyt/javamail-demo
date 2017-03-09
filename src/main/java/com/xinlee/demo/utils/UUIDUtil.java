package com.xinlee.demo.utils;

import java.util.UUID;

/**
 * Created by xin.lee on 2017/3/9.
 * UUID工具类
 */
public class UUIDUtil {

    /** 获取UUID */
    private static String getUUID() {
        return UUID.randomUUID().toString();
    }

    /** 获取UUID（32bit/36bit） */
    public static String getUUID(boolean is32bit) {
        if(is32bit) {
            return getUUID().replace("-", "");
        }else {
            return getUUID();
        }
    }
}
