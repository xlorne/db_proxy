package com.demo.db;

/**
 *
 * create by lorne on 2017/11/8
 */
public class DataSourceLocal {

    private final static ThreadLocal<DataSourceLocal> currentLocal = new ThreadLocal<DataSourceLocal>();

    public static DataSourceLocal current() {
        return currentLocal.get();
    }

    public static void setCurrent(DataSourceLocal current) {
        currentLocal.set(current);
    }

    private String key;


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
