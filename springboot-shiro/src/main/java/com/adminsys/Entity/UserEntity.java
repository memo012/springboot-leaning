package com.adminsys.Entity;

import java.util.Set;

/**
 * @Author: qiang
 * @ClassName: UserEntity
 * @Description: TODO
 * @Date: 2019/11/20 下午3:59
 * @Version: 1.0
 **/
public class UserEntity {

    private Integer uid;
    private String username;
    private String password;
    private Set<RoleEntity> roles;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
    }

}
