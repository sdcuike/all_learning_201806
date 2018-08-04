package com.sdcuike.spring.log.config;

import com.sdcuike.spring.log.requestinfo.LogFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author sdcuike
 * @date 2018/8/2
 * @since 2018/8/2
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean logFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();

        bean.setFilter(new LogFilter());
        bean.setUrlPatterns(Arrays.asList("/*"));
        bean.setOrder(FilterRegistrationBean.REQUEST_WRAPPER_FILTER_MAX_ORDER - 1);
        return bean;
    }
}
