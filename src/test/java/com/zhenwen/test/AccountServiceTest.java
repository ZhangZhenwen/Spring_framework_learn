package com.zhenwen.test;

import com.zhenwen.service.AccountService;
import com.zhenwen.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * created by IntelliJ IDEA
 *
 * @author zhenwen
 * @version jdk 11
 * @date 2020/3/17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {

    @Autowired
    @Qualifier("accountService")
    private AccountService as;

    @Test
    public void testTransfer() {
        as.test();
    }
}
