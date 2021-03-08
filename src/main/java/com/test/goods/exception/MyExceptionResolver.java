package com.test.goods.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;

public class MyExceptionResolver implements HandlerExceptionResolver {

    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {


        ModelAndView modelAndView = new ModelAndView();
        // 返回的错误页面
        modelAndView.setViewName("error");
        e.printStackTrace();
        return modelAndView;

        /*
           作用: 将异常信息转为字符串输出, 为了能够让我们可以观察到在前台页面异常信息展示

        // 从堆栈中获取异常信息
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        e.printStackTrace(printWriter);

        ModelAndView modelAndView = new ModelAndView();
        // 将获取的异常信息转为字符串
        String message = stringWriter.toString();
        // 在控制台打印输出异常信息
        System.out.println(message);
        // 返回的错误页面
        modelAndView.setViewName("error");
        // 将异常信息返回给页面
        // modelAndView.addObject("message",message);
         */

    }


}
