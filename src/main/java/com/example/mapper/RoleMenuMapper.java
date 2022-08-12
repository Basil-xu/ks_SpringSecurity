package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.RoleMenu;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 角色、菜单关联表 Mapper 接口
 * </p>
 *
 * @author Xu
 * @since 2022-08-10
 */
@Mapper
public interface RoleMenuMapper extends BaseMapper<RoleMenu> {

}
