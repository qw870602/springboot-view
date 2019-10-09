package com.yuqiyu.lesson.controller;

import com.yuqiyu.lesson.entity.UserEntity;
import com.yuqiyu.lesson.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author fengxiao
 * @date 2019/10/8 17:46
 * @description
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserJPA userJPA;

//    @RequestMapping("/index")
//    public String index(){
//        return "index";
//    }
    @RequestMapping(value = "/list")
    public List<UserEntity> list(){
        return userJPA.findAll();
    }
    @RequestMapping(value = "/save")
    public UserEntity save(UserEntity userEntity){
        return userJPA.save(userEntity);
    }
    @RequestMapping(value = "/delete")
    public List<UserEntity> delete(Long id){
        userJPA.deleteById(id);
        return userJPA.findAll();
    }
}
