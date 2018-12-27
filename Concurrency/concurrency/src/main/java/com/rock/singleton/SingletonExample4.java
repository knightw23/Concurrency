package com.rock.singleton;

import com.rock.annoations.NotRecommend;
import com.rock.annoations.NotThreadSafe;

/**
 * 懒汉模式 双重同步锁单例模式
 * 单例的实例在第一次使用的时候进行创建
 * <p>
 * 实例化对象的时候进行的操作
 * 1、分配对象内存空间
 * 2、初始化对象
 * 3、将对象指向该内存地址
 * <p>
 * 存在问题：
 * JVM和CPU优化，出现指令重排
 * 1、分配对象内存空间
 * 3、将对象指向该内存地址
 * 2、初始化对象
 * <p>
 * 如果出现指令重排，线程一：进行初始化对象，进入到了singletonExample1 = new SingletonExample4();
 * 这个时候，只是进行到指令重排后的第二步操作，也就是将对象指向内存地址，并没有初始化
 * 线程二：调用该方法，这个时候会发现singletonExample1 != null,就直接返回。使用实例去直接调用就会出现问题
 */
@NotThreadSafe
@NotRecommend
public class SingletonExample4 {

    /**
     * 私有构造方法
     */
    private SingletonExample4() {

    }

    /**
     * 单例对象
     */
    private static SingletonExample4 singletonExample1 = null;


    /**
     * 静态工厂方法，用于创建单例对象
     *
     * @return 单例对象
     */
    public static SingletonExample4 getSingletonExample1() {
        if (singletonExample1 == null) {
            synchronized (SingletonExample1.class) {
                if (singletonExample1 == null) {
                    singletonExample1 = new SingletonExample4();
                }
            }
        }
        return singletonExample1;
    }
}
