package com.anber.lambda.lambda;

import java.util.function.Consumer;

/**
 * 变量引用
 * @author anber
 * @date 2018/9/28
 **/
public class VarDemo {

    public static void main(String[] args) {
        String str = "我的时间";
//        str = ""; 在jdk1.8之前 内部类引用外部变量 变量必须是final类型的
        //在jdk1.8中 实际上也是需要的 只是默认不写 但实际上给你前面加上了final
        Consumer<String> consumer = s -> System.out.println(s + str);
        consumer.accept("111");
    }

}
