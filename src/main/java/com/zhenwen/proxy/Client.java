package com.zhenwen.proxy;

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
         *  基于接口的动态代理：
         *      涉及的类：proxy
         *      提供者：JDK 官方
         *  如何创建代理对象：
         *      使用proxy中的newProxyInstance方法
         *  创建被代理对象的要求：
         *      被代理类至少实现一个接口，如果没有则不能使用
         *  newProxyInstance的方法参数：
         *      ClassLoader：加载代理对象字节码
         *          用于加载代理对象字节码的，和被代理对象使用
         *      Class[]：字节码数组
         *          用于让代理对象和被代理对象有相同方法，固定写法
         *      InvocationHandler：用于提供增强代码
         *          让我们写如何代理，一般都是一个该接口的实现类，通常是匿名内部类，不是必须的
         *
         */
        Producer proxyProducer = (Producer) Proxy.newProxyInstance(producer.getClass().getClassLoader(),
                producer.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 作用：执行被代理对象的任何接口方法都会经过该方法
                     * @param proxy 代理对象的引用
                     * @param method 当前执行的方法
                     * @param args 当前执行方法的参数
                     * @return 和被代理对象方法有相同的返回值
                     * @throws Throwable .
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 增强代码
                        Object returnValue = null;
                        Float money = (Float) args[0];
                        if ("saleProduct".equals(method.getName())) {
                            returnValue = method.invoke(producer, money * 0.8f);
                        }

                        return returnValue;
                    }
                });
        proxyProducer.saleProduct(10000f);
    }
}















