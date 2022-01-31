package btmsdkobf;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class ek
  implements er, ThreadFactory
{
  private final ThreadGroup or = new ThreadGroup("TMS-COMMON");
  private final AtomicInteger os = new AtomicInteger(1);
  private final String ot = "Common Thread Pool-" + oS.getAndIncrement() + "-Thread-";
  
  public Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = new Thread(this.or, paramRunnable, this.ot + this.os.getAndIncrement(), 0L);
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