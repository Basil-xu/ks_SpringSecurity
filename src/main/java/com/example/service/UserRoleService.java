package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.UserRole;
import com.example.utils.ResponseResult;

/**
 * <p>
 * 用户、角色关联表 服务类
 * </p>
 *
 * @author Xu
 * @since 2022-08-11
 */
public interface UserRoleService extends IService<UserRole> {

    ResponseResult roleUserInsert(UserRole userRole);
}
