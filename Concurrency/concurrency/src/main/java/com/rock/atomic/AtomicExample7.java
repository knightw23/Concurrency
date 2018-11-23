package com.rock.atomic;

import com.rock.annoations.ThreadSafe;
import com.sun.org.apache.bcel.internal.generic.NEW;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicStampedReference;

@Slf4j
@ThreadSafe
public class AtomicExample7 {

    public static void main(String[] args) throws Exception {
        int numberA = 10;
        int numberB = 100;
        AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<Integer>(numberA, 1);

        /**
         * compareAndSet 参数说明
         * 第一个参数：原始值
         * 第二个参数：修改后的值
         * 第三个参数：期望版本号
         * 第四个参数：更改之后的版本号
         */
        boolean result = atomicStampedReference.compareAndSet(numberA, numberB, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
        if (result) {
            log.info("修改成功");
            log.info("版本号为：{}", atomicStampedReference.getStamp());
        }

        /**
         * 因为上一次修改之后版本号为2 ，这里我们期望版本号为3 所以修改失败
         */
        boolean result2 = atomicStampedReference.compareAndSet(numberA, numberB, 3, atomicStampedReference.getStamp() + 1);
        if (!result2) {
            log.info("修改失败");
        }


        log.info("更改后的版本号:{}", atomicStampedReference.getStamp());
        log.info("更改后的值为:{}", atomicStampedReference.getReference());

    }
}
