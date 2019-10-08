package com.yuqiyu.lessonOne.jpa;

import com.yuqiyu.lessonOne.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
 * @author fengxiao
 * @date 2019/10/8 19:58
 * @description
 */
public interface UserJPA extends JpaRepository<UserEntity,Long>,
        JpaSpecificationExecutor<UserEntity>, Serializable {
}
