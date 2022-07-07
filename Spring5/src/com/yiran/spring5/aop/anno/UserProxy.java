package com.yiran.spring5.aop.anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 增强类
 *
 * @author zh
 * @date 2022/07/07
 */
@Component
@Aspect //生成代理对象
@Order(3)
public class UserProxy {

    //相同切入点进行抽取
    @Pointcut(value = "execution(* com.yiran.spring5.aop.anno.User.add(..))")
    public void pointCut(){

    }

    // 前置通知。
    @Before(value = "pointCut()")
    public void before() {
        System.out.println("before...");
    }

    //最终通知 不管有没有异常 都执行
    @After(value = "execution(* com.yiran.spring5.aop.anno.User.add(..))")
    public void after() {
        System.out.println("after....");
    }

    //后置通知（返回通知)，当有异常就不执行。
    @AfterReturning(value = "execution(* com.yiran.spring5.aop.anno.User.add(..))")
    public void afterReturning() {
        System.out.println("afterReturning....");
    }

    //异常通知
    @AfterThrowing(value = "execution(* com.yiran.spring5.aop.anno.User.add(..))")
    public void afterThrowing() {
        System.out.println("afterThrowing....");
    }

    //环绕通知：在方法之前和之后都执行。
    @Around(value = "execution(* com.yiran.spring5.aop.anno.User.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕之前....");
        proceedingJoinPoint.proceed();
        System.out.println("环绕之后....");
    }
}
