package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.UserRole;
import com.example.mapper.UserRoleMapper;
import com.example.service.UserRoleService;
import com.example.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户、角色关联表 服务实现类
 * </p>
 *
 * @author Xu
 * @since 2022-08-11
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

    @Autowired
    UserRoleMapper userRoleMapper;

    @Override
    public ResponseResult roleUserInsert(UserRole userRole) {
            userRoleMapper.insert(userRole);

        return new ResponseResult(200,"SUCCESS");
    }
}
