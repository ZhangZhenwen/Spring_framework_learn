package com.zhenwen.service.impl;

import com.zhenwen.dao.AccountDao;
import com.zhenwen.dao.impl.AccountDaoImpl;
import com.zhenwen.service.AccountService;

/**
 * created by IntelliJ IDEA
 *
 * @author zhenwen
 * @version jdk 11
 * @date 2020/3/10
 */

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    public AccountServiceImpl() {
        System.out.println("accountService is ready");
    }

    @Override
    public void saveAccount(){
        accountDao.saveAccount();
    }
}
