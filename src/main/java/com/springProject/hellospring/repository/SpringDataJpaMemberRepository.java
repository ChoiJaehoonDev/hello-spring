package com.springProject.hellospring.repository;

import com.springProject.hellospring.domain.Member;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    @Override
    Optional<Member> findByName(String name);
    //JPQL -> select m from Member m where m.name = ? 자동 완성
    // And, Or 가능
}
