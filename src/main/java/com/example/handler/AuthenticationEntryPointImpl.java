package com.example.handler;


import com.alibaba.fastjson.JSON;
import com.example.entity.User;
import com.example.mapper.UserLogMapper;
import com.example.mapper.UserMapper;
import com.example.utils.ResponseResult;
import com.example.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 认证的异常处理类
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint{


    @Autowired
    UserLogMapper userLogMapper;

    @Autowired
    UserMapper userMapper;

    private static String userAccount;

    private static  Long userId;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) {
        ResponseResult result = new ResponseResult(HttpStatus.UNAUTHORIZED.value(),"用户名认证失败,账号或密码错误");

        if(userLogMapper.insertLog(userId,request.getHeader("HTTP_CLIENT_IP"),1,null,null)<=0){
            throw new RuntimeException("存入Mysql失败");
        }
        // TODO 处理移除
        WebUtils.renderString(response,JSON.toJSONString(result));
    }

    /***
     * 获取到用户账号
     * @param user
     */
    public static void getUserAccount(User user){
        userId = user.getId();
    }

}
