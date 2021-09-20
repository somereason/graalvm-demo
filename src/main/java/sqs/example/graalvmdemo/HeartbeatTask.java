package sqs.example.graalvmdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Component
public class HeartbeatTask {

    AtomicInteger count = new AtomicInteger(0);

    @Scheduled(fixedRate = 5000)
    private void run() {
        log.info("running count: " + count.getAndAdd(1));
    }
}
