package com.springProject.hellospring.controller;

import com.springProject.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired  //spring container에서 memberservice를 가져옴
    public MemberController(MemberService memberService) {      //DI
        this.memberService = memberService;
    }
}
