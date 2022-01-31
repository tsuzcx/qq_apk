package btmsdkobf;

import android.os.Debug;
import java.util.HashMap;

final class ix
  implements eq.a
{
  public void a(Thread paramThread, Runnable paramRunnable)
  {
    paramRunnable = new es.c();
    paramRunnable.oT = 3;
    paramRunnable.de = ((eo)paramThread).bF();
    paramRunnable.name = paramThread.getName();
    paramRunnable.priority = paramThread.getPriority();
    paramRunnable.oV = -1L;
    paramRunnable.oW = -1L;
    ep.di().put(paramThread, paramRunnable);
    ep.dj();
    ep.dk().a(paramRunnable, ep.activeCount());
  }
  
  public void b(Thread paramThread, Runnable paramRunnable)
  {
    paramThread = (es.c)ep.di().remove(paramThread);
    if (paramThread != null)
    {
      paramThread.oV = (System.currentTimeMillis() - paramThread.oV);
      paramThread.oW = (Debug.threadCpuTimeNanos() - paramThread.oW);
      ep.dj();
      ep.dk().b(paramThread);
    }
  }
  
  public void beforeExecute(Thread paramThread, Runnable paramRunnable)
  {
    paramThread = (es.c)ep.di().get(paramThread);
    if (paramThread != null)
    {
      ep.dj();
      ep.dk().a(paramThread);
      paramThread.oV = System.currentTimeMillis();
      paramThread.oW = Debug.threadCpuTimeNanos();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.ix
 * JD-Core Version:    0.7.0.1
 */