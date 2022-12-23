package com.ml.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ml.entity.User;
import com.ml.dao.UserMapper;
import com.ml.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    /**
     * 根据用户名查询用户信息
     * @param userName
     * @return
     */
    @Override
    public User findUserByUserName(String userName) {
//创建条件构造器
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
//用户名
        queryWrapper.eq("username",userName);
//返回查询记录
        return baseMapper.selectOne(queryWrapper);
    }

}
