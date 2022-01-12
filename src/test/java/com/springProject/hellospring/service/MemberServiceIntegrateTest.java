package com.springProject.hellospring.service;

import com.springProject.hellospring.domain.Member;
import com.springProject.hellospring.repository.MemberRepository;
import com.springProject.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceIntegrateTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;


    @Test
    void 회원가입() {   //한글로도 가능, 테스트기떄문에 가능
        //given 주어지고

        Member member = new Member();
        member.setName("Hoon");

        //when 실행했을때
        Long saveID = memberService.join(member);

        //then 결과가 나와야함
        Member findMember = memberService.findOne(saveID).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복회원예외(){
        //given
        Member member1 = new Member();
        member1.setName("Hoon");

        Member member2 = new Member();
        member2.setName("Hoon");

        memberService.join(member1);

        // ()-> memberService.join(member2)이걸 실행하면 IllegalStateException.class이 에러가 나와야함
        //try-catch보다 선호
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

//        try {
//            memberService.join(member2);
//            fail();
//        }catch (IllegalStateException e){
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.12121");
//        }
    }

}