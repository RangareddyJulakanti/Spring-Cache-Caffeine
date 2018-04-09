package com.essilor.demo.caffinecache.service;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Created by RANGAREJ on 4/6/2018.
 */

public interface CustomerService {
    public String sayHai(String customer);
    public String  remove(String  instrument);
    public void clearAllCaches();
}
