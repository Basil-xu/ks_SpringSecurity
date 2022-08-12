package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.Role;
import com.example.mapper.RoleMapper;
import com.example.service.RoleService;
import com.example.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author Xu
 * @since 2022-08-10
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {


    @Autowired
    RoleMapper roleMapper;

    /***
     * 添加角色
     * @param role
     * @return
     */
    @Override
    public ResponseResult insertRole(Role role) {
        roleMapper.insert(role);
        return new ResponseResult(200,"成功");
    }
}
