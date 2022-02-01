package com.tencent.token;

import android.os.Debug;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.token.global.taiji.CustomPriorityBlockingQueue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public final class xh
  implements xg.a, xj
{
  static long g;
  static long h;
  ReentrantReadWriteLock a = new ReentrantReadWriteLock();
  protected CustomPriorityBlockingQueue<Runnable> b = new CustomPriorityBlockingQueue();
  protected LinkedList<a> c = new LinkedList();
  protected ArrayList<a> d = new ArrayList();
  protected HashMap<a, Thread> e = new HashMap();
  protected xg f = null;
  volatile boolean i = false;
  private ReentrantReadWriteLock j = new ReentrantReadWriteLock();
  private ArrayList<Object> k = new ArrayList();
  private ArrayList<xj.a> l = new ArrayList();
  private int m;
  private boolean n = false;
  private HandlerThread o;
  private b p;
  private xj.a q = null;
  
  public xh()
  {
    int i2 = Runtime.getRuntime().availableProcessors();
    int i1 = i2;
    if (i2 < 4) {
      i1 = 4;
    }
    this.m = i1;
    this.f = new xg(this.m + 2, TimeUnit.SECONDS, this.b, new ThreadPoolExecutor.CallerRunsPolicy());
    this.f.a = this;
    this.o = new HandlerThread("TMS_THREAD_POOL_HANDLER");
    this.o.start();
    this.p = new b(this.o.getLooper());
    this.a.writeLock().lock();
    try
    {
      this.i = true;
      h = System.currentTimeMillis();
      g = 2000L;
      return;
    }
    finally
    {
      this.a.writeLock().unlock();
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if ((paramBoolean) || (this.f.getCorePoolSize() < this.m))
    {
      this.f.setCorePoolSize(this.m);
      this.f.setMaximumPoolSize(this.m);
    }
  }
  
  public final ArrayList<Object> a()
  {
    ArrayList localArrayList = new ArrayList();
    this.j.readLock().lock();
    try
    {
      localArrayList.addAll(this.k);
      return localArrayList;
    }
    finally
    {
      this.j.readLock().unlock();
    }
  }
  
  public final void a(final Runnable paramRunnable)
  {
    this.a.writeLock().lock();
    try
    {
      paramRunnable = (a)paramRunnable;
      Iterator localIterator = this.e.keySet().iterator();
      while ((localIterator != null) && (localIterator.hasNext()))
      {
        a locala = (a)localIterator.next();
        if ((locala != null) && (locala.equals(paramRunnable)))
        {
          localIterator.remove();
          i1 = 1;
          break label84;
        }
      }
      int i1 = 0;
      label84:
      this.a.writeLock().unlock();
      if (i1 != 0)
      {
        long l1 = System.currentTimeMillis();
        long l2 = paramRunnable.a.f;
        paramRunnable.a.f = (l1 - l2);
        l1 = Debug.threadCpuTimeNanos();
        l2 = paramRunnable.a.g;
        paramRunnable.a.g = (l1 - l2);
        this.p.post(new Runnable()
        {
          public final void run()
          {
            xh.a(xh.this).writeLock().lock();
            try
            {
              Iterator localIterator = xh.b(xh.this).iterator();
              while (localIterator.hasNext()) {
                localIterator.next();
              }
              xh.a(xh.this).writeLock().unlock();
              if (xh.this.f.getActiveCount() + 4 <= xh.c(xh.this)) {
                xh.a(xh.this, true);
              }
              return;
            }
            finally
            {
              xh.a(xh.this).writeLock().unlock();
            }
          }
        });
      }
      return;
    }
    finally
    {
      this.a.writeLock().unlock();
    }
  }
  
  public final void a(Runnable paramRunnable, String paramString)
  {
    this.a.writeLock().lock();
    try
    {
      paramRunnable = new a(5, paramRunnable, paramString);
      this.c.add(paramRunnable);
      this.d.add(paramRunnable);
      this.p.sendEmptyMessage(1);
      return;
    }
    finally
    {
      this.a.writeLock().unlock();
    }
  }
  
  /* Error */
  public final void a(Thread paramThread, final Runnable paramRunnable)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 73	com/tencent/token/xh:a	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   4: invokevirtual 152	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   7: invokevirtual 157	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   10: aload_0
    //   11: getfield 85	com/tencent/token/xh:d	Ljava/util/ArrayList;
    //   14: invokevirtual 226	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   17: astore 7
    //   19: iconst_0
    //   20: istore 4
    //   22: aload 7
    //   24: ifnull +64 -> 88
    //   27: aload_2
    //   28: checkcast 16	com/tencent/token/xh$a
    //   31: astore 6
    //   33: iload 4
    //   35: istore_3
    //   36: aload 6
    //   38: astore_2
    //   39: aload 7
    //   41: invokeinterface 204 1 0
    //   46: ifeq +47 -> 93
    //   49: aload 7
    //   51: invokeinterface 208 1 0
    //   56: checkcast 16	com/tencent/token/xh$a
    //   59: astore_2
    //   60: aload_2
    //   61: ifnull -28 -> 33
    //   64: aload_2
    //   65: aload 6
    //   67: invokevirtual 251	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   70: ifeq -37 -> 33
    //   73: aload 7
    //   75: invokeinterface 211 1 0
    //   80: iconst_1
    //   81: istore_3
    //   82: aload 6
    //   84: astore_2
    //   85: goto +8 -> 93
    //   88: aconst_null
    //   89: astore_2
    //   90: iload 4
    //   92: istore_3
    //   93: aload_0
    //   94: getfield 73	com/tencent/token/xh:a	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   97: invokevirtual 152	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   100: invokevirtual 172	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   103: iload_3
    //   104: ifne +4 -> 108
    //   107: return
    //   108: aload_2
    //   109: getfield 254	com/tencent/token/xh$a:a	Lcom/tencent/token/xj$b;
    //   112: invokestatic 163	java/lang/System:currentTimeMillis	()J
    //   115: putfield 258	com/tencent/token/xj$b:f	J
    //   118: aload_2
    //   119: getfield 254	com/tencent/token/xh$a:a	Lcom/tencent/token/xj$b;
    //   122: invokestatic 263	android/os/Debug:threadCpuTimeNanos	()J
    //   125: putfield 264	com/tencent/token/xj$b:g	J
    //   128: aload_0
    //   129: getfield 73	com/tencent/token/xh:a	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   132: invokevirtual 152	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   135: invokevirtual 157	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   138: aload_0
    //   139: getfield 90	com/tencent/token/xh:e	Ljava/util/HashMap;
    //   142: aload_2
    //   143: aload_1
    //   144: invokevirtual 284	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   147: pop
    //   148: aload_0
    //   149: getfield 73	com/tencent/token/xh:a	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   152: invokevirtual 152	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   155: invokevirtual 172	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   158: aload_2
    //   159: getfield 254	com/tencent/token/xh$a:a	Lcom/tencent/token/xj$b;
    //   162: getfield 286	com/tencent/token/xj$b:d	I
    //   165: istore 4
    //   167: iload 4
    //   169: ifgt +8 -> 177
    //   172: iconst_1
    //   173: istore_3
    //   174: goto +16 -> 190
    //   177: iload 4
    //   179: istore_3
    //   180: iload 4
    //   182: bipush 10
    //   184: if_icmple +6 -> 190
    //   187: bipush 10
    //   189: istore_3
    //   190: aload_1
    //   191: iload_3
    //   192: invokevirtual 291	java/lang/Thread:setPriority	(I)V
    //   195: aload_1
    //   196: aload_2
    //   197: getfield 254	com/tencent/token/xh$a:a	Lcom/tencent/token/xj$b;
    //   200: getfield 294	com/tencent/token/xj$b:c	Ljava/lang/String;
    //   203: invokevirtual 297	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   206: aload_2
    //   207: getfield 254	com/tencent/token/xh$a:a	Lcom/tencent/token/xj$b;
    //   210: aload_1
    //   211: invokevirtual 300	java/lang/Thread:getId	()J
    //   214: putfield 302	com/tencent/token/xj$b:k	J
    //   217: aload_0
    //   218: getfield 94	com/tencent/token/xh:n	Z
    //   221: istore 5
    //   223: aload_0
    //   224: getfield 148	com/tencent/token/xh:p	Lcom/tencent/token/xh$b;
    //   227: new 10	com/tencent/token/xh$1
    //   230: dup
    //   231: aload_0
    //   232: iload 5
    //   234: aload_2
    //   235: invokespecial 305	com/tencent/token/xh$1:<init>	(Lcom/tencent/token/xh;ZLcom/tencent/token/xh$a;)V
    //   238: invokevirtual 271	com/tencent/token/xh$b:post	(Ljava/lang/Runnable;)Z
    //   241: pop
    //   242: aload_0
    //   243: iconst_1
    //   244: putfield 94	com/tencent/token/xh:n	Z
    //   247: return
    //   248: astore_1
    //   249: aload_0
    //   250: getfield 73	com/tencent/token/xh:a	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   253: invokevirtual 152	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   256: invokevirtual 172	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   259: aload_1
    //   260: athrow
    //   261: astore_1
    //   262: aload_0
    //   263: getfield 73	com/tencent/token/xh:a	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   266: invokevirtual 152	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   269: invokevirtual 172	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   272: aload_1
    //   273: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	274	0	this	xh
    //   0	274	1	paramThread	Thread
    //   0	274	2	paramRunnable	Runnable
    //   35	157	3	i1	int
    //   20	165	4	i2	int
    //   221	12	5	bool	boolean
    //   31	52	6	locala	a
    //   17	57	7	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   138	148	248	finally
    //   10	19	261	finally
    //   27	33	261	finally
    //   39	60	261	finally
    //   64	80	261	finally
  }
  
  public final ArrayList<xj.a> b()
  {
    ArrayList localArrayList = new ArrayList();
    this.j.readLock().lock();
    try
    {
      localArrayList.addAll(this.l);
      return localArrayList;
    }
    finally
    {
      this.j.readLock().unlock();
    }
  }
  
  public final void b(final Runnable paramRunnable, String paramString)
  {
    paramRunnable = new a(2147483647, paramRunnable, paramString);
    this.a.writeLock().lock();
    try
    {
      this.d.add(paramRunnable);
      this.a.writeLock().unlock();
      this.p.post(new Runnable()
      {
        public final void run()
        {
          xh.this.f.execute(paramRunnable);
          if ((xh.this.f.getActiveCount() >= xh.c(xh.this)) && (xh.this.f.getCorePoolSize() < 18))
          {
            xh.this.f.setCorePoolSize(xh.this.f.getCorePoolSize() + 1);
            xh.this.f.setMaximumPoolSize(xh.this.f.getCorePoolSize() + 1);
          }
          else
          {
            xh.a(xh.this, false);
          }
          Iterator localIterator = xh.this.b().iterator();
          while (localIterator.hasNext())
          {
            localIterator.next();
            xh.this.f.getActiveCount();
          }
        }
      });
      return;
    }
    finally
    {
      this.a.writeLock().unlock();
    }
  }
  
  final class a
    implements Comparable<a>, Runnable
  {
    xj.b a = new xj.b();
    
    public a(int paramInt, Runnable paramRunnable, String paramString)
    {
      if (paramString != null)
      {
        this$1 = paramString;
        if (paramString.length() != 0) {}
      }
      else
      {
        this$1 = paramRunnable.getClass().getName();
      }
      paramString = this.a;
      paramString.a = 1;
      paramString.d = paramInt;
      paramString.c = xh.this;
      paramString.b = 0L;
      paramString.i = paramRunnable;
      paramString.h = false;
      paramString.j = null;
      paramString.e = System.currentTimeMillis();
    }
    
    public final void run()
    {
      xj.b localb = this.a;
      if ((localb != null) && (localb.i != null)) {
        this.a.i.run();
      }
    }
  }
  
  final class b
    extends Handler
  {
    public b(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      if (paramMessage.what != 1) {
        return;
      }
      removeMessages(paramMessage.what);
      if (xh.d(xh.this))
      {
        long l = System.currentTimeMillis();
        if ((xh.c() > 0L) && (Math.abs(xh.d() - l) > xh.c()))
        {
          paramMessage = xh.this;
          paramMessage.a.writeLock().lock();
        }
        try
        {
          paramMessage.i = false;
          xh.h = 0L;
          xh.g = 0L;
          paramMessage.a.writeLock().unlock();
        }
        finally
        {
          paramMessage.a.writeLock().unlock();
        }
        return;
      }
      xh.e(xh.this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.xh
 * JD-Core Version:    0.7.0.1
 */