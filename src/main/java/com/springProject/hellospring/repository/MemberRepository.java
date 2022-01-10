package com.springProject.hellospring.repository;

import com.springProject.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);   //null을 처리하기 위한 방법 중 하나
    List<Member> findAll();
}
