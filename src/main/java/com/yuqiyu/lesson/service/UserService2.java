package com.yuqiyu.lesson.service;


import com.yuqiyu.lesson.entity.UserEntity2;
import com.yuqiyu.lesson.jpa.UserJPA2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * ========================
 * Created with IntelliJ IDEA.
 * User：恒宇少年
 * Date：2017/4/18
 * Time：22:40
 * 码云：http://git.oschina.net/jnyqy
 * ========================
 */
public class UserService2 implements UserDetailsService
{
    @Autowired
    UserJPA2 userJPA2;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity2 user = userJPA2.findByUsername(username);
        if(user == null)
        {
            throw new UsernameNotFoundException("未查询到用户："+username+"信息！");
        }
        return user;
    }
}
