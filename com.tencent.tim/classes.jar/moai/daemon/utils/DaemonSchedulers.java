package moai.daemon.utils;

import android.os.Handler;
import android.os.HandlerThread;
import java.lang.reflect.Method;

public class DaemonSchedulers
{
  public static final Scheduler single = new SingleThreadScheduler(null);
  
  private static boolean hasCallback(Handler paramHandler, Runnable paramRunnable)
  {
    try
    {
      boolean bool = ((Boolean)Handler.class.getMethod("hasCallbacks", new Class[] { Runnable.class }).invoke(paramHandler, new Object[] { paramRunnable })).booleanValue();
      return bool;
    }
    catch (Exception paramHandler) {}
    return false;
  }
  
  public static abstract interface Scheduler
  {
    public abstract boolean hasTask(Runnable paramRunnable);
    
    public abstract void remove(Runnable paramRunnable);
    
    public abstract void replace(Runnable paramRunnable);
    
    public abstract void replace(Runnable paramRunnable, long paramLong);
    
    public abstract void run(Runnable paramRunnable);
    
    public abstract void run(Runnable paramRunnable, long paramLong);
    
    public abstract void runIfNotExist(Runnable paramRunnable);
    
    public abstract void runIfNotExist(Runnable paramRunnable, long paramLong);
  }
  
  static class SingleThreadScheduler
    implements DaemonSchedulers.Scheduler
  {
    private static Handler sHandler;
    
    static
    {
      HandlerThread localHandlerThread = new HandlerThread("moai-daemon-single", -2);
      localHandlerThread.start();
      sHandler = new Handler(localHandlerThread.getLooper());
    }
    
    public boolean hasTask(Runnable paramRunnable)
    {
      return DaemonSchedulers.hasCallback(sHandler, paramRunnable);
    }
    
    public void remove(Runnable paramRunnable)
    {
      sHandler.removeCallbacks(paramRunnable);
    }
    
    public void replace(Runnable paramRunnable)
    {
      replace(paramRunnable, 0L);
    }
    
    public void replace(Runnable paramRunnable, long paramLong)
    {
      try
      {
        remove(paramRunnable);
        run(paramRunnable, paramLong);
        return;
      }
      finally {}
    }
    
    public void run(Runnable paramRunnable)
    {
      run(paramRunnable, 0L);
    }
    
    public void run(Runnable paramRunnable, long paramLong)
    {
      sHandler.postDelayed(paramRunnable, paramLong);
    }
    
    public void runIfNotExist(Runnable paramRunnable)
    {
      runIfNotExist(paramRunnable, 0L);
    }
    
    public void runIfNotExist(Runnable paramRunnable, long paramLong)
    {
      if (!hasTask(paramRunnable)) {
        try
        {
          if (!hasTask(paramRunnable)) {
            sHandler.postDelayed(paramRunnable, paramLong);
          }
          return;
        }
        finally {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.daemon.utils.DaemonSchedulers
 * JD-Core Version:    0.7.0.1
 */