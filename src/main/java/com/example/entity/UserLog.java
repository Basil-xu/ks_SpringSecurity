package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/***
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("db_user_log")
public class UserLog {
    /**
     * 自增id
     */
    @TableId
    private int id;
    /**
     *v用户id
     */
    private Long user_id;
    /**
     * 登陆ip
     */
    private String login_ip;
    /**
     *创建时间
     */
    private Date login_time;
    /**
     *描述
     */
    private String describe;
    /***
     * 成功状态
     */
    private  int success;
    /***
     *登陆token
     */
    private  String token;
    /***
     *过期时间
     */
    private  Date expire_time;
    /***
     *系统id  1:后台;2:单点;3:验证码
     */
    private int system_id;
    /***
     *失效状态 0未失效，1失效
     */
    private boolean invalid;




}
