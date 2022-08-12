package com.example.controller;


import com.example.entity.Role;
import com.example.service.RoleService;
import com.example.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author Xu
 * @since 2022-08-10
 */
@RestController
public class RoleController {


    @Autowired
    RoleService roleService;
    @PostMapping("/role/list")
    @PreAuthorize("hasAnyAuthority('SYSTEM:ROLE:LIST')")
    @ResponseBody
    public ResponseResult roleQuery(){
        return new ResponseResult(200,"success",roleService.list());
    }

    /***
     * 添加角色
     * @param role
     * @return
     */
    @PostMapping("/role/insert")
    @PreAuthorize("hasAuthority('SYSTEM:ROLE:INSERT')")
    @ResponseBody
    public ResponseResult roleInsert(@RequestBody Role role){
        return roleService.insertRole(role);
    }

}
