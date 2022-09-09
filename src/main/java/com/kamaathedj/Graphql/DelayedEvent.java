package com.kamaathedj.Graphql;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public record DelayedEvent(long startTime, String message) implements Delayed {

    @Override
    public long getDelay( TimeUnit unit) {
        long diff = startTime - System.currentTimeMillis();
        return unit.convert(diff, TimeUnit.MILLISECONDS);
    }
    @Override
    public int compareTo( Delayed o) {
        return (int) (this.startTime - ((DelayedEvent) o).startTime);
    }


}
