package com.sdcuike.rxjava.observable;


import io.reactivex.Observable;

/**
 * Observable push数据，数据源自己提供demo
 *
 * @author sdcuike
 * @date 2018/6/7
 * @since 2018/6/7
 */
public class ObservableCreateDemo {
    public static void main(String[] args) {
        Observable.create(emitter -> {
            try {
                emitter.onNext(1);
                if (true) {
//                    throw new RuntimeException("error test");
                }
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onNext("hello");
                emitter.onComplete();
            } catch (Exception e) {
                emitter.onError(e);
            }
        }).subscribe(System.out::println);
    }
}
