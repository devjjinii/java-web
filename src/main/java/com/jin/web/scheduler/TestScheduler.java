package com.jin.web.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class TestScheduler {

    Logger logger = LoggerFactory.getLogger(TestScheduler.class);

    @Scheduled(cron = "*/5 * * * * *") // 5초마다
    public void scheduleTest() {
        logger.info("scheduleTest 동작중 >>>> : {}" , Calendar.getInstance().getTime());
    }
}
