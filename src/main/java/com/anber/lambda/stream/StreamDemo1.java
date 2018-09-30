package com.anber.lambda.stream;

import java.util.stream.IntStream;

/**
 * @author anber
 * @date 2018/9/29
 **/
public class StreamDemo1 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int sum = 0;
        //外部迭代
        for (int i : nums) {
            sum += i;
        }
        System.out.println("输出结果:" + sum);

        //使用stream内部迭代
        //这里面的map就是中间操作(返回stream的操作)
        //sum就是终止操作
//        int sum1 = IntStream.of(nums).map(i -> i * 2).sum();
        int sum1 = IntStream.of(nums).map(StreamDemo1::doubleSum).sum();
        System.out.println("输出结果:" + sum1);

        System.out.println("惰性求值就是终止没有调用的情况下,中间操作不会执行  ");
        IntStream.of(nums).map(StreamDemo1::doubleSum);
    }

    public static int doubleSum(int i){
        System.out.println("这里执行乘以2的操作");
        return i * 2;
    }
}