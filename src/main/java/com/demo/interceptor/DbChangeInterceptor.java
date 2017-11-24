package com.demo.interceptor;

import com.demo.db.DataSourceLocal;
import com.demo.db.DataSourceProxy;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * create by lorne on 2017/11/8
 */
@Aspect
@Component
public class DbChangeInterceptor implements Ordered{

    @Override
    public int getOrder() {
        return 1;
    }

    @Around("execution(* com.demo.service.impl.*Impl.*(..))")
    public Object around(ProceedingJoinPoint point)throws Throwable{
        if(DataSourceLocal.current()!=null){
            DataSourceProxy.changeDb(DataSourceLocal.current().getKey());
        }
        return point.proceed();
    }
}
