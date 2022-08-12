package com.example.service.impl;

import com.example.entity.LoginUser;
import com.example.entity.User;
import com.example.handler.AuthenticationEntryPointImpl;
import com.example.mapper.UserLogMapper;
import com.example.mapper.UserMapper;
import com.example.service.LoginService;
import com.example.utils.JwtUtil;
import com.example.utils.RedisCache;
import com.example.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import static com.example.utils.IpAddr.getIpAddr;


/***
 * LoginService实现类
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserLogMapper userLogMapper;

    /***
     * 用户认证
     * @param user
     * @param request
     * @return ResponseResult
     */

    @Override
    public ResponseResult login(User user, HttpServletRequest request) throws Exception {
        //获取用户IP
        user.setUser_ip(getIpAddr(request));
        // TODO 获取当前时间戳
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.HOUR_OF_DAY, 3);
        // TODO 将User对象传递给认证处理器
        AuthenticationEntryPointImpl.getUserAccount(user);
        //用户认证
        // TODO AuthenticationManager authenticate 进行用户认证
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getAccount(),user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        // TODO 校验ip
        boolean  bool = userMapper.Checkip(user.getAccount()).equals(user.getUser_ip());
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        // TODO 如果认证没通过，给出对应的提示

        if(Objects.isNull(authenticate) || !bool){
            // TODO IP校验不正确
            userLogMapper.insertLog(loginUser.getUser().getId().toString(),user.getUser_ip(),1,null,null);
            return new ResponseResult(300,"登录失败,IP校验失败...");

        }
        // TODO 如果认证通过了，使用userid生成一个jwt jwt存入ResponseResult返回
        String jwt = JwtUtil.createJWT(loginUser.getUser().getId().toString());
        Map<String,String> map = new HashMap<>();
        map.put("token",jwt);
        // TODO 把完整的用户信息存入redis  userid作为key 设置key的过期时间 3个小时后过期 60*60*3 秒为单位
        redisCache.setCacheObject("token:"+loginUser.getUser().getId().toString(),loginUser);
        redisCache.expire("token:"+loginUser.getUser().getId().toString(),60*60);
        // TODO 将token/IP存储到mysql
        userLogMapper.insertLog(loginUser.getUser().getId().toString(),user.getUser_ip(),0,jwt,c.getTime());
        return new ResponseResult(200,"登录成功",map);
    }

    /**
     * 退出登录
     * @return ResponseResult
     */
    @Override
    public ResponseResult logout() {
        // TODO 获取SecurityContextHolder中的用户id
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        // TODO 删除redis中的值
          if(!redisCache.deleteObject("token:"+loginUser.getUser().getId())){
              return new ResponseResult(100,"注销失败");
          }
        return new ResponseResult(200,"注销成功");
    }

    /**
     * 用户注册
     * @param user
     * @return ResponseResult
     */
    @Override
    public ResponseResult loginRes(User user, HttpServletRequest request) throws Exception {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setUser_ip(getIpAddr(request));
        if(userMapper.insert(user)<=0){
            return new ResponseResult(100,"注册失败");
        }
        return new ResponseResult(200,"注册成功");
    }
}
