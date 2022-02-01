package btmsdkobf;

import android.os.Debug;
import android.os.HandlerThread;
import java.util.HashMap;

public class ep
{
  private static HashMap<Thread, es.c> oO = new HashMap();
  private static es.a oP;
  private static eq.a oQ = new eq.a()
  {
    public void a(Thread paramAnonymousThread, Runnable paramAnonymousRunnable)
    {
      paramAnonymousRunnable = new es.c();
      paramAnonymousRunnable.oT = 3;
      paramAnonymousRunnable.de = ((eo)paramAnonymousThread).bF();
      paramAnonymousRunnable.name = paramAnonymousThread.getName();
      paramAnonymousRunnable.priority = paramAnonymousThread.getPriority();
      paramAnonymousRunnable.oV = -1L;
      paramAnonymousRunnable.oW = -1L;
      ep.di().put(paramAnonymousThread, paramAnonymousRunnable);
      ep.dj();
      ep.dk().a(paramAnonymousRunnable, ep.activeCount());
    }
    
    public void b(Thread paramAnonymousThread, Runnable paramAnonymousRunnable)
    {
      paramAnonymousThread = (es.c)ep.di().remove(paramAnonymousThread);
      if (paramAnonymousThread != null)
      {
        paramAnonymousThread.oV = (System.currentTimeMillis() - paramAnonymousThread.oV);
        paramAnonymousThread.oW = (Debug.threadCpuTimeNanos() - paramAnonymousThread.oW);
        ep.dj();
        ep.dk().b(paramAnonymousThread);
      }
    }
    
    public void beforeExecute(Thread paramAnonymousThread, Runnable paramAnonymousRunnable)
    {
      paramAnonymousThread = (es.c)ep.di().get(paramAnonymousThread);
      if (paramAnonymousThread != null)
      {
        ep.dj();
        ep.dk().a(paramAnonymousThread);
        paramAnonymousThread.oV = System.currentTimeMillis();
        paramAnonymousThread.oW = Debug.threadCpuTimeNanos();
      }
    }
  };
  
  public static HandlerThread a(String paramString, int paramInt, long paramLong)
  {
    return new eo(paramString, paramInt, paramLong);
  }
  
  public static int activeCount()
  {
    return oO.size();
  }
  
  private static void dg()
  {
    if (oP == null) {
      oP = en.da();
    }
  }
  
  public static eq.a dh()
  {
    return oQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.ep
 * JD-Core Version:    0.7.0.1
 */