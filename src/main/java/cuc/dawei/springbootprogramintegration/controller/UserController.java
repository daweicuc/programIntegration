package cuc.dawei.springbootprogramintegration.controller;

import cuc.dawei.springbootprogramintegration.entity.User;
import cuc.dawei.springbootprogramintegration.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName UserController
 * @Description 对用户数据的增删改查
 * @Author Mike
 * @Date 2019/6/2 17:18
 * @Version 1.0
 */
@EnableAsync
@RestController
@RequestMapping(value="user",produces = "application/json;charset=utf-8")
@Api(tags="对用户的管理API")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    User user;
    @Autowired
    TestasyncController testasyncController;

    Logger logger = LoggerFactory.getLogger(UserController.class);
    @PostMapping(value="insertUser")
    @ApiOperation(value="增加新用户")
    @ApiImplicitParam(name = "user",value = "用户实体",required = true,dataType = "User")
    public String insertUser(@RequestBody User user){
        logger.info("插入的用户名："+user.getName()+"---密码："+user.getPasd());
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

    @PostMapping(value="insertUserAsyn",produces = "application/json;charset=utf-8" )
    @ApiOperation(value="异步增加新用户")
    @ApiImplicitParams({@ApiImplicitParam(name = "name",value = "用户名",required = true,dataType = "String"),
            @ApiImplicitParam(name = "pasd",value = "密码",required = true,dataType = "String")})
    public void TestSync(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String pasd = request.getParameter("pasd");
        user.setName(name);
        user.setPasd(pasd);
        logger.info("您要插入的信息如下："+user.getName()+user.getPasd()+"\n下面将会异步执行插入操作！");
        response.getWriter().print("您要插入的信息如下："+user+"\n下面将会异步执行插入操作！");
        try {
            testasyncController.AsncInsert(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
