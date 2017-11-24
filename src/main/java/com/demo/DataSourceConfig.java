package com.demo;

import com.alibaba.druid.pool.DruidDataSource;
import com.demo.db.DataSourceProxy;
import com.lorne.core.framework.utils.config.ConfigHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * create by lorne on 2017/8/17
 */
@Configuration
public class DataSourceConfig {

    private ConfigHelper configHelper;

    public DataSourceConfig() {
        configHelper = new ConfigHelper("db.properties");
    }

    private void reloadDataSource(){
        String [] names = configHelper.getStringArrayValue("db.name");
        for(String name:names){
            DruidDataSource dataSource = new DruidDataSource();
            dataSource.setUrl(configHelper.getStringValue(String.format("%s.datasource.url",name)));
            dataSource.setUsername(configHelper.getStringValue(String.format("%s.datasource.username",name)));//用户名
            dataSource.setPassword(configHelper.getStringValue(String.format("%s.datasource.password",name)));//密码
            dataSource.setInitialSize(3);
            dataSource.setMaxActive(20);
            dataSource.setMinIdle(0);
            dataSource.setMaxWait(60000);
            dataSource.setValidationQuery("SELECT 1");
            dataSource.setTestOnBorrow(false);
            dataSource.setTestWhileIdle(true);
            dataSource.setPoolPreparedStatements(false);
            DataSourceProxy.addDataSource(name,dataSource);
        }
    }

    @Bean
    public DataSource dataSource() {
        DataSourceProxy dataSourceProxy = new DataSourceProxy();
        reloadDataSource();
        return dataSourceProxy;
    }
}