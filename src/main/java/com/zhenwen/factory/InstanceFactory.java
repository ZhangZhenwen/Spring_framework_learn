package com.zhenwen.factory;

import com.zhenwen.service.AccountService;
import com.zhenwen.service.impl.AccountServiceImpl;

/**
 * created by IntelliJ IDEA
 *
 * 模拟一个工厂类（存在于jar包中的，我们无法通过修改源码的方式来提供默认构造函数）
 *
 * @author zhenwen
 * @version jdk 11
 * @date 2020/3/15
 */

public class InstanceFactory {

    public AccountService getAccountService() {
        return new AccountServiceImpl();
    }
}
