package com.yiran.spring5.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * spring配置类
 *
 * @author zh
 * @date 2022/07/07
 */
@Configuration // 作为配置类，替代xml配置文件
@ComponentScan(basePackages = {"com.yiran.spring5"})
public class SpringConfig {
}
