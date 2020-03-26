package com.zhenwen.utils;

import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * created by IntelliJ IDEA
 *
 * @author zhenwen
 * @version jdk 11
 * @date 2020/3/18
 */
@Component("manager")
@Aspect
public class TransactionManager {

    private ConnectionUtils connectionUtils;

    @Autowired
    @Qualifier("connectionUtils")
    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    @Pointcut("execution(* com.zhenwen.service.impl.AccountServiceImpl.*(..))")
    public void manager() {}

    /**
     * 开启事务
     */
    @Before("manager()")
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
    @AfterReturning("manager()")
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
    @AfterThrowing("manager()")
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
    @After("manager()")
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
