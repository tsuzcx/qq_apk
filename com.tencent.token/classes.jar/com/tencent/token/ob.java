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

public final class ob
{
  public static int a = -1;
  public static int b = -1;
  private static int c = 20000;
  private static ThreadPoolExecutor d;
  private static final Lock e = new ReentrantLock();
  
  public static oa a(ArrayList paramArrayList, String paramString, int paramInt)
  {
    e.lock();
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    c localc = new c((byte)0);
    localoa = new oa();
    try
    {
      if (d == null) {
        d = new ThreadPoolExecutor(3, 5, 3000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(5), new a("HalleyAccess"));
      }
      paramArrayList = a(paramArrayList, paramString).iterator();
      while (paramArrayList.hasNext())
      {
        paramString = new b(localCountDownLatch, localc, (oa)paramArrayList.next());
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
      paramArrayList = localoa;
      if (localCountDownLatch.await(i, TimeUnit.MILLISECONDS)) {
        paramArrayList = localc.b;
      }
    }
    catch (RejectedExecutionException|InterruptedException|Throwable paramArrayList)
    {
      for (;;)
      {
        paramArrayList = localoa;
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
        lo.a("ParallelResolver", "getFastSocket end.");
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
        lo.a("ParallelResolver", "getFastSocket end.");
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
      np localnp = (np)paramArrayList.next();
      oa localoa = new oa();
      localoa.f = localnp;
      localArrayList.add(localoa);
    }
    if (!TextUtils.isEmpty(paramString))
    {
      paramArrayList = new oa();
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
  
  private static oa b(String paramString, int paramInt)
  {
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    c localc = new c((byte)0);
    oa localoa = new oa();
    localoa.b = paramString;
    paramString = new b(localCountDownLatch, localc, localoa);
    ld.a().a(paramString);
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
    return localoa;
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
    private ob.c b = null;
    private oa c = null;
    
    public b(CountDownLatch paramCountDownLatch, ob.c paramc, oa paramoa)
    {
      this.a = paramCountDownLatch;
      this.b = paramc;
      this.c = paramoa;
    }
    
    public final void run()
    {
      try
      {
        oa localoa = this.c;
        Object localObject1 = new StringBuilder("Thread:");
        ((StringBuilder)localObject1).append(Thread.currentThread().getName());
        ((StringBuilder)localObject1).append(" isDaemon:");
        ((StringBuilder)localObject1).append(Thread.currentThread().isDaemon());
        lo.c("ConnectorImpl", ((StringBuilder)localObject1).toString());
        long l1 = System.currentTimeMillis();
        boolean bool = TextUtils.isEmpty(localoa.b);
        InetSocketAddress localInetSocketAddress;
        if (!bool)
        {
          try
          {
            localObject1 = InetAddress.getByName(localoa.b);
          }
          catch (Exception localException1)
          {
            localException1.getClass().getSimpleName();
            new StringBuilder("Dns InetAddress exception: domain").append(localoa.b);
            localInetSocketAddress = null;
          }
          localoa.d = ((int)(System.currentTimeMillis() - l1));
          localInetSocketAddress = new InetSocketAddress(localInetSocketAddress.getHostAddress(), 14000);
        }
        else
        {
          localInetSocketAddress = new InetSocketAddress(localoa.f.a, localoa.f.b);
          localoa.d = 0;
        }
        Socket localSocket = new Socket();
        l1 = 0L;
        try
        {
          long l2 = System.currentTimeMillis();
          l1 = l2;
          localoa.a = nu.a().b.a;
          l1 = l2;
          localSocket.connect(localInetSocketAddress, localoa.a);
          l1 = l2;
          if (localSocket.isConnected())
          {
            l1 = l2;
            if (!localSocket.isClosed())
            {
              l1 = l2;
              localoa.c = localSocket;
              l1 = l2;
              localoa.e = ((int)(System.currentTimeMillis() - l2));
            }
          }
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          localException2.getClass().getSimpleName();
          oh.a(localException2);
          localoa.e = ((int)(System.currentTimeMillis() - l1));
          localoa.c = null;
        }
        System.currentTimeMillis();
        ob.a = this.c.d;
        ob.b = this.c.e;
        localObject2 = this.b;
        localoa = this.c;
        if (localoa != null)
        {
          ((ob.c)localObject2).a.lock();
          try
          {
            if (((ob.c)localObject2).b == null) {
              ((ob.c)localObject2).b = localoa;
            } else {
              try
              {
                localoa.c.close();
              }
              catch (IOException localIOException)
              {
                localIOException.printStackTrace();
              }
            }
          }
          finally
          {
            ((ob.c)localObject2).a.unlock();
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
    oa b = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ob
 * JD-Core Version:    0.7.0.1
 */