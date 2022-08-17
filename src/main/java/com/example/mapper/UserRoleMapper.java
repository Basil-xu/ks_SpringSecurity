package com.example.mapper;



import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户、角色关联表 Mapper 接口
 * </p>
 *
 * @author Xu
 * @since 2022-08-10
 */
@Mapper
@Repository
public interface UserRoleMapper extends BaseMapper<UserRole> {

}
