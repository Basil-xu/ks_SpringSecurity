package com.example.entity;
/**
 * <p>
 * 角色、菜单关联表
 * </p>
 *
 * @author Xu
 * @since 2022-08-10
 */

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 角色、菜单关联表
 * </p>
 *
 * @author Xu
 * @since 2022-08-10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("db_role_menu")
@EqualsAndHashCode(callSuper = false)
public class RoleMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    @TableId
    private Long roleId;

    /**
     * 菜单id
     */
    private Long menuId;


}
