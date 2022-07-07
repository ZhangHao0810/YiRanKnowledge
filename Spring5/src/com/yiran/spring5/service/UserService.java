package com.yiran.spring5.service;

import com.yiran.spring5.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

//在注解里面，value属性值可以不写，
//默认值是类名称，首字母小写
// UserService ---> userService
@Component(value = "userService")//<bean id="userService" class="..."/>
//@Service
public class UserService {

    @Value(value = "abc")
    private String str;

//    @Autowired
//    @Qualifier(value = "userDaoImpl")

//    @Resource // 根据类型注入
    @Resource(name = "userDaoImpl") //根据名称进行注入
    private UserDao userDao;

    public void add(){
        System.out.println("Service.....add...");
        userDao.update();
    }
}
