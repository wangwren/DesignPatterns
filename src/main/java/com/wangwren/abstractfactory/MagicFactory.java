package com.wangwren.abstractfactory;

/**
 * 具体工厂：该工厂属于魔法族，注意这里是族。
 *  继承抽象工厂，生成的都是魔法族需要用到的产品
 */
public class MagicFactory extends AbastractFactory {
    @Override
    Food createFood() {
        return new MushRoom();
    }

    @Override
    Vehicle createVehicle() {
        return new Broom();
    }

    @Override
    Weapon createWeapon() {
        return new MagicStick();
    }
}
