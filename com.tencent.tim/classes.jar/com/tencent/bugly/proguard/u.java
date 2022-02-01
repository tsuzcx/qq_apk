package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import com.tencent.bugly.b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

public final class u
{
  private static u b = null;
  public t a;
  private final p c;
  private final Context d;
  private Map<Integer, Long> e = new HashMap();
  private long f;
  private long g;
  private LinkedBlockingQueue<Runnable> h = new LinkedBlockingQueue();
  private LinkedBlockingQueue<Runnable> i = new LinkedBlockingQueue();
  private final Object j = new Object();
  private int k = 0;
  
  private u(Context paramContext)
  {
    this.d = paramContext;
    this.c = p.a();
  }
  
  public static u a()
  {
    try
    {
      u localu = b;
      return localu;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static u a(Context paramContext)
  {
    try
    {
      if (b == null) {
        b = new u(paramContext);
      }
      paramContext = b;
      return paramContext;
    }
    finally {}
  }
  
  private void a(Runnable paramRunnable, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    if (paramRunnable == null) {
      x.d("[UploadManager] Upload task should not be null", new Object[0]);
    }
    x.c("[UploadManager] Add upload task (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
    if (paramBoolean2)
    {
      if (paramRunnable == null)
      {
        x.d("[UploadManager] Upload task should not be null", new Object[0]);
        return;
      }
      x.c("[UploadManager] Execute synchronized upload task (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
      Thread localThread = z.a(paramRunnable, "BUGLY_SYNC_UPLOAD");
      if (localThread == null)
      {
        x.e("[UploadManager] Failed to start a thread to execute synchronized upload task, add it to queue.", new Object[0]);
        a(paramRunnable, true);
        return;
      }
      try
      {
        localThread.join(paramLong);
        return;
      }
      catch (Throwable localThrowable)
      {
        x.e("[UploadManager] Failed to join upload synchronized task with message: %s. Add it to queue.", new Object[] { localThrowable.getMessage() });
        a(paramRunnable, true);
        c(0);
        return;
      }
    }
    a(paramRunnable, paramBoolean1);
    c(0);
  }
  
  private boolean a(Runnable paramRunnable, boolean paramBoolean)
  {
    if (paramRunnable == null)
    {
      x.a("[UploadManager] Upload task should not be null", new Object[0]);
      return false;
    }
    try
    {
      x.c("[UploadManager] Add upload task to queue (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
      Object localObject = this.j;
      if (paramBoolean) {}
      for (;;)
      {
        try
        {
          this.h.put(paramRunnable);
          return true;
        }
        finally {}
        this.i.put(paramRunnable);
      }
      return false;
    }
    catch (Throwable paramRunnable)
    {
      x.e("[UploadManager] Failed to add upload task to queue: %s", new Object[] { paramRunnable.getMessage() });
    }
  }
  
  private void c(int paramInt)
  {
    w localw = w.a();
    LinkedBlockingQueue localLinkedBlockingQueue1 = new LinkedBlockingQueue();
    LinkedBlockingQueue localLinkedBlockingQueue2 = new LinkedBlockingQueue();
    for (;;)
    {
      int n;
      synchronized (this.j)
      {
        x.c("[UploadManager] Try to poll all upload task need and put them into temp queue (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
        n = this.h.size();
        paramInt = this.i.size();
        if ((n == 0) && (paramInt == 0))
        {
          x.c("[UploadManager] There is no upload task in queue.", new Object[0]);
          return;
        }
        if (localw == null) {
          break label526;
        }
        if (localw.b()) {
          break label522;
        }
        break label526;
        if (m < n)
        {
          Runnable localRunnable1 = (Runnable)this.h.peek();
          if (localRunnable1 != null) {
            try
            {
              localLinkedBlockingQueue1.put(localRunnable1);
              this.h.poll();
              m += 1;
            }
            catch (Throwable localThrowable1)
            {
              x.e("[UploadManager] Failed to add upload task to temp urgent queue: %s", new Object[] { localThrowable1.getMessage() });
              continue;
            }
          }
        }
      }
      int m = 0;
      for (;;)
      {
        if (m < paramInt)
        {
          Runnable localRunnable2 = (Runnable)this.i.peek();
          if (localRunnable2 != null) {
            try
            {
              localLinkedBlockingQueue2.put(localRunnable2);
              this.i.poll();
              m += 1;
            }
            catch (Throwable localThrowable2)
            {
              for (;;)
              {
                x.e("[UploadManager] Failed to add upload task to temp urgent queue: %s", new Object[] { localThrowable2.getMessage() });
              }
            }
          }
        }
      }
      if (n > 0) {
        x.c("[UploadManager] Execute urgent upload tasks of queue which has %d tasks (pid=%d | tid=%d)", new Object[] { Integer.valueOf(n), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
      }
      m = 0;
      if (m < n)
      {
        Runnable localRunnable3 = (Runnable)localLinkedBlockingQueue1.poll();
        if (localRunnable3 != null) {
          for (;;)
          {
            synchronized (this.j)
            {
              if ((this.k >= 2) && (localObject1 != null))
              {
                localObject1.a(localRunnable3);
                m += 1;
                break;
              }
              x.a("[UploadManager] Create and start a new thread to execute a upload task: %s", new Object[] { "BUGLY_ASYNC_UPLOAD" });
              if (z.a(new u.1(this, localRunnable3), "BUGLY_ASYNC_UPLOAD") != null) {
                synchronized (this.j)
                {
                  this.k += 1;
                }
              }
            }
            x.d("[UploadManager] Failed to start a thread to execute asynchronous upload task, will try again next time.", new Object[0]);
            a(localRunnable3, true);
          }
        }
      }
      if (paramInt > 0) {
        x.c("[UploadManager] Execute upload tasks of queue which has %d tasks (pid=%d | tid=%d)", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
      }
      if (localObject3 != null)
      {
        localObject3.a(new u.2(this, paramInt, localLinkedBlockingQueue2));
        return;
      }
      else
      {
        label522:
        return;
        label526:
        paramInt = 0;
      }
      m = 0;
    }
  }
  
  /* Error */
  public final long a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: iflt +36 -> 39
    //   6: aload_0
    //   7: getfield 40	com/tencent/bugly/proguard/u:e	Ljava/util/Map;
    //   10: iload_1
    //   11: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   14: invokeinterface 192 2 0
    //   19: checkcast 194	java/lang/Long
    //   22: astore 4
    //   24: aload 4
    //   26: ifnull +30 -> 56
    //   29: aload 4
    //   31: invokevirtual 198	java/lang/Long:longValue	()J
    //   34: lstore_2
    //   35: aload_0
    //   36: monitorexit
    //   37: lload_2
    //   38: lreturn
    //   39: ldc 200
    //   41: iconst_1
    //   42: anewarray 4	java/lang/Object
    //   45: dup
    //   46: iconst_0
    //   47: iload_1
    //   48: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   51: aastore
    //   52: invokestatic 107	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   55: pop
    //   56: lconst_0
    //   57: lstore_2
    //   58: goto -23 -> 35
    //   61: astore 4
    //   63: aload_0
    //   64: monitorexit
    //   65: aload 4
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	u
    //   0	68	1	paramInt	int
    //   34	24	2	l	long
    //   22	8	4	localLong	Long
    //   61	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   6	24	61	finally
    //   29	35	61	finally
    //   39	56	61	finally
  }
  
  public final long a(boolean paramBoolean)
  {
    long l3 = 0L;
    long l4 = z.b();
    int m;
    List localList;
    long l1;
    long l2;
    if (paramBoolean)
    {
      m = 5;
      localList = this.c.a(m);
      if ((localList != null) && (localList.size() > 0)) {
        l1 = l3;
      }
    }
    else
    {
      try
      {
        r localr = (r)localList.get(0);
        l2 = l3;
        l1 = l3;
        if (localr.e >= l4)
        {
          l1 = l3;
          l2 = z.b(localr.g);
          if (m != 3) {
            break label171;
          }
          l1 = l2;
          this.f = l2;
          label100:
          l1 = l2;
          localList.remove(localr);
        }
        l1 = l2;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          x.a(localThrowable);
        }
      }
      l2 = l1;
      if (localList.size() > 0)
      {
        this.c.a(localList);
        l2 = l1;
      }
    }
    for (;;)
    {
      x.c("[UploadManager] Local network consume: %d KB", new Object[] { Long.valueOf(l2 / 1024L) });
      return l2;
      m = 3;
      break;
      label171:
      l1 = l2;
      this.g = l2;
      break label100;
      if (paramBoolean) {
        l2 = this.g;
      } else {
        l2 = this.f;
      }
    }
  }
  
  public final void a(int paramInt, long paramLong)
  {
    if (paramInt >= 0) {}
    for (;;)
    {
      try
      {
        this.e.put(Integer.valueOf(paramInt), Long.valueOf(paramLong));
        r localr = new r();
        localr.b = paramInt;
        localr.e = paramLong;
        localr.c = "";
        localr.d = "";
        localr.g = new byte[0];
        this.c.b(paramInt);
        this.c.a(localr);
        x.c("[UploadManager] Uploading(ID:%d) time: %s", new Object[] { Integer.valueOf(paramInt), z.a(paramLong) });
        return;
      }
      finally {}
      x.e("[UploadManager] Unknown uploading ID: %d", new Object[] { Integer.valueOf(paramInt) });
    }
  }
  
  public final void a(int paramInt, am paramam, String paramString1, String paramString2, t paramt, long paramLong, boolean paramBoolean)
  {
    int m = paramam.g;
    paramam = a.a(paramam);
    try
    {
      a(new v(this.d, paramInt, m, paramam, paramString1, paramString2, paramt, true, paramBoolean), true, true, paramLong);
      return;
    }
    catch (Throwable paramam)
    {
      while (x.a(paramam)) {}
      paramam.printStackTrace();
    }
  }
  
  public final void a(int paramInt, am paramam, String paramString1, String paramString2, t paramt, boolean paramBoolean)
  {
    int m = paramam.g;
    paramam = a.a(paramam);
    try
    {
      a(new v(this.d, paramInt, m, paramam, paramString1, paramString2, paramt, 0, 0, false, null), paramBoolean, false, 0L);
      return;
    }
    catch (Throwable paramam)
    {
      while (x.a(paramam)) {}
      paramam.printStackTrace();
    }
  }
  
  /* Error */
  protected final void a(long paramLong, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_3
    //   3: ifeq +106 -> 109
    //   6: iconst_5
    //   7: istore 4
    //   9: new 214	com/tencent/bugly/proguard/r
    //   12: dup
    //   13: invokespecial 248	com/tencent/bugly/proguard/r:<init>	()V
    //   16: astore 5
    //   18: aload 5
    //   20: iload 4
    //   22: putfield 250	com/tencent/bugly/proguard/r:b	I
    //   25: aload 5
    //   27: invokestatic 203	com/tencent/bugly/proguard/z:b	()J
    //   30: putfield 216	com/tencent/bugly/proguard/r:e	J
    //   33: aload 5
    //   35: ldc 252
    //   37: putfield 255	com/tencent/bugly/proguard/r:c	Ljava/lang/String;
    //   40: aload 5
    //   42: ldc 252
    //   44: putfield 257	com/tencent/bugly/proguard/r:d	Ljava/lang/String;
    //   47: aload 5
    //   49: lload_1
    //   50: invokestatic 297	com/tencent/bugly/proguard/z:c	(J)[B
    //   53: putfield 219	com/tencent/bugly/proguard/r:g	[B
    //   56: aload_0
    //   57: getfield 60	com/tencent/bugly/proguard/u:c	Lcom/tencent/bugly/proguard/p;
    //   60: iload 4
    //   62: invokevirtual 259	com/tencent/bugly/proguard/p:b	(I)V
    //   65: aload_0
    //   66: getfield 60	com/tencent/bugly/proguard/u:c	Lcom/tencent/bugly/proguard/p;
    //   69: aload 5
    //   71: invokevirtual 262	com/tencent/bugly/proguard/p:a	(Lcom/tencent/bugly/proguard/r;)Z
    //   74: pop
    //   75: iload_3
    //   76: ifeq +39 -> 115
    //   79: aload_0
    //   80: lload_1
    //   81: putfield 240	com/tencent/bugly/proguard/u:g	J
    //   84: ldc_w 299
    //   87: iconst_1
    //   88: anewarray 4	java/lang/Object
    //   91: dup
    //   92: iconst_0
    //   93: lload_1
    //   94: ldc2_w 234
    //   97: ldiv
    //   98: invokestatic 238	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   101: aastore
    //   102: invokestatic 94	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   105: pop
    //   106: aload_0
    //   107: monitorexit
    //   108: return
    //   109: iconst_3
    //   110: istore 4
    //   112: goto -103 -> 9
    //   115: aload_0
    //   116: lload_1
    //   117: putfield 224	com/tencent/bugly/proguard/u:f	J
    //   120: goto -36 -> 84
    //   123: astore 5
    //   125: aload_0
    //   126: monitorexit
    //   127: aload 5
    //   129: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	this	u
    //   0	130	1	paramLong	long
    //   0	130	3	paramBoolean	boolean
    //   7	104	4	m	int
    //   16	54	5	localr	r
    //   123	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	75	123	finally
    //   79	84	123	finally
    //   84	106	123	finally
    //   115	120	123	finally
  }
  
  public final void b()
  {
    List localList = this.c.a(3);
    if ((localList == null) || (localList.size() == 0)) {
      return;
    }
    this.f = 0L;
    this.c.a(localList);
    x.c("[UploadManager] Clear network consume.", new Object[0]);
  }
  
  public final boolean b(int paramInt)
  {
    if (b.c) {
      x.c("Uploading frequency will not be checked if SDK is in debug mode.", new Object[0]);
    }
    long l;
    do
    {
      return true;
      l = System.currentTimeMillis() - a(paramInt);
      x.c("[UploadManager] Time interval is %d seconds since last uploading(ID: %d).", new Object[] { Long.valueOf(l / 1000L), Integer.valueOf(paramInt) });
    } while (l >= 30000L);
    x.a("[UploadManager] Data only be uploaded once in %d seconds.", new Object[] { Long.valueOf(30L) });
    return false;
  }
  
  public final void c()
  {
    List localList = this.c.a(5);
    if ((localList == null) || (localList.size() == 0)) {
      return;
    }
    this.g = 0L;
    this.c.a(localList);
    x.c("[UploadManager] Clear network consume of stuck.", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.bugly.proguard.u
 * JD-Core Version:    0.7.0.1
 */