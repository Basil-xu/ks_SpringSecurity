package com.example.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class LoginUser implements UserDetails {

    private  User user;

    // TODO 储存权限信息集合
    private List<String> permissions;

    // TODO 储存SpringSecurity 需要的权限信息集合
    @JSONField(serialize = false) // TODO
    private  List<SimpleGrantedAuthority>  authorities;



    /***
     * 获取权限信息
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (authorities!=null){
            return authorities;
        }
        // TODO 把 permissions 中String类型的权限信息封装成 SimpleGrantedAuthority 对象 存入 authorities 中
        authorities = permissions.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        return authorities;
    }



    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getAccount();
    }

    public String getUserIp(){
        return  getUser().getUser_ip();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public LoginUser(User user, List<String> permissions) {
        this.user = user;
        this.permissions = permissions;
    }
}
