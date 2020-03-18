package com.zhenwen.service.impl;

import com.zhenwen.dao.AccountDao;
import com.zhenwen.entity.Account;
import com.zhenwen.service.AccountService;
import com.zhenwen.utils.TransactionManager;

import java.util.List;

/**
 * created by IntelliJ IDEA

 * @author zhenwen
 * @version jdk 11
 * @date 2020/3/10
 */

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;
    private TransactionManager manager;



    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void setManager(TransactionManager manager) {
        this.manager = manager;
    }

    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }

    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    @Override
    public void deleteAccount(Integer accountId) {
        accountDao.deleteAccount(accountId);
    }

    @Override
    public void transfer(String sourceName, String targetName, Float salary) {
        try {
            manager.beginTransaction();

            Account source = accountDao.findAccountByName(sourceName);
            Account target = accountDao.findAccountByName(targetName);
            source.setSalary(source.getSalary() - salary);
            target.setSalary(target.getSalary() + salary);
            accountDao.updateAccount(source);
            accountDao.updateAccount(target);

            manager.commit();
        } catch (Exception e) {
            manager.rollback();
            e.printStackTrace();
        } finally {
            manager.release();
        }

    }
}
