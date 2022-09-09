package com.kamaathedj.Graphql;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.LoggerFactory;

import java.util.concurrent.DelayQueue;
import java.util.logging.Logger;

public class MyTests {
 Logger log = (Logger) LoggerFactory.getLogger(MyTests.class);
    @Test
    void delay() throws InterruptedException {
        final DelayQueue<DelayedEvent>delayQueue = new DelayQueue<>();
        final long timeFirst = System.currentTimeMillis()+10_000;
        delayQueue.offer(new DelayedEvent(timeFirst,"1"));
        log.info("done");
        log.info(delayQueue.take().message());
    }
}
