package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.Menu;
import com.example.mapper.MenuMapper;
import com.example.service.MenuService;
import com.example.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author Xu
 * @since 2022-08-10
 */
@Service
class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {


    @Autowired
    MenuMapper menuMapper;






    @Override
    public ResponseResult insertMenu(Menu menu) {
        if(menuMapper.insert(menu)>0){
            return new ResponseResult(200,"0");
        }
        return new ResponseResult(300,"1");
    }




}
