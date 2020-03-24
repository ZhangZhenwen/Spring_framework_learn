package com.zhenwen.cglib;

import com.zhenwen.proxy.Producer;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * created by IntelliJ IDEA
 *
 * @author zhenwen
 * @version jdk 11
 * @date 2020/3/24
 */

public class Client {

    public static void main(String[] args) {
        final ProducerImpl producer = new ProducerImpl();

        /**
         * 动态代理：
         *  特点：字节码随用随创建，随用随加载
         *  作用：不修改源码的基础上对方法加强
         *  分类：
         *      基于接口的动态代理
         *      基于子类的动态代理
         *  基于子类的动态代理：
         *      涉及的类：Enhancer
         *      提供者：第三方 cglib库
         *  如何创建代理对象：
         *      使用Enhancer类中的create方法
         *  创建被代理对象的要求：
         *      被代理类不能是最终类
         *  create方法的参数：
         *      Class：字节码
         *          用于加载代理对象字节码的
         *      Callback：用于提供增强代码
         *          一般写的都是该接口的子接口实现类，MethodInterceptor
         *
         */
        Producer cglibProducer = (Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            /**
             *
             * @param proxy
             * @param method
             * @param args
             * @param methodProxy 当前执行方法的代理对象
             * @return
             * @throws Throwable
             */
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                // 增强代码
                Object returnValue = null;
                Float money = (Float) args[0];

                if ("saleProduct".equals(method.getName())) {
                    returnValue = method.invoke(producer, money * 0.8f);
                }

                return returnValue;
            }
        });
        cglibProducer.saleProduct(12000f);
    }
}















