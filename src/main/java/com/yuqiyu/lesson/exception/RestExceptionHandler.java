package com.yuqiyu.lesson.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * ========================
 * Created with IntelliJ IDEA.
 * User：恒宇少年
 * Date：2017/4/29
 * Time：10:38
 * 码云：http://git.oschina.net/jnyqy
 * ========================
 */
@ControllerAdvice(annotations = Controller.class)  //配置控制器通知
@ResponseBody
public class RestExceptionHandler
{
    /**
     * 默认统一异常处理方法
     * @param e 默认Exception异常对象
     * @return
     */
    @ExceptionHandler //用来配置需要拦截的异常类型，默认是全局类型
    @ResponseStatus //默认500
    public ApiResult runtimeExceptionHandler(Exception e) {
        return ApiResultGenerator.errorResult(e.getMessage(),e);
    }
}
