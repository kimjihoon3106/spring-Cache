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

    @Cacheable(key = "#memberId", unless = "#result == pull")
    public Member findById(Long memberId) {
        Member member = store.get(memberId);
        log.info("Repository find {}", member);
        return member;
    }

    @CachePut(key = "#member.id")
    @CacheEvict(key = "'all'")
    public Member save(Member member) {
        Long newId = calculateId();
        member.setId(newId);

        log.info("Repository save {}",member);

        store.put(member.getId(), member);
        return member;
    }

    private Long calculateId() {
        if(store.isEmpty()) {
            return 1L;
        }

        int lastIndex = store.size() - 1;
        return (Long) store.keySet().toArray()[lastIndex] + 1;
    }

    @CachePut(key = "#member.id")
    @CacheEvict(key = "'all'")
    public Member update(Member member) {
        log.info("Repository update {}", member);
        store.put(member.getId(), member);
        return member;
    }
}
