package cuc.dawei.springbootprogramintegration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName testController
 * @Description TODO
 * @Author Mike
 * @Date 2019/6/13 17:50
 * @Version 1.0
 */
@Controller
public class testController {
    @RequestMapping(value = "index")
    public String getIndex(){
       return "index";
    }
}
