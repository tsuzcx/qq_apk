package moai.concurrent;

import android.util.Log;
import java.util.Collection;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

public class GapQueue<E>
  extends LinkedBlockingQueue<E>
{
  private final AtomicLong lastTake = new AtomicLong();
  private final long timeGap;
  
  public GapQueue(int paramInt, long paramLong)
  {
    super(paramInt);
    this.timeGap = paramLong;
  }
  
  public GapQueue(long paramLong)
  {
    this.timeGap = paramLong;
  }
  
  public GapQueue(Collection<? extends E> paramCollection, long paramLong)
  {
    super(paramCollection);
    this.timeGap = paramLong;
  }
  
  public E take()
    throws InterruptedException
  {
    long l = System.currentTimeMillis();
    l -= this.lastTake.getAndSet(l);
    if ((l < this.timeGap) && (l > 0L))
    {
      Log.d("GapQueue", "wait for +" + l + "ms");
      Thread.sleep(l);
    }
    return super.take();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.concurrent.GapQueue
 * JD-Core Version:    0.7.0.1
 */