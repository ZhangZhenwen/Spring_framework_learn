package com.zhenwen.dao.impl;

import com.zhenwen.dao.AccountDao;
import org.springframework.stereotype.Repository;

/**
 * created by IntelliJ IDEA
 *
 * @author zhenwen
 * @version jdk 11
 * @date 2020/3/10
 */
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    @Override
    public void saveAccount() {
        System.out.println("保存账户");
    }
}
