package com.anber.lambda.lambda;

/**
 * @author anber
 * @date 2018/9/28
 **/
@FunctionalInterface
interface IMath{
    int add(int x, int y);
}

@FunctionalInterface
interface IMath2{
    int mul(int x, int y);
}

public class TypeDemo {

    public static void main(String[] args) {
        //变量类型定义
        IMath lambda = (x, y) -> x + y;

        //数组里
        IMath[] lambda1 = {(x, y) -> x + y};

        //强转
        Object lambda2 = (IMath)(x, y) -> x + y;

        //通过返回类型
        IMath lambda3 = createLambda();

        TypeDemo typeDemo = new TypeDemo();
        //当有两义性的时候,使用强转对应的接口解决
        typeDemo.test((IMath) (x, y) -> x + y);

    }

    public void test(IMath2 iMath) {

    }

    public void test(IMath iMath) {

    }

    public static IMath createLambda() {
        return (x, y) -> x + y;
    }
}
