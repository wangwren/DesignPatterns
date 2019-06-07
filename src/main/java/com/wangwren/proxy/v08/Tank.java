package com.wangwren.proxy.v08;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

/**
 * 问题：我想记录坦克的移动时间
 * 最简单的办法：修改代码，记录时间
 * 问题2：如果无法改变方法源码呢？
 * 用继承？
 * v05:使用代理
 * v06:代理有各种类型
 * 问题：如何实现代理的各种组合？继承？Decorator?
 * v07:代理的对象改成Movable类型-越来越像decorator了
 * v08:如果有stop方法需要代理...
 * 如果想让LogProxy可以重用，不仅可以代理Tank，还可以代理任何其他可以代理的类型 Object
 * （毕竟日志记录，时间计算是很多方法都需要的东西），这时该怎么做呢？
 * 分离代理行为与被代理对象
 * 使用jdk的动态代理
 */
public class Tank implements Movable {

    /**
     * 模拟坦克移动了一段儿时间
     */
    @Override
    public void move() {
        System.out.println("Tank moving claclacla...");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Tank tank = new Tank();

        //reflection 反射 通过二进制字节码分析类的属性和方法
        //参数说明：第一个参数，生成代理类需要加载到内存中用的ClassLoader
        //第二个参数，代理类需要实现的接口，JDK的代理必须要实现接口
        //**jdk反射生成代理必须面向接口，这是由Proxy的内部实现决定的**
        //第三个参数，代理类需要做的事情，需要实现InvocationHandler接口，实现invoke方法，在该方法中做需要做的事情
        Movable m = (Movable)Proxy.newProxyInstance(Tank.class.getClassLoader(),
                new Class[]{Movable.class}, //tank.class.getInterfaces()
                new LogHander(tank)
        );

        //这里m调用的move方法是调用的生成的代理实现了Movable接口的move方法
        //之后在move方法中调用了LogHander的invoke方法
        m.move();
    }
}

class LogHander implements InvocationHandler {

    Tank tank;

    public LogHander(Tank tank) {
        this.tank = tank;
    }
    //getClass.getMethods[],获取一个类的所有方法

    /**
     *
     * @param proxy 生成的代码对象，其实就是上面的 m
     * @param method 调的是哪个方法，这里的method就是move
     * @param args 往调的那个方法里传的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("method " + method.getName() + " start..");
        //调用move方法，相当于tank.move()
        Object o = method.invoke(tank, args);
        System.out.println("method " + method.getName() + " end!");
        return o;
    }
}



interface Movable {
    void move();
}