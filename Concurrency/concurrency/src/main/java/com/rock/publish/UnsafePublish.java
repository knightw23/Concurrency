package com.rock.publish;

import com.rock.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
@NotThreadSafe
public class UnsafePublish {

    private String[] strs = {"a", "b", "c"};

    public String[] getStrs() {
        return strs;
    }

    public static void main(String[] args) {
        /**
         * 这样发布的对象是不安全的，因为别的线程一样可以通过getStrs() 方法获取的到数组
         * 然后改变里面的值。这样别的线程取的值就不一样
         */
        UnsafePublish unsafePublish = new UnsafePublish();
        log.info("当前数组的值为：{}", Arrays.toString(unsafePublish.getStrs()));
        String[] strs = unsafePublish.getStrs();
        strs[0] = "aaa";
        log.info("当前数组的值为：{}", Arrays.toString(unsafePublish.getStrs()));
    }
}
