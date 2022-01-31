package btmsdkobf;

import android.content.Context;
import android.os.Debug;
import android.os.HandlerThread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
import java.util.concurrent.TimeUnit;

public class en
  implements el.a, es
{
  private static long oH = 0L;
  private static long oI = 0L;
  private static es.a oK = new iu();
  private static ArrayList ox = new ArrayList();
  private Object V = new Object();
  protected ArrayList oA = new ArrayList();
  protected HashMap oB = new HashMap();
  private int oC = cU();
  protected el oD = null;
  private boolean oE = false;
  private HandlerThread oF;
  private iw oG;
  private volatile boolean oJ = false;
  private ArrayList ow = new ArrayList();
  protected PriorityBlockingQueue oy = new PriorityBlockingQueue(5);
  protected LinkedList oz = new LinkedList();
  
  public en(Context paramContext)
  {
    eg.f("ThreadPool", "core pool size: " + this.oC);
    this.oD = new el(0, this.oC + 2, 3L, TimeUnit.SECONDS, this.oy, new ThreadPoolExecutor.CallerRunsPolicy());
    this.oD.a(this);
    this.oF = new HandlerThread("TMS_THREAD_POOL_HANDLER");
    this.oF.start();
    this.oG = new iw(this, this.oF.getLooper());
  }
  
  private int cU()
  {
    int i = Runtime.getRuntime().availableProcessors() * 4 + 2;
    if (i > 16) {
      return 16;
    }
    return i;
  }
  
  private int cV()
  {
    return cU() * 2;
  }
  
  private void cW()
  {
    try
    {
      synchronized (this.V)
      {
        if (!this.oz.isEmpty())
        {
          Iterator localIterator = this.oz.iterator();
          if ((localIterator != null) && (localIterator.hasNext()))
          {
            iv localiv = (iv)localIterator.next();
            localIterator.remove();
            cX();
            this.oD.execute(localiv);
            localIterator = ox.iterator();
            if (localIterator.hasNext()) {
              ((es.a)localIterator.next()).a(localiv.a(), this.oD.getActiveCount());
            }
          }
        }
      }
      if (this.oz.isEmpty()) {
        break label163;
      }
    }
    catch (Throwable localThrowable)
    {
      eg.h("ThreadPool", "executeTask (Throwable):" + localThrowable.toString());
      return;
    }
    this.oG.sendEmptyMessage(1);
    label163:
  }
  
  private void cX()
  {
    if (this.oD.getCorePoolSize() < this.oC)
    {
      this.oD.setCorePoolSize(this.oC);
      this.oD.setMaximumPoolSize(this.oC);
    }
  }
  
  private boolean cZ()
  {
    return this.oJ;
  }
  
  public static es.a da()
  {
    return oK;
  }
  
  public HandlerThread a(String paramString, int paramInt, long paramLong)
  {
    return ep.a(paramString, paramInt, paramLong);
  }
  
  public void a(int paramInt, Runnable paramRunnable, String paramString, long paramLong, boolean paramBoolean, Object paramObject)
  {
    synchronized (this.V)
    {
      paramRunnable = new iv(this, paramInt, paramRunnable, paramString, paramLong, paramBoolean, paramObject);
      this.oz.add(paramRunnable);
      this.oA.add(paramRunnable);
      this.oG.sendEmptyMessage(1);
      return;
    }
  }
  
  public void a(Runnable paramRunnable, String paramString, long paramLong, boolean paramBoolean, Object paramObject)
  {
    a(5, paramRunnable, paramString, paramLong, paramBoolean, paramObject);
  }
  
  public void afterExecute(Runnable paramRunnable, Throwable arg2)
  {
    for (;;)
    {
      synchronized (this.V)
      {
        paramRunnable = (iv)paramRunnable;
        Iterator localIterator = this.oB.keySet().iterator();
        if (localIterator != null)
        {
          if (!localIterator.hasNext()) {
            break label294;
          }
          iv localiv = (iv)localIterator.next();
          if ((localiv == null) || (!localiv.equals(paramRunnable))) {
            continue;
          }
          localIterator.remove();
          i = 1;
          if (i != 0)
          {
            long l1 = System.currentTimeMillis();
            long l2 = paramRunnable.a().oV;
            paramRunnable.a().oV = (l1 - l2);
            l1 = Debug.threadCpuTimeNanos();
            l2 = paramRunnable.a().oW;
            paramRunnable.a().oW = (l1 - l2);
            localIterator = ox.iterator();
            if (localIterator.hasNext()) {
              ((es.a)localIterator.next()).b(paramRunnable.a());
            }
          }
        }
      }
      int i = this.oD.getActiveCount();
      int j = this.oD.getQueue().size();
      int k = this.oD.getCorePoolSize();
      if ((i == 1) && (j == 0))
      {
        if (k > 0)
        {
          this.oC = cU();
          this.oD.setCorePoolSize(0);
          this.oD.setMaximumPoolSize(this.oC + 2);
        }
        paramRunnable = this.ow.iterator();
        while (paramRunnable.hasNext()) {
          ((es.b)paramRunnable.next()).dm();
        }
        this.oE = false;
      }
      return;
      label294:
      i = 0;
    }
  }
  
  public void b(Runnable paramRunnable, String paramString, long paramLong, boolean paramBoolean, Object paramObject)
  {
    for (;;)
    {
      synchronized (this.V)
      {
        paramRunnable = new iv(this, 2147483647, paramRunnable, paramString, paramLong, paramBoolean, paramObject);
        this.oA.add(paramRunnable);
        this.oD.execute(paramRunnable);
        if ((this.oD.getActiveCount() >= this.oC) && (this.oC < cV()))
        {
          this.oC += 1;
          this.oD.setCorePoolSize(this.oC);
          this.oD.setMaximumPoolSize(this.oC);
          eg.f("ThreadPool", "expand urgent core pool size: " + this.oC);
          paramString = ox.iterator();
          if (!paramString.hasNext()) {
            break;
          }
          ((es.a)paramString.next()).a(paramRunnable.a(), this.oD.getActiveCount());
        }
      }
      cX();
    }
  }
  
  public void beforeExecute(Thread paramThread, Runnable paramRunnable)
  {
    int i = 10;
    for (;;)
    {
      Iterator localIterator;
      int j;
      synchronized (this.V)
      {
        localIterator = this.oA.iterator();
        if (localIterator == null) {
          break label251;
        }
        paramRunnable = (iv)paramRunnable;
        j = paramRunnable.a().priority;
        if (j < 1)
        {
          i = 1;
          paramThread.setPriority(i);
          if (!localIterator.hasNext()) {
            break label255;
          }
          iv localiv = (iv)localIterator.next();
          if ((localiv == null) || (!localiv.equals(paramRunnable))) {
            continue;
          }
          localIterator.remove();
          i = 1;
          if (i == 0) {
            break label251;
          }
          if (this.oE) {
            break label165;
          }
          localIterator = this.ow.iterator();
          if (!localIterator.hasNext()) {
            break label165;
          }
          ((es.b)localIterator.next()).dl();
        }
      }
      if (j <= 10)
      {
        i = j;
        continue;
        label165:
        localIterator = ox.iterator();
        while (localIterator.hasNext()) {
          ((es.a)localIterator.next()).a(paramRunnable.a());
        }
        paramRunnable.a().oV = System.currentTimeMillis();
        paramRunnable.a().oW = Debug.threadCpuTimeNanos();
        this.oB.put(paramRunnable, paramThread);
        paramThread.setName(paramRunnable.a().name);
        this.oE = true;
        label251:
        return;
        label255:
        i = 0;
      }
    }
  }
  
  public void cY()
  {
    synchronized (this.V)
    {
      this.oJ = false;
      oI = 0L;
      oH = 0L;
      eg.f("ThreadPool", "wake up threa pool");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.en
 * JD-Core Version:    0.7.0.1
 */