package com.zhenwen.utils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * created by IntelliJ IDEA
 *
 * @author zhenwen
 * @version jdk 11
 * @date 2020/3/18
 */

public class ConnectionUtils {

    private ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 获取当前线程上的连接
     * @return 当前线程上的连接
     */
    public Connection getThreadConnection() {
        Connection conn = threadLocal.get();

        if (conn == null) {
            try {
                conn = dataSource.getConnection();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            threadLocal.set(conn);
        }

        return conn;
    }

    /**
     * 把连接和线程解绑
     */
    public void removeConnection() {
        threadLocal.remove();
    }
}
