package com.example.controller;

import com.example.entity.UserRole;
import com.example.service.UserRoleService;
import com.example.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户、角色关联表 前端控制器
 * </p>
 *
 * @author Xu
 * @since 2022-08-10
 */
@RestController
public class UserRoleController {

    @Autowired
    UserRoleService userRoleService;

    @PostMapping("/roleUser/insert")
    @PreAuthorize("hasAnyAuthority('SYSTEM:USERROLE:INSERT')")
    @ResponseBody
    public ResponseResult roleUserInsert(@RequestBody UserRole userRole){
        return userRoleService.roleUserInsert(userRole);
    }
}
