package com.example.springcache.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
@NoArgsConstructor
public class Members {
    private List<Member> members = new ArrayList<>();

    public Members(List<Member> members) {
        this.members = members;
    }
}
