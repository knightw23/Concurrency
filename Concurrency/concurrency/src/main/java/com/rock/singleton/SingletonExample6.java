package com.rock.singleton;

import com.rock.annoations.ThreadSafe;

/**
 * 饿汉模式
 * 在类装载的时候创建
 * <p>
 * 存在问题：
 * 使用静态代码块加载类的时候，定义静态变量要写在静态代码块之前
 * 不同的静态代码块是按顺序执行的
 * <p>
 * 使用注意：
 * 构造方法中不存在过多的处理
 * 加载了，一定会使用
 */
@ThreadSafe
public class SingletonExample6 {

    /**
     * 私有构造方法
     */
    private SingletonExample6() {

    }

    static {
        singletonExample1 = new SingletonExample6();
    }

    /**
     * 单例对象
     */
    private static SingletonExample6 singletonExample1 = null;

    /**
     * 静态工厂方法，用于创建单例对象
     *
     * @return 单例对象
     */
    public static SingletonExample6 getSingletonExample1() {
        return singletonExample1;
    }

    public static void main(String[] args) {
        System.out.println(getSingletonExample1());
    }
}
