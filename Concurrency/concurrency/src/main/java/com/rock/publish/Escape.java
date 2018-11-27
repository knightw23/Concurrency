package com.rock.publish;

import com.rock.annoations.NotRecommend;
import com.rock.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 对象溢出
 */
@Slf4j
@NotThreadSafe
@NotRecommend
public class Escape {

    private int number = 10;

    public Escape() {
        new InnerClass();
    }

    class InnerClass {

        public InnerClass() {
            log.info("{}", Escape.this.number);
        }
    }

    public static void main(String[] args) {
        /**
         * 在Escape的构造方法中，实例化了一个InnerClass对象
         * 在InnerClass的构造方法中调用了Escape这时候的Escape对象是有可能没有构造完成的
         * 所以就造成了对象溢出
         * 所以在对象未完成构造之前不允许发布
         *
         */
        new Escape();
    }
}
