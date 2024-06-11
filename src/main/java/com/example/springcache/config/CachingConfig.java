package com.example.springcache.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

// @EnableCaching은 springBootApplication에 추가해도 된다
// 그러나 어차피 캐시 설정을 위한 Config 클래스를 추가할거라면 해당 클래스에 추가해도 된다.
@EnableCaching
@Configuration
public class CachingConfig {

    @Bean
    public CacheManager cacheManager() {
        ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager();
        cacheManager.setAllowNullValues(false);
        cacheManager.setCacheNames(List.of("members"));
        return cacheManager;
    }
}
