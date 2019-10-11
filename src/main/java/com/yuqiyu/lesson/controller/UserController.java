package com.yuqiyu.lesson.controller;

import com.yuqiyu.lesson.entity.UserEntity;
import com.yuqiyu.lesson.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
    @RequestMapping(value = "/cutPage")
    public List<UserEntity> cutPage(int page){
        UserEntity user=new UserEntity();
        user.setSize(2);
        user.setSord("desc");
        user.setPage(page);
        Sort.Direction sort_direction=Sort.Direction.ASC.toString().equalsIgnoreCase(user.getSord())?Sort.Direction.ASC:Sort.Direction.DESC;
        Sort sort=new Sort(sort_direction,user.getSidx());
        PageRequest pageRequest=new PageRequest(user.getPage()-1,user.getSize(),sort);
        return userJPA.findAll(pageRequest).getContent();
    }

    public static void main(String[] args) {
        System.out.println(Sort.Direction.ASC);
    }
}
