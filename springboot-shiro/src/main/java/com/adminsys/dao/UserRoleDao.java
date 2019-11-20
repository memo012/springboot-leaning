package com.adminsys.dao;

import com.adminsys.Entity.UserEntity;
import org.springframework.stereotype.Repository;

/**
 * @Author: qiang
 * @ClassName: UserRoleEntity
 * @Description: TODO
 * @Date: 2019/11/20 下午7:45
 * @Version: 1.0
 **/
@Repository
public interface UserRoleDao {
    UserEntity findByUsername(String username);
}
