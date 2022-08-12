package com.example.controller;

import com.example.entity.User;
import com.example.service.LoginService;
import com.example.utils.ResponseResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 登录Controller
 */
@RestController
public class LoginController {

    @Resource
    private LoginService loginService;

    /**
     * 登录
     * @param user
     * @return ResponseResult
     */
    @RequestMapping("/user/login")
    @ResponseBody
    public ResponseResult login(@RequestBody User user, HttpServletRequest request) throws Exception {
        return loginService.login(user,request);
    }


    /***
     * 注册
     * @param user
     * @return
     */
    @RequestMapping("/user/loginRes")
    @ResponseBody
    public ResponseResult loginRes(@RequestBody User user, HttpServletRequest request) throws Exception {
        return loginService.loginRes(user,request);
    }


    /***
     * 注销
     * @return ResponseResult
     */
    @RequestMapping("/user/logout")
    @ResponseBody
    public ResponseResult logout(){
        return loginService.logout();
    }

}
