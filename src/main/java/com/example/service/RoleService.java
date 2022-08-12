package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Role;
import com.example.utils.ResponseResult;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author Xu
 * @since 2022-08-10
 */
public interface RoleService extends IService<Role> {

    ResponseResult insertRole(Role role);
}
