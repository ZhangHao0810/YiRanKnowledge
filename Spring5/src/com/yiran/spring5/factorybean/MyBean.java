package com.yiran.spring5.factorybean;

import com.yiran.spring5.demo.User;
import org.springframework.beans.factory.FactoryBean;

public class MyBean implements FactoryBean {

    @Override
    public User getObject() throws Exception {
        User user = new User();
        user.add();
        return user;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
