package com.springProject.hellospring;

import com.springProject.hellospring.repository.JpaMemberRepository;
import com.springProject.hellospring.repository.MemberRepository;
import com.springProject.hellospring.repository.MemoryMemberRepository;
import com.springProject.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {
    // spring bean :
    // controller -> service -> repository
    // spring을 시작하기전에 controll, service, repository 필수

    EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em){
        this.em = em;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new JpaMemberRepository(em);
    }
    
}
