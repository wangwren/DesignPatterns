package com.wangwren.factorymethod;

/**
 * 汽车工厂类，用于生产汽车
 */
public class CarFactory {
    public Moveable create() {
        System.out.println("a car created!");
        return new Car();
    }
}
