package com.adminsys.dao;

import com.adminsys.Entity.RoleEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * @Author: qiang
 * @ClassName: RoleEntity
 * @Description: 角色数据层
 * @Date: 2019/11/20 下午4:44
 * @Version: 1.0
 **/
@Repository
public interface RoleDao extends BaseMapper<RoleEntity> {
}
