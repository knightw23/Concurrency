package com.rock.singleton;

import com.rock.annoations.NotThreadSafe;

/**
 * 懒汉模式
 * 单例的实例在第一次使用的时候进行创建
 *
 * 存在问题：
 * 在单线程的情况下这里是没有问题的
 * 如果在多线程的情况下
 * 线程1 已经进入了 if (singletonExample1 == null) 判断
 * 在创建对象的时候，，，这个时候，线程1的初始化对象没有完成
 * 线程2依旧进入if判断这样又会重新创建一个对象
 * 这样就可能出现两次初始化SingletonExample1对象
 */
@NotThreadSafe
public class SingletonExample1 {

    /**
     * 私有构造方法
     */
    private SingletonExample1() {

    }

    /**
     * 单例对象
     */
    private static SingletonExample1 singletonExample1 = null;

    /**
     * 静态工厂方法，用于创建单例对象
     *
     * @return 单例对象
     */
    public static SingletonExample1 getSingletonExample1() {
        if (singletonExample1 == null) {
            singletonExample1 = new SingletonExample1();
        }
        return singletonExample1;
    }
}
