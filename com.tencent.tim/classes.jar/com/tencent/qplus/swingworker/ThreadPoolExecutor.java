package com.tencent.qplus.swingworker;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPoolExecutor
  extends AbstractExecutorService
{
  static final int RUNNING = 0;
  static final int SHUTDOWN = 1;
  static final int STOP = 2;
  static final int TERMINATED = 3;
  private static final RejectedExecutionHandler defaultHandler = new AbortPolicy();
  private static final RuntimePermission shutdownPerm = new RuntimePermission("modifyThread");
  private volatile boolean allowCoreThreadTimeOut;
  private long completedTaskCount;
  private volatile int corePoolSize;
  private volatile RejectedExecutionHandler handler;
  private volatile long keepAliveTime;
  private int largestPoolSize;
  final ReentrantLock mainLock = new ReentrantLock();
  private volatile int maximumPoolSize;
  private volatile int poolSize;
  volatile int runState;
  private final Condition termination = this.mainLock.newCondition();
  private volatile ThreadFactory threadFactory;
  private final BlockingQueue<Runnable> workQueue;
  private final HashSet<Worker> workers = new HashSet();
  
  public ThreadPoolExecutor(int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit, BlockingQueue<Runnable> paramBlockingQueue)
  {
    this(paramInt1, paramInt2, paramLong, paramTimeUnit, paramBlockingQueue, Executors.defaultThreadFactory(), defaultHandler);
  }
  
  public ThreadPoolExecutor(int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit, BlockingQueue<Runnable> paramBlockingQueue, RejectedExecutionHandler paramRejectedExecutionHandler)
  {
    this(paramInt1, paramInt2, paramLong, paramTimeUnit, paramBlockingQueue, Executors.defaultThreadFactory(), paramRejectedExecutionHandler);
  }
  
  public ThreadPoolExecutor(int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit, BlockingQueue<Runnable> paramBlockingQueue, ThreadFactory paramThreadFactory)
  {
    this(paramInt1, paramInt2, paramLong, paramTimeUnit, paramBlockingQueue, paramThreadFactory, defaultHandler);
  }
  
  public ThreadPoolExecutor(int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit, BlockingQueue<Runnable> paramBlockingQueue, ThreadFactory paramThreadFactory, RejectedExecutionHandler paramRejectedExecutionHandler)
  {
    if ((paramInt1 < 0) || (paramInt2 <= 0) || (paramInt2 < paramInt1) || (paramLong < 0L)) {
      throw new IllegalArgumentException();
    }
    if ((paramBlockingQueue == null) || (paramThreadFactory == null) || (paramRejectedExecutionHandler == null)) {
      throw new NullPointerException();
    }
    this.corePoolSize = paramInt1;
    this.maximumPoolSize = paramInt2;
    this.workQueue = paramBlockingQueue;
    this.keepAliveTime = paramTimeUnit.toNanos(paramLong);
    this.threadFactory = paramThreadFactory;
    this.handler = paramRejectedExecutionHandler;
  }
  
  private boolean addIfUnderCorePoolSize(Runnable paramRunnable)
  {
    Object localObject2 = null;
    ReentrantLock localReentrantLock = this.mainLock;
    localReentrantLock.lock();
    Object localObject1 = localObject2;
    try
    {
      if (this.poolSize < this.corePoolSize)
      {
        localObject1 = localObject2;
        if (this.runState == 0) {
          localObject1 = addThread(paramRunnable);
        }
      }
      localReentrantLock.unlock();
      if (localObject1 == null) {
        return false;
      }
    }
    finally
    {
      localReentrantLock.unlock();
    }
    ((Thread)localObject1).start();
    return true;
  }
  
  private boolean addIfUnderMaximumPoolSize(Runnable paramRunnable)
  {
    Object localObject2 = null;
    ReentrantLock localReentrantLock = this.mainLock;
    localReentrantLock.lock();
    Object localObject1 = localObject2;
    try
    {
      if (this.poolSize < this.maximumPoolSize)
      {
        localObject1 = localObject2;
        if (this.runState == 0) {
          localObject1 = addThread(paramRunnable);
        }
      }
      localReentrantLock.unlock();
      if (localObject1 == null) {
        return false;
      }
    }
    finally
    {
      localReentrantLock.unlock();
    }
    ((Thread)localObject1).start();
    return true;
  }
  
  private Thread addThread(Runnable paramRunnable)
  {
    if (((paramRunnable instanceof SchedulingRule)) && (isConflicting((SchedulingRule)paramRunnable))) {
      paramRunnable = null;
    }
    Thread localThread;
    int i;
    do
    {
      Worker localWorker;
      do
      {
        return paramRunnable;
        localWorker = new Worker(paramRunnable);
        localThread = this.threadFactory.newThread(localWorker);
        paramRunnable = localThread;
      } while (localThread == null);
      localWorker.thread = localThread;
      this.workers.add(localWorker);
      i = this.poolSize + 1;
      this.poolSize = i;
      paramRunnable = localThread;
    } while (i <= this.largestPoolSize);
    this.largestPoolSize = i;
    return localThread;
  }
  
  private List<Runnable> drainQueue()
  {
    ArrayList localArrayList = new ArrayList();
    this.workQueue.drainTo(localArrayList);
    for (;;)
    {
      if (this.workQueue.isEmpty()) {
        return localArrayList;
      }
      Object localObject = this.workQueue.iterator();
      try
      {
        if (((Iterator)localObject).hasNext())
        {
          localObject = (Runnable)((Iterator)localObject).next();
          if (this.workQueue.remove(localObject)) {
            localArrayList.add(localObject);
          }
        }
      }
      catch (ConcurrentModificationException localConcurrentModificationException) {}
    }
  }
  
  private void ensureQueuedTaskHandled(Runnable paramRunnable)
  {
    Thread localThread = null;
    int i = 1;
    ReentrantLock localReentrantLock = this.mainLock;
    localReentrantLock.lock();
    for (;;)
    {
      try
      {
        int j = this.runState;
        if (j != 0)
        {
          boolean bool = this.workQueue.remove(paramRunnable);
          if (bool)
          {
            localReentrantLock.unlock();
            if (i == 0) {
              break label109;
            }
            reject(paramRunnable);
            return;
          }
        }
        if ((j >= 2) || (this.poolSize >= Math.max(this.corePoolSize, 1)) || (this.workQueue.isEmpty())) {
          break label120;
        }
        localThread = addThread(null);
        i = 0;
        continue;
        if (localThread == null) {
          continue;
        }
      }
      finally
      {
        localReentrantLock.unlock();
      }
      label109:
      localThread.start();
      return;
      label120:
      i = 0;
    }
  }
  
  private void tryTerminate()
  {
    if (this.poolSize == 0)
    {
      int j = this.runState;
      int i = j;
      if (j < 2)
      {
        i = j;
        if (!this.workQueue.isEmpty())
        {
          j = 0;
          Thread localThread = addThread(null);
          i = j;
          if (localThread != null)
          {
            localThread.start();
            i = j;
          }
        }
      }
      if ((i == 2) || (i == 1))
      {
        this.runState = 3;
        this.termination.signalAll();
        terminated();
      }
    }
  }
  
  private boolean workerCanExit()
  {
    boolean bool2 = true;
    ReentrantLock localReentrantLock = this.mainLock;
    localReentrantLock.lock();
    boolean bool1 = bool2;
    try
    {
      if (this.runState < 2)
      {
        bool1 = bool2;
        if (!this.workQueue.isEmpty()) {
          if (this.allowCoreThreadTimeOut)
          {
            int i = this.poolSize;
            int j = Math.max(1, this.corePoolSize);
            bool1 = bool2;
            if (i > j) {}
          }
          else
          {
            bool1 = false;
          }
        }
      }
      return bool1;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  protected void afterExecute(Runnable paramRunnable, Throwable paramThrowable) {}
  
  public void allowCoreThreadTimeOut(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.keepAliveTime <= 0L)) {
      throw new IllegalArgumentException("Core threads must have nonzero keep alive times");
    }
    this.allowCoreThreadTimeOut = paramBoolean;
  }
  
  public boolean allowsCoreThreadTimeOut()
  {
    return this.allowCoreThreadTimeOut;
  }
  
  /* Error */
  public boolean awaitTermination(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    // Byte code:
    //   0: aload_3
    //   1: lload_1
    //   2: invokevirtual 123	java/util/concurrent/TimeUnit:toNanos	(J)J
    //   5: lstore_1
    //   6: aload_0
    //   7: getfield 94	com/tencent/qplus/swingworker/ThreadPoolExecutor:mainLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   10: astore_3
    //   11: aload_3
    //   12: invokevirtual 135	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   15: aload_0
    //   16: getfield 139	com/tencent/qplus/swingworker/ThreadPoolExecutor:runState	I
    //   19: istore 4
    //   21: iload 4
    //   23: iconst_3
    //   24: if_icmpne +9 -> 33
    //   27: aload_3
    //   28: invokevirtual 146	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   31: iconst_1
    //   32: ireturn
    //   33: lload_1
    //   34: lconst_0
    //   35: lcmp
    //   36: ifgt +9 -> 45
    //   39: aload_3
    //   40: invokevirtual 146	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   43: iconst_0
    //   44: ireturn
    //   45: aload_0
    //   46: getfield 100	com/tencent/qplus/swingworker/ThreadPoolExecutor:termination	Ljava/util/concurrent/locks/Condition;
    //   49: lload_1
    //   50: invokeinterface 252 3 0
    //   55: lstore_1
    //   56: goto -41 -> 15
    //   59: astore 5
    //   61: aload_3
    //   62: invokevirtual 146	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   65: aload 5
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	ThreadPoolExecutor
    //   0	68	1	paramLong	long
    //   0	68	3	paramTimeUnit	TimeUnit
    //   19	6	4	i	int
    //   59	7	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   15	21	59	finally
    //   45	56	59	finally
  }
  
  protected void beforeExecute(Thread paramThread, Runnable paramRunnable) {}
  
  public void execute(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      throw new NullPointerException();
    }
    if ((this.poolSize >= this.corePoolSize) || (!addIfUnderCorePoolSize(paramRunnable)))
    {
      if ((this.runState != 0) || (!this.workQueue.offer(paramRunnable))) {
        break label71;
      }
      if ((this.runState != 0) || (this.poolSize == 0)) {
        ensureQueuedTaskHandled(paramRunnable);
      }
    }
    label71:
    while (addIfUnderMaximumPoolSize(paramRunnable)) {
      return;
    }
    reject(paramRunnable);
  }
  
  protected void finalize()
  {
    shutdown();
  }
  
  /* Error */
  public int getActiveCount()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 94	com/tencent/qplus/swingworker/ThreadPoolExecutor:mainLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: astore_3
    //   5: aload_3
    //   6: invokevirtual 135	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   9: aload_0
    //   10: getfield 105	com/tencent/qplus/swingworker/ThreadPoolExecutor:workers	Ljava/util/HashSet;
    //   13: invokevirtual 272	java/util/HashSet:iterator	()Ljava/util/Iterator;
    //   16: astore 4
    //   18: iconst_0
    //   19: istore_1
    //   20: aload 4
    //   22: invokeinterface 202 1 0
    //   27: istore_2
    //   28: iload_2
    //   29: ifne +9 -> 38
    //   32: aload_3
    //   33: invokevirtual 146	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   36: iload_1
    //   37: ireturn
    //   38: aload 4
    //   40: invokeinterface 206 1 0
    //   45: checkcast 18	com/tencent/qplus/swingworker/ThreadPoolExecutor$Worker
    //   48: invokevirtual 275	com/tencent/qplus/swingworker/ThreadPoolExecutor$Worker:isActive	()Z
    //   51: istore_2
    //   52: iload_2
    //   53: ifeq -33 -> 20
    //   56: iload_1
    //   57: iconst_1
    //   58: iadd
    //   59: istore_1
    //   60: goto -40 -> 20
    //   63: astore 4
    //   65: aload_3
    //   66: invokevirtual 146	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   69: aload 4
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	ThreadPoolExecutor
    //   19	41	1	i	int
    //   27	26	2	bool	boolean
    //   4	62	3	localReentrantLock	ReentrantLock
    //   16	23	4	localIterator	Iterator
    //   63	7	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	18	63	finally
    //   20	28	63	finally
    //   38	52	63	finally
  }
  
  /* Error */
  public long getCompletedTaskCount()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 94	com/tencent/qplus/swingworker/ThreadPoolExecutor:mainLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: astore 6
    //   6: aload 6
    //   8: invokevirtual 135	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   11: aload_0
    //   12: getfield 279	com/tencent/qplus/swingworker/ThreadPoolExecutor:completedTaskCount	J
    //   15: lstore_1
    //   16: aload_0
    //   17: getfield 105	com/tencent/qplus/swingworker/ThreadPoolExecutor:workers	Ljava/util/HashSet;
    //   20: invokevirtual 272	java/util/HashSet:iterator	()Ljava/util/Iterator;
    //   23: astore 7
    //   25: aload 7
    //   27: invokeinterface 202 1 0
    //   32: istore 5
    //   34: iload 5
    //   36: ifne +10 -> 46
    //   39: aload 6
    //   41: invokevirtual 146	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   44: lload_1
    //   45: lreturn
    //   46: aload 7
    //   48: invokeinterface 206 1 0
    //   53: checkcast 18	com/tencent/qplus/swingworker/ThreadPoolExecutor$Worker
    //   56: getfield 282	com/tencent/qplus/swingworker/ThreadPoolExecutor$Worker:completedTasks	J
    //   59: lstore_3
    //   60: lload_3
    //   61: lload_1
    //   62: ladd
    //   63: lstore_1
    //   64: goto -39 -> 25
    //   67: astore 7
    //   69: aload 6
    //   71: invokevirtual 146	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   74: aload 7
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	ThreadPoolExecutor
    //   15	49	1	l1	long
    //   59	2	3	l2	long
    //   32	3	5	bool	boolean
    //   4	66	6	localReentrantLock	ReentrantLock
    //   23	24	7	localIterator	Iterator
    //   67	8	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	25	67	finally
    //   25	34	67	finally
    //   46	60	67	finally
  }
  
  public int getCorePoolSize()
  {
    return this.corePoolSize;
  }
  
  public long getKeepAliveTime(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.keepAliveTime, TimeUnit.NANOSECONDS);
  }
  
  public int getLargestPoolSize()
  {
    ReentrantLock localReentrantLock = this.mainLock;
    localReentrantLock.lock();
    try
    {
      int i = this.largestPoolSize;
      return i;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public int getMaximumPoolSize()
  {
    return this.maximumPoolSize;
  }
  
  public int getPoolSize()
  {
    return this.poolSize;
  }
  
  public BlockingQueue<Runnable> getQueue()
  {
    return this.workQueue;
  }
  
  public RejectedExecutionHandler getRejectedExecutionHandler()
  {
    return this.handler;
  }
  
  boolean getTask(Worker paramWorker)
  {
    for (;;)
    {
      try
      {
        int i = this.runState;
        if (i > 1) {
          return false;
        }
        if ((this.workQueue instanceof ScheduleLinkedBlockingQueue))
        {
          ScheduleLinkedBlockingQueue localScheduleLinkedBlockingQueue = (ScheduleLinkedBlockingQueue)this.workQueue;
          if (i == 1)
          {
            paramWorker.currentTask = ((Runnable)this.workQueue.poll());
            if (paramWorker.currentTask != null) {
              return true;
            }
          }
          else
          {
            if ((this.poolSize > this.corePoolSize) || (this.allowCoreThreadTimeOut))
            {
              localScheduleLinkedBlockingQueue.polllToWorker(this.keepAliveTime, TimeUnit.NANOSECONDS, paramWorker);
              continue;
            }
            localScheduleLinkedBlockingQueue.takeToWorker(paramWorker);
            continue;
          }
        }
        else
        {
          if (i == 1)
          {
            paramWorker.currentTask = ((Runnable)this.workQueue.poll());
            continue;
          }
          if ((this.poolSize > this.corePoolSize) || (this.allowCoreThreadTimeOut))
          {
            paramWorker.currentTask = ((Runnable)this.workQueue.poll(this.keepAliveTime, TimeUnit.NANOSECONDS));
            continue;
          }
          paramWorker.currentTask = ((Runnable)this.workQueue.take());
          continue;
        }
        if (workerCanExit())
        {
          if (this.runState >= 1) {
            interruptIdleWorkers();
          }
          return false;
        }
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
  
  /* Error */
  public long getTaskCount()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 94	com/tencent/qplus/swingworker/ThreadPoolExecutor:mainLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: astore 7
    //   6: aload 7
    //   8: invokevirtual 135	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   11: aload_0
    //   12: getfield 279	com/tencent/qplus/swingworker/ThreadPoolExecutor:completedTaskCount	J
    //   15: lstore_2
    //   16: aload_0
    //   17: getfield 105	com/tencent/qplus/swingworker/ThreadPoolExecutor:workers	Ljava/util/HashSet;
    //   20: invokevirtual 272	java/util/HashSet:iterator	()Ljava/util/Iterator;
    //   23: astore 8
    //   25: aload 8
    //   27: invokeinterface 202 1 0
    //   32: ifne +27 -> 59
    //   35: aload_0
    //   36: getfield 117	com/tencent/qplus/swingworker/ThreadPoolExecutor:workQueue	Ljava/util/concurrent/BlockingQueue;
    //   39: invokeinterface 335 1 0
    //   44: istore_1
    //   45: iload_1
    //   46: i2l
    //   47: lstore 4
    //   49: aload 7
    //   51: invokevirtual 146	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   54: lload 4
    //   56: lload_2
    //   57: ladd
    //   58: lreturn
    //   59: aload 8
    //   61: invokeinterface 206 1 0
    //   66: checkcast 18	com/tencent/qplus/swingworker/ThreadPoolExecutor$Worker
    //   69: astore 9
    //   71: lload_2
    //   72: aload 9
    //   74: getfield 282	com/tencent/qplus/swingworker/ThreadPoolExecutor$Worker:completedTasks	J
    //   77: ladd
    //   78: lstore 4
    //   80: aload 9
    //   82: invokevirtual 275	com/tencent/qplus/swingworker/ThreadPoolExecutor$Worker:isActive	()Z
    //   85: istore 6
    //   87: lload 4
    //   89: lstore_2
    //   90: iload 6
    //   92: ifeq -67 -> 25
    //   95: lconst_1
    //   96: lload 4
    //   98: ladd
    //   99: lstore_2
    //   100: goto -75 -> 25
    //   103: astore 8
    //   105: aload 7
    //   107: invokevirtual 146	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   110: aload 8
    //   112: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	ThreadPoolExecutor
    //   44	2	1	i	int
    //   15	85	2	l1	long
    //   47	50	4	l2	long
    //   85	6	6	bool	boolean
    //   4	102	7	localReentrantLock	ReentrantLock
    //   23	37	8	localIterator	Iterator
    //   103	8	8	localObject	Object
    //   69	12	9	localWorker	Worker
    // Exception table:
    //   from	to	target	type
    //   11	25	103	finally
    //   25	45	103	finally
    //   59	87	103	finally
  }
  
  public ThreadFactory getThreadFactory()
  {
    return this.threadFactory;
  }
  
  /* Error */
  void interruptIdleWorkers()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 94	com/tencent/qplus/swingworker/ThreadPoolExecutor:mainLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: astore_2
    //   5: aload_2
    //   6: invokevirtual 135	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   9: aload_0
    //   10: getfield 105	com/tencent/qplus/swingworker/ThreadPoolExecutor:workers	Ljava/util/HashSet;
    //   13: invokevirtual 272	java/util/HashSet:iterator	()Ljava/util/Iterator;
    //   16: astore_3
    //   17: aload_3
    //   18: invokeinterface 202 1 0
    //   23: istore_1
    //   24: iload_1
    //   25: ifne +8 -> 33
    //   28: aload_2
    //   29: invokevirtual 146	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   32: return
    //   33: aload_3
    //   34: invokeinterface 206 1 0
    //   39: checkcast 18	com/tencent/qplus/swingworker/ThreadPoolExecutor$Worker
    //   42: invokevirtual 339	com/tencent/qplus/swingworker/ThreadPoolExecutor$Worker:interruptIfIdle	()V
    //   45: goto -28 -> 17
    //   48: astore_3
    //   49: aload_2
    //   50: invokevirtual 146	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   53: aload_3
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	ThreadPoolExecutor
    //   23	2	1	bool	boolean
    //   4	46	2	localReentrantLock	ReentrantLock
    //   16	18	3	localIterator	Iterator
    //   48	6	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	17	48	finally
    //   17	24	48	finally
    //   33	45	48	finally
  }
  
  public boolean isConflicting(SchedulingRule paramSchedulingRule)
  {
    this.mainLock.lock();
    try
    {
      Iterator localIterator = this.workers.iterator();
      boolean bool;
      do
      {
        Object localObject;
        do
        {
          do
          {
            bool = localIterator.hasNext();
            if (!bool) {
              return false;
            }
            localObject = (Worker)localIterator.next();
          } while (!(((Worker)localObject).currentTask instanceof SchedulingRule));
          localObject = (SchedulingRule)((Worker)localObject).currentTask;
        } while (localObject == null);
        bool = ((SchedulingRule)localObject).isConflicting(paramSchedulingRule);
      } while (!bool);
      return true;
    }
    finally
    {
      this.mainLock.unlock();
    }
  }
  
  public boolean isShutdown()
  {
    return this.runState != 0;
  }
  
  boolean isStopped()
  {
    return this.runState == 2;
  }
  
  public boolean isTerminated()
  {
    return this.runState == 3;
  }
  
  public boolean isTerminating()
  {
    boolean bool2 = true;
    int i = this.runState;
    boolean bool1 = bool2;
    if (i != 1)
    {
      bool1 = bool2;
      if (i != 2) {
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public int prestartAllCoreThreads()
  {
    int i = 0;
    for (;;)
    {
      if (!addIfUnderCorePoolSize(null)) {
        return i;
      }
      i += 1;
    }
  }
  
  public boolean prestartCoreThread()
  {
    return addIfUnderCorePoolSize(null);
  }
  
  public void purge()
  {
    try
    {
      Iterator localIterator = getQueue().iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          return;
        }
        Runnable localRunnable = (Runnable)localIterator.next();
        if (((localRunnable instanceof Future)) && (((Future)localRunnable).isCancelled())) {
          localIterator.remove();
        }
      }
      return;
    }
    catch (ConcurrentModificationException localConcurrentModificationException) {}
  }
  
  void reject(Runnable paramRunnable)
  {
    this.handler.rejectedExecution(paramRunnable, this);
  }
  
  public boolean remove(Runnable paramRunnable)
  {
    return getQueue().remove(paramRunnable);
  }
  
  /* Error */
  public void setCorePoolSize(int paramInt)
  {
    // Byte code:
    //   0: iload_1
    //   1: ifge +11 -> 12
    //   4: new 107	java/lang/IllegalArgumentException
    //   7: dup
    //   8: invokespecial 108	java/lang/IllegalArgumentException:<init>	()V
    //   11: athrow
    //   12: aload_0
    //   13: getfield 94	com/tencent/qplus/swingworker/ThreadPoolExecutor:mainLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   16: astore 5
    //   18: aload 5
    //   20: invokevirtual 135	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   23: aload_0
    //   24: getfield 113	com/tencent/qplus/swingworker/ThreadPoolExecutor:corePoolSize	I
    //   27: iload_1
    //   28: isub
    //   29: istore_2
    //   30: aload_0
    //   31: iload_1
    //   32: putfield 113	com/tencent/qplus/swingworker/ThreadPoolExecutor:corePoolSize	I
    //   35: iload_2
    //   36: ifge +67 -> 103
    //   39: aload_0
    //   40: getfield 117	com/tencent/qplus/swingworker/ThreadPoolExecutor:workQueue	Ljava/util/concurrent/BlockingQueue;
    //   43: invokeinterface 335 1 0
    //   48: istore_3
    //   49: iload_2
    //   50: ifge +19 -> 69
    //   53: iload_3
    //   54: ifle +15 -> 69
    //   57: aload_0
    //   58: getfield 137	com/tencent/qplus/swingworker/ThreadPoolExecutor:poolSize	I
    //   61: istore 4
    //   63: iload 4
    //   65: iload_1
    //   66: if_icmplt +9 -> 75
    //   69: aload 5
    //   71: invokevirtual 146	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   74: return
    //   75: aload_0
    //   76: aconst_null
    //   77: invokespecial 143	com/tencent/qplus/swingworker/ThreadPoolExecutor:addThread	(Ljava/lang/Runnable;)Ljava/lang/Thread;
    //   80: astore 6
    //   82: aload 6
    //   84: ifnull -15 -> 69
    //   87: aload 6
    //   89: invokevirtual 151	java/lang/Thread:start	()V
    //   92: iload_3
    //   93: iconst_1
    //   94: isub
    //   95: istore_3
    //   96: iload_2
    //   97: iconst_1
    //   98: iadd
    //   99: istore_2
    //   100: goto -51 -> 49
    //   103: iload_2
    //   104: ifle -35 -> 69
    //   107: aload_0
    //   108: getfield 137	com/tencent/qplus/swingworker/ThreadPoolExecutor:poolSize	I
    //   111: istore_3
    //   112: iload_3
    //   113: iload_1
    //   114: if_icmple -45 -> 69
    //   117: aload_0
    //   118: getfield 105	com/tencent/qplus/swingworker/ThreadPoolExecutor:workers	Ljava/util/HashSet;
    //   121: invokevirtual 272	java/util/HashSet:iterator	()Ljava/util/Iterator;
    //   124: astore 6
    //   126: aload 6
    //   128: invokeinterface 202 1 0
    //   133: ifeq -64 -> 69
    //   136: iload_2
    //   137: ifle -68 -> 69
    //   140: aload_0
    //   141: getfield 137	com/tencent/qplus/swingworker/ThreadPoolExecutor:poolSize	I
    //   144: iload_1
    //   145: if_icmple -76 -> 69
    //   148: aload_0
    //   149: getfield 117	com/tencent/qplus/swingworker/ThreadPoolExecutor:workQueue	Ljava/util/concurrent/BlockingQueue;
    //   152: invokeinterface 369 1 0
    //   157: ifne -88 -> 69
    //   160: aload 6
    //   162: invokeinterface 206 1 0
    //   167: checkcast 18	com/tencent/qplus/swingworker/ThreadPoolExecutor$Worker
    //   170: invokevirtual 339	com/tencent/qplus/swingworker/ThreadPoolExecutor$Worker:interruptIfIdle	()V
    //   173: iload_2
    //   174: iconst_1
    //   175: isub
    //   176: istore_2
    //   177: goto -51 -> 126
    //   180: astore 6
    //   182: aload 5
    //   184: invokevirtual 146	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   187: aload 6
    //   189: athrow
    //   190: astore 6
    //   192: goto -123 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	195	0	this	ThreadPoolExecutor
    //   0	195	1	paramInt	int
    //   29	148	2	i	int
    //   48	67	3	j	int
    //   61	6	4	k	int
    //   16	167	5	localReentrantLock	ReentrantLock
    //   80	81	6	localObject1	Object
    //   180	8	6	localObject2	Object
    //   190	1	6	localSecurityException	SecurityException
    // Exception table:
    //   from	to	target	type
    //   23	35	180	finally
    //   39	49	180	finally
    //   57	63	180	finally
    //   75	82	180	finally
    //   87	92	180	finally
    //   107	112	180	finally
    //   117	126	180	finally
    //   126	136	180	finally
    //   140	173	180	finally
    //   117	126	190	java/lang/SecurityException
    //   126	136	190	java/lang/SecurityException
    //   140	173	190	java/lang/SecurityException
  }
  
  public void setKeepAliveTime(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException();
    }
    if ((paramLong == 0L) && (allowsCoreThreadTimeOut())) {
      throw new IllegalArgumentException("Core threads must have nonzero keep alive times");
    }
    this.keepAliveTime = paramTimeUnit.toNanos(paramLong);
  }
  
  public void setMaximumPoolSize(int paramInt)
  {
    if ((paramInt <= 0) || (paramInt < this.corePoolSize)) {
      throw new IllegalArgumentException();
    }
    localReentrantLock = this.mainLock;
    localReentrantLock.lock();
    for (;;)
    {
      try
      {
        i = this.maximumPoolSize - paramInt;
        this.maximumPoolSize = paramInt;
        if (i > 0)
        {
          j = this.poolSize;
          if (j <= paramInt) {}
        }
      }
      finally
      {
        int i;
        int j;
        Iterator localIterator;
        localReentrantLock.unlock();
      }
      try
      {
        localIterator = this.workers.iterator();
        if ((localIterator.hasNext()) && (i > 0))
        {
          j = this.poolSize;
          if (j > paramInt) {
            continue;
          }
        }
      }
      catch (SecurityException localSecurityException)
      {
        continue;
      }
      localReentrantLock.unlock();
      return;
      ((Worker)localIterator.next()).interruptIfIdle();
      i -= 1;
    }
  }
  
  public void setRejectedExecutionHandler(RejectedExecutionHandler paramRejectedExecutionHandler)
  {
    if (paramRejectedExecutionHandler == null) {
      throw new NullPointerException();
    }
    this.handler = paramRejectedExecutionHandler;
  }
  
  public void setThreadFactory(ThreadFactory paramThreadFactory)
  {
    if (paramThreadFactory == null) {
      throw new NullPointerException();
    }
    this.threadFactory = paramThreadFactory;
  }
  
  /* Error */
  public void shutdown()
  {
    // Byte code:
    //   0: invokestatic 384	java/lang/System:getSecurityManager	()Ljava/lang/SecurityManager;
    //   3: astore 4
    //   5: aload 4
    //   7: ifnull +11 -> 18
    //   10: aload 4
    //   12: getstatic 67	com/tencent/qplus/swingworker/ThreadPoolExecutor:shutdownPerm	Ljava/lang/RuntimePermission;
    //   15: invokevirtual 390	java/lang/SecurityManager:checkPermission	(Ljava/security/Permission;)V
    //   18: aload_0
    //   19: getfield 94	com/tencent/qplus/swingworker/ThreadPoolExecutor:mainLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   22: astore_3
    //   23: aload_3
    //   24: invokevirtual 135	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   27: aload 4
    //   29: ifnull +22 -> 51
    //   32: aload_0
    //   33: getfield 105	com/tencent/qplus/swingworker/ThreadPoolExecutor:workers	Ljava/util/HashSet;
    //   36: invokevirtual 272	java/util/HashSet:iterator	()Ljava/util/Iterator;
    //   39: astore 5
    //   41: aload 5
    //   43: invokeinterface 202 1 0
    //   48: ifne +48 -> 96
    //   51: aload_0
    //   52: getfield 139	com/tencent/qplus/swingworker/ThreadPoolExecutor:runState	I
    //   55: istore_1
    //   56: iload_1
    //   57: iconst_1
    //   58: if_icmpge +8 -> 66
    //   61: aload_0
    //   62: iconst_1
    //   63: putfield 139	com/tencent/qplus/swingworker/ThreadPoolExecutor:runState	I
    //   66: aload_0
    //   67: getfield 105	com/tencent/qplus/swingworker/ThreadPoolExecutor:workers	Ljava/util/HashSet;
    //   70: invokevirtual 272	java/util/HashSet:iterator	()Ljava/util/Iterator;
    //   73: astore 4
    //   75: aload 4
    //   77: invokeinterface 202 1 0
    //   82: istore_2
    //   83: iload_2
    //   84: ifne +42 -> 126
    //   87: aload_0
    //   88: invokespecial 392	com/tencent/qplus/swingworker/ThreadPoolExecutor:tryTerminate	()V
    //   91: aload_3
    //   92: invokevirtual 146	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   95: return
    //   96: aload 4
    //   98: aload 5
    //   100: invokeinterface 206 1 0
    //   105: checkcast 18	com/tencent/qplus/swingworker/ThreadPoolExecutor$Worker
    //   108: getfield 170	com/tencent/qplus/swingworker/ThreadPoolExecutor$Worker:thread	Ljava/lang/Thread;
    //   111: invokevirtual 396	java/lang/SecurityManager:checkAccess	(Ljava/lang/Thread;)V
    //   114: goto -73 -> 41
    //   117: astore 4
    //   119: aload_3
    //   120: invokevirtual 146	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   123: aload 4
    //   125: athrow
    //   126: aload 4
    //   128: invokeinterface 206 1 0
    //   133: checkcast 18	com/tencent/qplus/swingworker/ThreadPoolExecutor$Worker
    //   136: invokevirtual 339	com/tencent/qplus/swingworker/ThreadPoolExecutor$Worker:interruptIfIdle	()V
    //   139: goto -64 -> 75
    //   142: astore 4
    //   144: aload_0
    //   145: iload_1
    //   146: putfield 139	com/tencent/qplus/swingworker/ThreadPoolExecutor:runState	I
    //   149: aload 4
    //   151: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	this	ThreadPoolExecutor
    //   55	91	1	i	int
    //   82	2	2	bool	boolean
    //   22	98	3	localReentrantLock	ReentrantLock
    //   3	94	4	localObject1	Object
    //   117	10	4	localObject2	Object
    //   142	8	4	localSecurityException	SecurityException
    //   39	60	5	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   32	41	117	finally
    //   41	51	117	finally
    //   51	56	117	finally
    //   61	66	117	finally
    //   66	75	117	finally
    //   75	83	117	finally
    //   87	91	117	finally
    //   96	114	117	finally
    //   126	139	117	finally
    //   144	152	117	finally
    //   66	75	142	java/lang/SecurityException
    //   75	83	142	java/lang/SecurityException
    //   126	139	142	java/lang/SecurityException
  }
  
  /* Error */
  public List<Runnable> shutdownNow()
  {
    // Byte code:
    //   0: invokestatic 384	java/lang/System:getSecurityManager	()Ljava/lang/SecurityManager;
    //   3: astore 4
    //   5: aload 4
    //   7: ifnull +11 -> 18
    //   10: aload 4
    //   12: getstatic 67	com/tencent/qplus/swingworker/ThreadPoolExecutor:shutdownPerm	Ljava/lang/RuntimePermission;
    //   15: invokevirtual 390	java/lang/SecurityManager:checkPermission	(Ljava/security/Permission;)V
    //   18: aload_0
    //   19: getfield 94	com/tencent/qplus/swingworker/ThreadPoolExecutor:mainLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   22: astore_3
    //   23: aload_3
    //   24: invokevirtual 135	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   27: aload 4
    //   29: ifnull +22 -> 51
    //   32: aload_0
    //   33: getfield 105	com/tencent/qplus/swingworker/ThreadPoolExecutor:workers	Ljava/util/HashSet;
    //   36: invokevirtual 272	java/util/HashSet:iterator	()Ljava/util/Iterator;
    //   39: astore 5
    //   41: aload 5
    //   43: invokeinterface 202 1 0
    //   48: ifne +56 -> 104
    //   51: aload_0
    //   52: getfield 139	com/tencent/qplus/swingworker/ThreadPoolExecutor:runState	I
    //   55: istore_1
    //   56: iload_1
    //   57: iconst_2
    //   58: if_icmpge +8 -> 66
    //   61: aload_0
    //   62: iconst_2
    //   63: putfield 139	com/tencent/qplus/swingworker/ThreadPoolExecutor:runState	I
    //   66: aload_0
    //   67: getfield 105	com/tencent/qplus/swingworker/ThreadPoolExecutor:workers	Ljava/util/HashSet;
    //   70: invokevirtual 272	java/util/HashSet:iterator	()Ljava/util/Iterator;
    //   73: astore 4
    //   75: aload 4
    //   77: invokeinterface 202 1 0
    //   82: istore_2
    //   83: iload_2
    //   84: ifne +50 -> 134
    //   87: aload_0
    //   88: invokespecial 399	com/tencent/qplus/swingworker/ThreadPoolExecutor:drainQueue	()Ljava/util/List;
    //   91: astore 4
    //   93: aload_0
    //   94: invokespecial 392	com/tencent/qplus/swingworker/ThreadPoolExecutor:tryTerminate	()V
    //   97: aload_3
    //   98: invokevirtual 146	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   101: aload 4
    //   103: areturn
    //   104: aload 4
    //   106: aload 5
    //   108: invokeinterface 206 1 0
    //   113: checkcast 18	com/tencent/qplus/swingworker/ThreadPoolExecutor$Worker
    //   116: getfield 170	com/tencent/qplus/swingworker/ThreadPoolExecutor$Worker:thread	Ljava/lang/Thread;
    //   119: invokevirtual 396	java/lang/SecurityManager:checkAccess	(Ljava/lang/Thread;)V
    //   122: goto -81 -> 41
    //   125: astore 4
    //   127: aload_3
    //   128: invokevirtual 146	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   131: aload 4
    //   133: athrow
    //   134: aload 4
    //   136: invokeinterface 206 1 0
    //   141: checkcast 18	com/tencent/qplus/swingworker/ThreadPoolExecutor$Worker
    //   144: invokevirtual 402	com/tencent/qplus/swingworker/ThreadPoolExecutor$Worker:interruptNow	()V
    //   147: goto -72 -> 75
    //   150: astore 4
    //   152: aload_0
    //   153: iload_1
    //   154: putfield 139	com/tencent/qplus/swingworker/ThreadPoolExecutor:runState	I
    //   157: aload 4
    //   159: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	this	ThreadPoolExecutor
    //   55	99	1	i	int
    //   82	2	2	bool	boolean
    //   22	106	3	localReentrantLock	ReentrantLock
    //   3	102	4	localObject1	Object
    //   125	10	4	localObject2	Object
    //   150	8	4	localSecurityException	SecurityException
    //   39	68	5	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   32	41	125	finally
    //   41	51	125	finally
    //   51	56	125	finally
    //   61	66	125	finally
    //   66	75	125	finally
    //   75	83	125	finally
    //   87	97	125	finally
    //   104	122	125	finally
    //   134	147	125	finally
    //   152	160	125	finally
    //   66	75	150	java/lang/SecurityException
    //   75	83	150	java/lang/SecurityException
    //   134	147	150	java/lang/SecurityException
  }
  
  protected void terminated() {}
  
  void workerDone(Worker paramWorker)
  {
    ReentrantLock localReentrantLock = this.mainLock;
    localReentrantLock.lock();
    try
    {
      this.completedTaskCount += paramWorker.completedTasks;
      this.workers.remove(paramWorker);
      int i = this.poolSize - 1;
      this.poolSize = i;
      if (i == 0) {
        tryTerminate();
      }
      return;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public static class AbortPolicy
    implements RejectedExecutionHandler
  {
    public void rejectedExecution(Runnable paramRunnable, ThreadPoolExecutor paramThreadPoolExecutor)
    {
      throw new RejectedExecutionException();
    }
  }
  
  public static class CallerRunsPolicy
    implements RejectedExecutionHandler
  {
    public void rejectedExecution(Runnable paramRunnable, ThreadPoolExecutor paramThreadPoolExecutor)
    {
      if (!paramThreadPoolExecutor.isShutdown()) {
        paramRunnable.run();
      }
    }
  }
  
  public static class DiscardOldestPolicy
    implements RejectedExecutionHandler
  {
    public void rejectedExecution(Runnable paramRunnable, ThreadPoolExecutor paramThreadPoolExecutor)
    {
      if (!paramThreadPoolExecutor.isShutdown())
      {
        paramThreadPoolExecutor.getQueue().poll();
        paramThreadPoolExecutor.execute(paramRunnable);
      }
    }
  }
  
  public static class DiscardPolicy
    implements RejectedExecutionHandler
  {
    public void rejectedExecution(Runnable paramRunnable, ThreadPoolExecutor paramThreadPoolExecutor) {}
  }
  
  final class Worker
    implements Runnable
  {
    volatile long completedTasks;
    Runnable currentTask;
    private final ReentrantLock runLock = new ReentrantLock();
    Thread thread;
    
    Worker(Runnable paramRunnable)
    {
      this.currentTask = paramRunnable;
    }
    
    /* Error */
    private void runTask(Runnable paramRunnable)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 31	com/tencent/qplus/swingworker/ThreadPoolExecutor$Worker:runLock	Ljava/util/concurrent/locks/ReentrantLock;
      //   4: astore 4
      //   6: aload 4
      //   8: invokevirtual 41	java/util/concurrent/locks/ReentrantLock:lock	()V
      //   11: aload_0
      //   12: getfield 23	com/tencent/qplus/swingworker/ThreadPoolExecutor$Worker:this$0	Lcom/tencent/qplus/swingworker/ThreadPoolExecutor;
      //   15: getfield 45	com/tencent/qplus/swingworker/ThreadPoolExecutor:runState	I
      //   18: iconst_2
      //   19: if_icmpge +27 -> 46
      //   22: invokestatic 51	java/lang/Thread:interrupted	()Z
      //   25: ifeq +21 -> 46
      //   28: aload_0
      //   29: getfield 23	com/tencent/qplus/swingworker/ThreadPoolExecutor$Worker:this$0	Lcom/tencent/qplus/swingworker/ThreadPoolExecutor;
      //   32: getfield 45	com/tencent/qplus/swingworker/ThreadPoolExecutor:runState	I
      //   35: iconst_2
      //   36: if_icmplt +10 -> 46
      //   39: aload_0
      //   40: getfield 53	com/tencent/qplus/swingworker/ThreadPoolExecutor$Worker:thread	Ljava/lang/Thread;
      //   43: invokevirtual 56	java/lang/Thread:interrupt	()V
      //   46: iconst_0
      //   47: istore_2
      //   48: aload_0
      //   49: getfield 23	com/tencent/qplus/swingworker/ThreadPoolExecutor$Worker:this$0	Lcom/tencent/qplus/swingworker/ThreadPoolExecutor;
      //   52: aload_0
      //   53: getfield 53	com/tencent/qplus/swingworker/ThreadPoolExecutor$Worker:thread	Ljava/lang/Thread;
      //   56: aload_1
      //   57: invokevirtual 60	com/tencent/qplus/swingworker/ThreadPoolExecutor:beforeExecute	(Ljava/lang/Thread;Ljava/lang/Runnable;)V
      //   60: aload_1
      //   61: invokeinterface 63 1 0
      //   66: iconst_1
      //   67: istore_3
      //   68: iload_3
      //   69: istore_2
      //   70: aload_0
      //   71: getfield 23	com/tencent/qplus/swingworker/ThreadPoolExecutor$Worker:this$0	Lcom/tencent/qplus/swingworker/ThreadPoolExecutor;
      //   74: aload_1
      //   75: aconst_null
      //   76: invokevirtual 67	com/tencent/qplus/swingworker/ThreadPoolExecutor:afterExecute	(Ljava/lang/Runnable;Ljava/lang/Throwable;)V
      //   79: iload_3
      //   80: istore_2
      //   81: aload_0
      //   82: aload_0
      //   83: getfield 69	com/tencent/qplus/swingworker/ThreadPoolExecutor$Worker:completedTasks	J
      //   86: lconst_1
      //   87: ladd
      //   88: putfield 69	com/tencent/qplus/swingworker/ThreadPoolExecutor$Worker:completedTasks	J
      //   91: aload 4
      //   93: invokevirtual 72	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   96: return
      //   97: astore 5
      //   99: iload_2
      //   100: ifne +13 -> 113
      //   103: aload_0
      //   104: getfield 23	com/tencent/qplus/swingworker/ThreadPoolExecutor$Worker:this$0	Lcom/tencent/qplus/swingworker/ThreadPoolExecutor;
      //   107: aload_1
      //   108: aload 5
      //   110: invokevirtual 67	com/tencent/qplus/swingworker/ThreadPoolExecutor:afterExecute	(Ljava/lang/Runnable;Ljava/lang/Throwable;)V
      //   113: aload 5
      //   115: athrow
      //   116: astore_1
      //   117: aload 4
      //   119: invokevirtual 72	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   122: aload_1
      //   123: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	124	0	this	Worker
      //   0	124	1	paramRunnable	Runnable
      //   47	53	2	i	int
      //   67	13	3	j	int
      //   4	114	4	localReentrantLock	ReentrantLock
      //   97	17	5	localRuntimeException	java.lang.RuntimeException
      // Exception table:
      //   from	to	target	type
      //   60	66	97	java/lang/RuntimeException
      //   70	79	97	java/lang/RuntimeException
      //   81	91	97	java/lang/RuntimeException
      //   11	46	116	finally
      //   48	60	116	finally
      //   60	66	116	finally
      //   70	79	116	finally
      //   81	91	116	finally
      //   103	113	116	finally
      //   113	116	116	finally
    }
    
    void interruptIfIdle()
    {
      ReentrantLock localReentrantLock = this.runLock;
      if (localReentrantLock.tryLock()) {}
      try
      {
        if (this.thread != Thread.currentThread()) {
          this.thread.interrupt();
        }
        return;
      }
      finally
      {
        localReentrantLock.unlock();
      }
    }
    
    void interruptNow()
    {
      this.thread.interrupt();
    }
    
    boolean isActive()
    {
      return this.runLock.isLocked();
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 33	com/tencent/qplus/swingworker/ThreadPoolExecutor$Worker:currentTask	Ljava/lang/Runnable;
      //   4: ifnonnull +25 -> 29
      //   7: aload_0
      //   8: getfield 23	com/tencent/qplus/swingworker/ThreadPoolExecutor$Worker:this$0	Lcom/tencent/qplus/swingworker/ThreadPoolExecutor;
      //   11: aload_0
      //   12: invokevirtual 89	com/tencent/qplus/swingworker/ThreadPoolExecutor:getTask	(Lcom/tencent/qplus/swingworker/ThreadPoolExecutor$Worker;)Z
      //   15: istore_1
      //   16: iload_1
      //   17: ifne +12 -> 29
      //   20: aload_0
      //   21: getfield 23	com/tencent/qplus/swingworker/ThreadPoolExecutor$Worker:this$0	Lcom/tencent/qplus/swingworker/ThreadPoolExecutor;
      //   24: aload_0
      //   25: invokevirtual 93	com/tencent/qplus/swingworker/ThreadPoolExecutor:workerDone	(Lcom/tencent/qplus/swingworker/ThreadPoolExecutor$Worker;)V
      //   28: return
      //   29: aload_0
      //   30: aload_0
      //   31: getfield 33	com/tencent/qplus/swingworker/ThreadPoolExecutor$Worker:currentTask	Ljava/lang/Runnable;
      //   34: invokespecial 95	com/tencent/qplus/swingworker/ThreadPoolExecutor$Worker:runTask	(Ljava/lang/Runnable;)V
      //   37: aload_0
      //   38: getfield 23	com/tencent/qplus/swingworker/ThreadPoolExecutor$Worker:this$0	Lcom/tencent/qplus/swingworker/ThreadPoolExecutor;
      //   41: getfield 98	com/tencent/qplus/swingworker/ThreadPoolExecutor:mainLock	Ljava/util/concurrent/locks/ReentrantLock;
      //   44: invokevirtual 41	java/util/concurrent/locks/ReentrantLock:lock	()V
      //   47: aload_0
      //   48: aconst_null
      //   49: putfield 33	com/tencent/qplus/swingworker/ThreadPoolExecutor$Worker:currentTask	Ljava/lang/Runnable;
      //   52: aload_0
      //   53: getfield 23	com/tencent/qplus/swingworker/ThreadPoolExecutor$Worker:this$0	Lcom/tencent/qplus/swingworker/ThreadPoolExecutor;
      //   56: getfield 98	com/tencent/qplus/swingworker/ThreadPoolExecutor:mainLock	Ljava/util/concurrent/locks/ReentrantLock;
      //   59: invokevirtual 72	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   62: goto -62 -> 0
      //   65: astore_2
      //   66: aload_0
      //   67: getfield 23	com/tencent/qplus/swingworker/ThreadPoolExecutor$Worker:this$0	Lcom/tencent/qplus/swingworker/ThreadPoolExecutor;
      //   70: aload_0
      //   71: invokevirtual 93	com/tencent/qplus/swingworker/ThreadPoolExecutor:workerDone	(Lcom/tencent/qplus/swingworker/ThreadPoolExecutor$Worker;)V
      //   74: aload_2
      //   75: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	76	0	this	Worker
      //   15	2	1	bool	boolean
      //   65	10	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   0	16	65	finally
      //   29	62	65	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.qplus.swingworker.ThreadPoolExecutor
 * JD-Core Version:    0.7.0.1
 */