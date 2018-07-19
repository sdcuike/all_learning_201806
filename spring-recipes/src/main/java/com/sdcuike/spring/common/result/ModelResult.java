package com.sdcuike.spring.common.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一返回体：包含数据的情况下；
 * 请优先使用对应的Builder方法
 *
 * @author sdcuike
 * @date 2018/7/18
 * @since 2018/7/18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModelResult<T> extends BaseResult {
    /**
     * 根据某id/no/*去数据表里查询，如果查不到时(没有故障)，success为true而model为null
     */
    private T data;

    /**
     * 数据是否来源于缓存
     */
    private Boolean readFromCache;

    /**
     * 分页信息：总行数
     */
    private long totalRows;

    public <SubClass extends ModelResult> SubClass withData(T data) {
        this.data = data;
        return (SubClass) this;
    }

    public <SubClass extends ModelResult> SubClass withDataFromDb(T data) {
        this.data = data;
        this.readFromCache = false;
        return (SubClass) this;
    }

    public <SubClass extends ModelResult> SubClass withDataCache(T data) {
        this.data = data;
        this.readFromCache = true;
        return (SubClass) this;
    }

    public <SubClass extends ModelResult> SubClass withReadFromCache(Boolean readFromCache) {
        this.readFromCache = readFromCache;
        return (SubClass) this;
    }

    public <SubClass extends ModelResult> SubClass withTotalRows(long totalRows) {
        this.totalRows = totalRows;
        return (SubClass) this;
    }

}
