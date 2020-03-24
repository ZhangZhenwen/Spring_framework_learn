package com.zhenwen.proxy;

/**
 * created by IntelliJ IDEA
 *
 * @author zhenwen
 * @version jdk 11
 * @date 2020/3/24
 */

public interface Producer {
    /**
     * 销售
     * @param money 所需的钱
     */
    public void saleProduct(float money);

    /**
     * 售后
     * @param money 所需的钱
     */
    public void afterService(float money);
}
