package com.yuqiyu.lesson.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author fengxiao
 * @date 2019/10/8 19:55
 * @description
 */
@Entity
@Table(name="t_user")
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="t_id")
    private Long id;

    @Column(name="t_name")
    private String name;

    @Column(name="t_age")
    private int age;

    @Column(name="t_address")
    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
