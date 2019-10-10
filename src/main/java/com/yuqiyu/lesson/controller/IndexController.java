package com.yuqiyu.lesson.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yuqiyu.lesson.entity.UserEntity;
import com.yuqiyu.lesson.jpa.UserJPA;
import com.yuqiyu.lesson.utils.LoggerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * @author fengxiao
 * @date 2019/10/8 17:46
 * @description
 */
@RestController
@RequestMapping("/user")
public class IndexController {

    @RequestMapping("/login_view")
    public String login_view(){
        return "login";
    }
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    /**
     * 简单测试请求日志的记录
     * @param request 请求对象
     * @param name 用户名
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/testLog",method = RequestMethod.GET,produces = { "text/html;charset=utf-8" })
    public JSONObject login(HttpServletRequest request, String name) throws Exception
    {
        JSONObject obj = new JSONObject();
        obj.put("msg","用户："+name+"，登录成功。");
        //String str=JSON.toJSONString(obj);
        //将返回值写入到请求对象中
        request.setAttribute(LoggerUtils.LOGGER_RETURN,obj);
        return obj;
    }

}
