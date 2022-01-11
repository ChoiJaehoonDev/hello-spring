package com.springProject.hellospring.controller;

import com.springProject.hellospring.domain.Member;
import com.springProject.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired  //spring container에서 memberservice를 가져옴
    public MemberController(MemberService memberService) {      //DI
        this.memberService = memberService;
    }

    @GetMapping("/members/new")     //get방식 데이터를 조회할 때 주로 사용
    public String createFrom(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")    //post방식 데이터를 form같은 형식으로 전달할 때 주로 사용
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());
        System.out.println("member = " + member.getName());
        memberService.join(member);

        return "redirect:/";    //전 화면으로 돌려보내기
    }
}
