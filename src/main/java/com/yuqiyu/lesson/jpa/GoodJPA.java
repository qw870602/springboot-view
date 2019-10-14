package com.yuqiyu.lesson.jpa;

import com.yuqiyu.lesson.entity.GoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * ========================
 * Created with IntelliJ IDEA.
 * User：恒宇少年
 * Date：2017/4/15
 * Time：15:10
 * 码云：http://git.oschina.net/jnyqy
 * ========================
 */
public interface GoodJPA
        extends
        JpaRepository<GoodEntity,Long>
//        QuerydslPredicateExecutor<GoodEntity>
{

}
