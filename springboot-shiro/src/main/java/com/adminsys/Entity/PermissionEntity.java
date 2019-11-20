package com.adminsys.Entity;

/**
 * @Author: qiang
 * @ClassName: PermissionEntity
 * @Description: TODO
 * @Date: 2019/11/20 下午4:01
 * @Version: 1.0
 **/
public class PermissionEntity {

    private Integer pid;
    private String name;
    private String url;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
