package com.yiran.spring5.JDK动态代理;

import com.yiran.spring5.demo.User;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class JDKProxy {

    public static void main(String[] args) {
        // 创建接口实现类的代理对象
        Class[] interfaces = {UserDao.class};
//        Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                return null;
//            }
//        });
        UserDaoImpl userDao = new UserDaoImpl();
        UserDao dao = (UserDao) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new UserDaoProxy(userDao));
        int result = dao.add(1, 2);
        System.out.println("result: " + result);
    }
}

// 创建代理对象
class UserDaoProxy implements InvocationHandler {

    // 创建的是谁的代理对象，就要把谁传递过来。
    // 有参构造
    private Object obj;

    public UserDaoProxy(Object obj) {
        this.obj = obj;
    }


    /**
     * invoke 方法的作用： 只要类被创建，方法就会被调用。
     * <p>
     * 在这里面写增强的逻辑。
     */

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // 在方法之前
        System.out.println("Befor....." + method.getName() + ":传递的参数" + Arrays.toString(args));
        // 被增强的方法
        Object res = method.invoke(obj, args);
        // 在方法之后
        System.out.println("After.....  " + obj);

        return res;
    }
}
