package com.essilor.demo;

import com.essilor.demo.caffeinecache.service.MusicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by RANGAREJ on 4/6/2018.
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.essilor.demo")
public class CaffeineCacheAppRunner{
    private static Logger log = LoggerFactory.getLogger(CaffeineCacheAppRunner.class);
    @Autowired
    private MusicService musicService;
    @Autowired
    private CacheManager cacheManager;

    public static  void main(String... args) throws Exception {
        SpringApplication.run(CaffeineCacheAppRunner.class, args);
    }

    public void play(String instrument){
        musicService.play(instrument);
    }

}
