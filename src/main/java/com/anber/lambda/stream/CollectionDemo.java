package com.anber.lambda.stream;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 收集器
 * @author anber
 * @date 2018/9/29
 **/

class Student{

    public static final String MAN = "男";

    public static final String WOMEN = "女";

    private String name;

    private Integer age;

    private String sex;

    private String group;

    public Student() {
    }

    public Student(String name, Integer age, String sex, String group) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", group='" + group + '\'' +
                '}';
    }
}
public class CollectionDemo {

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        Student student1 = new Student("张三", 12, Student.MAN, "one");
        Student student2 = new Student("李四", 18, Student.MAN, "one");
        Student student3 = new Student("小丽", 20, Student.WOMEN, "two");
        Student student4 = new Student("小红", 22, Student.WOMEN, "two");
        Student student5 = new Student("王二", 25, Student.WOMEN, "three");
        Student student6 = new Student("王五", 30, Student.WOMEN, "three");
        Student student7 = new Student("小A", 60, Student.MAN, "four");
        Student student8 = new Student("小B", 50, Student.MAN, "four");
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);
        list.add(student5);
        list.add(student6);
        list.add(student7);
        list.add(student8);

        //得到所有学生的年龄列表
        //s->s.getAge()  --> Student::getAge,不会多生成一个类似lambda$0的函数
        Set<Integer> ages = list.stream()
                .map(Student::getAge)
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println("学生的年龄列表:" + ages);

        //统计汇总信息
        IntSummaryStatistics ageSummaryStatistics = list.stream().collect(Collectors.summarizingInt(Student::getAge));
        System.out.println("年龄统计汇总信息:" + ageSummaryStatistics);

        //分块
        Map<Boolean, List<Student>> genders = list.stream().collect(Collectors.partitioningBy(s -> s.getSex().equals(Student.MAN)));
        System.out.println("男女学生列表:" + genders);

        //分组
        Map<String, List<Student>> graders = list.stream().collect(Collectors.groupingBy(Student::getGroup));
        System.out.println("学生班级列表:" + graders);

        //得到所有班级学生的个数
        Map<String, Long> gradersCount = list.stream().collect(Collectors.groupingBy(Student::getGroup, Collectors.counting()));
        System.out.println("班级学生个数列表:" + gradersCount);
    }
}
