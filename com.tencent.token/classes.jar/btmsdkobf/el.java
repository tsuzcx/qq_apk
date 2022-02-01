package btmsdkobf;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class el
  extends ThreadPoolExecutor
{
  private a ou = null;
  
  public el(int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit, BlockingQueue<Runnable> paramBlockingQueue, RejectedExecutionHandler paramRejectedExecutionHandler)
  {
    super(paramInt1, paramInt2, paramLong, paramTimeUnit, paramBlockingQueue, new ek(), paramRejectedExecutionHandler);
  }
  
  public void a(a parama)
  {
    this.ou = parama;
  }
  
  protected void afterExecute(Runnable paramRunnable, Throwable paramThrowable)
  {
    super.afterExecute(paramRunnable, paramThrowable);
    a locala = this.ou;
    if (locala != null) {
      locala.afterExecute(paramRunnable, paramThrowable);
    }
  }
  
  protected void beforeExecute(Thread paramThread, Runnable paramRunnable)
  {
    super.beforeExecute(paramThread, paramRunnable);
    a locala = this.ou;
    if (locala != null) {
      locala.beforeExecute(paramThread, paramRunnable);
    }
  }
  
  public void execute(Runnable paramRunnable)
  {
    super.execute(paramRunnable);
  }
  
  public static abstract interface a
  {
    public abstract void afterExecute(Runnable paramRunnable, Throwable paramThrowable);
    
    public abstract void beforeExecute(Thread paramThread, Runnable paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.el
 * JD-Core Version:    0.7.0.1
 */