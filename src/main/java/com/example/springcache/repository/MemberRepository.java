package com.example.springcache.repository;

import com.example.springcache.domain.Member;
import com.example.springcache.domain.Members;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Repository
@CacheConfig(cacheNames = "members")
public class MemberRepository {

    private final Map<Long, Member> store = new LinkedHashMap<>();

    @Cacheable(key = "'all'")
    public Members findAll() {
        List<Member> members = store.values().stream().toList();
        log.info("Repository findAll ()", members);
        return new Members(members);
    }
}
