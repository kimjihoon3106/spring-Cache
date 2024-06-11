package com.example.springcache.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class MemberDto {
    private Long id;
    private String name;
    private int age;

    public MemberDto() {
    }

    public MemberDto(Long id, String name, int age, String password) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
