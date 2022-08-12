package com.example.controller;


import com.example.entity.RoleMenu;
import com.example.service.RoleMenuService;
import com.example.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 角色、菜单关联表 前端控制器
 * </p>
 *
 * @author Xu
 * @since 2022-08-10
 */
@RestController
public class RoleMenuController {

    @Autowired
    RoleMenuService roleMenuService;

    @PostMapping("/roleMenu/insert")
    @PreAuthorize("hasAnyAuthority('SYSTEM:ROLEMENU:INSERT')")
    @ResponseBody
    public ResponseResult roleMenu(@RequestBody RoleMenu roleMenu){

        return roleMenuService.RoleMenuinsert(roleMenu);
    }

}
