package com.rock.singleton;

import com.rock.annoations.NotRecommend;
import com.rock.annoations.NotThreadSafe;
import com.rock.annoations.ThreadSafe;

/**
 * 懒汉模式
 * 单例的实例在第一次使用的时候进行创建
 * <p>
 * 存在问题：
 * 如果加了synchronized关键字，同一时间只能一个线程访问该方法
 * 会将性能降低
 */
@ThreadSafe
@NotRecommend
public class SingletonExample3 {

    /**
     * 私有构造方法
     */
    private SingletonExample3() {

    }

    /**
     * 单例对象
     */
    private static SingletonExample3 singletonExample1 = null;

    /**
     * 静态工厂方法，用于创建单例对象
     *
     * @return 单例对象
     */
    public static synchronized SingletonExample3 getSingletonExample1() {
        if (singletonExample1 == null) {
            singletonExample1 = new SingletonExample3();
        }
        return singletonExample1;
    }
}
