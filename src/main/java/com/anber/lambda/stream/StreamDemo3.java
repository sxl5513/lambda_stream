package com.anber.lambda.stream;

import java.util.Random;
import java.util.stream.Stream;

/**
 * @author anber
 * @date 2018/9/29
 **/
public class StreamDemo3 {

    public static void main(String[] args) {
        String str = "my name is 007";

        //把每个单词的长度打印出来
        Stream.of(str.split(" ")).filter(s -> s.length() > 2).map(s -> s.length()).forEach(System.out::println);

        //flatMap A->B的属性(是个集合),最终得到所有A元素里面的所有B属性的集合
        //IntStream/LongStream不是stream的子类,所以需要装箱 boxed
        Stream.of(str.split(" ")).flatMap(s -> s.chars().boxed()).forEach(
                i -> System.out.println((char)i.intValue())
        );

        System.out.println("----------peek-------------");
        //peek 用于debug 是中间操作,和foreach是终止操作
        Stream.of(str.split(" ")).peek(System.out::println).forEach(System.out::println);

        //limit使用,主要用于无限流
        new Random().ints().filter(x -> x > 500 && x < 10000).limit(10).forEach(System.out::println);
    }
}
