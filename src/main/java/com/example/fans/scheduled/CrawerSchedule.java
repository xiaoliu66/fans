package com.example.fans.scheduled;

import com.example.fans.controller.FansController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author xiaoliu66@github.com
 * @since 2021/7/5 20:29
 * @version 1.0
 */
@Component
public class CrawerSchedule implements SchedulingConfigurer {

    @Autowired
    private FansController crawerFans;

    @Value("${mid}")
    private String mid; // 用户id

    @Value("${cron}")
    private String crons;

    private Logger logger = LoggerFactory.getLogger(CrawerSchedule.class);

    // @Scheduled(cron = "0 */1 * * * *")
    // public void schedule() {
    //     logger.info("任务开始：{}", LocalDateTime.now());
    //     Integer fans = crawerFans.getFans(String.valueOf(mid));
    //     System.out.println(fans);
    //     logger.info("任务结束：{}", LocalDateTime.now());
    // }

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        // String cron = crons;
        //
        // scheduledTaskRegistrar.addCronTask(new Runnable() {
        //     @Override
        //     public void run() {
        //         logger.info("任务开始：{}", LocalDateTime.now());
        //         Integer fans = crawerFans.getFansByUid(String.valueOf(mid));
        //         System.out.println(fans);
        //         logger.info("任务结束：{}", LocalDateTime.now());
        //     }
        // },cron);
    }
}
