package com.yiran.spring5.demo;

import com.sun.org.apache.xpath.internal.operations.Or;

/**
 * 订单  基于XML，使用有参构造进行注入。
 *
 * @author zh
 * @date 2022/07/07
 */
public class Orders {

    private String oname;
    private String address;

    public Orders(String oname, String address) {
        this.address = address;
        this.oname = oname;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "oname='" + oname + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
