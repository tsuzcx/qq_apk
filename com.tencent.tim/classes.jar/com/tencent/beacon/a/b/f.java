package com.tencent.beacon.a.b;

import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.NonNull;
import android.util.SparseArray;
import com.tencent.beacon.base.util.c;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class f
  extends a
{
  private static final int b = Runtime.getRuntime().availableProcessors();
  private static final int c = Math.max(2, Math.min(b - 1, 3));
  private static final AtomicInteger d = new AtomicInteger(0);
  private final ScheduledExecutorService e;
  private final SparseArray<a> f;
  private final SparseArray<Handler> g;
  private final g h = new g();
  private boolean i = false;
  private boolean j = true;
  
  f()
  {
    this(null);
  }
  
  f(ScheduledExecutorService paramScheduledExecutorService)
  {
    ScheduledExecutorService localScheduledExecutorService = paramScheduledExecutorService;
    if (paramScheduledExecutorService == null) {
      localScheduledExecutorService = Executors.newScheduledThreadPool(c, this.h);
    }
    this.e = localScheduledExecutorService;
    this.f = new SparseArray();
    this.g = new SparseArray();
  }
  
  private Runnable b(Runnable paramRunnable)
  {
    return new e(this, paramRunnable);
  }
  
  private boolean e()
  {
    boolean bool = false;
    if (this.i)
    {
      c.b("[task] was closed , should all stopped!", new Object[0]);
      bool = true;
    }
    return bool;
  }
  
  public Handler a(int paramInt)
  {
    try
    {
      Handler localHandler = (Handler)this.g.get(paramInt);
      Object localObject1 = localHandler;
      if (localHandler == null)
      {
        localObject1 = new HandlerThread(this.h.a());
        ((HandlerThread)localObject1).start();
        localObject1 = new Handler(((HandlerThread)localObject1).getLooper());
      }
      this.g.put(paramInt, localObject1);
      return localObject1;
    }
    finally {}
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2, @NonNull Runnable paramRunnable)
  {
    for (;;)
    {
      try
      {
        boolean bool = e();
        if (bool) {
          return;
        }
        a locala = (a)this.f.get(paramInt);
        if ((locala != null) && (!locala.a())) {
          continue;
        }
        paramRunnable = b(paramRunnable);
        if (paramLong1 <= 0L) {
          break label137;
        }
      }
      finally {}
      paramRunnable = new a(this.e.scheduleAtFixedRate(paramRunnable, paramLong1, paramLong2, TimeUnit.MILLISECONDS), paramRunnable, paramLong1, paramLong2, TimeUnit.MILLISECONDS);
      c.a("[task] add a new polling task! taskId: %d , periodTime: %d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong2) });
      this.f.put(paramInt, paramRunnable);
      continue;
      label137:
      paramLong1 = 0L;
      while (paramLong2 < 500L)
      {
        paramLong2 = 500L;
        break;
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    a locala = (a)this.f.get(paramInt);
    if ((locala != null) && (!locala.a()))
    {
      c.a("[task] cancel a old pollingTaskWrapper!", new Object[0]);
      locala.a(paramBoolean);
    }
  }
  
  public void a(long paramLong, @NonNull Runnable paramRunnable)
  {
    for (;;)
    {
      try
      {
        boolean bool = e();
        if (bool) {
          return;
        }
        paramRunnable = b(paramRunnable);
        if (paramLong > 0L) {
          this.e.schedule(paramRunnable, paramLong, TimeUnit.MILLISECONDS);
        } else {
          paramLong = 0L;
        }
      }
      finally {}
    }
  }
  
  /* Error */
  public void a(@NonNull Runnable paramRunnable)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 137	com/tencent/beacon/a/b/f:e	()Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: aload_1
    //   16: invokespecial 141	com/tencent/beacon/a/b/f:b	(Ljava/lang/Runnable;)Ljava/lang/Runnable;
    //   19: astore_1
    //   20: aload_0
    //   21: getfield 80	com/tencent/beacon/a/b/f:e	Ljava/util/concurrent/ScheduledExecutorService;
    //   24: aload_1
    //   25: invokeinterface 189 2 0
    //   30: goto -19 -> 11
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	f
    //   0	38	1	paramRunnable	Runnable
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	33	finally
    //   14	30	33	finally
  }
  
  /* Error */
  public void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: invokespecial 137	com/tencent/beacon/a/b/f:e	()Z
    //   8: istore_3
    //   9: iload_3
    //   10: ifeq +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: iload_2
    //   17: aload_0
    //   18: getfield 85	com/tencent/beacon/a/b/f:f	Landroid/util/SparseArray;
    //   21: invokevirtual 193	android/util/SparseArray:size	()I
    //   24: if_icmpge +23 -> 47
    //   27: aload_0
    //   28: aload_0
    //   29: getfield 85	com/tencent/beacon/a/b/f:f	Landroid/util/SparseArray;
    //   32: iload_2
    //   33: invokevirtual 197	android/util/SparseArray:keyAt	(I)I
    //   36: iload_1
    //   37: invokevirtual 199	com/tencent/beacon/a/b/f:a	(IZ)V
    //   40: iload_2
    //   41: iconst_1
    //   42: iadd
    //   43: istore_2
    //   44: goto -28 -> 16
    //   47: aload_0
    //   48: iconst_0
    //   49: putfield 67	com/tencent/beacon/a/b/f:j	Z
    //   52: ldc 201
    //   54: iconst_0
    //   55: anewarray 99	java/lang/Object
    //   58: invokestatic 171	com/tencent/beacon/base/util/c:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   61: goto -48 -> 13
    //   64: astore 4
    //   66: aload_0
    //   67: monitorexit
    //   68: aload 4
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	f
    //   0	71	1	paramBoolean	boolean
    //   1	43	2	k	int
    //   8	2	3	bool	boolean
    //   64	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	9	64	finally
    //   16	40	64	finally
    //   47	61	64	finally
  }
  
  /* Error */
  public void b(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 67	com/tencent/beacon/a/b/f:j	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 85	com/tencent/beacon/a/b/f:f	Landroid/util/SparseArray;
    //   18: iload_1
    //   19: invokevirtual 109	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   22: checkcast 6	com/tencent/beacon/a/b/f$a
    //   25: astore_3
    //   26: aload_3
    //   27: ifnull -16 -> 11
    //   30: aload_3
    //   31: invokevirtual 139	com/tencent/beacon/a/b/f$a:a	()Z
    //   34: ifeq -23 -> 11
    //   37: aload_3
    //   38: aload_0
    //   39: getfield 80	com/tencent/beacon/a/b/f:e	Ljava/util/concurrent/ScheduledExecutorService;
    //   42: aload_3
    //   43: invokestatic 204	com/tencent/beacon/a/b/f$a:a	(Lcom/tencent/beacon/a/b/f$a;)Ljava/lang/Runnable;
    //   46: aload_3
    //   47: invokestatic 207	com/tencent/beacon/a/b/f$a:b	(Lcom/tencent/beacon/a/b/f$a;)J
    //   50: aload_3
    //   51: invokestatic 209	com/tencent/beacon/a/b/f$a:c	(Lcom/tencent/beacon/a/b/f$a;)J
    //   54: aload_3
    //   55: invokestatic 212	com/tencent/beacon/a/b/f$a:d	(Lcom/tencent/beacon/a/b/f$a;)Ljava/util/concurrent/TimeUnit;
    //   58: invokeinterface 153 7 0
    //   63: invokestatic 215	com/tencent/beacon/a/b/f$a:a	(Lcom/tencent/beacon/a/b/f$a;Ljava/util/concurrent/Future;)Ljava/util/concurrent/Future;
    //   66: pop
    //   67: goto -56 -> 11
    //   70: astore_3
    //   71: aload_0
    //   72: monitorexit
    //   73: aload_3
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	f
    //   0	75	1	paramInt	int
    //   6	2	2	bool	boolean
    //   25	30	3	locala	a
    //   70	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	70	finally
    //   14	26	70	finally
    //   30	67	70	finally
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 217
    //   6: iconst_0
    //   7: anewarray 99	java/lang/Object
    //   10: invokestatic 171	com/tencent/beacon/base/util/c:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   13: aload_0
    //   14: invokespecial 137	com/tencent/beacon/a/b/f:e	()Z
    //   17: istore_2
    //   18: iload_2
    //   19: ifeq +6 -> 25
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: aload_0
    //   26: iconst_1
    //   27: putfield 67	com/tencent/beacon/a/b/f:j	Z
    //   30: iload_1
    //   31: aload_0
    //   32: getfield 85	com/tencent/beacon/a/b/f:f	Landroid/util/SparseArray;
    //   35: invokevirtual 193	android/util/SparseArray:size	()I
    //   38: if_icmpge +22 -> 60
    //   41: aload_0
    //   42: aload_0
    //   43: getfield 85	com/tencent/beacon/a/b/f:f	Landroid/util/SparseArray;
    //   46: iload_1
    //   47: invokevirtual 197	android/util/SparseArray:keyAt	(I)I
    //   50: invokevirtual 219	com/tencent/beacon/a/b/f:b	(I)V
    //   53: iload_1
    //   54: iconst_1
    //   55: iadd
    //   56: istore_1
    //   57: goto -27 -> 30
    //   60: ldc 217
    //   62: iconst_0
    //   63: anewarray 99	java/lang/Object
    //   66: invokestatic 171	com/tencent/beacon/base/util/c:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   69: goto -47 -> 22
    //   72: astore_3
    //   73: aload_0
    //   74: monitorexit
    //   75: aload_3
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	f
    //   1	56	1	k	int
    //   17	2	2	bool	boolean
    //   72	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	18	72	finally
    //   25	30	72	finally
    //   30	53	72	finally
    //   60	69	72	finally
  }
  
  static final class a
  {
    private final Runnable a;
    private final long b;
    private final long c;
    private final TimeUnit d;
    private Future<?> e;
    
    a(Future<?> paramFuture, Runnable paramRunnable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
    {
      this.e = paramFuture;
      this.a = paramRunnable;
      this.b = paramLong1;
      this.c = paramLong2;
      this.d = paramTimeUnit;
    }
    
    boolean a()
    {
      return this.e.isCancelled();
    }
    
    boolean a(boolean paramBoolean)
    {
      return this.e.cancel(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.a.b.f
 * JD-Core Version:    0.7.0.1
 */