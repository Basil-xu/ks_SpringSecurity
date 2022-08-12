package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.RoleMenu;
import com.example.utils.ResponseResult;

/**
 * <p>
 * 角色、菜单关联表 服务类
 * </p>
 *
 * @author Xu
 * @since 2022-08-11
 */
public interface RoleMenuService extends IService<RoleMenu> {

    ResponseResult RoleMenuinsert(RoleMenu roleMenu);
}
