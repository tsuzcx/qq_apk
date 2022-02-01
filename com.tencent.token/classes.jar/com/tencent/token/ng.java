package com.tencent.token;

import com.tencent.halley.downloader.d.a.a;
import com.tencent.halley.downloader.d.a.d;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class ng
  implements nn
{
  private static ng e;
  private nh a;
  private nh b;
  private nk c;
  private nk d;
  
  private ng()
  {
    Object localObject = new a((byte)0);
    this.a = new nh(ls.a(), ls.a(), TimeUnit.MILLISECONDS, (BlockingQueue)localObject, new a("HallyDownload-MassTaskPool"));
    ((a)localObject).a = this.a;
    localObject = new a((byte)0);
    this.b = new nh(1, ls.b(), TimeUnit.MILLISECONDS, (BlockingQueue)localObject, new a("HallyDownload-EaseTaskPool"));
    ((a)localObject).a = this.b;
    localObject = new d((byte)0);
    this.c = new nk(ls.a() + ls.b() + 1, TimeUnit.MILLISECONDS, (BlockingQueue)localObject, new a("HallyDownload-DirectPool"));
    ((d)localObject).a = this.c;
    localObject = new d((byte)0);
    this.d = new nk((ls.a() << 1) + 1, TimeUnit.MILLISECONDS, (BlockingQueue)localObject, new a("HallyDownload-SchedulePool"));
    ((d)localObject).a = this.d;
  }
  
  public static ng a()
  {
    try
    {
      if (e == null) {
        e = new ng();
      }
      ng localng = e;
      return localng;
    }
    finally {}
  }
  
  public final nm a(Runnable paramRunnable)
  {
    return new nm(this.a.submit(paramRunnable));
  }
  
  public final nm b(Runnable paramRunnable)
  {
    return new nm(this.b.submit(paramRunnable));
  }
  
  public final nm c(Runnable paramRunnable)
  {
    return new nm(this.c.submit(paramRunnable));
  }
  
  public final nm d(Runnable paramRunnable)
  {
    return new nm(this.d.submit(paramRunnable));
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
      if (localObject != null) {
        localObject = ((SecurityManager)localObject).getThreadGroup();
      } else {
        localObject = Thread.currentThread().getThreadGroup();
      }
      this.b = ((ThreadGroup)localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("-");
      ((StringBuilder)localObject).append(a.getAndIncrement());
      ((StringBuilder)localObject).append("-thread-");
      this.d = ((StringBuilder)localObject).toString();
    }
    
    public final Thread newThread(Runnable paramRunnable)
    {
      ThreadGroup localThreadGroup = this.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.d);
      localStringBuilder.append(this.c.getAndIncrement());
      paramRunnable = new Thread(localThreadGroup, paramRunnable, localStringBuilder.toString(), 0L);
      if (paramRunnable.isDaemon()) {
        paramRunnable.setDaemon(false);
      }
      try
      {
        paramRunnable.setPriority(ls.d);
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
 * Qualified Name:     com.tencent.token.ng
 * JD-Core Version:    0.7.0.1
 */