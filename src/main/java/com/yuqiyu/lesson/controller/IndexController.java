package com.yuqiyu.lesson.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yuqiyu.lesson.entity.UserEntity;
import com.yuqiyu.lesson.jpa.UserJPA;
import com.yuqiyu.lesson.utils.LoggerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author fengxiao
 * @date 2019/10/8 17:46
 * @description
 */
@Controller
@RequestMapping("/api")
public class IndexController {

    private final static Logger logger=LoggerFactory.getLogger(IndexController.class);
    @Autowired
    private UserJPA userJPA;

    @RequestMapping("/login_view")
    public String login_view(){
        return "login";
    }
    @RequestMapping("/main")
    public String main(){
        return "main";
    }
    @RequestMapping(value = "/index/{number}")
    @ResponseBody
    public String index(@PathVariable int number){
//        logger.debug("访问了debug方法");
//        logger.info("访问了info方法");
//        logger.error("访问了error方法");
        System.out.println(20/number);
        return "get index success";
    }
    @RequestMapping("/age")
    @ResponseBody
    public List<UserEntity> age(){
        return userJPA.naQuery(25);
    }
    @RequestMapping("/deleteWhere")
    @ResponseBody
    public String deleteWhere(){
        userJPA.deleteQuery("admin","111111");
        return "自定义删除成功";
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

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public String upload(HttpServletRequest request, MultipartFile file) {
        try {
            String uploadDir=request.getSession().getServletContext().getRealPath("/");
            uploadDir+="upload/file/";
            File dir=new File(uploadDir);
            if(!dir.exists()){
                //dir.mkdir(); 创建单层目录
                 dir.mkdirs();
            }
            executeUpload(uploadDir,file);
        } catch (Exception e) {
            e.printStackTrace();
            return "上传失败";
        }
        return "上传成功";
    }

    @RequestMapping(value = "/uploads",method = RequestMethod.POST)
    @ResponseBody
    public String uploads(HttpServletRequest request, MultipartFile[] file) {
        try {
            String uploadDir=request.getSession().getServletContext().getRealPath("/");
            uploadDir+="upload/file/";
            File dir=new File(uploadDir);
            if(!dir.exists()){
                //dir.mkdir(); 创建单层目录
                dir.mkdirs();
            }
            for(int i=0;i<file.length;i++){
                if(file[i]!=null){
                    executeUpload(uploadDir,file[i]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "上传失败";
        }
        return "上传成功";
    }

    private void executeUpload(String uploadDir,MultipartFile file) throws Exception{
        String suffix=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String fileName= UUID.randomUUID()+suffix;
        File serverFile=new File(uploadDir+fileName);
        file.transferTo(serverFile);
    }

}
