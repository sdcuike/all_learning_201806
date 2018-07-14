package com.sdcuike.rxjava;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

import java.util.concurrent.TimeUnit;

/**
 * @author sdcuike
 * @date 2018/6/7
 * @since 2018/6/7
 */
public class HelloWorld {
    
    public static void main(String[] args) throws InterruptedException {
        hello("doctor who");
        hello("doctor who", "sjdf");
        
        System.out.println("========");
        helloTransform("神秘博士", "法师", "无垠的天空");
        System.out.println("========");
        interval();
        
        TimeUnit.SECONDS.sleep(10);
        
    }
    
    
    public static void hello(String... args) {
        Observable.fromArray(args).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println(Thread.currentThread().getName() + " : " + s);
            }
        });
    }
    
    public static void helloTransform(String... args) {
        Observable.fromArray(args)
                  .map(arg -> Thread.currentThread().getName() + ": hello " + arg + " !!")
                  .subscribe(System.out::println);
    }
    
    
    public static void interval() {
        Observable.interval(1, TimeUnit.SECONDS)
                  .subscribe(System.out::println);
    }
}
