package com.essilor.demo.caffeinecache.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

/**
 * Created by RANGAREJ on 4/9/2018.
 */
@Service
public class CommonServiceImpl implements CommonService {
    private static Logger log = LoggerFactory.getLogger(MusicServiceIml.class);
    @Caching(evict = {
            @CacheEvict(value = "instruments", allEntries = true),
            @CacheEvict(value = "customers", allEntries = true)
    })
    public void clearAllCaches() {
        log.info("Cleared instrument cache");
    }
}
