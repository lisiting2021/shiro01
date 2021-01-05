package com.zking.shiro.realm;

import com.zking.shiro.mapper.UserMapper;
import com.zking.shiro.model.User;
import com.zking.shiro.service.IUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class Myrealm extends AuthorizingRealm {

    @Autowired
    private IUserService iUserService;

   //权限认证
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    //身份认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取用户输入的账号密码
        String password = authenticationToken.getCredentials().toString();
        String username = authenticationToken.getPrincipal().toString();
        //根据用户输入的账号查找该账号的所有信息
        User user = iUserService.login(username);
        System.out.println("......"+user);
        if(user==null){
            throw new RuntimeException("未知账号");
        }
        SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(
                user.getUsername(),
                user.getPassword(),
//              盐
                ByteSource.Util.bytes(user.getSalt()),
                this.getName()
        );
        return info;
    }
}
