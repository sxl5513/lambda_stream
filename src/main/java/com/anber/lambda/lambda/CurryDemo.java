package com.anber.lambda.lambda;

import java.util.function.Function;

/**
 * 级联表达式和
 *
 * 柯里化:把对个参数的函数转化为只有一个参数的函数
 * 柯里化目的:把函数标准化了
 * 高阶函数:返回函数的函数
 *
 * @author anber
 * @date 2018/9/28
 **/
public class CurryDemo {

    public static void main(String[] args) {
        //实现了x+y的级联方式
        Function<Integer, Function<Integer, Integer>> function = x -> y -> x + y;
        System.out.println(function.apply(2).apply(3));

        Function<Integer, Function<Integer, Function<Integer, Integer>>> function1 = x -> y -> z -> x + y + z;
        System.out.println(function1.apply(2).apply(3).apply(4));

        int[] num = {2, 3, 4};
        Function f = function1;
        for (int i = 0; i < num.length; i++) {
            if (f instanceof Function) {
                Object o = f.apply(num[i]);
                if (o instanceof Function) {
                    f = (Function) o;
                } else {
                    System.out.println("调用结束,结果为:" + o);
                }
            }
        }
    }

}
