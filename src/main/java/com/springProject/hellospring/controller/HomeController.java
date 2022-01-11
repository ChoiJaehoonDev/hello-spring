package com.springProject.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //spring container를 먼저 찾고 실행
public class HomeController {

    @GetMapping("/")    //가장 처음에 호출되는 부분
    public String home(){
        return "home";
    }

}
