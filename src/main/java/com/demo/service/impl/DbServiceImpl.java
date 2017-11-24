package com.demo.service.impl;

import com.demo.dao.TestDao;
import com.demo.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * create by lorne on 2017/11/8
 */
@Service

public class DbServiceImpl implements DbService {


    @Autowired
    private TestDao testDao;

    @Override
    @Transactional
    public int save(String name) {

        int rs = testDao.save(name);

        return rs;
    }



}
