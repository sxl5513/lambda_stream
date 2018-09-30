package com.anber.lambda.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

/**
 * @author anber
 * @date 2018/9/25
 **/

class Dog{

    private String name = "哮天犬";

    private int food = 10;

    public Dog() {
    }

    public Dog(String name) {
        this.name = name;
    }

    /**
     * 狗叫,静态方法
     * @param dog
     */
    public static void bark(Dog dog) {
        System.out.println(dog + "叫了");
    }

    /**
     * 吃狗粮
     * @param num
     * @return 还剩下多少斤
     */
    public int eat(int num) {
        System.out.println("吃了" + num + "斤");
        this.food -= num;
        return this.food;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class MethodRefrenceDemo {


    public static void main(String[] args) {
        //    Consumer<String> consumer = s -> System.out.println(s);
        //方法引用
        Consumer<String> consumer = System.out::println;
        consumer.accept("bbbbbbb");

        //静态方法的引用  Consumer默认调该类的toString()方法
        Consumer<Dog> dogConsumer = Dog::bark;
        Dog dog = new Dog();
        dogConsumer.accept(dog);

        //非静态方法, 使用对象实例的方法引用
//        Function<Integer, Integer> function = dog::eat;
        //一元函数
//        UnaryOperator<Integer> function = dog::eat;
        //基本类型简写
        IntUnaryOperator function = dog::eat;
        System.out.println("还剩下" + function.applyAsInt(2) + "斤");

        //使用类名引用
        BiFunction<Dog, Integer, Integer> biFunction = Dog::eat;
        System.out.println("还剩下" + biFunction.apply(dog, 3) + "斤");

        //构造函数的方法引用
        Supplier<Dog> supplier = Dog::new;
        System.out.println("创建了新对象" + supplier.get());

        //有参数构造行数方法的引用
        Function<String, Dog> function1 = Dog::new;
        System.out.println("创建了新对象" + function1.apply("旺旺"));



        List<String> list = new ArrayList<>();

        test(list);
//        list = null;

        System.out.println(list);
    }

    //变量只是传值而不是传引用
    private static void test(List<String> list) {
        list = null;
    }


}
