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

public class AccountServiceImplOld implements AccountService {

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
        try {
            manager.beginTransaction();

            List<Account> accounts = accountDao.findAll();

            manager.commit();
            return accounts;
        } catch (Exception e) {
            manager.rollback();
            throw new RuntimeException(e);
        } finally {
            manager.release();
        }
    }

    @Override
    public Account findAccountById(Integer accountId) {
        try {
            manager.beginTransaction();

            Account account = accountDao.findAccountById(accountId);

            manager.commit();
            return account;
        } catch (Exception e) {
            manager.rollback();
            throw new RuntimeException(e);
        } finally {
            manager.release();
        }
    }

    @Override
    public void saveAccount(Account account) {
        try {
            manager.beginTransaction();

            accountDao.saveAccount(account);

            manager.commit();
        } catch (Exception e) {
            manager.rollback();
            throw new RuntimeException(e);
        } finally {
            manager.release();
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            manager.beginTransaction();

            accountDao.updateAccount(account);

            manager.commit();
        } catch (Exception e) {
            manager.rollback();
            throw new RuntimeException(e);
        } finally {
            manager.release();
        }
    }

    @Override
    public void deleteAccount(Integer accountId) {
        try {
            manager.beginTransaction();

            accountDao.deleteAccount(accountId);

            manager.commit();
        } catch (Exception e) {
            manager.rollback();
            throw new RuntimeException(e);
        } finally {
            manager.release();
        }
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
            throw new RuntimeException(e);
        } finally {
            manager.release();
        }

    }
}
