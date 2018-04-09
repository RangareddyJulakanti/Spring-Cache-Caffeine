package com.essilor.demo.caffeinecache.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Component;

@Component
@CacheConfig(cacheNames = {"instruments"})
public class MusicServiceIml implements MusicService {
    private static Logger log = LoggerFactory.getLogger(MusicServiceIml.class);
    @Cacheable(value = "instruments",key = "#instrument")
    public String play(String instrument) {
        log.info("Executing: " + this.getClass().getSimpleName() + ".play(\"" + instrument + "\");");
        return "paying " + instrument + "!";
    }
    @CacheEvict(key = "#instrument")
    public String  remove(String  instrument) {
        log.info("Executing removed all music instruction", instrument);
        return instrument;
    }

    @Caching(evict = {
            @CacheEvict(value = "instruments", allEntries = true)
    })
    public void clearAllCaches() {
        log.info("Cleared instrument cache");
    }
}
