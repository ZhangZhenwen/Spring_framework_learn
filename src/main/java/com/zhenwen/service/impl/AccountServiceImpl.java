package com.zhenwen.service.impl;

import com.zhenwen.service.AccountService;

/**
 * created by IntelliJ IDEA
 *
 * @author zhenwen
 * @version jdk 11
 * @date 2020/3/10
 */

public class AccountServiceImpl implements AccountService {

    public AccountServiceImpl() {
        System.out.println("accountService is ready");
    }

    @Override
    public void saveAccount(){
        System.out.println("saveAccount...");
    }

    public void init() {
        System.out.println("create...");
    }

    public void destroy() {
        System.out.println("destroy...");
    }
}
