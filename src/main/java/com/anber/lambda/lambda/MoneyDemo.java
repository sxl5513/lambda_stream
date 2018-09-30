package com.anber.lambda.lambda;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.function.Function;

/**
 * @author anber
 * @date 2018/9/25
 **/
interface IMoneyFormat{
    String format(int i);
}

class MyMoney{
    private final int money;

    public MyMoney(int money) {
        this.money = money;
    }

//    public void printMoney(IMoneyFormat moneyFormat) {
//        System.out.println("我的存款:" + moneyFormat.format(this.money));
//    }
    public void printMoney(Function<Integer, String> moneyFormat) {
    System.out.println("我的存款:" + moneyFormat.apply(this.money));
}
}

public class MoneyDemo {

    public static void main(String[] args) {
        MyMoney myMoney = new MyMoney(999999999);
        Function<Integer, String> integerStringFunction = i -> new DecimalFormat("#,###").format(i);
        //函数接口链式操作
        myMoney.printMoney(integerStringFunction.andThen(s -> "$" + s));
    }
}
