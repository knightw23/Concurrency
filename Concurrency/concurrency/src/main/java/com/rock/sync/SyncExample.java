package com.rock.sync;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SyncExample {

    //修饰代码块 作用于调用对象
    public void test1(int j) {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                log.info("test1 {}------ {}", j, i);
            }
        }
    }

    //修饰方法 作用于调用对象
    public synchronized void test2(int j) {
        for (int i = 0; i < 10; i++) {
            log.info("test2  {}-------------------{}", j, i);
        }
    }

    public static void main(String[] args) {

        //region 修饰代码块测试 test1方法

        /*SyncExample syncExample = new SyncExample();
        ExecutorService executors = Executors.newCachedThreadPool();
        executors.execute(() -> {
            syncExample.test1(1);
        });

        executors.execute(() -> {
            syncExample.test1(2);
        });*/

       /* SyncExample syncExample = new SyncExample();
        SyncExample example = new SyncExample();
        ExecutorService executors = Executors.newCachedThreadPool();
        executors.execute(() -> {
            syncExample.test1(1);
        });
        executors.execute(() -> {
            example.test1(2);
        });*/
        //endregion

        //region 修饰方法测试 test2方法
      /*  SyncExample syncExample = new SyncExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            syncExample.test2(1);
        });
        executorService.execute(() -> {
            syncExample.test2(2);
        });*/

      /*  SyncExample syncExample = new SyncExample();
        SyncExample syncExample1 = new SyncExample();
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
