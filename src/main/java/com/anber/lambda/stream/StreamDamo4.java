package com.anber.lambda.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author anber
 * @date 2018/9/29
 **/
public class StreamDamo4 {

    public static void main(String[] args) {
        String str = "my name is 007";

        //使用并行流
        str.chars().parallel().forEach(s -> System.out.print((char)s));
        System.out.println();
        //使用forEachOrdered保证顺序
        str.chars().parallel().forEachOrdered(s -> System.out.print((char)s));
        //收集到list
        List<String> list = Stream.of(str.split(" ")).collect(Collectors.toList());
        System.out.println(list);


        //使用reduce拼接字符串
        Optional<String> letters = Stream.of(str.split(" ")).reduce((s1, s2) -> s1 + "|" + s2);
        System.out.println(letters.orElse(""));

        //带有初始化值得reduce
        String reduce = Stream.of(str.split(" ")).reduce("", (s1, s2) -> s1 + "|" + s2);
        System.out.println(reduce);
        //计算单词总长度
        Integer length = Stream.of(str.split(" ")).map(s -> s.length()).reduce(0, (s1, s2) -> s1 + s2);
        System.out.println(length);

        //max的使用
        Optional<String> max = Stream.of(str.split(" ")).max(Comparator.comparingInt(s -> s.length()));
        System.out.println(max.orElse(""));

        //使用findFirst短路操作
        OptionalInt first = new Random().ints().findFirst();
        System.out.println(first.getAsInt());

    }
}
