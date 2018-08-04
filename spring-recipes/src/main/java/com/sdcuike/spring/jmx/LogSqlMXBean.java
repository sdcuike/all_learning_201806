package com.sdcuike.spring.jmx;

import ch.qos.logback.classic.Level;
import org.springframework.stereotype.Component;

/**
 * @author sdcuike
 * @date 2018/8/4
 * @since 2018/8/4
 */
@Component
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
            LoggerLevelUtils.setLogLevel("com.sdcuike.spring.log.db", Level.DEBUG);
        } else {
            LoggerLevelUtils.setLogLevel("com.sdcuike.spring.log.db", Level.INFO);

        }
    }

}
