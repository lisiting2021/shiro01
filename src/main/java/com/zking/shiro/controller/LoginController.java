package com.zking.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/LoginController")
public class LoginController {

    @RequestMapping("/login")
    public String login(String username,String password){
        //得到主体
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(username,password);
        try {
            subject.login(token);
//            System.out.println("123456");
            //登录成功跳主页面
            return "main";
        } catch (Exception e) {
            return "login";
        }
    }


}
