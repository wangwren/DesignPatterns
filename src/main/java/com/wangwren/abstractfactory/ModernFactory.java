package com.wangwren.abstractfactory;

/**
 * 具体工厂：需要实现抽象工厂，该工厂属于现代族，生成的都是现代人需要用到的东西
 */
public class ModernFactory extends AbastractFactory {
    @Override
    Food createFood() {
        return new Bread();
    }

    @Override
    Vehicle createVehicle() {
        return new Car();
    }

    @Override
    Weapon createWeapon() {
        return new AK47();
    }
}
