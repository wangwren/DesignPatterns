package com.wangwren.strategy;

import java.util.Arrays;

/**
 * writing tests first!
 * extreme programming
 */
public class Main {
    public static void main(String[] args) {
        //int[] a = {9, 2, 3, 5, 7, 1, 4};
        Cat[] a = {new Cat(3, 3), new Cat(5, 5), new Cat(1, 1)};
        //Dog[] a = {new Dog(3), new Dog(5), new Dog(1)};
        Sorter<Cat> sorter = new Sorter<>();

        //使用lambda表达式，可以替换策略模式，需要保证接口中只有一个抽象类
        //使用lambda其实并不灵活，相当于写死在程序里了
        sorter.sort(a, (o1, o2)->{
            if(o1.weight < o2.weight) {
                return -1;
            } else if (o1.weight>o2.weight){
                return 1;
            } else{
                return 0;
            }
        });
        System.out.println(Arrays.toString(a));
    }
}
