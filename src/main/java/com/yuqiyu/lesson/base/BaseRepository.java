package com.yuqiyu.lesson.base;

import com.yuqiyu.lesson.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * @author fengxiao
 * @date 2019/10/11 16:42
 * @description
 */
@NoRepositoryBean
public interface BaseRepository<T,PK extends Serializable> extends JpaRepository<T,PK>, JpaSpecificationExecutor<T> {
}
