package com.xinlee.demo.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;

/**
 * Created by xin.lee on 2017/3/9.
 * C3P0工具类
 */
public class C3P0Util {

    /** C3P0数据源 */
    private static final ComboPooledDataSource comboPooledDataSource;

    /** 初始化 */
    static {
        /** 默认读取classpath下的c3p0-config.xml配置文件 */
        comboPooledDataSource  = new ComboPooledDataSource();
    }

    /**
     * 获取C3P0数据源
     * @return 数据源
     */
    public static DataSource getComboPooledDataSource() {
        return comboPooledDataSource;
    }
}
