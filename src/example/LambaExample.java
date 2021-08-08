package example;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambaExample {
    public static boolean testPredicate(Predicate predicate,String t){
        return  predicate.test(t);
    }
    public static boolean testPredicate2(Predicate predicate1,Predicate predicate2,String t){
        return  predicate1.and(predicate2).test(t);
    }

    public static  Object  testSupplier(Supplier supplier){
        return supplier.get();
    }

    public static  void   testConsumer(Consumer consumer,String str){
        consumer.accept(str);
    }

    public static  void   testConsumer2(Consumer consumer,Consumer consumer2,String str){
        consumer.andThen(consumer2).accept(str);
    }

    public static  int  testFunction(Function function,String str){
        return (int) function.apply(str);
    }

    public static  int  testFunction2(Function function,Function function2,String str){
        return (int) function.andThen(function2).apply(str);
    }
}
