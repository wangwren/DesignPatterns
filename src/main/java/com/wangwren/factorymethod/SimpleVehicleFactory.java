package com.wangwren.factorymethod;

/**
 * @author wwr
 * 简单工厂的可扩展性不好
 *
 * 简单工厂，在产品上扩展性好，但是在产品族上不行。
 */
public class SimpleVehicleFactory {
    public Car createCar() {
        //before processing
        return new Car();
    }

    public Broom createBroom() {
        return new Broom();
    }
}
