package com.konasl.camel.ep;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping(value = "/test/get")
    public String testApi(){
        return "Get Success";
    }

    @PostMapping(value = "/test/post")
    public String testPostApi(@RequestBody String str){
        System.out.println("Message body : " + str);
        return "Post Success : "+str;
    }
}
