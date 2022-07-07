package com.yiran.spring5.aop.anno;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class PersonProxy {
    // 前置通知。
    @Before(value = "execution(* com.yiran.spring5.aop.anno.User.add(..))")
    public void before() {
        System.out.println("Person before...");
    }
}
