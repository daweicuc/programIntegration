package cuc.dawei.springbootprogramintegration.controller;

import cuc.dawei.springbootprogramintegration.entity.User;
import cuc.dawei.springbootprogramintegration.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author Mike
 * @Date 2019/6/2 17:18
 * @Version 1.0
 */
@RestController
@RequestMapping(value="user")
@Api(tags="对用户的管理API")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping(value="insertUser")
    @ApiOperation(value="增加新用户")
    @ApiImplicitParam(name = "user",value = "用户实体",required = true,dataType = "User")
    public String insertUser(@RequestBody User user){
        System.out.println(user);
        userService.insertUser(user);
        return "插入用户成功";
    }
}
