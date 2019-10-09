package com.yuqiyu.lesson.controller;

import com.yuqiyu.lesson.entity.UserEntity;
import com.yuqiyu.lesson.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

/**
 * @author fengxiao
 * @date 2019/10/8 17:46
 * @description
 */
@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private UserJPA userJPA;

    @RequestMapping("/login")
    public String login(UserEntity user, HttpServletRequest request){
        boolean flag=true;
        String result="登录成功";
        UserEntity userEntity=null;
        Optional<UserEntity> optional=userJPA.findOne((root,criteriaQuery,criteriaBuilder)->{
            criteriaQuery.where(criteriaBuilder.equal(root.get("name"),user.getName()));
            return null;
        });
        if(optional.isPresent()){
            userEntity=optional.get();
        }
        if (userEntity==null){
            flag=false;
            result="用户不存在,登录失败";
        }else if(!userEntity.getPwd().equals(user.getPwd())){
            flag=false;
            result="密码不正确";
        }
        if(flag){
            request.getSession().setAttribute("_session_user",userEntity);
        }
        return result;
    }

}
