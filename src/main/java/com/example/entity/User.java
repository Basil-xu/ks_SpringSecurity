package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


/**
 * 用户表(User)实体类
 * @Data               提供类的get、set、equals、hashCode、canEqual、toString方法
 * @AllArgsConstructor 全参构造器
 * @NoArgsConstructor  无参构造器
 * @TableName          指定数据库中的表
 * @TableId            对应的是将数据库的主键进行映射
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("db_user")
public class User implements Serializable {
    /**
     * 自增id
     */
    @TableId("id")
    private Long id;
    /**
     * 用户账号
     */
    private String account;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 账号是否锁定
     */
    private Byte locked;
    /**
     * 联系方式
     */
    private String phone;
    /**
     * 创建人
     */
    private String create_by;
    /**
     * 修改人
     */
    private String modify_by;
    /**
     * 创建时间
     */
    private Date create_time;
    /**
     * 修改时间
     */
    private  Date modify_time;
    /**
     * 1:已删除，0：未删除
     */
    private Byte delete_flag;
    /**
     * 用户IP
     */
    private String user_ip;

}
