package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Menu;
import com.example.utils.ResponseResult;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author Xu
 * @since 2022-08-10
 */
public interface MenuService extends IService<Menu> {

    ResponseResult insertMenu(Menu menu);

}
