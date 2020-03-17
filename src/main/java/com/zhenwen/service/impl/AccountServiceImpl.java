package com.zhenwen.service.impl;

import com.zhenwen.dao.AccountDao;
import com.zhenwen.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * created by IntelliJ IDEA
 *
 * XML的配置
 * <bean id="accountService" class="com.zhenwen.service.impl.AccountServiceImpl"
 *      scope="" init-method="" destroy-method="">
 *      <property name="" value="" | ref=""></property>
 * </bean>
 *
 * 用于创建对象的
 *      他们的作用就是在XML配置文件中编写一个<bean>标签实现的功能是一样的
 *      @Component
 *          作用：把当前对象存入Spring容器中
 *          属性：
 *              value：用于指定bean的id，默认当前类名，首字母小写
 *      @Controller 表现层
 *      @Service 业务层
 *      @Reposity 持久层
 *          作用与属性和Component一样
 *          是Spring框架为我们提供明确的三层使用的注解，是我们的三层对象更加清晰
 *
 * 用于注入数据的
 *      他们的作用就是在xml配置文件中<property>标签的作用是一样的
 *      @Autowired
 *          作用：自动按照类型注入，只要容器中有唯一的一个bean对象和要注入变量类型匹配，就可以注入成功
 *               如果Ioc容器中没有任何bean类型和要注入的类型匹配，就会报错。
 *               如果有多个bean类型匹配时，
 *          位置：可以是变量上，也可以是方法上。
 *      @Qualifier
 *          作用：在按照类中注入的基础之上再按照名称注入。再给类成员注入时，不能单独使用，但是在给方法参数注入时可以。
 *          属性：
 *              value：用于指定注入bean的id
 *      @Resouce
 *          作用：直接按照bean的id注入，可以独立使用
 *          属性：
 *              name：用于指定bean的id
 *      以上三种注入都只能注入其他bean类型的数据，基本类型和string类型无法使用
 *      另外，集合类型的注入只能通过xml来实现
 *
 *      @Value
 *          作用：用来注入基本类型和string类型数据
 *          属性：
 *              value：用于指定数据的值，可以使用Spring中的SpEl ${表达式}
 *
 * 用于改变作用范围的
 *      他们的作用集合在scope属性实现的功能是一样的
 *      @Scope
 *          作用：用于指定bean的作用范围
 *          属性：
 *              value：指定范围的取值。 singleton prototype
 *
 * 和生命周期相关的
 *      他们的作用在init-method和destroy-method的作用是一样的
 *      @PreDestroy
 *          作用：用于指定销毁方法
 *      @PostConstruct
 *          作用：用于指定初始化方法
 *
 * @author zhenwen
 * @version jdk 11
 * @date 2020/3/10
 */
@Component(value = "accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    @Qualifier("accountDao")
    @Resource()
    private AccountDao accountDao;

    @PostConstruct
    public void init() {
        System.out.println("initial...");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("destroy...");
    }

    @Override
    public void saveAccount(){
        accountDao.saveAccount();
    }
}
