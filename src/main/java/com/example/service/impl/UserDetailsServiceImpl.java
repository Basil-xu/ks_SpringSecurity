package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.entity.LoginUser;
import com.example.entity.User;
import com.example.mapper.MenuMapper;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MenuMapper menuMapper;



    // TODO 实现UserDetailsService接口，重写UserDetails方法，自定义用户的信息从数据中查询
    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {

        // TODO （认证，即校验该用户是否存在）查询用户信息
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getAccount,account);
        User user = userMapper.selectOne(queryWrapper);
        if (Objects.isNull(user)){
            throw new RuntimeException("用户名或者密码错误");
        }
        // TODO (授权，即查询用户具有哪些权限)查询对应的用户信息
        //List<String> list = new ArrayList<String>(Arrays.asList("test","admin"));

        List<String> list = menuMapper.selectPermsByUserId(user.getId());
        //把数据封装成UserDetails返回
        return new LoginUser(user,list);
    }
}
