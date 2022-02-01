package moai.concurrent;

import android.util.Log;

import java.util.Collection;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 实现一个 Minimum-Gap Scheduling Queue，相邻两次 {@link #take()}  操作不小于某个时间间隔。
 */
public class GapQueue<E> extends LinkedBlockingQueue<E> {
    private final AtomicLong lastTake = new AtomicLong();
    private final long timeGap;

    public GapQueue(long timeGap) {
        super();
        this.timeGap = timeGap;
    }

    public GapQueue(Collection<? extends E> collection, long timeGap) {
        super(collection);
        this.timeGap = timeGap;
    }

    public GapQueue(int capacity, long timeGap) {
        super(capacity);
        this.timeGap = timeGap;
    }

    @Override
    public E take() throws InterruptedException {
        long time = System.currentTimeMillis();
        if ((time = time - lastTake.getAndSet(time)) < timeGap && time > 0) {
            Log.d("GapQueue", "wait for +" + time + "ms");
            Thread.sleep(time);
        }
        return super.take();
    }
}
