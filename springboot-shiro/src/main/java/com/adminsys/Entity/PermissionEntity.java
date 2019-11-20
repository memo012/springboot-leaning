package com.adminsys.Entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * @Author: qiang
 * @ClassName: PermissionEntity
 * @Description: 权限表
 * @Date: 2019/11/20 下午4:01
 * @Version: 1.0
 **/
@TableName("permission")
public class PermissionEntity implements Serializable {

    private static final long serialVersionUID = 6556179590132762063L;
    /**
     *  权限id
     */
    @TableId
    private Integer pid;

    /**
     *  权限名
     */
    private String pname;

    /**
     *  权限地址
     */
    private String url;


    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }


    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
