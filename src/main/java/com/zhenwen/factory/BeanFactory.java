package com.zhenwen.factory;

import com.zhenwen.service.AccountService;
import com.zhenwen.utils.TransactionManager;

import java.lang.reflect.Proxy;

/**
 * created by IntelliJ IDEA
 *
 * @author zhenwen
 * @version jdk 11
 * @date 2020/3/24
 */

public class BeanFactory {
    private AccountService accountService;
    private TransactionManager manager;

    public void setManager(TransactionManager manager) {
        this.manager = manager;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public AccountService getAccountService() {
        return (AccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    Object rtValue = null;
                    try {
                        manager.beginTransaction();

                        rtValue = method.invoke(accountService, args);

                        manager.commit();
                        return rtValue;
                    } catch (Exception e) {
                        manager.rollback();
                        throw new RuntimeException(e);
                    } finally {
                        manager.release();
                    }
                });
    }
}
