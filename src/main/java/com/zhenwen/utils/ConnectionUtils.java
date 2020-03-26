package com.zhenwen.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

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
@Repository("connectionUtils")
public class ConnectionUtils {

    private ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
    private DataSource dataSource;

    @Autowired
    @Qualifier("dataSource")
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
