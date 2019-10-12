package com.yuqiyu.lesson.jpa;

import com.yuqiyu.lesson.entity.UserEntity2;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ========================
 * Created with IntelliJ IDEA.
 * User：恒宇少年
 * Date：2017/4/18
 * Time：22:35
 * 码云：http://git.oschina.net/jnyqy
 * ========================
 */
public interface UserJPA2 extends JpaRepository<UserEntity2,Long>
{
    //使用SpringDataJPA方法定义查询,SpringDataJPA的一个规则
    public UserEntity2 findByUsername(String username);
}
