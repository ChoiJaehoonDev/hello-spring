package com.springProject.hellospring;

import com.springProject.hellospring.repository.MemberRepository;
import com.springProject.hellospring.repository.MemoryMemberRepository;
import com.springProject.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    // spring bean :
    // controller -> service -> repository
    // spring을 시작하기전에 controll, service, repository 필수

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
    
}
