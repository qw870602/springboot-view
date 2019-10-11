package com.yuqiyu.lesson.jpa;

import com.yuqiyu.lesson.base.BaseRepository;
import com.yuqiyu.lesson.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * @author fengxiao
 * @date 2019/10/8 19:58
 * @description
 */
@Transactional
public interface UserJPA extends BaseRepository<UserEntity,Long> {
    //自定义SQL
    @Query(value = "select*from t_user where t_age>?1",nativeQuery = true)
    List<UserEntity> naQuery(int age);

    @Modifying
    @Query(value = "delete from t_user where t_name=?1 and t_pwd=?2",nativeQuery = true)
    void deleteQuery(String name,String pwd);
}
