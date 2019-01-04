package com.rock.threadLocal;

/**
 * 请求访问的时候需要存储的数据
 */
public class RequestHolder {

    private final static ThreadLocal<Long> requestHolder = new InheritableThreadLocal<>();

    public static void add(long id) {
        requestHolder.set(id);
    }

    public static Long getId() {
        return requestHolder.get();
    }

    public static void remove() {
        requestHolder.remove();
    }

}
