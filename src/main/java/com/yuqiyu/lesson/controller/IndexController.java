package com.yuqiyu.lesson.controller;

import com.yuqiyu.lesson.entity.UserEntity;
import com.yuqiyu.lesson.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * @author fengxiao
 * @date 2019/10/8 17:46
 * @description
 */
@Controller
@RequestMapping("/user")
public class IndexController {

    @RequestMapping("/login_view")
    public String login_view(){
        return "login";
    }
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

}
