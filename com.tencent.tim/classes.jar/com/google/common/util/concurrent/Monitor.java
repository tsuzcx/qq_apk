package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.j2objc.annotations.Weak;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.concurrent.GuardedBy;

@Beta
@GwtIncompatible
public final class Monitor
{
  @GuardedBy("lock")
  private Guard activeGuards = null;
  private final boolean fair;
  private final ReentrantLock lock;
  
  public Monitor()
  {
    this(false);
  }
  
  public Monitor(boolean paramBoolean)
  {
    this.fair = paramBoolean;
    this.lock = new ReentrantLock(paramBoolean);
  }
  
  @GuardedBy("lock")
  private void await(Guard paramGuard, boolean paramBoolean)
    throws InterruptedException
  {
    if (paramBoolean) {
      signalNextWaiter();
    }
    beginWaitingFor(paramGuard);
    try
    {
      do
      {
        paramGuard.condition.await();
        paramBoolean = paramGuard.isSatisfied();
      } while (!paramBoolean);
      return;
    }
    finally
    {
      endWaitingFor(paramGuard);
    }
  }
  
  @GuardedBy("lock")
  private boolean awaitNanos(Guard paramGuard, long paramLong, boolean paramBoolean)
    throws InterruptedException
  {
    int i = 1;
    for (;;)
    {
      if (paramLong <= 0L)
      {
        if (i == 0) {
          endWaitingFor(paramGuard);
        }
        return false;
      }
      int j = i;
      int k;
      if (i != 0) {
        if (paramBoolean) {
          k = i;
        }
      }
      try
      {
        signalNextWaiter();
        k = i;
        beginWaitingFor(paramGuard);
        j = 0;
        k = j;
        paramLong = paramGuard.condition.awaitNanos(paramLong);
        k = j;
        boolean bool = paramGuard.isSatisfied();
        i = j;
        if (!bool) {
          continue;
        }
        return true;
      }
      finally
      {
        if (k == 0) {
          endWaitingFor(paramGuard);
        }
      }
    }
  }
  
  @GuardedBy("lock")
  private void awaitUninterruptibly(Guard paramGuard, boolean paramBoolean)
  {
    if (paramBoolean) {
      signalNextWaiter();
    }
    beginWaitingFor(paramGuard);
    try
    {
      do
      {
        paramGuard.condition.awaitUninterruptibly();
        paramBoolean = paramGuard.isSatisfied();
      } while (!paramBoolean);
      return;
    }
    finally
    {
      endWaitingFor(paramGuard);
    }
  }
  
  @GuardedBy("lock")
  private void beginWaitingFor(Guard paramGuard)
  {
    int i = paramGuard.waiterCount;
    paramGuard.waiterCount = (i + 1);
    if (i == 0)
    {
      paramGuard.next = this.activeGuards;
      this.activeGuards = paramGuard;
    }
  }
  
  @GuardedBy("lock")
  private void endWaitingFor(Guard paramGuard)
  {
    int i = paramGuard.waiterCount - 1;
    paramGuard.waiterCount = i;
    Object localObject1;
    Object localObject2;
    if (i == 0)
    {
      localObject1 = this.activeGuards;
      localObject2 = null;
    }
    for (;;)
    {
      if (localObject1 == paramGuard)
      {
        if (localObject2 == null) {
          this.activeGuards = ((Guard)localObject1).next;
        }
        for (;;)
        {
          ((Guard)localObject1).next = null;
          return;
          localObject2.next = ((Guard)localObject1).next;
        }
      }
      Guard localGuard = ((Guard)localObject1).next;
      localObject2 = localObject1;
      localObject1 = localGuard;
    }
  }
  
  private static long initNanoTime(long paramLong)
  {
    if (paramLong <= 0L) {
      paramLong = 0L;
    }
    long l;
    do
    {
      return paramLong;
      l = System.nanoTime();
      paramLong = l;
    } while (l != 0L);
    return 1L;
  }
  
  @GuardedBy("lock")
  private boolean isSatisfied(Guard paramGuard)
  {
    try
    {
      boolean bool = paramGuard.isSatisfied();
      return bool;
    }
    catch (Throwable paramGuard)
    {
      signalAllWaiters();
      throw Throwables.propagate(paramGuard);
    }
  }
  
  private static long remainingNanos(long paramLong1, long paramLong2)
  {
    if (paramLong2 <= 0L) {
      return 0L;
    }
    return paramLong2 - (System.nanoTime() - paramLong1);
  }
  
  @GuardedBy("lock")
  private void signalAllWaiters()
  {
    for (Guard localGuard = this.activeGuards; localGuard != null; localGuard = localGuard.next) {
      localGuard.condition.signalAll();
    }
  }
  
  @GuardedBy("lock")
  private void signalNextWaiter()
  {
    for (Guard localGuard = this.activeGuards;; localGuard = localGuard.next) {
      if (localGuard != null)
      {
        if (isSatisfied(localGuard)) {
          localGuard.condition.signal();
        }
      }
      else {
        return;
      }
    }
  }
  
  private static long toSafeNanos(long paramLong, TimeUnit paramTimeUnit)
  {
    paramLong = paramTimeUnit.toNanos(paramLong);
    if (paramLong <= 0L) {
      return 0L;
    }
    if (paramLong > 6917529027641081853L) {
      return 6917529027641081853L;
    }
    return paramLong;
  }
  
  public void enter()
  {
    this.lock.lock();
  }
  
  /* Error */
  public boolean enter(long paramLong, TimeUnit paramTimeUnit)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 9
    //   3: lload_1
    //   4: aload_3
    //   5: invokestatic 123	com/google/common/util/concurrent/Monitor:toSafeNanos	(JLjava/util/concurrent/TimeUnit;)J
    //   8: lstore 4
    //   10: aload_0
    //   11: getfield 34	com/google/common/util/concurrent/Monitor:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   14: astore_3
    //   15: aload_0
    //   16: getfield 29	com/google/common/util/concurrent/Monitor:fair	Z
    //   19: ifne +13 -> 32
    //   22: aload_3
    //   23: invokevirtual 126	java/util/concurrent/locks/ReentrantLock:tryLock	()Z
    //   26: ifeq +6 -> 32
    //   29: iload 9
    //   31: ireturn
    //   32: invokestatic 131	java/lang/Thread:interrupted	()Z
    //   35: istore 8
    //   37: iload 8
    //   39: istore 9
    //   41: invokestatic 86	java/lang/System:nanoTime	()J
    //   44: lstore 6
    //   46: lload 4
    //   48: lstore_1
    //   49: iload 8
    //   51: istore 9
    //   53: aload_3
    //   54: lload_1
    //   55: getstatic 135	java/util/concurrent/TimeUnit:NANOSECONDS	Ljava/util/concurrent/TimeUnit;
    //   58: invokevirtual 137	java/util/concurrent/locks/ReentrantLock:tryLock	(JLjava/util/concurrent/TimeUnit;)Z
    //   61: istore 10
    //   63: iload 10
    //   65: istore 9
    //   67: iload 8
    //   69: ifeq -40 -> 29
    //   72: invokestatic 141	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   75: invokevirtual 144	java/lang/Thread:interrupt	()V
    //   78: iload 10
    //   80: ireturn
    //   81: astore 11
    //   83: lload 6
    //   85: lload 4
    //   87: invokestatic 146	com/google/common/util/concurrent/Monitor:remainingNanos	(JJ)J
    //   90: lstore_1
    //   91: iconst_1
    //   92: istore 8
    //   94: goto -45 -> 49
    //   97: astore_3
    //   98: iload 9
    //   100: ifeq +9 -> 109
    //   103: invokestatic 141	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   106: invokevirtual 144	java/lang/Thread:interrupt	()V
    //   109: aload_3
    //   110: athrow
    //   111: astore_3
    //   112: iconst_1
    //   113: istore 9
    //   115: goto -17 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	this	Monitor
    //   0	118	1	paramLong	long
    //   0	118	3	paramTimeUnit	TimeUnit
    //   8	78	4	l1	long
    //   44	40	6	l2	long
    //   35	58	8	bool1	boolean
    //   1	113	9	bool2	boolean
    //   61	18	10	bool3	boolean
    //   81	1	11	localInterruptedException	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   53	63	81	java/lang/InterruptedException
    //   41	46	97	finally
    //   53	63	97	finally
    //   83	91	111	finally
  }
  
  public boolean enterIf(Guard paramGuard)
  {
    if (paramGuard.monitor != this) {
      throw new IllegalMonitorStateException();
    }
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      boolean bool = paramGuard.isSatisfied();
      if (!bool) {}
      return bool;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public boolean enterIf(Guard paramGuard, long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramGuard.monitor != this) {
      throw new IllegalMonitorStateException();
    }
    boolean bool1;
    if (!enter(paramLong, paramTimeUnit)) {
      bool1 = false;
    }
    for (;;)
    {
      return bool1;
      try
      {
        boolean bool2 = paramGuard.isSatisfied();
        bool1 = bool2;
        if (bool2) {
          continue;
        }
        return bool2;
      }
      finally
      {
        this.lock.unlock();
      }
    }
  }
  
  public boolean enterIfInterruptibly(Guard paramGuard)
    throws InterruptedException
  {
    if (paramGuard.monitor != this) {
      throw new IllegalMonitorStateException();
    }
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lockInterruptibly();
    try
    {
      boolean bool = paramGuard.isSatisfied();
      if (!bool) {}
      return bool;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public boolean enterIfInterruptibly(Guard paramGuard, long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    if (paramGuard.monitor != this) {
      throw new IllegalMonitorStateException();
    }
    ReentrantLock localReentrantLock = this.lock;
    boolean bool1;
    if (!localReentrantLock.tryLock(paramLong, paramTimeUnit)) {
      bool1 = false;
    }
    for (;;)
    {
      return bool1;
      try
      {
        boolean bool2 = paramGuard.isSatisfied();
        bool1 = bool2;
        if (bool2) {
          continue;
        }
        return bool2;
      }
      finally
      {
        localReentrantLock.unlock();
      }
    }
  }
  
  public void enterInterruptibly()
    throws InterruptedException
  {
    this.lock.lockInterruptibly();
  }
  
  public boolean enterInterruptibly(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    return this.lock.tryLock(paramLong, paramTimeUnit);
  }
  
  public void enterWhen(Guard paramGuard)
    throws InterruptedException
  {
    if (paramGuard.monitor != this) {
      throw new IllegalMonitorStateException();
    }
    ReentrantLock localReentrantLock = this.lock;
    boolean bool = localReentrantLock.isHeldByCurrentThread();
    localReentrantLock.lockInterruptibly();
    try
    {
      if (!paramGuard.isSatisfied()) {
        await(paramGuard, bool);
      }
      return;
    }
    finally
    {
      leave();
    }
  }
  
  /* Error */
  public boolean enterWhen(Guard paramGuard, long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    // Byte code:
    //   0: lload_2
    //   1: aload 4
    //   3: invokestatic 123	com/google/common/util/concurrent/Monitor:toSafeNanos	(JLjava/util/concurrent/TimeUnit;)J
    //   6: lstore 7
    //   8: aload_1
    //   9: getfield 151	com/google/common/util/concurrent/Monitor$Guard:monitor	Lcom/google/common/util/concurrent/Monitor;
    //   12: aload_0
    //   13: if_acmpeq +11 -> 24
    //   16: new 153	java/lang/IllegalMonitorStateException
    //   19: dup
    //   20: invokespecial 154	java/lang/IllegalMonitorStateException:<init>	()V
    //   23: athrow
    //   24: aload_0
    //   25: getfield 34	com/google/common/util/concurrent/Monitor:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   28: astore 11
    //   30: aload 11
    //   32: invokevirtual 169	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   35: istore 9
    //   37: aload_0
    //   38: getfield 29	com/google/common/util/concurrent/Monitor:fair	Z
    //   41: ifne +76 -> 117
    //   44: invokestatic 131	java/lang/Thread:interrupted	()Z
    //   47: ifeq +11 -> 58
    //   50: new 40	java/lang/InterruptedException
    //   53: dup
    //   54: invokespecial 175	java/lang/InterruptedException:<init>	()V
    //   57: athrow
    //   58: aload 11
    //   60: invokevirtual 126	java/util/concurrent/locks/ReentrantLock:tryLock	()Z
    //   63: ifeq +54 -> 117
    //   66: lconst_0
    //   67: lstore 5
    //   69: aload_1
    //   70: invokevirtual 59	com/google/common/util/concurrent/Monitor$Guard:isSatisfied	()Z
    //   73: ifne +28 -> 101
    //   76: lload 5
    //   78: lconst_0
    //   79: lcmp
    //   80: ifne +57 -> 137
    //   83: lload 7
    //   85: lstore_2
    //   86: aload_0
    //   87: aload_1
    //   88: lload_2
    //   89: iload 9
    //   91: invokespecial 177	com/google/common/util/concurrent/Monitor:awaitNanos	(Lcom/google/common/util/concurrent/Monitor$Guard;JZ)Z
    //   94: istore 10
    //   96: iload 10
    //   98: ifeq +50 -> 148
    //   101: iconst_1
    //   102: istore 9
    //   104: iload 9
    //   106: ifne +8 -> 114
    //   109: aload 11
    //   111: invokevirtual 157	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   114: iload 9
    //   116: ireturn
    //   117: lload 7
    //   119: invokestatic 179	com/google/common/util/concurrent/Monitor:initNanoTime	(J)J
    //   122: lstore 5
    //   124: aload 11
    //   126: lload_2
    //   127: aload 4
    //   129: invokevirtual 137	java/util/concurrent/locks/ReentrantLock:tryLock	(JLjava/util/concurrent/TimeUnit;)Z
    //   132: ifne -63 -> 69
    //   135: iconst_0
    //   136: ireturn
    //   137: lload 5
    //   139: lload 7
    //   141: invokestatic 146	com/google/common/util/concurrent/Monitor:remainingNanos	(JJ)J
    //   144: lstore_2
    //   145: goto -59 -> 86
    //   148: iconst_0
    //   149: istore 9
    //   151: goto -47 -> 104
    //   154: astore_1
    //   155: iload 9
    //   157: ifne +7 -> 164
    //   160: aload_0
    //   161: invokespecial 43	com/google/common/util/concurrent/Monitor:signalNextWaiter	()V
    //   164: aload 11
    //   166: invokevirtual 157	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   169: aload_1
    //   170: athrow
    //   171: astore_1
    //   172: aload 11
    //   174: invokevirtual 157	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   177: aload_1
    //   178: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	this	Monitor
    //   0	179	1	paramGuard	Guard
    //   0	179	2	paramLong	long
    //   0	179	4	paramTimeUnit	TimeUnit
    //   67	71	5	l1	long
    //   6	134	7	l2	long
    //   35	121	9	bool1	boolean
    //   94	3	10	bool2	boolean
    //   28	145	11	localReentrantLock	ReentrantLock
    // Exception table:
    //   from	to	target	type
    //   69	76	154	finally
    //   86	96	154	finally
    //   137	145	154	finally
    //   160	164	171	finally
  }
  
  public void enterWhenUninterruptibly(Guard paramGuard)
  {
    if (paramGuard.monitor != this) {
      throw new IllegalMonitorStateException();
    }
    ReentrantLock localReentrantLock = this.lock;
    boolean bool = localReentrantLock.isHeldByCurrentThread();
    localReentrantLock.lock();
    try
    {
      if (!paramGuard.isSatisfied()) {
        awaitUninterruptibly(paramGuard, bool);
      }
      return;
    }
    finally
    {
      leave();
    }
  }
  
  /* Error */
  public boolean enterWhenUninterruptibly(Guard paramGuard, long paramLong, TimeUnit paramTimeUnit)
  {
    // Byte code:
    //   0: lload_2
    //   1: aload 4
    //   3: invokestatic 123	com/google/common/util/concurrent/Monitor:toSafeNanos	(JLjava/util/concurrent/TimeUnit;)J
    //   6: lstore 5
    //   8: aload_1
    //   9: getfield 151	com/google/common/util/concurrent/Monitor$Guard:monitor	Lcom/google/common/util/concurrent/Monitor;
    //   12: aload_0
    //   13: if_acmpeq +11 -> 24
    //   16: new 153	java/lang/IllegalMonitorStateException
    //   19: dup
    //   20: invokespecial 154	java/lang/IllegalMonitorStateException:<init>	()V
    //   23: athrow
    //   24: aload_0
    //   25: getfield 34	com/google/common/util/concurrent/Monitor:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   28: astore 4
    //   30: lconst_0
    //   31: lstore_2
    //   32: aload 4
    //   34: invokevirtual 169	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   37: istore 13
    //   39: invokestatic 131	java/lang/Thread:interrupted	()Z
    //   42: istore 12
    //   44: aload_0
    //   45: getfield 29	com/google/common/util/concurrent/Monitor:fair	Z
    //   48: ifne +15 -> 63
    //   51: iload 12
    //   53: istore 11
    //   55: aload 4
    //   57: invokevirtual 126	java/util/concurrent/locks/ReentrantLock:tryLock	()Z
    //   60: ifne +34 -> 94
    //   63: lload 5
    //   65: invokestatic 179	com/google/common/util/concurrent/Monitor:initNanoTime	(J)J
    //   68: lstore_2
    //   69: lload 5
    //   71: lstore 7
    //   73: iload 12
    //   75: istore 11
    //   77: aload 4
    //   79: lload 7
    //   81: getstatic 135	java/util/concurrent/TimeUnit:NANOSECONDS	Ljava/util/concurrent/TimeUnit;
    //   84: invokevirtual 137	java/util/concurrent/locks/ReentrantLock:tryLock	(JLjava/util/concurrent/TimeUnit;)Z
    //   87: istore 12
    //   89: iload 12
    //   91: ifeq +48 -> 139
    //   94: iload 13
    //   96: istore 12
    //   98: lload_2
    //   99: lstore 7
    //   101: aload_1
    //   102: invokevirtual 59	com/google/common/util/concurrent/Monitor$Guard:isSatisfied	()Z
    //   105: istore 13
    //   107: iload 13
    //   109: ifeq +62 -> 171
    //   112: iconst_1
    //   113: istore 12
    //   115: iload 12
    //   117: ifne +8 -> 125
    //   120: aload 4
    //   122: invokevirtual 157	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   125: iload 11
    //   127: ifeq +9 -> 136
    //   130: invokestatic 141	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   133: invokevirtual 144	java/lang/Thread:interrupt	()V
    //   136: iload 12
    //   138: ireturn
    //   139: iload 11
    //   141: ifeq +9 -> 150
    //   144: invokestatic 141	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   147: invokevirtual 144	java/lang/Thread:interrupt	()V
    //   150: iconst_0
    //   151: ireturn
    //   152: astore 14
    //   154: iconst_1
    //   155: istore 11
    //   157: lload_2
    //   158: lload 5
    //   160: invokestatic 146	com/google/common/util/concurrent/Monitor:remainingNanos	(JJ)J
    //   163: lstore 7
    //   165: iconst_1
    //   166: istore 11
    //   168: goto -91 -> 77
    //   171: lload_2
    //   172: lconst_0
    //   173: lcmp
    //   174: ifne +33 -> 207
    //   177: lload_2
    //   178: lstore 7
    //   180: lload 5
    //   182: invokestatic 179	com/google/common/util/concurrent/Monitor:initNanoTime	(J)J
    //   185: lstore_2
    //   186: lload 5
    //   188: lstore 9
    //   190: lload_2
    //   191: lstore 7
    //   193: aload_0
    //   194: aload_1
    //   195: lload 9
    //   197: iload 12
    //   199: invokespecial 177	com/google/common/util/concurrent/Monitor:awaitNanos	(Lcom/google/common/util/concurrent/Monitor$Guard;JZ)Z
    //   202: istore 12
    //   204: goto -89 -> 115
    //   207: lload_2
    //   208: lstore 7
    //   210: lload_2
    //   211: lload 5
    //   213: invokestatic 146	com/google/common/util/concurrent/Monitor:remainingNanos	(JJ)J
    //   216: lstore 9
    //   218: goto -28 -> 190
    //   221: astore 14
    //   223: iconst_1
    //   224: istore 11
    //   226: iconst_0
    //   227: istore 12
    //   229: lload 7
    //   231: lstore_2
    //   232: goto -134 -> 98
    //   235: astore_1
    //   236: aload 4
    //   238: invokevirtual 157	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   241: aload_1
    //   242: athrow
    //   243: astore_1
    //   244: iload 11
    //   246: ifeq +9 -> 255
    //   249: invokestatic 141	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   252: invokevirtual 144	java/lang/Thread:interrupt	()V
    //   255: aload_1
    //   256: athrow
    //   257: astore_1
    //   258: iload 12
    //   260: istore 11
    //   262: goto -18 -> 244
    //   265: astore_1
    //   266: goto -22 -> 244
    //   269: astore_1
    //   270: goto -26 -> 244
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	273	0	this	Monitor
    //   0	273	1	paramGuard	Guard
    //   0	273	2	paramLong	long
    //   0	273	4	paramTimeUnit	TimeUnit
    //   6	206	5	l1	long
    //   71	159	7	l2	long
    //   188	29	9	l3	long
    //   53	208	11	bool1	boolean
    //   42	217	12	bool2	boolean
    //   37	71	13	bool3	boolean
    //   152	1	14	localInterruptedException1	InterruptedException
    //   221	1	14	localInterruptedException2	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   77	89	152	java/lang/InterruptedException
    //   101	107	221	java/lang/InterruptedException
    //   180	186	221	java/lang/InterruptedException
    //   193	204	221	java/lang/InterruptedException
    //   210	218	221	java/lang/InterruptedException
    //   101	107	235	finally
    //   180	186	235	finally
    //   193	204	235	finally
    //   210	218	235	finally
    //   120	125	243	finally
    //   236	243	243	finally
    //   44	51	257	finally
    //   55	63	257	finally
    //   63	69	257	finally
    //   77	89	265	finally
    //   157	165	269	finally
  }
  
  public int getOccupiedDepth()
  {
    return this.lock.getHoldCount();
  }
  
  public int getQueueLength()
  {
    return this.lock.getQueueLength();
  }
  
  public int getWaitQueueLength(Guard paramGuard)
  {
    if (paramGuard.monitor != this) {
      throw new IllegalMonitorStateException();
    }
    this.lock.lock();
    try
    {
      int i = paramGuard.waiterCount;
      return i;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public boolean hasQueuedThread(Thread paramThread)
  {
    return this.lock.hasQueuedThread(paramThread);
  }
  
  public boolean hasQueuedThreads()
  {
    return this.lock.hasQueuedThreads();
  }
  
  public boolean hasWaiters(Guard paramGuard)
  {
    return getWaitQueueLength(paramGuard) > 0;
  }
  
  public boolean isFair()
  {
    return this.fair;
  }
  
  public boolean isOccupied()
  {
    return this.lock.isLocked();
  }
  
  public boolean isOccupiedByCurrentThread()
  {
    return this.lock.isHeldByCurrentThread();
  }
  
  public void leave()
  {
    ReentrantLock localReentrantLock = this.lock;
    try
    {
      if (localReentrantLock.getHoldCount() == 1) {
        signalNextWaiter();
      }
      return;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public boolean tryEnter()
  {
    return this.lock.tryLock();
  }
  
  public boolean tryEnterIf(Guard paramGuard)
  {
    if (paramGuard.monitor != this) {
      throw new IllegalMonitorStateException();
    }
    ReentrantLock localReentrantLock = this.lock;
    boolean bool1;
    if (!localReentrantLock.tryLock()) {
      bool1 = false;
    }
    for (;;)
    {
      return bool1;
      try
      {
        boolean bool2 = paramGuard.isSatisfied();
        bool1 = bool2;
        if (bool2) {
          continue;
        }
        return bool2;
      }
      finally
      {
        localReentrantLock.unlock();
      }
    }
  }
  
  public void waitFor(Guard paramGuard)
    throws InterruptedException
  {
    if (paramGuard.monitor == this) {}
    for (int i = 1; (i & this.lock.isHeldByCurrentThread()) == 0; i = 0) {
      throw new IllegalMonitorStateException();
    }
    if (!paramGuard.isSatisfied()) {
      await(paramGuard, true);
    }
  }
  
  public boolean waitFor(Guard paramGuard, long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    paramLong = toSafeNanos(paramLong, paramTimeUnit);
    if (paramGuard.monitor == this) {}
    for (int i = 1; (i & this.lock.isHeldByCurrentThread()) == 0; i = 0) {
      throw new IllegalMonitorStateException();
    }
    if (paramGuard.isSatisfied()) {
      return true;
    }
    if (Thread.interrupted()) {
      throw new InterruptedException();
    }
    return awaitNanos(paramGuard, paramLong, true);
  }
  
  public void waitForUninterruptibly(Guard paramGuard)
  {
    if (paramGuard.monitor == this) {}
    for (int i = 1; (i & this.lock.isHeldByCurrentThread()) == 0; i = 0) {
      throw new IllegalMonitorStateException();
    }
    if (!paramGuard.isSatisfied()) {
      awaitUninterruptibly(paramGuard, true);
    }
  }
  
  /* Error */
  public boolean waitForUninterruptibly(Guard paramGuard, long paramLong, TimeUnit paramTimeUnit)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 12
    //   3: iconst_1
    //   4: istore 11
    //   6: lload_2
    //   7: aload 4
    //   9: invokestatic 123	com/google/common/util/concurrent/Monitor:toSafeNanos	(JLjava/util/concurrent/TimeUnit;)J
    //   12: lstore 6
    //   14: aload_1
    //   15: getfield 151	com/google/common/util/concurrent/Monitor$Guard:monitor	Lcom/google/common/util/concurrent/Monitor;
    //   18: aload_0
    //   19: if_acmpne +27 -> 46
    //   22: iconst_1
    //   23: istore 5
    //   25: iload 5
    //   27: aload_0
    //   28: getfield 34	com/google/common/util/concurrent/Monitor:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   31: invokevirtual 169	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   34: iand
    //   35: ifne +17 -> 52
    //   38: new 153	java/lang/IllegalMonitorStateException
    //   41: dup
    //   42: invokespecial 154	java/lang/IllegalMonitorStateException:<init>	()V
    //   45: athrow
    //   46: iconst_0
    //   47: istore 5
    //   49: goto -24 -> 25
    //   52: aload_1
    //   53: invokevirtual 59	com/google/common/util/concurrent/Monitor$Guard:isSatisfied	()Z
    //   56: ifeq +6 -> 62
    //   59: iload 11
    //   61: ireturn
    //   62: lload 6
    //   64: invokestatic 179	com/google/common/util/concurrent/Monitor:initNanoTime	(J)J
    //   67: lstore 8
    //   69: invokestatic 131	java/lang/Thread:interrupted	()Z
    //   72: istore 10
    //   74: lload 6
    //   76: lstore_2
    //   77: iconst_1
    //   78: istore 11
    //   80: aload_0
    //   81: aload_1
    //   82: lload_2
    //   83: iload 11
    //   85: invokespecial 177	com/google/common/util/concurrent/Monitor:awaitNanos	(Lcom/google/common/util/concurrent/Monitor$Guard;JZ)Z
    //   88: istore 11
    //   90: iload 11
    //   92: istore 12
    //   94: iload 12
    //   96: istore 11
    //   98: iload 10
    //   100: ifeq -41 -> 59
    //   103: invokestatic 141	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   106: invokevirtual 144	java/lang/Thread:interrupt	()V
    //   109: iload 12
    //   111: ireturn
    //   112: astore 4
    //   114: aload_1
    //   115: invokevirtual 59	com/google/common/util/concurrent/Monitor$Guard:isSatisfied	()Z
    //   118: istore 10
    //   120: iload 10
    //   122: ifeq +11 -> 133
    //   125: invokestatic 141	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   128: invokevirtual 144	java/lang/Thread:interrupt	()V
    //   131: iconst_1
    //   132: ireturn
    //   133: lload 8
    //   135: lload 6
    //   137: invokestatic 146	com/google/common/util/concurrent/Monitor:remainingNanos	(JJ)J
    //   140: lstore_2
    //   141: iconst_1
    //   142: istore 10
    //   144: iconst_0
    //   145: istore 11
    //   147: goto -67 -> 80
    //   150: astore_1
    //   151: iload 10
    //   153: ifeq +9 -> 162
    //   156: invokestatic 141	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   159: invokevirtual 144	java/lang/Thread:interrupt	()V
    //   162: aload_1
    //   163: athrow
    //   164: astore_1
    //   165: iload 12
    //   167: istore 10
    //   169: goto -18 -> 151
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	this	Monitor
    //   0	172	1	paramGuard	Guard
    //   0	172	2	paramLong	long
    //   0	172	4	paramTimeUnit	TimeUnit
    //   23	25	5	i	int
    //   12	124	6	l1	long
    //   67	67	8	l2	long
    //   72	96	10	bool1	boolean
    //   4	142	11	bool2	boolean
    //   1	165	12	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   80	90	112	java/lang/InterruptedException
    //   80	90	150	finally
    //   114	120	164	finally
    //   133	141	164	finally
  }
  
  @Beta
  public static abstract class Guard
  {
    final Condition condition;
    @Weak
    final Monitor monitor;
    @GuardedBy("monitor.lock")
    Guard next;
    @GuardedBy("monitor.lock")
    int waiterCount = 0;
    
    protected Guard(Monitor paramMonitor)
    {
      this.monitor = ((Monitor)Preconditions.checkNotNull(paramMonitor, "monitor"));
      this.condition = paramMonitor.lock.newCondition();
    }
    
    public abstract boolean isSatisfied();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.Monitor
 * JD-Core Version:    0.7.0.1
 */