package com.zking.shiro.servlet;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//从请求中拿到账号密码
        String username = req.getParameter("username");
        String pwd = req.getParameter("pwd");
        System.out.println(username);
        System.out.println(pwd);
        //设置账号中
        UsernamePasswordToken token=new UsernamePasswordToken(username,pwd);
        //得到主体
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            //登录成功就重定向
            resp.sendRedirect("main.jsp");
        }catch (Exception e){
            e.printStackTrace();
        }



    }
}
