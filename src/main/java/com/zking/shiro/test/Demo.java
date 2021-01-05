package com.zking.shiro.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

public class Demo {

    public static void main(String[] args) {
        //读取配置文件
        IniSecurityManagerFactory ini=new IniSecurityManagerFactory("classpath:shiro.ini");
        //创建安全管理器
        SecurityManager instance = ini.getInstance();
        //设置安全管理器
        SecurityUtils.setSecurityManager(instance);
        //得到主体
        Subject subject = SecurityUtils.getSubject();
        //登录认证
        UsernamePasswordToken token=new UsernamePasswordToken("zs","1234");

        try {
            subject.login(token);
            System.out.println("登录成功！");
        }catch (UnknownAccountException ua){
            System.out.println("账号不存在");
        }catch (IncorrectCredentialsException ic){
            System.out.println("密码不正确");
        }catch (AuthenticationException e){
            System.out.println("账号和密码错误");
        }
        //消缓存
        subject.logout();



    }
}
