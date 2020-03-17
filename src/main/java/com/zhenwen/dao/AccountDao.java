package com.zhenwen.dao;

import com.zhenwen.entity.Account;

import java.util.List;

/**
 * created by IntelliJ IDEA
 *
 * @author zhenwen
 * @version jdk 11
 * @date 2020/3/10
 */

public interface AccountDao {
    /**
     * 查询所有
     * @return account
     */
    List<Account> findAll();

    /**
     * 查找
     * @param accountId account
     * @return account
     */
    Account findAccountById(Integer accountId);

    /**
     * 保存
     * @param account account
     */
    void saveAccount(Account account);

    /**
     * 更新
     * @param account account
     */
    void updateAccount(Account account);

    /**
     * 删除
     * @param accountId account
     */
    void deleteAccount(Integer accountId);
}
