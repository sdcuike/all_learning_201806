package com.sdcuike.dubbo.learning.service;

import com.alibaba.fastjson.JSONObject;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author sdcuike
 * @date 2018/5/31
 * @since 2018/5/31
 */
public interface HystrixService {

    String echo();

    int echo(int primitive);

    JSONObject testGener(String para);

    String testGenerRe(String para);

    String test(Par par);

    Set<String> testSet(Set<String> set);

    Object testMap(Map<String, Object> map);

    int[] testArray(int[] array);

    String[] testArray2(String[] strings);

    Date testDate(Date date);

    List<Object> testList(List<Object> list);

    public static class Par {
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    public static void main(String[] args) {
        System.out.println(Par.class.toString());
    }
}
