package moai.concurrent;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class MThreadFactory implements ThreadFactory {
    private AtomicInteger counter = new AtomicInteger(1);
    private String prefix = "";
    private int priority = Thread.NORM_PRIORITY;

    public MThreadFactory(String prefix, int priority) {
        this.prefix = prefix;
        this.priority = priority;
    }

    public MThreadFactory(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public Thread newThread(Runnable r) {
        return newThread(r, "" + counter.getAndIncrement());
    }

    public Thread newThread(Runnable r, String id) {
        Thread executor = new Thread(r, prefix + " #" + id);
        executor.setDaemon(true);
        executor.setPriority(priority);

        return executor;
    }
}
