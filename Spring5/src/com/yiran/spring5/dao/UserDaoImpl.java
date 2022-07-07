package com.yiran.spring5.dao;


import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{
    @Override
    public void update() {
        System.out.println("UserDaoImpl----update");
    }
}
