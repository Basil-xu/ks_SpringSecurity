package com.example.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.RoleMenu;
import com.example.mapper.RoleMenuMapper;
import com.example.service.RoleMenuService;
import com.example.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色、菜单关联表 服务实现类
 * </p>
 *
 * @author Xu
 * @since 2022-08-11
 */
@Service
class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements RoleMenuService {

    @Autowired
    RoleMenuMapper  roleMenuMapper;

    @Override
    public ResponseResult RoleMenuinsert(RoleMenu roleMenu) {
        roleMenuMapper.insert(roleMenu);
        return new ResponseResult(200,"成功");
    }
}
