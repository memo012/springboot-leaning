package com.adminsys.Entity;

import java.util.Set;

/**
 * @Author: qiang
 * @ClassName: RoleEntity
 * @Description: TODO
 * @Date: 2019/11/20 下午4:00
 * @Version: 1.0
 **/
public class RoleEntity {

    private Integer rid;
    private String rname;
    private Set<PermissionEntity> permissionSet;
    private Set<UserEntity> users;

    public Set<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(Set<UserEntity> users) {
        this.users = users;
    }

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
