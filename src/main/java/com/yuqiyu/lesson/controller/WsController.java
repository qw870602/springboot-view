package com.yuqiyu.lesson.controller;

import com.yuqiyu.lesson.websocket.WiselyMessage;
import com.yuqiyu.lesson.websocket.WiselyReponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * ========================
 * Created with IntelliJ IDEA.
 * User：恒宇少年
 * Date：2017/4/27
 * Time：22:12
 * 码云：http://git.oschina.net/jnyqy
 * ========================
 */
@Controller
public class WsController {
    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse") //对订阅@SendTo中路径的浏览器发送请求
    public WiselyReponse say(WiselyMessage message) throws Exception
    {
        //等待3秒返回消息内容
        Thread.sleep(3000);
        return new WiselyReponse("欢迎使用webScoket："+message.getName());
    }
}
