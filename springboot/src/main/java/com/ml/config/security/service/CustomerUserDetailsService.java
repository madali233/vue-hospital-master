package com.ml.config.security.service;

import com.ml.entity.User;
import com.ml.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Auther:ml
 * @Date:2022/12/23 - 12 - 23 - 8:42
 * @Description:com.ml.config.security.service
 * @version: 1.0
 */
@Component
public class CustomerUserDetailsService implements UserDetailsService {
    @Resource
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws
            UsernameNotFoundException {
    //调用根据用户名查询用户信息的方法
        User user = userService.findUserByUserName(username);
    //如果对象为空，则认证失败
        if (user == null) {
            throw new UsernameNotFoundException("用户名或密码错误!");
        }
        return user;
    }
}
