package com.db.batchScheduler.schedulers;

import com.db.batchScheduler.service.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BatchScheduler {

    @Autowired
    private SchedulerService schedulerService;

    @Scheduled(initialDelay = 5000, fixedDelay = 5000)
    public void executeScheduler(){
//        System.out.println("Hi");
        schedulerService.readData();
    }

}
