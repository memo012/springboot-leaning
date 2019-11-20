package com.adminsys.Entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Set;

/**
 * @Author: qiang
 * @ClassName: RoleEntity
 * @Description: 角色表
 * @Date: 2019/11/20 下午4:00
 * @Version: 1.0
 **/
@TableName("role")
public class RoleEntity implements Serializable {

    private static final long serialVersionUID = -2351487354936762520L;
    /**
     * 角色id
     */
    @TableId
    private Integer rid;

    /**
     *  角色名
     */
    private String rname;

    /**
     *  权限名（一个角色可能对应多个权限）
     */
    @TableField(exist = false)
    private Set<PermissionEntity> permissionSet;



    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public Set<PermissionEntity> getPermissionSet() {
        return permissionSet;
    }

    public void setPermissionSet(Set<PermissionEntity> permissionSet) {
        this.permissionSet = permissionSet;
    }

}
