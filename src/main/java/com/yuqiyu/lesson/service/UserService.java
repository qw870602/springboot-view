package com.yuqiyu.lesson.service;

import com.yuqiyu.lesson.entity.UserEntity;
import com.yuqiyu.lesson.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fengxiao
 * @date 2019/10/12 15:25
 * @description
 */
@Service
@CacheConfig(cacheNames = "user")  //可以不用这个注解，cacheNames的值作为默认键值使用
public class UserService {

    @Autowired
    private UserJPA userJPA;

    @Cacheable(cacheNames = "fengxiao")
    //有效期内重启项目后也还是从缓存读取,如果先删除了数据，再调这个方法，缓存没有更新
    public List<UserEntity> list(){
        return userJPA.findAll();
    }

    public String delete(Long id){
        userJPA.deleteById(id);
        return "删除成功";
    }

}
