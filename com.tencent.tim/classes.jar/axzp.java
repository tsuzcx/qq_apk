import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

class axzp
  implements ThreadFactory
{
  private final AtomicInteger mThreadId = new AtomicInteger(0);
  
  axzp(axzo paramaxzo) {}
  
  public Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = new Thread(paramRunnable);
    paramRunnable.setName(String.format("arch_disk_io_%d", new Object[] { Integer.valueOf(this.mThreadId.getAndIncrement()) }));
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axzp
 * JD-Core Version:    0.7.0.1
 */