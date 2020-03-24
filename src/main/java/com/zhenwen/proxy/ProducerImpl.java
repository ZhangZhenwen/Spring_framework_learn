package com.zhenwen.proxy;

/**
 * created by IntelliJ IDEA
 *
 * @author zhenwen
 * @version jdk 11
 * @date 2020/3/24
 */

public class ProducerImpl implements Producer {

    @Override
    public void saleProduct(float money) {
        System.out.println("销售产品，拿到钱" + money);
    }

    @Override
    public void afterService(float money) {
        System.out.println("售后服务，拿到钱" + money);
    }
}
