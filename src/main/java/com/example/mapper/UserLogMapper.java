package com.example.mapper;

import com.example.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * <p>
 * 用户登录记录表 Mapper 接口
 * </p>
 *
 * @author Xu
 * @since 2022-08-10
 */
@Mapper
@Repository
public interface UserLogMapper {
     int insertLog(@Param("user_id") Long user_id, @Param("login_ip") String login_ip, @Param("success") int success, @Param("token") String token,@Param("expire_time")Date expire_time);

     int UpdateStatus(User user);
}
