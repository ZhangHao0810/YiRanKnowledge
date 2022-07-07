package com.yiran.spring5.JDK动态代理;

public class UserDaoImpl  implements  UserDao{
    @Override
    public int add(int a, int b) {
        System.out.println("add方法执行了");
        return a+b;
    }

    @Override
    public void update(String id) {
        System.out.println("Update...."+id);
    }
}
