package com.yuqiyu.lesson.base;

import lombok.Data;

import java.io.Serializable;

/**
 * @author fengxiao
 * @date 2019/10/11 16:54
 * @description
 */
@Data
public class BaseEntity implements Serializable {

    protected int page=1;
    protected int size=20;
    protected String sidx="id";
    protected String sord;

}
