package com.zhenwen.test;

import com.zhenwen.entity.Account;
import com.zhenwen.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * created by IntelliJ IDEA
 *
 * @author zhenwen
 * @version jdk 11
 * @date 2020/3/17
 */

public class AccountServiceTest {
    @Test
    public void testFindAll() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountService as = ac.getBean("accountService", AccountService.class);

        List<Account> accounts = as.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
    @Test
    public void testFindAOne() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountService as = ac.getBean("accountService", AccountService.class);

        Account account = as.findAccountById(1);
        System.out.println(account);
    }
    @Test
    public void testSave() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountService as = ac.getBean("accountService", AccountService.class);

        as.saveAccount(new Account("老六", 1000.0));
    }
    @Test
    public void testUpdate() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountService as = ac.getBean("accountService", AccountService.class);

        Account account = as.findAccountById(4);
        account.setName("111");
        as.updateAccount(account);
    }
    @Test
    public void testDelete() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountService as = ac.getBean("accountService", AccountService.class);

        as.deleteAccount(4);
    }
}
