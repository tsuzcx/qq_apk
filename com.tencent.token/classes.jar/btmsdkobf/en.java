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
    eg.f("ThreadPool", "core pool size: " + this.oC);
    this.oD = new el(0, this.oC + 2, 3L, TimeUnit.SECONDS, this.oy, new ThreadPoolExecutor.CallerRunsPolicy());
    this.oD.a(this);
    this.oF = new HandlerThread("TMS_THREAD_POOL_HANDLER");
    this.oF.start();
    this.oG = new b(this.oF.getLooper());
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
            a locala = (a)localIterator.next();
            localIterator.remove();
            cX();
            this.oD.execute(locala);
            localIterator = ox.iterator();
            if (localIterator.hasNext()) {
              ((es.a)localIterator.next()).a(locala.a(), this.oD.getActiveCount());
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
            break label294;
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
        paramRunnable = new a(2147483647, paramRunnable, paramString, paramLong, paramBoolean, paramObject);
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
        paramRunnable = (a)paramRunnable;
        j = paramRunnable.a().priority;
        if (j < 1)
        {
          i = 1;
          paramThread.setPriority(i);
          if (!localIterator.hasNext()) {
            break label255;
          }
          a locala = (a)localIterator.next();
          if ((locala == null) || (!locala.equals(paramRunnable))) {
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
      this.b.oT = 1;
      this.b.priority = paramInt;
      this.b.name = en.this;
      this.b.de = paramLong;
      this.b.oY = paramRunnable;
      this.b.oX = paramBoolean;
      this.b.oZ = paramObject;
      this.b.oU = System.currentTimeMillis();
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
        if ((this.b != null) && (this.b.oY != null)) {
          this.b.oY.run();
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        eg.h("ThreadPool", "run (Throwable):" + localThrowable.toString());
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
      switch (paramMessage.what)
      {
      default: 
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