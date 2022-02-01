package com.tencent.token;

import com.tencent.halley.downloader.d.a.a;
import com.tencent.halley.downloader.d.a.b;
import com.tencent.halley.downloader.d.a.d;
import com.tencent.halley.downloader.d.a.f;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class ag
  implements ai
{
  private static ag e = null;
  private b a;
  private b b;
  private f c;
  private f d;
  
  private ag()
  {
    Object localObject = new a(64);
    this.a = new b(k.a(), k.a(), 60L, TimeUnit.MILLISECONDS, (BlockingQueue)localObject, new a("HallyDownload-MassTaskPool"));
    ((a)localObject).a(this.a);
    localObject = new a(64);
    this.b = new b(1, k.b(), 60L, TimeUnit.MILLISECONDS, (BlockingQueue)localObject, new a("HallyDownload-EaseTaskPool"));
    ((a)localObject).a(this.b);
    localObject = new d(16);
    this.c = new f(1, k.a() + k.b() + 1, 60L, TimeUnit.MILLISECONDS, (BlockingQueue)localObject, new a("HallyDownload-DirectPool"));
    ((d)localObject).a(this.c);
    localObject = new d(16);
    this.d = new f(1, (k.a() << 1) + 1, 60L, TimeUnit.MILLISECONDS, (BlockingQueue)localObject, new a("HallyDownload-SchedulePool"));
    ((d)localObject).a(this.d);
  }
  
  public static ag a()
  {
    try
    {
      if (e == null) {
        e = new ag();
      }
      ag localag = e;
      return localag;
    }
    finally {}
  }
  
  public final ah a(Runnable paramRunnable)
  {
    return new ah(this.a.submit(paramRunnable));
  }
  
  public final ah b(Runnable paramRunnable)
  {
    return new ah(this.b.submit(paramRunnable));
  }
  
  public final ah c(Runnable paramRunnable)
  {
    return new ah(this.c.submit(paramRunnable));
  }
  
  public final ah d(Runnable paramRunnable)
  {
    return new ah(this.d.submit(paramRunnable));
  }
  
  static final class a
    implements ThreadFactory
  {
    private static final AtomicInteger a = new AtomicInteger(1);
    private final ThreadGroup b;
    private final AtomicInteger c = new AtomicInteger(1);
    private final String d;
    
    a(String paramString)
    {
      Object localObject = System.getSecurityManager();
      if (localObject != null) {}
      for (localObject = ((SecurityManager)localObject).getThreadGroup();; localObject = Thread.currentThread().getThreadGroup())
      {
        this.b = ((ThreadGroup)localObject);
        this.d = (paramString + "-" + a.getAndIncrement() + "-thread-");
        return;
      }
    }
    
    public final Thread newThread(Runnable paramRunnable)
    {
      paramRunnable = new Thread(this.b, paramRunnable, this.d + this.c.getAndIncrement(), 0L);
      if (paramRunnable.isDaemon()) {
        paramRunnable.setDaemon(false);
      }
      try
      {
        paramRunnable.setPriority(k.d);
        return paramRunnable;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return paramRunnable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ag
 * JD-Core Version:    0.7.0.1
 */