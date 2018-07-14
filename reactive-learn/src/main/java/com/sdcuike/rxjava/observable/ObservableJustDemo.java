package com.sdcuike.rxjava.observable;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

/**
 * @author sdcuike
 * @date 2018/6/7
 * @since 2018/6/7
 */
public class ObservableJustDemo {
    public static void main(String[] args) {
    
        Observable.just(1,3,4,66,88)
                  .subscribe(System.out::println);
        System.out.println("===================");
    
         List<Integer> list = Arrays.asList(11, 33, 222, 55, 666, 88);
         Observable.fromIterable(list)
                   .subscribe(System.out::println);
    }
}
