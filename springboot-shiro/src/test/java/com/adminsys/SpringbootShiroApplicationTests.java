package com.adminsys;

import com.adminsys.Entity.UserEntity;
import com.adminsys.dao.UserDao;
import com.adminsys.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootShiroApplicationTests {

    @Resource
    private IUserService iUserService;

    @Test
    public void contextLoads() {
        UserEntity admin = iUserService.findByUsername("admin");
        System.out.println(admin.getUsername());
    }

}
