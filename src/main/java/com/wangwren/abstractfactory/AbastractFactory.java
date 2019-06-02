package com.wangwren.abstractfactory;

/**
 * @author wwr
 * 抽象工厂：
 *  包含抽象方法，可以生产一族产品。
 */
public abstract class AbastractFactory {

    abstract Food createFood();

    abstract Vehicle createVehicle();

    abstract Weapon createWeapon();
}
