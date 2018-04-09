package com.essilor.demo.caffeinecache.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

/**
 * Created by RANGAREJ on 4/6/2018.
 */
@Service
@CacheConfig(cacheNames = {"customers"})
public class CustomerServiceImpl implements CustomerService {
    private static Logger log = LoggerFactory.getLogger(MusicServiceIml.class);
    @Override
    @Cacheable(value = "customers",key="#customer")
    public String sayHai(String customer) {

        log.info("Executing: " + this.getClass().getSimpleName() + ".sayHai(\"" + customer + "\");");
        return "Hi "+customer;
    }
    @CacheEvict(key = "#customer")
    @Override
    public String  remove(String  customer) {
        log.info("Executing removed all customers", customer);
        return customer;
    }

    @Caching(evict = {
            @CacheEvict(value = "customers", allEntries = true)
    })
    @Override
    public void clearAllCaches() {
        log.info("Cleared customer cache");
    }
}
