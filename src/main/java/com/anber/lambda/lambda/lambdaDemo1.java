package com.anber.lambda.lambda;

/**
 * @author anber
 * @date 2018/9/25
 **/
public class lambdaDemo1 {
    /**
     * @FunctionalInterface 这个注解是jdk8的标注函数式接口,一个函数式接口只能有一个要实现的方法
     */
    @FunctionalInterface
    interface Inter{
        int doubleNum(int i);

        /**
         * 默认实现方法,这是jdk8中比较重要的新特性
         * @param i
         * @param j
         * @return
         */
        default int add(int i, int j) {
            return i + j;
        }
    }

    @FunctionalInterface
    interface Inter2{
        int doubleNum(int i);

        /**
         * 默认实现方法,这是jdk8中比较重要的新特性
         * @param i
         * @param j
         * @return
         */
        default int add(int i, int j) {
            return i + j;
        }
    }

    @FunctionalInterface
    interface Inter3 extends Inter, Inter2{

        @Override
        default int add(int i, int j) {
            return Inter.super.add(i, j);
        }
    }

    public static void main(String[] args) {
        Inter inter1 = (i) -> i * 2;

        System.out.println(inter1.add(2,3));
        System.out.println(inter1.doubleNum(20));

        //这种是最常见的
        Inter inter2 = i -> i * 2;

        Inter inter3 = (int i) -> i * 2;

        Inter inter4 = i -> {
            return i * 2;
        };
    }
}
