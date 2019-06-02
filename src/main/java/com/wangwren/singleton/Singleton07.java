package com.wangwren.singleton;

/**
 * @author wwr
 * 枚举单例
 *  不仅可以解决线程同步问题，还可以解决反序列化。
 *
 *  该方式是由Java创始人之一在Effective Java书中提到的。
 *  可以说是完美中的完美。
 *
 *  反序列化问题：
 *      以上单例模式，都没有办法解决反序列化，即可以通过反射的方式，再实例化得到对象。
 *      但是枚举单例反序列化后，得到的还是对应的值(或称对象)，没法实例化得到对象。
 */
public enum Singleton07 {

    INSTANCE;

    public void m(){
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Singleton07.INSTANCE.hashCode());
            }).start();
        }
    }
}
