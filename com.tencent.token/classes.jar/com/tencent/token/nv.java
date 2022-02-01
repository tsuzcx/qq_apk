package com.tencent.token;

import android.text.TextUtils;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
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

public final class nv
{
  public static int a = -1;
  public static int b = -1;
  private static int c = 20000;
  private static ThreadPoolExecutor d;
  private static final Lock e = new ReentrantLock();
  
  public static nu a(ArrayList paramArrayList, String paramString, int paramInt)
  {
    e.lock();
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    c localc = new c((byte)0);
    localnu = new nu();
    try
    {
      if (d == null) {
        d = new ThreadPoolExecutor(3, 5, 3000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(5), new a("HalleyAccess"));
      }
      paramArrayList = a(paramArrayList, paramString).iterator();
      while (paramArrayList.hasNext())
      {
        paramString = new b(localCountDownLatch, localc, (nu)paramArrayList.next());
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
      paramArrayList = localnu;
      if (localCountDownLatch.await(i, TimeUnit.MILLISECONDS)) {
        paramArrayList = localc.b;
      }
    }
    catch (RejectedExecutionException|InterruptedException|Throwable paramArrayList)
    {
      for (;;)
      {
        paramArrayList = localnu;
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
        li.a("ParallelResolver", "getFastSocket end.");
        return paramString.c;
      }
      return null;
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
        li.a("ParallelResolver", "getFastSocket end.");
        return paramArrayList.c;
      }
      return null;
    }
    return null;
  }
  
  private static List a(ArrayList paramArrayList, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      nj localnj = (nj)paramArrayList.next();
      nu localnu = new nu();
      localnu.f = localnj;
      localArrayList.add(localnu);
    }
    if (!TextUtils.isEmpty(paramString))
    {
      paramArrayList = new nu();
      paramArrayList.b = paramString;
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
  
  private static nu b(String paramString, int paramInt)
  {
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    c localc = new c((byte)0);
    nu localnu = new nu();
    localnu.b = paramString;
    paramString = new b(localCountDownLatch, localc, localnu);
    kx.a().a(paramString);
    long l = paramInt;
    try
    {
      if (localCountDownLatch.await(l, TimeUnit.MILLISECONDS))
      {
        paramString = localc.b;
        return paramString;
      }
    }
    catch (InterruptedException paramString)
    {
      paramString.printStackTrace();
    }
    return localnu;
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
    private nv.c b = null;
    private nu c = null;
    
    public b(CountDownLatch paramCountDownLatch, nv.c paramc, nu paramnu)
    {
      this.a = paramCountDownLatch;
      this.b = paramc;
      this.c = paramnu;
    }
    
    public final void run()
    {
      try
      {
        nu localnu = this.c;
        Object localObject1 = new StringBuilder("Thread:");
        ((StringBuilder)localObject1).append(Thread.currentThread().getName());
        ((StringBuilder)localObject1).append(" isDaemon:");
        ((StringBuilder)localObject1).append(Thread.currentThread().isDaemon());
        li.c("ConnectorImpl", ((StringBuilder)localObject1).toString());
        long l1 = System.currentTimeMillis();
        boolean bool = TextUtils.isEmpty(localnu.b);
        InetSocketAddress localInetSocketAddress;
        if (!bool)
        {
          try
          {
            localObject1 = InetAddress.getByName(localnu.b);
          }
          catch (Exception localException1)
          {
            localException1.getClass().getSimpleName();
            new StringBuilder("Dns InetAddress exception: domain").append(localnu.b);
            localInetSocketAddress = null;
          }
          localnu.d = ((int)(System.currentTimeMillis() - l1));
          localInetSocketAddress = new InetSocketAddress(localInetSocketAddress.getHostAddress(), 14000);
        }
        else
        {
          localInetSocketAddress = new InetSocketAddress(localnu.f.a, localnu.f.b);
          localnu.d = 0;
        }
        Socket localSocket = new Socket();
        l1 = 0L;
        try
        {
          long l2 = System.currentTimeMillis();
          l1 = l2;
          localnu.a = no.a().b.a;
          l1 = l2;
          localSocket.connect(localInetSocketAddress, localnu.a);
          l1 = l2;
          if (localSocket.isConnected())
          {
            l1 = l2;
            if (!localSocket.isClosed())
            {
              l1 = l2;
              localnu.c = localSocket;
              l1 = l2;
              localnu.e = ((int)(System.currentTimeMillis() - l2));
            }
          }
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          localException2.getClass().getSimpleName();
          ob.a(localException2);
          localnu.e = ((int)(System.currentTimeMillis() - l1));
          localnu.c = null;
        }
        System.currentTimeMillis();
        nv.a = this.c.d;
        nv.b = this.c.e;
        localObject2 = this.b;
        localnu = this.c;
        if (localnu != null)
        {
          ((nv.c)localObject2).a.lock();
          try
          {
            if (((nv.c)localObject2).b == null) {
              ((nv.c)localObject2).b = localnu;
            } else {
              try
              {
                localnu.c.close();
              }
              catch (IOException localIOException)
              {
                localIOException.printStackTrace();
              }
            }
          }
          finally
          {
            ((nv.c)localObject2).a.unlock();
          }
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject2;
        label429:
        break label429;
      }
      localObject2 = this.a;
      if (localObject2 != null) {
        ((CountDownLatch)localObject2).countDown();
      }
    }
  }
  
  static final class c
  {
    Lock a = new ReentrantLock();
    nu b = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.nv
 * JD-Core Version:    0.7.0.1
 */