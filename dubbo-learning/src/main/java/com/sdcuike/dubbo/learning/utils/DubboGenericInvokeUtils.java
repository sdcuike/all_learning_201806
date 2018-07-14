package com.sdcuike.dubbo.learning.utils;

import com.alibaba.fastjson.JSONArray;
import com.google.common.base.Splitter;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @author sdcuike
 * @date 2018/7/3
 * @since 2018/7/3
 */
public class DubboGenericInvokeUtils {

    /**
     * @param parameterTypes 英文逗号隔开的字符串
     * @return
     */
    public static String[] generateParameterTypes(String parameterTypes) {
        if (StringUtils.isBlank(parameterTypes)) {
            return null;
        }

        List<String> types = Splitter.on(",").trimResults().splitToList(parameterTypes);

        return types.toArray(new String[types.size()]);
    }


    /**
     * Parameter Structures:
     * If present, parameters for the rpc call MUST be provided as a Structured value. Either by-position through an Array or by-name through an Object.
     * <p>
     * by-position: params MUST be an Array, containing the values in the Server expected order.
     * <p>
     * see <a href="https://www.jsonrpc.org/specification">Parameter Structures</a>
     *
     * @param arguments rpc-json 协议参数位置表示法
     * @return
     */
    public static Object[] generateParameterValues(final String arguments) {

        if (StringUtils.isBlank(arguments)) {
            return null;
        }

        JSONArray jsonArray = JSONArray.parseArray(arguments);

        return jsonArray.toArray();
    }
}
