package com.sdcuike.spring.log.requestinfo;

import org.springframework.http.HttpMethod;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

/**
 * @author sdcuike
 * @date 2018/8/2
 * @since 2018/8/2
 */
class ServletRequestUtils {

    public static boolean isBinaryContent(final ServletRequest request) {
        if (request.getContentType() == null) {
            return false;
        }


        return request.getContentType().startsWith("image") ||
                request.getContentType().startsWith("video") ||
                request.getContentType().startsWith("audio");
    }


    public static boolean isMultipart(final ServletRequest request) {
        return request.getContentType() != null && request.getContentType().startsWith("multipart/form-data");
    }


    public static boolean isPostHttpMethod(final HttpServletRequest request) {
        return HttpMethod.POST.matches(request.getMethod());
    }

    public static boolean isApplicationJsonMediaType(final ServletRequest request) {
        return request.getContentType() != null && request.getContentType().startsWith("application/json");

    }
    public static boolean isApplicationFormMediaType(final ServletRequest request) {
        return request.getContentType() != null && request.getContentType().startsWith("application/x-www-form-urlencoded");

    }
}
