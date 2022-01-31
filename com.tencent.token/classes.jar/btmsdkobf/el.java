package btmsdkobf;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class el
  extends ThreadPoolExecutor
{
  private el.a ou = null;
  
  public el(int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit, BlockingQueue paramBlockingQueue, RejectedExecutionHandler paramRejectedExecutionHandler)
  {
    super(paramInt1, paramInt2, paramLong, paramTimeUnit, paramBlockingQueue, new ek(), paramRejectedExecutionHandler);
  }
  
  public void a(el.a parama)
  {
    this.ou = parama;
  }
  
  protected void afterExecute(Runnable paramRunnable, Throwable paramThrowable)
  {
    super.afterExecute(paramRunnable, paramThrowable);
    if (this.ou != null) {
      this.ou.afterExecute(paramRunnable, paramThrowable);
    }
  }
  
  protected void beforeExecute(Thread paramThread, Runnable paramRunnable)
  {
    super.beforeExecute(paramThread, paramRunnable);
    if (this.ou != null) {
      this.ou.beforeExecute(paramThread, paramRunnable);
    }
  }
  
  public void execute(Runnable paramRunnable)
  {
    super.execute(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.el
 * JD-Core Version:    0.7.0.1
 */