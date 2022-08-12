package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author Xu
 * @since 2022-08-10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("db_role")
public class Role implements Serializable {

    @TableId
    private Long id;

    private String name;

    /**
     * 角色权限字符串
     */
    private String roleKey;

    /**
     * 角色状态（0正常 1停用）
     */
    private String status;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否删除（0未删除 1已删除）
     */
    private Integer delFlag;

    private Long createBy;

    private Long updateBy;

    /**
     * 备注
     */
    private String remark;


}