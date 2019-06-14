package cuc.dawei.springbootprogramintegration.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @ClassName ScheduledService
 * @Description TODO
 * @Author Mike
 * @Date 2019/6/14 21:26
 * @Version 1.0
 */
@Service
public class ScheduledService {
    //定时任务：秒 分 时 日 月 周
    @Scheduled(cron = "0 * * * * MON-SAT")
    public void hello(){
        System.out.println("执行定时任务");
    }
}
