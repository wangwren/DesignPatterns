package com.wangwren.singleton;

/**
 * @author wwr
 * 单例模式：
 *  饿汉式。
 *  类加载到内存后，就实例化一个单例，JVM保证线程安全！。
 *  简单实用，推荐。
 *
 *  唯一缺点：不管是否使用该类，类装载时就完成实例化。
 *
 *  平常用这个就可以了，如果追求完美继续。
 */
public class Singleton01 {

    private static final Singleton01 INSTANCE = new Singleton01();

    private Singleton01(){}

    public static Singleton01 getInstance(){
        return INSTANCE;
    }

    public void m(){
        System.out.println("m");
    }
}
