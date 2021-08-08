package test;


import example.LambaExample;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambaTest {

    @Test
    public void testPredicate(){
        boolean abc = LambaExample.testPredicate(a -> a.toString().length() > 0, "abc");
        Assert.assertTrue(abc);
    }

    @Test
    public void testPredicate2(){

        Predicate<String> p1 = a -> a.length()>0;
        Predicate<String> p2 = a -> a.length()<10;
        boolean abc = LambaExample.testPredicate2(p1,p2,"abc");
        boolean abc2 = LambaExample.testPredicate2(a->a.toString().length()>0, b->b.toString().length()<10,"abc222222222222");
        Assert.assertTrue(abc);
        Assert.assertTrue(abc2); //超出范围报错
    }
    
    

    @Test
    public void  testSupplier(){
        Object o = LambaExample.testSupplier(() -> 1);
        System.out.println(o);
    }

    @Test
    public void testConsumer(){
        LambaExample.testConsumer(s-> System.out.println("接受的参数"+s),"anc");

    }

    @Test
    public void testConsumer2(){
        LambaExample.testConsumer2(a -> {
            String[] split = a.toString().split(",");
            System.out.println(split[0]);
        },a->{
            String[] split = a.toString().split(",");
            System.out.println(split[1]);
        },"aaa,ccc");
    }

    @Test
    public   void testFunction(){
        int i = LambaExample.testFunction(s -> Integer.parseInt((String) s), "123");
        System.out.println(i);
    }

    @Test
    public   void testFunction2(){
        Function<Integer,Integer> p2 = (s)->{
            return s+12000;
        };
        int i = LambaExample.testFunction2(s -> Integer.parseInt((String) s), p2,"123");
        System.out.println(i);
    }

    //Predicete 还可以组合and or ..
    //Consumer 可以组合 andthen
    //Fucntion 可以组合 andThen , compose

    /**
     * map，或者数组可以转化成list 再转流
     */
    @Test
    public  void testStream(){
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("efc");
        list.add("lll");
        list.add("1232");

        list.stream().filter(a->a.contains("a")).forEach(System.out::println);
        list.stream().skip(2).forEach(System.out::println);

        //是否含有长度大于3的
        boolean b = list.stream().anyMatch(a -> a.length() > 3);
        System.out.println(b);

        //多管道
        list.stream().parallel().forEach(System.out::println);
        System.out.println("--------");
        list.stream().forEach(System.out::println);
    }

    @Test
    public void testArray(){
        String [] arr = new String[]{"abc","efg"};
        //通过Arrays把数组转化成stream
        Arrays.stream(arr).forEach(System.out::println);
        //通过Stream.of
        Stream<String> arr1 = Stream.of(arr);
        arr1.forEach(System.out::println);
        //流转list 通过collect 收集起来
        List<String> collect = arr1.collect(Collectors.toList());
        System.out.println(collect.toString());
    }

}
