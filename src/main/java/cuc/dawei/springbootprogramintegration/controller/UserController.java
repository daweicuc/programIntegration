package cuc.dawei.springbootprogramintegration.controller;

import cuc.dawei.springbootprogramintegration.entity.User;
import cuc.dawei.springbootprogramintegration.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
    @GetMapping(value = "getAllUser")
    @ApiOperation(value = "获取所有用户信息")
    public List<User> getAllUser(){
        System.out.println(userService.getAllUser());
        return  userService.getAllUser();
    }
    @PutMapping(value = "updateName")
    @ApiOperation(value = "修改用户名称")
    @ApiImplicitParams({@ApiImplicitParam(name="name1",value="改之后名称",dataType = "String"),
            @ApiImplicitParam(name="name2",value="改之前名称",dataType = "String")
    })
    public String updateUser(HttpServletRequest request){
        String name1=request.getParameter("name1");
        String name2=request.getParameter("name2");
        int ii=userService.updateUser(name1,name2);
        return "ii";
    }
}
