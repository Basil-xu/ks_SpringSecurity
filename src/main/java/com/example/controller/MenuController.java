package com.example.controller;


import com.example.entity.Menu;
import com.example.service.MenuService;
import com.example.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 菜单表 前端控制器
 * </p>
 *
 * @author Xu
 * @since 2022-08-10
 */
@RestController
public class MenuController {

    @Autowired
    MenuService menuService;

    @PostMapping("/menu/list")
    @PreAuthorize("hasAuthority('SYSTEM:MENU:LIST')")
    @ResponseBody
    public ResponseResult MenuList(){
        return new ResponseResult(200,"success",menuService.list());
    }

    /***
     * 添加菜单
     * @param menu
     * @return
     */
    @PostMapping("/menu/insert")
    @PreAuthorize("hasAuthority('SYSTEM:MENU:INSERT')")
    @ResponseBody
    public ResponseResult MenuList(@RequestBody Menu menu){
        return  menuService.insertMenu(menu);
    }
}
