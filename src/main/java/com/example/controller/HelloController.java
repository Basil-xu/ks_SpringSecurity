package com.example.controller;

import com.example.mapper.RoleMapper;
import com.example.mapper.UserMapper;
import com.example.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;


    @RequestMapping("/hello/user/list")
    @PreAuthorize("hasAuthority('SYSTEM:USER:LIST')")
    @ResponseBody
    public ResponseResult user(){
        return new ResponseResult(200,"成功",roleMapper.selectList(null));
    }


    @RequestMapping("/hello/user/log")
    @PreAuthorize("hasAuthority('SYSTEM:USER_LOG:LIST')")
    @ResponseBody
    public ResponseResult user_log(){
        return new ResponseResult(200,"成功",userMapper.selectList(null));
    }

}
