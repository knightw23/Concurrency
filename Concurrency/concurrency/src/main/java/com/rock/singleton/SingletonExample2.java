package com.rock.singleton;

import com.rock.annoations.NotThreadSafe;
import com.rock.annoations.ThreadSafe;

/**
 * 饿汉模式
 * 在类装载的时候创建
 * <p>
 * 存在问题：
 * 如果构造方法中存在很多处理就会导致该类加载过慢
 * 如果只加载了，而不使用的话会造成资源的浪费
 *
 * 使用注意：
 * 构造方法中不存在过多的处理
 * 加载了，一定会使用
 */
@ThreadSafe
public class SingletonExample2 {

    /**
     * 私有构造方法
     */
    private SingletonExample2() {

    }

    /**
     * 单例对象
     */
    private static SingletonExample2 singletonExample1 = new SingletonExample2();

    /**
     * 静态工厂方法，用于创建单例对象
     *
     * @return 单例对象
     */
    public static SingletonExample2 getSingletonExample1() {
        return singletonExample1;
    }
}
