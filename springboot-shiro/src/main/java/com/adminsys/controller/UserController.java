package com.adminsys.controller;

import com.adminsys.Entity.UserEntity;
import com.adminsys.service.IUserService;
import com.adminsys.util.JSONResult;
import com.adminsys.util.JWTUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: qiang
 * @ClassName: UserController
 * @Description: TODO
 * @Date: 2019/11/20 下午6:20
 * @Version: 1.0
 **/
@RestController
public class UserController {

    @Autowired
    private IUserService iUserService;

    @PostMapping("login")
    public JSONResult userLogin(@RequestParam("username") String username,@RequestParam("password") String password){
        UserEntity userEntity = iUserService.loginUser(username, password);
        if (userEntity != null) {
            return JSONResult.ok(JWTUtil.sign(username, password));
        }
        return JSONResult.build(401, "查询为空", null);
    }


    @RequestMapping(path = "/401")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public JSONResult unauthorized() {
        return JSONResult.errorRolesMsg("无权限");
    }


    @GetMapping("/article")
    public JSONResult article() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            return JSONResult.ok("你已登录");
        } else {
            return JSONResult.ok("你未登录");
        }
    }


    @GetMapping("/require_auth")
    @RequiresAuthentication
    public JSONResult requireAuth() {
        return JSONResult.ok("你已认证");
    }


    @GetMapping("/require_role")
    @RequiresRoles("admin")
    public JSONResult requireRole() {
        return JSONResult.ok("你是该角色");
    }

    @GetMapping("/require_permission")
    @RequiresPermissions(logical = Logical.AND, value = {"delete", "add"})
    public JSONResult requirePermission() {
        return JSONResult.ok("你具有该权限");
    }


}
