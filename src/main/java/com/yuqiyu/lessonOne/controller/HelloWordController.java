package com.yuqiyu.lessonOne.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fengxiao
 * @date 2019/10/8 17:46
 * @description
 */
@RestController
//@RequestMapping("/index")
public class HelloWordController {

    @RequestMapping("/index")
    public String index(){
        return "helloWorld";
    }

}
