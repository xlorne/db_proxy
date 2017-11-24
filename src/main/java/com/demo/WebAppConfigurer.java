package com.demo;

import com.demo.interceptor.DbNameInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * create by lorne on 2017/11/8
 */

@Component
@Configuration
public class WebAppConfigurer extends WebMvcConfigurerAdapter {


    @Autowired
    private DbNameInterceptor dbNameInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(dbNameInterceptor);
    }
}
