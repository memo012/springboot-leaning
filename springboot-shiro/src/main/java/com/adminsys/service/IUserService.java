package com.adminsys.service;

import com.adminsys.Entity.UserEntity;

/**
 * @Author: qiang
 * @ClassName: IUserService
 * @Description: TODO
 * @Date: 2019/11/20 下午4:59
 * @Version: 1.0
 **/
public interface IUserService {

    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return
     */
    UserEntity loginUser(String username, String password);

    /**
     *  通过用户名查询
     * @param username
     * @return
     */
    UserEntity findByUsername(String username);

}
