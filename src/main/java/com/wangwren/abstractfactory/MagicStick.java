package com.wangwren.abstractfactory;

/**
 * 具体产品
 */
public class MagicStick extends Weapon{
    @Override
    public void shoot() {
        System.out.println("diandian....");
    }
}
