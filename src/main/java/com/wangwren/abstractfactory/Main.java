package com.wangwren.abstractfactory;

/**
 * 使用时，如果想要换别的工厂，需要将ModernFactory换成别的就可以了，之后生成一系列别的产品族。
 *
 * 抽象工厂在产品族的扩展上非常好，比如，现在加入一个火星族，只需要创建火星族的具体工厂，实现抽象工厂，返回需要的产品就可以了。
 * 但是，抽象工厂在产品的扩展上很麻烦。比如，现在在一个族上加别的产品，那么需要抽象抽象工厂，之后继承了该抽象工厂的类，
 *  都需要去实现该方法(即生产产品)
 */
public class Main {
    public static void main(String[] args) {
        //生成具体工厂
        AbastractFactory f = new ModernFactory();

        Vehicle c = f.createVehicle();
        c.go();
        Weapon w = f.createWeapon();
        w.shoot();
        Food b = f.createFood();
        b.printName();
    }
}
