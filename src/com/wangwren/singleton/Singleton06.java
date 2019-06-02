package com.wangwren.singleton;

/**
 * 静态内部类方式。
 * 由JVM保证单例，线程安全。
 *
 * 加载外部类时，不会加载内部类，这样可以实现懒加载
 */
public class Singleton06 {

    private Singleton06(){}

    //静态内部类
    private static class Singleton06Holder{
        /**
         * 由于Singleton06构造方法私有，外部无法创建实例，但是内部类可以。
         * 外部06类加载不会加载内部类，而且06只加载一次。
         * 内部类只有在使用时会被加载，由内部类创建外部类实例，由于外部类只加载了一次，所以也就只有一个实例
         */
        private static final Singleton06 INSTANCE = new Singleton06();
    }

    public static Singleton06 getInstance(){
        return Singleton06Holder.INSTANCE;
    }

    public void m(){
        System.out.println("m");
    }
}
