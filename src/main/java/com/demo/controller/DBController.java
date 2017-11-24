package com.demo.controller;

import com.demo.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by lorne on 2017/11/8
 */
@RestController
@RequestMapping("/db/{dbName}/")
public class DBController {

    @Autowired
    private DbService dbService;


    @RequestMapping(value = "save",method = RequestMethod.GET)
    public int save(@RequestParam("name") String name){
        return dbService.save(name);
    }
}
