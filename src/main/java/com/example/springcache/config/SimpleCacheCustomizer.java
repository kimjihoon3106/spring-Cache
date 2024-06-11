package com.example.springcache.config;

import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.stereotype.Component;

// Cache Customizer를 따로 추가한 방법
@Component
public class SimpleCacheCustomizer implements CacheManagerCustomizer<ConcurrentMapCacheManager> {
    @Override
    public void customize(ConcurrentMapCacheManager cacheManager) {
        cacheManager.setAllowNullValues(false);
    }
}

// @Cacheable
// * 데이터를 캐시에 저장
// * 메서드를 호출할 때 캐시의 이름(value)과 키(key)를 확인하여 이미 저장된 데이터가 있으면 해당 데이터를 리턴
// * 만약 데이터가 없다면 메서드를 수행 후 결과값을 저장

// @CachePut
// * @Cacheable과 비슷하게 데이터를 캐시에 저장
// * 차이점은 @Cacheable은 캐시에 데이터가 이미 존재하면 메서드를 수행하지 않지만 @CachePut은 항상 메서드를 수행
// * 그래서 주로 캐시 데이터를 갱신할 때 많이 사용

// @CacheEvict
// * 캐시에 있는 데이터를 삭제

// @CacheConfig
// * 메서드가 아닌 클래스에 붙여서 공통된 캐시 기능을 모을 수 잇음
// * 예를 들명 cacheName, cacheManger 등등

// @Caching
// Cacheable, CachePut, CacheEvict를 여러개 사용할 때 묶어주는 기능

// 일반적으로 @Cacheable을 사용해서 캐싱하고 데이터를 갱신할때 @CachePut, @CacheEvict 중 하나를 선택해서 갱신한다.

// @CachePut을 사용하면 @Cacheable 데이터 조회 시 캐시에 새로운 데이터가 존재하기 때문에 DB 조회를 하지 않아도 된다는 장점이 있다.
