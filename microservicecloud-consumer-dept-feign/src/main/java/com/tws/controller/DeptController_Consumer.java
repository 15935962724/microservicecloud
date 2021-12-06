package com.tws.controller;

import com.tws.entity.Dept;
import com.tws.service.DeptClienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptController_Consumer {



    @Autowired
    private DeptClienService deptClienService;

   @RequestMapping(value = "/consumer/dept/add")
    public int add(Dept dept){
        return this.deptClienService.add(dept);
    }

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return this.deptClienService.get(id);
    }

    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list(){
        return this.deptClienService.list();
    }


}
