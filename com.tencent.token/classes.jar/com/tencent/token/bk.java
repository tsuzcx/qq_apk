package com.tencent.token;

import android.text.TextUtils;
import com.tencent.halley.common.a;
import com.tencent.halley.common.b;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class bk
{
  public static int a = -1;
  public static int b = -1;
  private static int c = 20000;
  private static ThreadPoolExecutor d;
  private static final Lock e = new ReentrantLock();
  
  public static bj a(ArrayList paramArrayList, String paramString, int paramInt)
  {
    e.lock();
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    c localc = new c((byte)0);
    localbj = new bj();
    try
    {
      if (d == null) {
        d = new ThreadPoolExecutor(3, 5, 3000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(5), new a("HalleyAccess"));
      }
      paramArrayList = a(paramArrayList, paramString).iterator();
      while (paramArrayList.hasNext())
      {
        paramString = new b(localCountDownLatch, localc, (bj)paramArrayList.next());
        d.execute(paramString);
      }
      int i;
      if (paramInt >= 0)
      {
        i = paramInt;
        if (paramInt <= c) {}
      }
      else
      {
        i = c;
      }
      paramArrayList = localbj;
      if (localCountDownLatch.await(i, TimeUnit.MILLISECONDS)) {
        paramArrayList = localc.a();
      }
    }
    catch (RejectedExecutionException|InterruptedException|Throwable paramArrayList)
    {
      for (;;)
      {
        paramArrayList = localbj;
      }
    }
    e.unlock();
    return paramArrayList;
  }
  
  public static Socket a(String paramString, int paramInt)
  {
    if (paramString != null)
    {
      if ("".equals(paramString)) {
        return null;
      }
      paramString = b(paramString, paramInt);
      if (paramString != null)
      {
        b.a("ParallelResolver", "getFastSocket end.");
        return paramString.c();
      }
    }
    return null;
  }
  
  public static Socket a(ArrayList paramArrayList, int paramInt)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() <= 0) {
        return null;
      }
      paramArrayList = a(paramArrayList, "", paramInt);
      if (paramArrayList != null)
      {
        b.a("ParallelResolver", "getFastSocket end.");
        return paramArrayList.c();
      }
    }
    return null;
  }
  
  private static List a(ArrayList paramArrayList, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      ay localay = (ay)paramArrayList.next();
      bj localbj = new bj();
      localbj.a(localay);
      localArrayList.add(localbj);
    }
    if (!TextUtils.isEmpty(paramString))
    {
      paramArrayList = new bj();
      paramArrayList.a(paramString);
      localArrayList.add(paramArrayList);
    }
    return localArrayList;
  }
  
  public static void a()
  {
    ThreadPoolExecutor localThreadPoolExecutor = d;
    if (localThreadPoolExecutor != null)
    {
      localThreadPoolExecutor.shutdownNow();
      d = null;
    }
  }
  
  private static bj b(String paramString, int paramInt)
  {
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    c localc = new c((byte)0);
    bj localbj = new bj();
    localbj.a(paramString);
    paramString = new b(localCountDownLatch, localc, localbj);
    a.a().a(paramString);
    long l = paramInt;
    try
    {
      if (localCountDownLatch.await(l, TimeUnit.MILLISECONDS))
      {
        paramString = localc.a();
        return paramString;
      }
    }
    catch (InterruptedException paramString)
    {
      paramString.printStackTrace();
    }
    return localbj;
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
      if (paramRunnable.getPriority() != 5) {
        paramRunnable.setPriority(5);
      }
      return paramRunnable;
    }
  }
  
  static final class b
    implements Runnable
  {
    private CountDownLatch a = null;
    private bk.c b = null;
    private bj c = null;
    
    public b(CountDownLatch paramCountDownLatch, bk.c paramc, bj parambj)
    {
      this.a = paramCountDownLatch;
      this.b = paramc;
      this.c = parambj;
    }
    
    public final void run()
    {
      try
      {
        this.c.a();
        bk.a = this.c.d();
        bk.b = this.c.e();
        this.b.a(this.c);
        label38:
        CountDownLatch localCountDownLatch = this.a;
        if (localCountDownLatch != null) {
          localCountDownLatch.countDown();
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        break label38;
      }
    }
  }
  
  static final class c
  {
    private Lock a = new ReentrantLock();
    private bj b = null;
    
    public final bj a()
    {
      return this.b;
    }
    
    public final void a(bj parambj)
    {
      if (parambj != null)
      {
        this.a.lock();
        try
        {
          if (this.b == null) {
            this.b = parambj;
          } else {
            parambj.b();
          }
          return;
        }
        finally
        {
          this.a.unlock();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.bk
 * JD-Core Version:    0.7.0.1
 */