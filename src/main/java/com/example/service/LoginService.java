package com.example.service;

import com.example.entity.User;
import com.example.utils.ResponseResult;

import javax.servlet.http.HttpServletRequest;

/**
 * Login接口
 */
public interface LoginService {

    ResponseResult login(User user, HttpServletRequest request) throws Exception;

    ResponseResult logout();

    ResponseResult loginRes(User user, HttpServletRequest request) throws Exception;
}
