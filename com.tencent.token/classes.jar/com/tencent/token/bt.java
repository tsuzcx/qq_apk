package com.tencent.token;

import android.text.TextUtils;
import com.tencent.halley.common.a;
import com.tencent.halley.common.c;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class bt
{
  public static int a = -1;
  public static int b = -1;
  private static int c = 20000;
  private static ThreadPoolExecutor d;
  private static final Lock e = new ReentrantLock();
  
  /* Error */
  public static bs a(ArrayList paramArrayList, String paramString, int paramInt)
  {
    // Byte code:
    //   0: getstatic 27	com/tencent/token/bt:e	Ljava/util/concurrent/locks/Lock;
    //   3: invokeinterface 40 1 0
    //   8: new 42	java/util/concurrent/CountDownLatch
    //   11: dup
    //   12: iconst_1
    //   13: invokespecial 45	java/util/concurrent/CountDownLatch:<init>	(I)V
    //   16: astore 5
    //   18: new 47	com/tencent/token/bw
    //   21: dup
    //   22: iconst_0
    //   23: invokespecial 50	com/tencent/token/bw:<init>	(B)V
    //   26: astore 6
    //   28: new 52	com/tencent/token/bs
    //   31: dup
    //   32: invokespecial 53	com/tencent/token/bs:<init>	()V
    //   35: astore 4
    //   37: getstatic 55	com/tencent/token/bt:d	Ljava/util/concurrent/ThreadPoolExecutor;
    //   40: ifnonnull +38 -> 78
    //   43: new 57	java/util/concurrent/ThreadPoolExecutor
    //   46: dup
    //   47: iconst_3
    //   48: iconst_5
    //   49: ldc2_w 58
    //   52: getstatic 65	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   55: new 67	java/util/concurrent/LinkedBlockingQueue
    //   58: dup
    //   59: iconst_5
    //   60: invokespecial 68	java/util/concurrent/LinkedBlockingQueue:<init>	(I)V
    //   63: new 70	com/tencent/token/bu
    //   66: dup
    //   67: ldc 72
    //   69: invokespecial 75	com/tencent/token/bu:<init>	(Ljava/lang/String;)V
    //   72: invokespecial 78	java/util/concurrent/ThreadPoolExecutor:<init>	(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;Ljava/util/concurrent/ThreadFactory;)V
    //   75: putstatic 55	com/tencent/token/bt:d	Ljava/util/concurrent/ThreadPoolExecutor;
    //   78: aload_0
    //   79: aload_1
    //   80: invokestatic 81	com/tencent/token/bt:a	(Ljava/util/ArrayList;Ljava/lang/String;)Ljava/util/List;
    //   83: invokeinterface 87 1 0
    //   88: astore_0
    //   89: aload_0
    //   90: invokeinterface 93 1 0
    //   95: ifeq +46 -> 141
    //   98: new 95	com/tencent/token/bv
    //   101: dup
    //   102: aload 5
    //   104: aload 6
    //   106: aload_0
    //   107: invokeinterface 99 1 0
    //   112: checkcast 52	com/tencent/token/bs
    //   115: invokespecial 102	com/tencent/token/bv:<init>	(Ljava/util/concurrent/CountDownLatch;Lcom/tencent/token/bw;Lcom/tencent/token/bs;)V
    //   118: astore_1
    //   119: getstatic 55	com/tencent/token/bt:d	Ljava/util/concurrent/ThreadPoolExecutor;
    //   122: aload_1
    //   123: invokevirtual 106	java/util/concurrent/ThreadPoolExecutor:execute	(Ljava/lang/Runnable;)V
    //   126: goto -37 -> 89
    //   129: astore_0
    //   130: getstatic 27	com/tencent/token/bt:e	Ljava/util/concurrent/locks/Lock;
    //   133: invokeinterface 109 1 0
    //   138: aload 4
    //   140: areturn
    //   141: iload_2
    //   142: iflt +12 -> 154
    //   145: iload_2
    //   146: istore_3
    //   147: iload_2
    //   148: getstatic 20	com/tencent/token/bt:c	I
    //   151: if_icmple +7 -> 158
    //   154: getstatic 20	com/tencent/token/bt:c	I
    //   157: istore_3
    //   158: aload 5
    //   160: iload_3
    //   161: i2l
    //   162: getstatic 65	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   165: invokevirtual 113	java/util/concurrent/CountDownLatch:await	(JLjava/util/concurrent/TimeUnit;)Z
    //   168: ifeq +23 -> 191
    //   171: aload 6
    //   173: invokevirtual 116	com/tencent/token/bw:a	()Lcom/tencent/token/bs;
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
    //   26	146	6	localbw	bw
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
    c.a("ParallelResolver", "getFastSocket end.");
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
    c.a("ParallelResolver", "getFastSocket end.");
    return paramArrayList.c();
  }
  
  private static List a(ArrayList paramArrayList, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      bg localbg = (bg)paramArrayList.next();
      bs localbs = new bs();
      localbs.a(localbg);
      localArrayList.add(localbs);
    }
    if (!TextUtils.isEmpty(paramString))
    {
      paramArrayList = new bs();
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
  
  private static bs b(String paramString, int paramInt)
  {
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    bw localbw = new bw((byte)0);
    bs localbs = new bs();
    localbs.a(paramString);
    paramString = new bv(localCountDownLatch, localbw, localbs);
    a.a().a(paramString);
    long l = paramInt;
    paramString = localbs;
    try
    {
      if (localCountDownLatch.await(l, TimeUnit.MILLISECONDS)) {
        paramString = localbw.a();
      }
      return paramString;
    }
    catch (InterruptedException paramString)
    {
      paramString.printStackTrace();
    }
    return localbs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.bt
 * JD-Core Version:    0.7.0.1
 */