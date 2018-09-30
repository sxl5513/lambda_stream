package com.anber.lambda.stream;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author anber
 * @date 2018/9/29
 **/
public class StreamDemo4 {

    public static void main(String[] args) {
        //调用parallel 产生一个并行流
//        IntStream.range(1, 100).parallel().peek(StreamDemo4::debug).count();

        //现在要实现一个这样的效果:
        //多次调用 parallel/sequential 以最后一次调用为准
//        IntStream.range(1, 100)
//                //调用parallel产生并行流
//                .parallel()
//                .peek(StreamDemo4::debug)
//                //调用sequential产生串行流
//                .sequential()
//                .peek(StreamDemo4::debug2)
//                .count();

        //并行流使用的线程池: ForkJoinPool.commonPool
        //默认的线程数是当前机器上的cpu个数
        //使用这个属性可以修改默认线程数
//        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "20");
//        IntStream.range(1, 100).parallel().peek(StreamDemo4::debug).count();

        //使用自己创建的线程池,不适用默认的线程池,防止任务被阻塞
        //线程名为:ForkJoinPool-1
        ForkJoinPool pool = new ForkJoinPool(20);
        pool.execute(() -> IntStream.range(1, 100).parallel().peek(StreamDemo4::debug).count());
        pool.shutdown();

        synchronized (pool) {
            try {
                pool.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private static void debug(int i) {
        System.out.println(Thread.currentThread().getName() + "debug: " + i);

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void debug2(int i) {
        System.err.println("debug2: " + i);

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
