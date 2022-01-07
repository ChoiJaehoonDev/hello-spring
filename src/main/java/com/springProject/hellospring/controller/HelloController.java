package com.springProject.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!dssdsddsdsd");
        return "hello"; // viewResolver를 통해 파일을 찾아감 ->  resources:templates/{viewName} + .html

    }

    @GetMapping("hell-mvc")
    public String helloMvc(@RequestParam(name = "name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody   //html바디부에 직접 데이터를 넣음
    public String helloString(@RequestParam("name") String name){
        return "hello" + name; // "hello spring"
    }

    @GetMapping("hello-api")
    @ResponseBody   // 기본으로 JSON형식으로 반환
    // viewResolver 대신 HttpMessageConverter가 동작함
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;       //json형식으로 보내짐(객체를 보냄)
    }


    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
