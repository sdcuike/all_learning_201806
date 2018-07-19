package com.sdcuike.spring.common.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一返回体：不包含数据的情况下；
 * 请优先使用对应的Builder方法
 *
 * @author sdcuike
 * @date 2018/7/18
 * @since 2018/7/18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResult {

    /**
     * 返回码：格式：业务.具体错误英文码;
     * 约定：0表示成功，其它表示错误
     * 如：isv.missing-method
     */
    private String code = "0";
    /**
     * 返回码描述：格式：中文/英文具体描述
     * 如：缺少方法名参数
     */
    private String msg = "";

    /**
     * 用户每次请求，无论成功与否 系统都会返回一个唯一识别码RequestId给用户，根据RequestId可以快速的排查问题
     */
    private String requestId;

    /**
     * 出错时的重要输入参数
     */
    private String inputParamWhereCatch;


    public boolean isSuccess() {
        return "0".equals(code);
    }

    public <T extends BaseResult> T withCode(String code) {
        this.code = code;
        return (T) this;
    }

    public <T extends BaseResult> T withMsg(String msg) {
        this.msg = msg;
        return (T) this;
    }

    public <T extends BaseResult> T withRequestId(String requestId) {
        this.requestId = requestId;
        return (T) this;
    }

    public <T extends BaseResult> T withInputParamWhereCatch(String inputParamWhereCatch) {
        this.inputParamWhereCatch = inputParamWhereCatch;
        return (T) this;
    }


    public <T extends BaseResult> T withCodeMsg(String code, String msg) {
        this.code = code;
        this.msg = msg;
        return (T) this;
    }


}
