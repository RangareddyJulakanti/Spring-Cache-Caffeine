package com.essilor.demo.caffinecache.controller;

import com.essilor.demo.caffinecache.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

/**
 * Created by RANGAREJ on 4/6/2018.
 */
@RestController
public class CustomerController {
    @Autowired
    CustomerService customerServiceImpl;

    @GetMapping("/customer/{customer}")
    public String customer(@PathVariable("customer") String customer) {

        return customerServiceImpl.sayHai(customer);
    }
    @GetMapping("/customer/clear")
    public void clearAllCustomerCaches(){
        customerServiceImpl.clearAllCaches();
    }
}
