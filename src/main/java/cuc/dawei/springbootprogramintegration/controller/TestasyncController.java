package cuc.dawei.springbootprogramintegration.controller;

import cuc.dawei.springbootprogramintegration.entity.User;
import cuc.dawei.springbootprogramintegration.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @ClassName TestasyncController
 * @Description
 * 执行异步操作的测试
 * @Author Mike
 * @Date 2019/6/14 20:10
 * @Version 1.0
 */
@Component
public class TestasyncController {
    @Autowired
    UserService userService;
    @Async("asyncPoolTaskExecutor")
    public void AsncInsert(User user){
        Logger logger = LoggerFactory.getLogger(TestasyncController.class);
        userService.insertUser(user);
        logger.info("正在执行异步的插入操作！");
    }


}
