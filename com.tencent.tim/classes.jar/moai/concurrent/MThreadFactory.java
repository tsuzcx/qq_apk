package moai.concurrent;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class MThreadFactory
  implements ThreadFactory
{
  private AtomicInteger counter = new AtomicInteger(1);
  private String prefix = "";
  private int priority = 5;
  
  public MThreadFactory(String paramString)
  {
    this.prefix = paramString;
  }
  
  public MThreadFactory(String paramString, int paramInt)
  {
    this.prefix = paramString;
    this.priority = paramInt;
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    return newThread(paramRunnable, "" + this.counter.getAndIncrement());
  }
  
  public Thread newThread(Runnable paramRunnable, String paramString)
  {
    paramRunnable = new Thread(paramRunnable, this.prefix + " #" + paramString);
    paramRunnable.setDaemon(true);
    paramRunnable.setPriority(this.priority);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.concurrent.MThreadFactory
 * JD-Core Version:    0.7.0.1
 */