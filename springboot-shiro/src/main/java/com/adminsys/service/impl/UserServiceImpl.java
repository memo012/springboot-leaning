package com.adminsys.service.impl;

import com.adminsys.Entity.UserEntity;
import com.adminsys.dao.UserDao;
import com.adminsys.dao.UserRoleDao;
import com.adminsys.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: qiang
 * @ClassName: UserServiceImpl
 * @Description: TODO
 * @Date: 2019/11/20 下午5:00
 * @Version: 1.0
 **/
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRoleDao userRoleDao;

    @Override
    public UserEntity loginUser(String username, String password) {
        return userDao.selectOne(new QueryWrapper<UserEntity>().eq("username", username).eq("password", password));
    }

    @Override
    public UserEntity findByUsername(String username) {
        return userRoleDao.findByUsername(username);
    }



}
