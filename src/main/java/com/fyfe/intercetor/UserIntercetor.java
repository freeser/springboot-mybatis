package com.fyfe.intercetor;

import com.fyfe.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserIntercetor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User) request.getSession().getAttribute("session_user");
        if (user==null){
            response.sendRedirect(request.getContextPath()+"/user/toIndex");//拦截后跳转的方法
            System.out.println("已成功拦截并转发跳转");
            return false;
        }
        System.out.println("合格不需要拦截，放行" + user.getUsername());
        return true;
    }
}