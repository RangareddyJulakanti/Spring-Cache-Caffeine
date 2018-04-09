package com.essilor.demo.caffeinecache.controller;

import com.essilor.demo.caffeinecache.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
