package com.wangwren.singleton;

/**
 * @author wwr
 * lazy loading
 * 懒汉式：
 *  Singleton02懒汉式可以通过加锁的方式解决。
 *  在方法上加锁，保证了线程安全，但也带来效率下降
 */
public class Singleton03 {
    private static Singleton03 INSTANCE;

    private Singleton03(){}

    public static synchronized Singleton03 getInstance(){
        if (INSTANCE == null){

            //模拟多线程访问
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return INSTANCE = new Singleton03();
        }
        return INSTANCE;
    }

    public void m(){
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0 ; i < 100 ; i ++){
            new Thread(() -> {
                System.out.println(Singleton03.getInstance().hashCode());
            }).start();
        }
    }
}
