package com.adminsys.dao;

import com.adminsys.Entity.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * @Author: qiang
 * @ClassName: UserEntity
 * @Description: 用户数据层
 * @Date: 2019/11/20 下午4:44
 * @Version: 1.0
 **/
@Repository
public interface UserDao extends BaseMapper<UserEntity> {



}
