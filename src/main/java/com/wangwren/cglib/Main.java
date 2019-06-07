package com.wangwren.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Random;

/**
 * CGLIB实现动态代理不需要接口
 *
 * CGLIB是通过指定父类来生成代理类，即代理类是Tank的子类
 * CGLIB底层也是用的ASM来操作二进制，所以即使类是final类型的，也可以生成代理类
 */
public class Main {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        //指定父类
        enhancer.setSuperclass(Tank.class);
        //相当于new TimeMethodInterceptor() JDK的InvocationHandler
        enhancer.setCallback(new TimeMethodInterceptor());
        //生成代理类
        Tank tank = (Tank)enhancer.create();
        //代理类执行move方法，之后执行intercept方法
        tank.move();
    }
}

class TimeMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println(o.getClass().getSuperclass().getName());
        System.out.println("before");
        Object result = null;
        //执行Tank的move方法
        result = methodProxy.invokeSuper(o, objects);
        System.out.println("after");
        return result;
    }
}

class Tank {
    public void move() {
        System.out.println("Tank moving claclacla...");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


