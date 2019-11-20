package com.adminsys.shiro;

import com.adminsys.Entity.PermissionEntity;
import com.adminsys.Entity.RoleEntity;
import com.adminsys.Entity.UserEntity;
import com.adminsys.service.IUserService;
import com.adminsys.util.JWTUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @Author: qiang
 * @ClassName: AutoRealm
 * @Description: TODO
 * @Date: 2019/11/20 下午4:42
 * @Version: 1.0
 **/
public class AuthRealm extends AuthorizingRealm {

    @Resource
    private IUserService iUserService;


    /**
     * 大坑！，必须重写此方法，不然Shiro会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }


    /**
     * 权限校验
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("权限校验");
        String username = JWTUtil.getUsername(principalCollection.toString());
        UserEntity user = iUserService.findByUsername(username);
        List<String> list = new ArrayList<>();
        List<String> roleNameList = new ArrayList<>();
        Set<RoleEntity> roles = user.getRoles();
        if (!CollectionUtils.isEmpty(roles)) {
            for (RoleEntity role :
                    roles) {
                roleNameList.add(role.getRname());
                Set<PermissionEntity> permissionSet = role.getPermissionSet();
                if (!CollectionUtils.isEmpty(permissionSet)) {
                    for (PermissionEntity permission :
                            permissionSet) {
                        System.out.println(permission.getPname());
                        list.add(permission.getPname());
                    }
                }
            }
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRoles(roleNameList);
        info.addStringPermissions(list);
        return info;
    }


    /**
     * 登录校验
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("登录校验");
        String token = (String) authenticationToken.getCredentials();
        // 解密获得username，用于和数据库进行对比
        String username = JWTUtil.getUsername(token);
        if (username == null) {
            throw new AuthenticationException("token认证失败");
        }
        UserEntity byUsername = iUserService.findByUsername(username);
        if (byUsername == null) {
            throw new AuthenticationException("用户名不存在");
        }
        if (!JWTUtil.verify(token, username, byUsername.getPassword())) {
            throw new AuthenticationException("用户名或密码错误");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(token, token, getName());
        return info;
    }
}
