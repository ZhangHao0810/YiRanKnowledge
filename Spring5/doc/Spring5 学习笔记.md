# Spring 5 学习笔记

本笔记基于尚硅谷 spring 5超详细源码级讲解 https://www.bilibili.com/video/BV1Vf4y127N5  Spring版本为 5.x

原教程视频时长 15小时， 学习周期【2022年7月6-10日】

# Spring 概念

1. Spring 是一个轻量级（体积小，jar包少。可以独立使用），开源的JavaEE框架。  
2. Spring 框架 解决企业应用开发的复杂性
3. Spring有两个核心部分：IOC、Aop

（1）IOC：控制反转，把创建对象的过程交给Spring管理

（2）Aop：面向切面，不修改源代码的前提下，进行功能的增强。

4. Spring 特点

（1）方便解耦，简化开发

（2）Aop 编程支持

（3）方便程序测试 （Junit）

（4）方便和其他框架整合（如Mybatis）

（5）方便进行事务、降低API的开发难度（对JDBC进行了封装）

（6）Spring源码是 经典学习范例！大师造！研读Spring源码可以快速提高能力。

# Spring 5 入门案例

1. IDEA中创建java项目

2. 访问：https://repo.spring.io/ui/native/release/org/springframework/spring/  下载 spring-5.2.9.RELEASE-dist.zip 并解压。

   > ![image-20220706110541277](Spring5 学习笔记.assets/Spring模块.png)
   >
   > Spring 发行包的组成部分（从底层向上看）
   >
   >1. Test 
   >2. Core Container （核心部分）
   > Beans 、 Core 对应 IOC的核心部分。
   > Context 上下文、 Expression  表达式
   >3. AOP ....
   >4. Data (JDBC、Transaction) / Web （Spring MVC）

   3. 导入Core Container 中的四个jar包到项目中。还有 commons-logging 这个日志包。因为spring的jar依赖了这个日志jar。\

   4. 创建普通类User，添加一个普通方法add。
      ```java
      public class User {
          public void add() {
              System.out.println("add.....");
          }
      }
      ```
      
   5. 创建Spring的配置文件， 并在配置文件中配置创建的对象。

      1. 配置文件使用XML格式创建。在src下创建xml配置文件。

      2. ```xml
         <!--    配置User对象创建-->
         <bean id="user" class="com.yiran.spring5.demo.User"></bean>
         ```

   6. 进行测试代码编写
```java
    @Test
    public void testAdd() {
//        1. 加载Spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        	//可以换用另一个容器 BeanFactory，效果相同
        BeanFactory factory = new ClassPathXmlApplicationContext("bean1.xml");
//        2. 获取配置创建的对象
        User user = context.getBean("user", User.class);
        	factory.getBean("user", User.class);

        System.out.println(user);
        user.add();
    }
输出：
com.yiran.spring5.demo.User@670b40af
add.....
```

# IOC容器

## IOC底层原理

1. 什么是IOC

   控制反转（Inversion of Control），把对象创建和对象之间的调用交给Spring进行管理。

   使用IOC的目的：降低代码耦合。高内聚低耦合。

   入门案例即IOC的实现。

   2. IOC底层原理

      工厂模式、XML解析、反射 

      ![工厂模式](Spring5 学习笔记.assets/工厂模式Demo.png)

      Spring IOC的过程

      ![IOC过程](Spring5 学习笔记.assets/IOC过程.png)

## IOC接口（BeanFactory）

IOC思想基于**IOC容器**完成，IOC容器的底层是**对象工厂**

Spring 提供了IOC容器的两种方式：（两个接口）

1. BeanFactory

   IOC容器的基本实现，Spring内部使用的接口。

   - 加载配置文件时，不会创建对象，在获取对象（使用）才会去创建对象。

2. ApplicationContext

  BeanFactory接口的子接口，提供了更多更强大的功能，面向开发人员进行使用的。

  - 一加载配置文件就会创建。 【服务器启动的时候就去创建，把耗时耗资源的操作放在服务器启动时。】

![IOC过程](Spring5 学习笔记.assets/ApplicationContext的实现类.png)

ClassPathXmlApplicationContext  ，src下，类路径。

FileSystemXmlApplicationContext ，对应带盘符的路径。

## IOC操作 Bean管理

1. 什么是Bean管理
   1. Spring创建对象
   2. Spring注入属性  set值
2. Bean管理操作的实现方式：（1） 基于XML配置文件方式实现，（2）基于注解方式

### 1. 基于XML

#### 基于XML方式创建对象

```xml
<!--配置User对象创建
	id：唯一标识
	class：类全路径
-->
<bean id="user" class="com.yiran.spring5.demo.User"></bean>
```

（1）在Spring 配置文件中，使用bean标签，标签里面添加对应属性，就可以实现对象创建。

（3）创建对象时，默认执行无参构造方法。【若类没有无参构造，则创建对象失败，报错】

#### 基于XML方式注入属性

（1）DI：依赖注入，注入属性。需要在创建对象的基础之上完成。

- 使用set方法进行注入

  ```xml
  <!--    用set 方法注入属性-->
  <bean id="book" class="com.yiran.spring5.demo.Book"> <!--创建对象-->
      <!--使用property完成属性注入
          name:类里面属性的名称
          value:向属性中注入的值
      -->
      <property name="bname" value="深入理解JVM"></property>
      <property name="bauthor" value="ZH"></property>
  </bean>
  ```

- 使用有参构造注入

### 2. 基于注解







# Aop

# JDBCTemplate

# 事务管理

# Spring 5 新特性

