package com.demo.interceptor;

import com.demo.db.DataSourceLocal;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 通过请求地址拦截数据库
 * create by lorne on 2017/11/8
 */
@Component
public class DbNameInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        String url = httpServletRequest.getRequestURI();


        String dbName = getDbName(url);
        if(StringUtils.isNotEmpty(dbName)){
            DataSourceLocal dbNameLocal = new DataSourceLocal();
            dbNameLocal.setKey(dbName);
            DataSourceLocal.setCurrent(dbNameLocal);
        }

        return true;
    }

    private String getDbName(String path){
        Pattern pattern = Pattern.compile("/db_.*/");

        Matcher matcher = pattern.matcher(path);

        if(matcher.find()){

            String res = matcher.group();
            res = res.replaceAll("/","");
            res = res.replace("db_","");

           return res;
        }

        return null;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
