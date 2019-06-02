package com.wangwren.abstractfactory;

/**
 * 具体产品
 */
public class Car extends Vehicle{

    @Override
    public void go() {
        System.out.println("Car go wuwuwuwuw....");
    }
}
