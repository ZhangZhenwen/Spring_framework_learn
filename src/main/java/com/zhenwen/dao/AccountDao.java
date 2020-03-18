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

    /**
     * 根据名称查询账户
     * @param accountName 账户名称
     * @return 如果有唯一结果就返回，如果没有结果就返回null
     */
    Account findAccountByName(String accountName);
}
