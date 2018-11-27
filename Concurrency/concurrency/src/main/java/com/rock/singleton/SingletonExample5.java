package com.rock.singleton;

import com.rock.annoations.ThreadSafe;

/**
 * 懒汉模式 双重同步锁单例模式
 * 单例的实例在第一次使用的时候进行创建
 */
@ThreadSafe
public class SingletonExample5 {

    /**
     * 私有构造方法
     */
    private SingletonExample5() {

    }

    /**
     * 单例对象
     * volatile + 双重检测机制 ---> 禁止指令重排
     */
    private volatile static SingletonExample5 singletonExample1 = null;


    /**
     * 静态工厂方法，用于创建单例对象
     *
     * @return 单例对象
     */
    public static SingletonExample5 getSingletonExample1() {
        if (singletonExample1 == null) {//双重检测机制
            synchronized (SingletonExample1.class) {//同步锁
                if (singletonExample1 == null) {
                    singletonExample1 = new SingletonExample5();
                }
            }
        }
        return singletonExample1;
    }
}
