package com.tencent.token;

import android.text.TextUtils;
import com.tencent.halley.common.a;
import com.tencent.halley.common.b;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
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
  
  /* Error */
  public static bj a(ArrayList paramArrayList, String paramString, int paramInt)
  {
    // Byte code:
    //   0: getstatic 33	com/tencent/token/bk:e	Ljava/util/concurrent/locks/Lock;
    //   3: invokeinterface 46 1 0
    //   8: new 48	java/util/concurrent/CountDownLatch
    //   11: dup
    //   12: iconst_1
    //   13: invokespecial 51	java/util/concurrent/CountDownLatch:<init>	(I)V
    //   16: astore 5
    //   18: new 12	com/tencent/token/bk$c
    //   21: dup
    //   22: iconst_0
    //   23: invokespecial 54	com/tencent/token/bk$c:<init>	(B)V
    //   26: astore 6
    //   28: new 56	com/tencent/token/bj
    //   31: dup
    //   32: invokespecial 57	com/tencent/token/bj:<init>	()V
    //   35: astore 4
    //   37: getstatic 59	com/tencent/token/bk:d	Ljava/util/concurrent/ThreadPoolExecutor;
    //   40: ifnonnull +38 -> 78
    //   43: new 61	java/util/concurrent/ThreadPoolExecutor
    //   46: dup
    //   47: iconst_3
    //   48: iconst_5
    //   49: ldc2_w 62
    //   52: getstatic 69	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   55: new 71	java/util/concurrent/LinkedBlockingQueue
    //   58: dup
    //   59: iconst_5
    //   60: invokespecial 72	java/util/concurrent/LinkedBlockingQueue:<init>	(I)V
    //   63: new 6	com/tencent/token/bk$a
    //   66: dup
    //   67: ldc 74
    //   69: invokespecial 77	com/tencent/token/bk$a:<init>	(Ljava/lang/String;)V
    //   72: invokespecial 80	java/util/concurrent/ThreadPoolExecutor:<init>	(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;Ljava/util/concurrent/ThreadFactory;)V
    //   75: putstatic 59	com/tencent/token/bk:d	Ljava/util/concurrent/ThreadPoolExecutor;
    //   78: aload_0
    //   79: aload_1
    //   80: invokestatic 83	com/tencent/token/bk:a	(Ljava/util/ArrayList;Ljava/lang/String;)Ljava/util/List;
    //   83: invokeinterface 89 1 0
    //   88: astore_0
    //   89: aload_0
    //   90: invokeinterface 95 1 0
    //   95: ifeq +46 -> 141
    //   98: new 9	com/tencent/token/bk$b
    //   101: dup
    //   102: aload 5
    //   104: aload 6
    //   106: aload_0
    //   107: invokeinterface 99 1 0
    //   112: checkcast 56	com/tencent/token/bj
    //   115: invokespecial 102	com/tencent/token/bk$b:<init>	(Ljava/util/concurrent/CountDownLatch;Lcom/tencent/token/bk$c;Lcom/tencent/token/bj;)V
    //   118: astore_1
    //   119: getstatic 59	com/tencent/token/bk:d	Ljava/util/concurrent/ThreadPoolExecutor;
    //   122: aload_1
    //   123: invokevirtual 106	java/util/concurrent/ThreadPoolExecutor:execute	(Ljava/lang/Runnable;)V
    //   126: goto -37 -> 89
    //   129: astore_0
    //   130: getstatic 33	com/tencent/token/bk:e	Ljava/util/concurrent/locks/Lock;
    //   133: invokeinterface 109 1 0
    //   138: aload 4
    //   140: areturn
    //   141: iload_2
    //   142: iflt +12 -> 154
    //   145: iload_2
    //   146: istore_3
    //   147: iload_2
    //   148: getstatic 26	com/tencent/token/bk:c	I
    //   151: if_icmple +7 -> 158
    //   154: getstatic 26	com/tencent/token/bk:c	I
    //   157: istore_3
    //   158: aload 5
    //   160: iload_3
    //   161: i2l
    //   162: getstatic 69	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   165: invokevirtual 113	java/util/concurrent/CountDownLatch:await	(JLjava/util/concurrent/TimeUnit;)Z
    //   168: ifeq +23 -> 191
    //   171: aload 6
    //   173: invokevirtual 116	com/tencent/token/bk$c:a	()Lcom/tencent/token/bj;
    //   176: astore_0
    //   177: aload_0
    //   178: astore 4
    //   180: goto -50 -> 130
    //   183: astore_0
    //   184: goto -54 -> 130
    //   187: astore_0
    //   188: goto -58 -> 130
    //   191: aload 4
    //   193: astore_0
    //   194: goto -17 -> 177
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	paramArrayList	ArrayList
    //   0	197	1	paramString	String
    //   0	197	2	paramInt	int
    //   146	15	3	i	int
    //   35	157	4	localObject	Object
    //   16	143	5	localCountDownLatch	CountDownLatch
    //   26	146	6	localc	c
    // Exception table:
    //   from	to	target	type
    //   37	78	129	java/util/concurrent/RejectedExecutionException
    //   78	89	129	java/util/concurrent/RejectedExecutionException
    //   89	126	129	java/util/concurrent/RejectedExecutionException
    //   147	154	129	java/util/concurrent/RejectedExecutionException
    //   154	158	129	java/util/concurrent/RejectedExecutionException
    //   158	177	129	java/util/concurrent/RejectedExecutionException
    //   37	78	183	java/lang/Throwable
    //   78	89	183	java/lang/Throwable
    //   89	126	183	java/lang/Throwable
    //   147	154	183	java/lang/Throwable
    //   154	158	183	java/lang/Throwable
    //   158	177	183	java/lang/Throwable
    //   37	78	187	java/lang/InterruptedException
    //   78	89	187	java/lang/InterruptedException
    //   89	126	187	java/lang/InterruptedException
    //   147	154	187	java/lang/InterruptedException
    //   154	158	187	java/lang/InterruptedException
    //   158	177	187	java/lang/InterruptedException
  }
  
  public static Socket a(String paramString, int paramInt)
  {
    if ((paramString == null) || ("".equals(paramString))) {}
    do
    {
      return null;
      paramString = b(paramString, paramInt);
    } while (paramString == null);
    b.a("ParallelResolver", "getFastSocket end.");
    return paramString.c();
  }
  
  public static Socket a(ArrayList paramArrayList, int paramInt)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {}
    do
    {
      return null;
      paramArrayList = a(paramArrayList, "", paramInt);
    } while (paramArrayList == null);
    b.a("ParallelResolver", "getFastSocket end.");
    return paramArrayList.c();
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
    if (d != null)
    {
      d.shutdownNow();
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
    paramString = localbj;
    try
    {
      if (localCountDownLatch.await(l, TimeUnit.MILLISECONDS)) {
        paramString = localc.a();
      }
      return paramString;
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
        if (this.a != null) {
          this.a.countDown();
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
    
    /* Error */
    public final void a(bj parambj)
    {
      // Byte code:
      //   0: aload_1
      //   1: ifnull +33 -> 34
      //   4: aload_0
      //   5: getfield 20	com/tencent/token/bk$c:a	Ljava/util/concurrent/locks/Lock;
      //   8: invokeinterface 32 1 0
      //   13: aload_0
      //   14: getfield 22	com/tencent/token/bk$c:b	Lcom/tencent/token/bj;
      //   17: ifnonnull +18 -> 35
      //   20: aload_0
      //   21: aload_1
      //   22: putfield 22	com/tencent/token/bk$c:b	Lcom/tencent/token/bj;
      //   25: aload_0
      //   26: getfield 20	com/tencent/token/bk$c:a	Ljava/util/concurrent/locks/Lock;
      //   29: invokeinterface 35 1 0
      //   34: return
      //   35: aload_1
      //   36: invokevirtual 39	com/tencent/token/bj:b	()V
      //   39: goto -14 -> 25
      //   42: astore_1
      //   43: aload_0
      //   44: getfield 20	com/tencent/token/bk$c:a	Ljava/util/concurrent/locks/Lock;
      //   47: invokeinterface 35 1 0
      //   52: aload_1
      //   53: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	54	0	this	c
      //   0	54	1	parambj	bj
      // Exception table:
      //   from	to	target	type
      //   13	25	42	finally
      //   35	39	42	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.bk
 * JD-Core Version:    0.7.0.1
 */