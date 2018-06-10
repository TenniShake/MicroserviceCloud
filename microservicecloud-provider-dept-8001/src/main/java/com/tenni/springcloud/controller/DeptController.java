package com.tenni.springcloud.controller;


import com.tenni.springcloud.entities.Dept;
import com.tenni.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService service;

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value="/dept/add",method=RequestMethod.POST)
    public  boolean add(@RequestBody Dept dept){
        return service.addDept(dept);
    }

    @RequestMapping(value="/dept/get/{id}",method=RequestMethod.GET)
    public  Dept get(@PathVariable("id") long id){
        return service.get(id);
    }

    @RequestMapping(value="/dept/list",method=RequestMethod.GET)
    public List<Dept> get(){
        return service.list();
    }

    @RequestMapping(value="/dept/discovery",method=RequestMethod.GET)
    public Object discovery(){
        List<String> list = client.getServices();
        System.out.println("****"+list);

        List<ServiceInstance> scrList = client.getInstances("MICROSERVICECLOUD-DEPT");
        for(ServiceInstance element:scrList){
            System.out.println(element.getServiceId()+"\t"
            +element.getHost()+"\t"+element.getPort()+"\t"+element.getUri());
        }
        return  this.client;
    }
}
