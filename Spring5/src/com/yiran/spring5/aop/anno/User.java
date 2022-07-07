package com.yiran.spring5.aop.anno;

import org.springframework.stereotype.Component;

/**
 * 被增强类
 *
 * @author zh
 * @date 2022/07/07
 */
@Component
public class User {
    public void add(){
        System.out.println("add.....");
    }
}
