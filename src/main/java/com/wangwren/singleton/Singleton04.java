package com.wangwren.singleton;

/**
 * @author wwr
 * 懒汉式：
 *  试图缩小加锁范围，但是依然导致线程不安全
 */
public class Singleton04 {
    private static Singleton04 INSTANCE;

    private Singleton04(){}

    public static Singleton04 getInstance(){
        if (INSTANCE == null){
            //试图减少同步代码块来提升效率，但是导致线程不安全
            synchronized (Singleton04.class){

                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                return INSTANCE = new Singleton04();
            }
        }
        return INSTANCE;
    }

    public void m(){
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Singleton04.getInstance().hashCode());
            }).start();
        }
    }
}
