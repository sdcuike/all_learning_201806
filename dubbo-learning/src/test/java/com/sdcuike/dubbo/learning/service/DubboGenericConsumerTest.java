package com.sdcuike.dubbo.learning.service;

import com.alibaba.dubbo.rpc.service.GenericService;
import com.sdcuike.dubbo.learning.utils.DubboGenericFactory;
import com.sdcuike.dubbo.learning.utils.DubboGenericInvokeUtils;
import org.apache.commons.lang3.time.FastDateFormat;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * @author sdcuike
 * @date 2018/5/31
 * @since 2018/5/31
 */
public class DubboGenericConsumerTest {
    GenericService hystrixService;

    @Before
    public void init() {
        hystrixService = DubboGenericFactory.get("", "dubbo://127.0.0.1:20088",
                "com.sdcuike.dubbo.learning.service.HystrixService", null);
    }


    @Test
    public void testGenerRe_参数为基本类型() throws InterruptedException {


        Object result = hystrixService.$invoke("testGenerRe", new String[]{"java.lang.String"}, new Object[]{"test"});

        System.out.println(result.getClass() + " ==  " + result);

        // rpc-json格式

        final String[] parameterTypes = DubboGenericInvokeUtils.generateParameterTypes(String.class.getName());
        final Object[] parameterValues = DubboGenericInvokeUtils.generateParameterValues("[\"test_test\"]");

        result = hystrixService.$invoke("testGenerRe", parameterTypes, parameterValues);
        System.out.println("==" + result);

    }

    @Test
    public void test_echo_无参数() {

        final Object echo = hystrixService.$invoke("echo", new String[]{}, new Object[]{});
        System.out.println(echo.getClass() + " ==  " + echo);

        //rpc-json格式
        final String[] parameterTypes = DubboGenericInvokeUtils.generateParameterTypes("");
        final Object[] parameterValues = DubboGenericInvokeUtils.generateParameterValues("");

        Object result = hystrixService.$invoke("echo", parameterTypes, parameterValues);
        System.out.println("==" + result);

    }

    @Test
    public void test_echo_无参数1() {
        //rpc-json格式
        final String[] parameterTypes = DubboGenericInvokeUtils.generateParameterTypes("");
        final Object[] parameterValues = DubboGenericInvokeUtils.generateParameterValues("");

        Object result = hystrixService.$invoke("echo", parameterTypes, parameterValues);
        System.out.println("==" + result);
    }

    @Test
    public void test_echo_primitive_参数为基本类型() {

        final Object echo = hystrixService.$invoke("echo", new String[]{int.class.getName()}, new Object[]{88});
        System.out.println(echo.getClass() + " ==  " + echo);


        //rpc-json格式
        String[] parameterTypes = DubboGenericInvokeUtils.generateParameterTypes(int.class.getName());
        Object[] parameterValues = DubboGenericInvokeUtils.generateParameterValues("[6886]");

        Object result = hystrixService.$invoke("echo", parameterTypes, parameterValues);
        System.out.println("==" + result);

        //参数类型不传
        parameterTypes = DubboGenericInvokeUtils.generateParameterTypes(int.class.getName());

        result = hystrixService.$invoke("echo", parameterTypes, parameterValues);
        System.out.println("==" + result);


    }

    @Test
    public void testGener_参数为基本类型() {

        Object result = hystrixService.$invoke("testGener", new String[]{"java.lang.String"}, new Object[]{"jsoj"});
        System.out.println(result.getClass() + " ==  " + result);

        //rpc-json格式
        String[] parameterTypes = DubboGenericInvokeUtils.generateParameterTypes(String.class.getName());
        final Object[] parameterValues = DubboGenericInvokeUtils.generateParameterValues("[\"6886\"]");

        result = hystrixService.$invoke("testGener", parameterTypes, parameterValues);
        System.out.println("==" + result);


        //参数类型不传
        parameterTypes = null;

        result = hystrixService.$invoke("testGener", parameterTypes, parameterValues);
        System.out.println("==" + result);
    }

    @Test
    public void test_test_参数为对象类型() {
        Map<String, Object> person = new HashMap<String, Object>();
        person.put("name", "xxx");
        person.put("age", 12);

        Object result = hystrixService.$invoke("test", new String[]{"com.sdcuike.dubbo.learning.service.HystrixService$Par"}, new Object[]{person});

        System.out.println(result.getClass() + " ==  " + result);


        //rpc-json格式
        final String[] parameterTypes = DubboGenericInvokeUtils.generateParameterTypes("com.sdcuike.dubbo.learning.service.HystrixService$Par");
        final Object[] parameterValues = DubboGenericInvokeUtils.generateParameterValues("[{\"name\":\"xxxt\",\"age\":88}]");

        result = hystrixService.$invoke("test", parameterTypes, parameterValues);
        System.out.println("==" + result);

    }

    @Test
    public void testDate_参数为日期类型() {
        Object result = hystrixService.$invoke("testDate", new String[]{Date.class.getName()}, new Object[]{new Date()});

        System.out.println(result.getClass() + " ==  " + result);

        //rpc-json格式
        final String[] parameterTypes = DubboGenericInvokeUtils.generateParameterTypes(Date.class.getName());
        final Object[] parameterValues = DubboGenericInvokeUtils.generateParameterValues("[\"2018-11-11 13:12:00\"]");

        Date date = (Date) hystrixService.$invoke("testDate", parameterTypes, parameterValues);
        System.out.println("==" + FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss").format(date));
    }

    @Test
    public void testList_参数为list类型() {

        Object result = hystrixService.$invoke("testList", new String[]{List.class.getName()},
                new Object[]{Arrays.asList("hell", "jdkfj")});

        System.out.println(result.getClass() + " ==  " + result);


        //rpc-json格式
        final String[] parameterTypes = DubboGenericInvokeUtils.generateParameterTypes(List.class.getName());
        final Object[] parameterValues = DubboGenericInvokeUtils.generateParameterValues("[[\"a\",\"b\"]]");

        result = hystrixService.$invoke("testList", parameterTypes, parameterValues);
        System.out.println("==" + result);
    }

    @Test
    public void testSet_参数为set类型() {
        Set<String> set = new HashSet<>();
        set.add("name");
        set.add("sex");

        Object result = hystrixService.$invoke("testSet", new String[]{Set.class.getName()},
                new Object[]{set});

        System.out.println(result.getClass() + " ==  " + result);


        //rpc-json格式
        final String[] parameterTypes = DubboGenericInvokeUtils.generateParameterTypes(Set.class.getName());
        final Object[] parameterValues = DubboGenericInvokeUtils.generateParameterValues("[[\"a\",\"b\"]]");

        result = hystrixService.$invoke("testSet", parameterTypes, parameterValues);
        System.out.println("==" + result.getClass() + result);
    }

    @Test
    public void testMap_参数为map类型() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "doctor who");
        map.put("age", 28888);

        Object result = hystrixService.$invoke("testMap", new String[]{Map.class.getName()},
                new Object[]{map});

        System.out.println(result.getClass() + " ==  " + result);


        //rpc-json格式
        final String[] parameterTypes = DubboGenericInvokeUtils.generateParameterTypes(Map.class.getName());
        final Object[] parameterValues = DubboGenericInvokeUtils.generateParameterValues("[{\"a\":124,\"b\":\"121\"}]");

        result = hystrixService.$invoke("testMap", parameterTypes, parameterValues);
        System.out.println("==" + result.getClass() + result);
    }

    @Test
    public void testArray_参数为数组类型() {
        int[] array = new int[]{11, 66};

        int[] result = (int[]) hystrixService.$invoke("testArray", new String[]{int[].class.getName()},
                new Object[]{array});

        System.out.println(result.getClass() + " ==  " + Arrays.toString(result));


        //rpc-json格式
        final String[] parameterTypes = DubboGenericInvokeUtils.generateParameterTypes(int[].class.getName());
        final Object[] parameterValues = DubboGenericInvokeUtils.generateParameterValues("[[12,13,14,15,16]]");

        int[] o = (int[]) hystrixService.$invoke("testArray", parameterTypes, parameterValues);
        System.out.println("==" + o.getClass() + Arrays.toString(o));
    }

    @Test
    public void testArray_参数为数组类型1() {


        //rpc-json格式
        final String[] parameterTypes = DubboGenericInvokeUtils.generateParameterTypes(int[].class.getName());
        final Object[] parameterValues = DubboGenericInvokeUtils.generateParameterValues("[[12,13,14,15,16]]");

        int[] o = (int[]) hystrixService.$invoke("testArray", parameterTypes, parameterValues);
        System.out.println("==" + o.getClass() + Arrays.toString(o));
    }

    @Test
    public void testArray_参数为数组类型2() {


        //rpc-json格式
        final String[] parameterTypes = DubboGenericInvokeUtils.generateParameterTypes("");
        final Object[] parameterValues = DubboGenericInvokeUtils.generateParameterValues("[[12,13,14,15,16]]");

        int[] o = (int[]) hystrixService.$invoke("testArray", parameterTypes, parameterValues);
        System.out.println("==" + o.getClass() + Arrays.toString(o));
    }

    @Test
    public void testArray2_参数为数组类型() {
        String[] array = new String[]{"who", "sd"};

        Object[] result = (Object[]) hystrixService.$invoke("testArray2", null,
                new Object[]{array});

        System.out.println(result.getClass() + " ==  " + Arrays.toString(result));
    }


}
