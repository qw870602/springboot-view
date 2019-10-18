package com.yuqiyu.lesson.user.controller;

import com.yuqiyu.lesson.user.bean.UserBean;
import com.yuqiyu.lesson.user.jpa.UserJPA3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ========================
 * Created with IntelliJ IDEA.
 * User：恒宇少年
 * Date：2017/5/30
 * Time：14:23
 * 码云：http://git.oschina.net/jnyqy
 * ========================
 */
@RestController
@RequestMapping(value = "/user")
public class UserController2 {

    @Autowired
    private UserJPA3 userJPA3;

    /**
     * 查询所有用户列表
     * @return
     */
    @RequestMapping(value = "/list2")
    public List<UserBean> list(){
        return userJPA3.findAll();
    }
}
