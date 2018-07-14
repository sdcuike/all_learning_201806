package com.sdcuike.dubbo.learning.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.sdcuike.dubbo.learning.service.HystrixService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author sdcuike
 * @date 2018/5/31
 * @since 2018/5/31
 */
public class HystrixServiceImpl implements HystrixService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private AtomicLong atomicLong = new AtomicLong(0);

    private long startTimeMill = 0;


    @Override
    public String echo() {
        return "hello no param";
    }

    @Override
    public int echo(int primitive) {
        return primitive;
    }

    @Override
    public JSONObject testGener(String para) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("para", para);
        return jsonObject;
    }

    @Override
    public String testGenerRe(String para) {

        return "haha " + para;
    }

    @Override
    public String test(Par par) {
        return "wowo " + par.getName() + par.getAge();
    }

    @Override
    public Date testDate(Date date) {
        return date;
    }

    @Override
    public List<Object> testList(List<Object> list) {
        return list;
    }


    @Override
    public Set<String> testSet(Set<String> set) {
        return set;
    }

    @Override
    public Object testMap(Map<String, Object> map) {
        return map;
    }

    @Override
    public int[] testArray(int[] array) {
        return array;
    }

    @Override
    public String[] testArray2(String[] strings) {
        return strings;
    }
}
