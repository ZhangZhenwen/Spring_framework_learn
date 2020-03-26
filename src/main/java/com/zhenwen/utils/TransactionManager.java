package com.zhenwen.utils;

import java.sql.SQLException;

/**
 * created by IntelliJ IDEA
 *
 * @author zhenwen
 * @version jdk 11
 * @date 2020/3/18
 */

public class TransactionManager {

    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    /**
     * 开启事务
     */
    public void beginTransaction() {
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
            System.out.println("begin transaction");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 提交事务
     */
    public void commit() {
        try {
            connectionUtils.getThreadConnection().commit();
            System.out.println("commit transaction");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */
    public void rollback() {
        try {
            connectionUtils.getThreadConnection().rollback();
            System.out.println("rollback transaction");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 释放
     */
    public void release() {
        try {
            connectionUtils.getThreadConnection().close();
            connectionUtils.removeConnection();
            System.out.println("release transaction");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
