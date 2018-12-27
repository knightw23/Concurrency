package com.rock.singleton;

import com.rock.annoations.Recommend;
import com.rock.annoations.ThreadSafe;
import org.springframework.util.CollectionUtils;


/**
 * 枚举模式，最安全的
 * 推荐使用
 */
@ThreadSafe
@Recommend
public class SingletonExample7 {

    /**
     * 私有构造方法
     */
    private SingletonExample7() {
        System.out.println("");
    }

    public static SingletonExample7 getSingletonExample7() {
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton {
        INSTANCE;

        private SingletonExample7 instance;

        //JVM保证这个方法只被调用一次，绝对的
        Singleton() {
            instance = new SingletonExample7();
        }

        private SingletonExample7 getInstance() {
            return instance;
        }
    }

    public static void main(String[] args) {

        System.out.println("============="+Singleton.INSTANCE);
        System.out.println("============="+Singleton.INSTANCE);
    }
}
