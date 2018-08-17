package com.sdcuike.spring.log.requestinfo;

import org.apache.commons.io.IOUtils;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author sdcuike
 * @date 2018/8/2
 * @since 2018/8/2
 */
class ContentCachingRequestWrapper extends HttpServletRequestWrapper {

    private byte[] cachingBytes;

    public ContentCachingRequestWrapper(HttpServletRequest request) throws IOException {
        super(request);
        cachingBytes = IOUtils.toByteArray(request.getInputStream());

    }

    @Override
    public ServletInputStream getInputStream() {
        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(cachingBytes);

        return new ServletInputStream() {
            @Override
            public boolean isFinished() {
                return byteArrayInputStream.available() == 0;
            }

            @Override
            public boolean isReady() {
                return true;
            }

            @Override
            public void setReadListener(ReadListener listener) {
                throw new RuntimeException("no implement");
            }

            @Override
            public int read() {
                return byteArrayInputStream.read();
            }
        };


    }

    @Override
    public BufferedReader getReader()  {
        return new BufferedReader(new InputStreamReader(this.getInputStream()));
    }


    public byte[] getCachingBytes() {
        return cachingBytes;
    }
}
