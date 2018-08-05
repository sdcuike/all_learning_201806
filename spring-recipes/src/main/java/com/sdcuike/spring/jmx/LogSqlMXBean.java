package com.sdcuike.spring.jmx;

import ch.qos.logback.classic.Level;
import org.jolokia.jmx.JsonMBean;
import org.springframework.stereotype.Component;

/**
 * @author sdcuike
 * @date 2018/8/4
 * @since 2018/8/4
 */
@Component
@JsonMBean
public class LogSqlMXBean implements ILogSqlMXBean {

    private volatile boolean logSql = false;


    private static final String LOGSQL_LOGGERNAME = "com.sdcuike.spring.log.db";


    @Override
    public boolean isLogSql() {
        return logSql;
    }

    @Override
    public void setLogSql(boolean logSql) {
        this.logSql = logSql;

        if (logSql) {
            LoggerLevelUtils.setLogLevel(LOGSQL_LOGGERNAME, Level.DEBUG);
        } else {
            LoggerLevelUtils.setLogLevel(LOGSQL_LOGGERNAME, Level.INFO);

        }
    }

}
