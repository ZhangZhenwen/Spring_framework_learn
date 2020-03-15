package com.zhenwen.ui;

import com.zhenwen.dao.AccountDao;
import com.zhenwen.service.AccountService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * created by IntelliJ IDEA
 *
 * @author zhenwen
 * @version jdk 11
 * @date 2020/3/10
 */

public class Client {

    /**
     * 获取spring的Ioc核心容器，并根据id获取对象
     *
     * ApplicationContext的三个常用实现类
     *      ClassPathXmlApplicationContext，它可以加载类路径下的配置文件，要求配置文件必须在类路径下，不再的话，加载不了。
     *      FileSystemXmlApplicationContext，它可以加载磁盘任意路径下的配置文件（必须有访问权限）。
     *      AnnotationConfigApplicationContext，它是用于读取注解创建容器的。
     *
     * 核心容器的两个接口
     * ApplicationContext：
     *      它在构建核心容器时，创建对象采取的策略时采用立即加载的方式，也就是说，只要一读取完配置文件，马上就创建配置文件中配置的对象。
     * BeanFactory：
     *      它在构建核心容器时，创建对象采取的策略时采用延迟加载的方式，也就是说，什么时候根据id获取对象了，才真正的创建对象。
     * @param args 系统参数
     */
    public static void main(String[] args) {
        // 获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 根据 id 获取 Bean 对象
        AccountService as = (AccountService) ac.getBean("accountService");
        AccountDao ad = ac.getBean("accountDao", AccountDao.class);

        System.out.println(as);
        System.out.println(ad);

        // -----------------------
        Resource resource = new ClassPathResource("bean.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
    }
}
