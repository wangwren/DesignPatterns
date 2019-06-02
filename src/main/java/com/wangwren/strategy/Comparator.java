package com.wangwren.strategy;

/**
 * @author wwr
 * @param <T>
 *
 * 策略设计模式：
 *  Java中Comparator算是使用了策略设计模式
 *  Comparable没有使用策略设计模式
 */
@FunctionalInterface
public interface Comparator<T> {
    int compare(T o1, T o2);

    default void m() {
        System.out.println("m");
    }
}
