package com.test.goods.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HandlerInterceptor01 implements HandlerInterceptor {

    // 在处理器执行之前
    // 登录校验/权限拦截
    // true继续执行, false中止执行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle方法执行");

        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        if (!email.equals("")) {
            return true;
        } else {
            response.sendRedirect(request.getContextPath() + "/goods/showLogin");
            return false;
        }
    }

    // 在处理器执行之后, 视图解析器之前
    // 在返回页面前可进行的操作
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle方法执行");
    }

    // 在处理器执行完毕, 视图解析器执行完毕之后
    // 记录日志
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion方法执行");
    }
}
