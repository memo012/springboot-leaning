package com.adminsys.dao;

import com.adminsys.Entity.PermissionEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * @Author: qiang
 * @ClassName: PermissionEntity
 * @Description: 权限数据层
 * @Date: 2019/11/20 下午4:45
 * @Version: 1.0
 **/
@Repository
public interface PermissionDao extends BaseMapper<PermissionEntity> {
}
