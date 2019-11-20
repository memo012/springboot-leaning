package com.adminsys.Entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Set;

/**
 * @Author: qiang
 * @ClassName: UserEntity
 * @Description: 用户表
 * @Date: 2019/11/20 下午3:59
 * @Version: 1.0
 **/
@TableName("users")
public class UserEntity implements Serializable {


    private static final long serialVersionUID = -359735344937282055L;

    /**
     *  标识符
     */
    @TableId("id")
    private String uid;

    /**
     *  用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 角色id
     */
    private Integer roleId;

    /**
     *  角色
     */
    @TableField(exist = false)
    private Set<RoleEntity> roles;


    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
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

}
