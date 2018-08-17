package com.sdcuike.spring.log.requestinfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Map;

/**
 * @author sdcuike
 * @date 2018/8/1
 * @since 2018/8/1
 */
public class LogFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(getClass());


    @Override
    public void init(javax.servlet.FilterConfig filterConfig) {
        logger.info("init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("doFilter");

        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        Cookie cookie = new Cookie("test", "SG1");
        cookie.setDomain(".localhost.com");

        cookie.setPath("/");
        cookie.setVersion(2);
        httpServletResponse.addCookie(cookie);
        ServletRequest servletRequest = request;
        if (!ServletRequestUtils.isBinaryContent(request) &&
                !ServletRequestUtils.isMultipart(request) &&
                ServletRequestUtils.isPostHttpMethod((HttpServletRequest) request) &&
                ServletRequestUtils.isApplicationJsonMediaType(request)) {

            servletRequest = new ContentCachingRequestWrapper((HttpServletRequest) request);
        }


        Object args = null;
        if (servletRequest instanceof ContentCachingRequestWrapper) {
            byte[] cachingBytes = ((ContentCachingRequestWrapper) servletRequest).getCachingBytes();

            args = new String(cachingBytes, request.getCharacterEncoding() == null ? StandardCharsets.UTF_8.name() : request.getCharacterEncoding());

        }

        if (ServletRequestUtils.isPostHttpMethod((HttpServletRequest) request) &&
                ServletRequestUtils.isApplicationFormMediaType(request)) {

            args = parameterMapToString(request);
        }

        logger.info("params :{}", args);

        chain.doFilter(servletRequest, response);


    }

    @Override
    public void destroy() {
        logger.info("destroy");
    }


    private String parameterMapToString(ServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();

        if (parameterMap == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, String[]> kv : parameterMap.entrySet()) {
            sb.append(kv.getKey()).append("=").append((kv.getValue() == null || kv.getValue().length == 1) ? kv.getValue()[0] : Arrays.toString(kv.getValue()));
            sb.append("&");
        }

        sb.deleteCharAt(sb.lastIndexOf("&"));

        return sb.toString();
    }
}
