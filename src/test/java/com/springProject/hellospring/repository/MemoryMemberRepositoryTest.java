package com.springProject.hellospring.repository;

import com.springProject.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {      // class level로 실행하면 한번에 테스트 가능, 테스트 순서는 보장이 안됨, 테스트 순서에 상관없이 실행되야함

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach  // 테스트가 끝날때 마다 실행 -> 모두 초기화됨
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("Jaehoon");

        repository.save(member);

        Member result =  repository.findById(member.getId()).get();  //Optional에서 get()으로 값을 바로 꺼낼 수 있음, 좋은 방법은 아니지만 테스트일떈 가능

        // Assertions.assertEquals(member, null); 실패했을땐 오류
        // Assertions.assertEquals(member, result) 기댓값, 예상값 -> 맞으면 초록불로 실행
        // 위 두개는 org.junit.jupiter.api

        // 아래 Assertions는 org.assertj.core.api
        assertThat(member).isEqualTo(result);
        // assertThat(member).isEqualTo(null);

    }
    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("Hoon");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("hhoon");
        repository.save(member2);

        Member result =  repository.findByName("Hoon").get();

//        Member result =  repository.findByName("hhoon").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member = new Member();
        member.setName("sss");
        repository.save(member);

        Member member1 = new Member();
        member1.setName("ssss");
        repository.save(member1);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }

}
