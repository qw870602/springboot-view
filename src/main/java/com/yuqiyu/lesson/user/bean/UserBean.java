package com.yuqiyu.lesson.user.bean;

import javax.persistence.*;

/**
 * 用户实体
 * ========================
 * Created with IntelliJ IDEA.
 * User：恒宇少年
 * Date：2017/5/30
 * Time：14:10
 * 码云：http://git.oschina.net/jnyqy
 * ========================
 */
@Entity
@Table(name = "t_user")
public class UserBean {

    @Id
    @Column(name = "t_id")
    @GeneratedValue
    private Long id;

    @Column(name = "t_name")
    private String name;

    @Column(name = "t_age")
    private int age;

    @Column(name = "t_address")
    private String address;

    @Column(name = "t_pwd")
    private String pwd;

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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
