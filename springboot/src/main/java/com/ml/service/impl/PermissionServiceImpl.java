package com.ml.service.impl;

import com.ml.entity.Permission;
import com.ml.dao.PermissionMapper;
import com.ml.service.PermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {
    /**
     * 根据用户ID查询权限列表
     *
     * @param userId
     * @return
     */
        @Override
        public List<Permission> findPermissionListByUserId(Long userId) {
            return baseMapper.findPermissionListByUserId(userId);
        }

    }
