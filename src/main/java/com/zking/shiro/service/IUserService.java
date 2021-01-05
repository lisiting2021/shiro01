package com.zking.shiro.service;

import com.zking.shiro.model.User;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IUserService {

    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User login(String username);
}
