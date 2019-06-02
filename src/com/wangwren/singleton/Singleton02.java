package com.wangwren.singleton;

/**
 * @author wwr
 *
 * lazy loading
 * 懒汉式：
 *  虽然达到了按需初始化的目的，但是带来了线程不安全的问题
 *
 */
public class Singleton02 {
    private static Singleton02 INSTANCE;

    private Singleton02(){}

    public static Singleton02 getInstance(){
        if (INSTANCE == null){

            //模拟线程,让线程睡1毫秒，这样有机会让别的线程进入到if中来，导致创建多个实例，线程不安全
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return INSTANCE = new Singleton02();
        }
        return INSTANCE;
    }

    public void m(){
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0 ; i < 100 ; i ++){
            new Thread(() -> {
                //创建100个线程，获取Singleton02实例，如果实例不一样那么hashCode值一定不同
                System.out.println(Singleton02.getInstance().hashCode());
            }).start();
        }
    }
}
