package com.yuqiyu.lesson.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author fengxiao
 * @date 2019/10/9 14:43
 * @description
 */
public class SessionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登录不拦截
        if(request.getRequestURI().equals("/user/login")||request.getRequestURI().equals("/user/login_view")){
            return true;
        }
        //验证session
        Object object=request.getSession().getAttribute("_session_user");
        if(object==null){
            response.sendRedirect("/user/login_view");
            return false;
        }
        return true;
    }
}
