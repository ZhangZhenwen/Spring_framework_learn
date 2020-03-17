package com.zhenwen.ui;

import com.zhenwen.dao.AccountDao;
import com.zhenwen.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * created by IntelliJ IDEA
 *
 * @author zhenwen
 * @version jdk 11
 * @date 2020/3/10
 */

public class Client {

    /**
     * @param args 系统参数
     */
    public static void main(String[] args) {
        // 获取核心容器对象
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 根据 id 获取 Bean 对象
        AccountService as = (AccountService) ac.getBean("accountService");

        as.saveAccount();

        ac.close();
        }
}
