package com.wangwren.singleton;

/**
 * @author wwr
 * 懒汉式：
 *  双重检查，双检锁方式。
 *
 *  这种方式可以说是完美了，但是有点复杂。
 */
public class Singleton05 {
    private static Singleton05 INSTANCE;

    private Singleton05(){}

    public static Singleton05 getInstance(){
        if (INSTANCE == null){
            //外层if是有必要的，因为多线程访问时，有的线程在第一个if判断时就会直接返回。
            synchronized (Singleton05.class){
                if (INSTANCE == null){
                    return INSTANCE = new Singleton05();
                }
            }
        }
        return INSTANCE;
    }

    public void m(){
        System.out.println("m");
    }
}
