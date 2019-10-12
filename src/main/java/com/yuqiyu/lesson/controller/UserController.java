package com.yuqiyu.lesson.controller;

import com.yuqiyu.lesson.entity.DemoEntity;
import com.yuqiyu.lesson.entity.UserEntity;
import com.yuqiyu.lesson.jpa.UserJPA;
import com.yuqiyu.lesson.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

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
    @Autowired
    private UserService userService;
    @Autowired
    private MessageSource messageSource;

//    @RequestMapping("/index")
//    public String index(){
//        return "index";
//    }
    @RequestMapping(value = "/list")
    public List<UserEntity> list(){
        return userService.list();
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
    @RequestMapping(value = "/validator")
    public String validator(@Valid DemoEntity entity, BindingResult result){
        if(result.hasErrors()){
            StringBuffer msg=new StringBuffer();
            List<FieldError> fieldErrors=result.getFieldErrors();
            Locale currentLocale= LocaleContextHolder.getLocale();
            fieldErrors.forEach(e->{
                String errorMsg=messageSource.getMessage(e,currentLocale);
                msg.append(e.getField()+":"+errorMsg+",");
            });
            return msg.toString();
        }
        return "验证通过,"+"名称:"+entity.getName()+"年龄:"+entity.getAge()+"地址:"+entity.getMail();
    }


    public static void main(String[] args) {
        System.out.println(Sort.Direction.ASC);
    }
}
