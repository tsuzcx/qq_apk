package btmsdkobf;

import android.content.Context;
import android.os.Debug;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
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
  private static es.a oK = new es.a()
  {
    public void a(es.c paramAnonymousc)
    {
      Iterator localIterator = en.dd().iterator();
      while (localIterator.hasNext()) {
        ((es.a)localIterator.next()).a(paramAnonymousc);
      }
    }
    
    public void a(es.c paramAnonymousc, int paramAnonymousInt)
    {
      Iterator localIterator = en.dd().iterator();
      while (localIterator.hasNext()) {
        ((es.a)localIterator.next()).a(paramAnonymousc, paramAnonymousInt);
      }
    }
    
    public void b(es.c paramAnonymousc)
    {
      Iterator localIterator = en.dd().iterator();
      while (localIterator.hasNext()) {
        ((es.a)localIterator.next()).b(paramAnonymousc);
      }
    }
  };
  private static ArrayList<es.a> ox = new ArrayList();
  private Object V = new Object();
  protected ArrayList<a> oA = new ArrayList();
  protected HashMap<a, Thread> oB = new HashMap();
  private int oC = cU();
  protected el oD = null;
  private boolean oE = false;
  private HandlerThread oF;
  private b oG;
  private volatile boolean oJ = false;
  private ArrayList<es.b> ow = new ArrayList();
  protected PriorityBlockingQueue<Runnable> oy = new PriorityBlockingQueue(5);
  protected LinkedList<a> oz = new LinkedList();
  
  public en(Context paramContext)
  {
    paramContext = new StringBuilder();
    paramContext.append("core pool size: ");
    paramContext.append(this.oC);
    eg.f("ThreadPool", paramContext.toString());
    this.oD = new el(0, this.oC + 2, 3L, TimeUnit.SECONDS, this.oy, new ThreadPoolExecutor.CallerRunsPolicy());
    this.oD.a(this);
    this.oF = new HandlerThread("TMS_THREAD_POOL_HANDLER");
    this.oF.start();
    this.oG = new b(this.oF.getLooper());
  }
  
  private int cU()
  {
    int j = Runtime.getRuntime().availableProcessors() * 4 + 2;
    int i = j;
    if (j > 16) {
      i = 16;
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
            a locala = (a)localIterator.next();
            localIterator.remove();
            cX();
            this.oD.execute(locala);
            localIterator = ox.iterator();
            while (localIterator.hasNext()) {
              ((es.a)localIterator.next()).a(locala.a(), this.oD.getActiveCount());
            }
          }
        }
        if (!this.oz.isEmpty()) {
          this.oG.sendEmptyMessage(1);
        }
        return;
      }
      StringBuilder localStringBuilder;
      return;
    }
    catch (Throwable localThrowable)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("executeTask (Throwable):");
      localStringBuilder.append(localThrowable.toString());
      eg.h("ThreadPool", localStringBuilder.toString());
    }
  }
  
  private void cX()
  {
    int i = this.oD.getCorePoolSize();
    int j = this.oC;
    if (i < j)
    {
      this.oD.setCorePoolSize(j);
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
      paramRunnable = new a(paramInt, paramRunnable, paramString, paramLong, paramBoolean, paramObject);
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
        paramRunnable = (a)paramRunnable;
        Iterator localIterator = this.oB.keySet().iterator();
        if (localIterator != null)
        {
          if (!localIterator.hasNext()) {
            break label297;
          }
          a locala = (a)localIterator.next();
          if ((locala == null) || (!locala.equals(paramRunnable))) {
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
            if (localIterator.hasNext())
            {
              ((es.a)localIterator.next()).b(paramRunnable.a());
              continue;
            }
          }
        }
        i = this.oD.getActiveCount();
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
          if (paramRunnable.hasNext())
          {
            ((es.b)paramRunnable.next()).dm();
            continue;
          }
          this.oE = false;
        }
        return;
      }
      label297:
      int i = 0;
    }
  }
  
  public void b(Runnable paramRunnable, String paramString, long paramLong, boolean paramBoolean, Object paramObject)
  {
    synchronized (this.V)
    {
      paramRunnable = new a(2147483647, paramRunnable, paramString, paramLong, paramBoolean, paramObject);
      this.oA.add(paramRunnable);
      this.oD.execute(paramRunnable);
      if ((this.oD.getActiveCount() >= this.oC) && (this.oC < cV()))
      {
        this.oC += 1;
        this.oD.setCorePoolSize(this.oC);
        this.oD.setMaximumPoolSize(this.oC);
        paramString = new StringBuilder();
        paramString.append("expand urgent core pool size: ");
        paramString.append(this.oC);
        eg.f("ThreadPool", paramString.toString());
      }
      else
      {
        cX();
      }
      paramString = ox.iterator();
      while (paramString.hasNext()) {
        ((es.a)paramString.next()).a(paramRunnable.a(), this.oD.getActiveCount());
      }
      return;
    }
  }
  
  public void beforeExecute(Thread paramThread, Runnable paramRunnable)
  {
    for (;;)
    {
      int j;
      synchronized (this.V)
      {
        Iterator localIterator = this.oA.iterator();
        if (localIterator != null)
        {
          paramRunnable = (a)paramRunnable;
          j = paramRunnable.a().priority;
          if (j >= 1) {
            break label248;
          }
          i = 1;
          paramThread.setPriority(i);
          j = 0;
          i = j;
          if (localIterator.hasNext())
          {
            a locala = (a)localIterator.next();
            if ((locala == null) || (!locala.equals(paramRunnable))) {
              continue;
            }
            localIterator.remove();
            i = 1;
          }
          if (i != 0)
          {
            if (!this.oE)
            {
              localIterator = this.ow.iterator();
              if (localIterator.hasNext())
              {
                ((es.b)localIterator.next()).dl();
                continue;
              }
            }
            localIterator = ox.iterator();
            if (localIterator.hasNext())
            {
              ((es.a)localIterator.next()).a(paramRunnable.a());
              continue;
            }
            paramRunnable.a().oV = System.currentTimeMillis();
            paramRunnable.a().oW = Debug.threadCpuTimeNanos();
            this.oB.put(paramRunnable, paramThread);
            paramThread.setName(paramRunnable.a().name);
            this.oE = true;
          }
        }
        return;
      }
      label248:
      int i = j;
      if (j > 10) {
        i = 10;
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
  
  class a
    implements Comparable<a>, Runnable
  {
    private es.c b = new es.c();
    
    public a(int paramInt, Runnable paramRunnable, String paramString, long paramLong, boolean paramBoolean, Object paramObject)
    {
      if (paramString != null)
      {
        this$1 = paramString;
        if (paramString.length() != 0) {}
      }
      else
      {
        this$1 = paramRunnable.getClass().getName();
      }
      paramString = this.b;
      paramString.oT = 1;
      paramString.priority = paramInt;
      paramString.name = en.this;
      paramString.de = paramLong;
      paramString.oY = paramRunnable;
      paramString.oX = paramBoolean;
      paramString.oZ = paramObject;
      paramString.oU = System.currentTimeMillis();
    }
    
    public int a(a parama)
    {
      int k = (int)(Math.abs(System.currentTimeMillis() - this.b.oU) / 200L);
      int j = this.b.priority;
      int i = j;
      if (k > 0) {
        i = j + k;
      }
      return parama.b.priority - i;
    }
    
    public es.c a()
    {
      return this.b;
    }
    
    public void run()
    {
      try
      {
        if ((this.b != null) && (this.b.oY != null))
        {
          this.b.oY.run();
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("run (Throwable):");
        localStringBuilder.append(localThrowable.toString());
        eg.h("ThreadPool", localStringBuilder.toString());
      }
    }
  }
  
  class b
    extends Handler
  {
    public b(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      if (paramMessage.what != 1) {
        return;
      }
      removeMessages(paramMessage.what);
      if (en.a(en.this))
      {
        eg.f("ThreadPool", "thread pool is pause");
        long l = System.currentTimeMillis();
        if ((en.db() > 0L) && (Math.abs(en.dc() - l) > en.db()))
        {
          eg.f("ThreadPool", "thread pool is auto wakeup");
          en.this.cY();
        }
        sendEmptyMessageDelayed(1, 1000L);
        return;
      }
      en.b(en.this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.en
 * JD-Core Version:    0.7.0.1
 */