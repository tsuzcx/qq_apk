package btmsdkobf;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class ek
  implements er, ThreadFactory
{
  private final ThreadGroup or = new ThreadGroup("TMS-COMMON");
  private final AtomicInteger os = new AtomicInteger(1);
  private final String ot;
  
  ek()
  {
    StringBuilder localStringBuilder = new StringBuilder("Common Thread Pool-");
    localStringBuilder.append(oS.getAndIncrement());
    localStringBuilder.append("-Thread-");
    this.ot = localStringBuilder.toString();
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    ThreadGroup localThreadGroup = this.or;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.ot);
    localStringBuilder.append(this.os.getAndIncrement());
    paramRunnable = new Thread(localThreadGroup, paramRunnable, localStringBuilder.toString(), 0L);
    if (paramRunnable.isDaemon()) {
      paramRunnable.setDaemon(false);
    }
    if (paramRunnable.getPriority() != 5) {
      paramRunnable.setPriority(5);
    }
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.ek
 * JD-Core Version:    0.7.0.1
 */