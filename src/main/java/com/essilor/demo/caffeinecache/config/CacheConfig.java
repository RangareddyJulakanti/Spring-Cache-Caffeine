package com.essilor.demo.caffeinecache.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.RemovalCause;
import com.github.benmanes.caffeine.cache.RemovalListener;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * Created by RANGAREJ on 4/2/2018.
 */
@Configuration
@EnableCaching
public class CacheConfig {

    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
        CaffeineCache instruments=new CaffeineCache("instruments", instrumentsCacheBuilder().build());
        CaffeineCache customer=new CaffeineCache("customers", customerCacheBuilder().build());
        simpleCacheManager.setCaches(Arrays.asList(instruments, customer));
        simpleCacheManager.initializeCaches();
        return simpleCacheManager;
    }
    Caffeine<Object, Object> instrumentsCacheBuilder() {
        return Caffeine.newBuilder()
                .initialCapacity(4)
                .maximumSize(5)
                .expireAfterWrite(5, TimeUnit.MINUTES)
                .removalListener(new CustomRemovalListener());
    }
    Caffeine<Object, Object> customerCacheBuilder() {
        return Caffeine.newBuilder()
                .initialCapacity(5)
                .maximumSize(4)
                .expireAfterWrite(5, TimeUnit.MINUTES)
                .removalListener(new CustomRemovalListener());

    }
    class CustomRemovalListener implements RemovalListener<Object, Object> {
        @Override
        public void onRemoval(Object key, Object value, RemovalCause cause) {
            System.out.format("removal listerner called with key [%s], cause [%s], evicted [%S], value[%s] \n",
                    key, cause.toString(), cause.wasEvicted(),value.toString());
            System.out.println("current Thread"+Thread.currentThread().getName());
        }
    }
}