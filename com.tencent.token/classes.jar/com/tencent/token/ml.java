package com.tencent.token;

import com.tencent.halley.downloader.d.a.a;
import com.tencent.halley.downloader.d.a.d;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class ml
  implements ms
{
  private static ml e;
  private mm a;
  private mm b;
  private mp c;
  private mp d;
  
  private ml()
  {
    Object localObject = new a((byte)0);
    this.a = new mm(kx.a(), kx.a(), TimeUnit.MILLISECONDS, (BlockingQueue)localObject, new a("HallyDownload-MassTaskPool"));
    ((a)localObject).a = this.a;
    localObject = new a((byte)0);
    this.b = new mm(1, kx.b(), TimeUnit.MILLISECONDS, (BlockingQueue)localObject, new a("HallyDownload-EaseTaskPool"));
    ((a)localObject).a = this.b;
    localObject = new d((byte)0);
    this.c = new mp(kx.a() + kx.b() + 1, TimeUnit.MILLISECONDS, (BlockingQueue)localObject, new a("HallyDownload-DirectPool"));
    ((d)localObject).a = this.c;
    localObject = new d((byte)0);
    this.d = new mp((kx.a() << 1) + 1, TimeUnit.MILLISECONDS, (BlockingQueue)localObject, new a("HallyDownload-SchedulePool"));
    ((d)localObject).a = this.d;
  }
  
  public static ml a()
  {
    try
    {
      if (e == null) {
        e = new ml();
      }
      ml localml = e;
      return localml;
    }
    finally {}
  }
  
  public final mr a(Runnable paramRunnable)
  {
    return new mr(this.a.submit(paramRunnable));
  }
  
  public final mr b(Runnable paramRunnable)
  {
    return new mr(this.b.submit(paramRunnable));
  }
  
  public final mr c(Runnable paramRunnable)
  {
    return new mr(this.c.submit(paramRunnable));
  }
  
  public final mr d(Runnable paramRunnable)
  {
    return new mr(this.d.submit(paramRunnable));
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
        paramRunnable.setPriority(kx.d);
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
 * Qualified Name:     com.tencent.token.ml
 * JD-Core Version:    0.7.0.1
 */