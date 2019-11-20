package com.adminsys.exception;

import com.adminsys.util.JSONResult;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: qiang
 * @ClassName: LvException
 * @Description: TODO
 * @Date: 2019/11/20 下午8:19
 * @Version: 1.0
 **/
@RestControllerAdvice
public class ExceptionController {


    // 捕捉shiro的异常
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(ShiroException.class)
    public JSONResult handle401(ShiroException e) {
        return JSONResult.errorTokenMsg("token不存在");
    }

    // 捕捉UnauthorizedException
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedException.class)
    public JSONResult handle401() {
        return JSONResult.errorPermissionMsg("不具备某种权限");
    }


    // 捕捉其他所有异常
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public JSONResult globalException(HttpServletRequest request, Throwable ex) {
        return JSONResult.errorMsg("异常");
    }



}
