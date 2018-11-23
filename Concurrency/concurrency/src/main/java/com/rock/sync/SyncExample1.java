package com.rock.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class SyncExample1 {

    //修饰类 作用于该类所有对象
    public static void test1(int j) {
        synchronized (SyncExample1.class) {
            for (int i = 0; i < 10; i++) {
                log.info("test1 {}------ {}", j, i);
            }
        }
    }

    //修饰静态方法 作用于这个类的所有对象
    public static synchronized void test2(int j) {
        for (int i = 0; i < 10; i++) {
            log.info("test2  {}-------------------{}", j, i);
        }
    }

    public static void main(String[] args) {

        //region 修饰代码块测试 test1方法

       /* SyncExample1 syncExample = new SyncExample1();
        ExecutorService executors = Executors.newCachedThreadPool();
        executors.execute(() -> {
            syncExample.test1(1);
        });

        executors.execute(() -> {
            syncExample.test1(2);
        });*/

        SyncExample1 syncExample = new SyncExample1();
        SyncExample1 example = new SyncExample1();
        ExecutorService executors = Executors.newCachedThreadPool();
        executors.execute(() -> {
            syncExample.test1(1);
        });
        executors.execute(() -> {
            example.test1(2);
        });
        //endregion

        //region 修饰静态方法测试 test2方法
        /*SyncExample1 syncExample = new SyncExample1();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            syncExample.test2(1);
        });
        executorService.execute(() -> {
            syncExample.test2(2);
        });*/

       /* SyncExample1 syncExample = new SyncExample1();
        SyncExample1 syncExample1 = new SyncExample1();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            syncExample.test2(1);
        });
        executorService.execute(() -> {
            syncExample1.test2(2);
        });*/
        //endregion

    }
}
