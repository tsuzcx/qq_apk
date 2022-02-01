package com.tencent.token.global.taiji;

import android.os.Debug;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class c
  implements b.a, i
{
  private static long n;
  private static long o;
  protected CustomPriorityBlockingQueue<Runnable> a = new CustomPriorityBlockingQueue(5);
  protected LinkedList<a> b = new LinkedList();
  protected ArrayList<a> c = new ArrayList();
  protected HashMap<a, Thread> d = new HashMap();
  protected b e = null;
  private ReentrantReadWriteLock f = new ReentrantReadWriteLock();
  private ArrayList<i.b> g = new ArrayList();
  private ArrayList<i.a> h = new ArrayList();
  private ReentrantReadWriteLock i = new ReentrantReadWriteLock();
  private int j = f();
  private boolean k = false;
  private HandlerThread l;
  private b m;
  private volatile boolean p = false;
  private g q;
  private i.a r = null;
  
  public c()
  {
    this.e.a(this);
    this.l = new HandlerThread("TMS_THREAD_POOL_HANDLER");
    this.l.start();
    this.m = new b(this.l.getLooper());
    b(2000L);
  }
  
  private void a(boolean paramBoolean)
  {
    if ((paramBoolean) || (this.e.getCorePoolSize() < this.j))
    {
      this.e.setCorePoolSize(this.j);
      this.e.setMaximumPoolSize(this.j);
    }
  }
  
  private int f()
  {
    int i2 = Runtime.getRuntime().availableProcessors();
    int i1 = i2;
    if (i2 < 4) {
      i1 = 4;
    }
    return i1;
  }
  
  private void g()
  {
    this.i.writeLock().lock();
    for (;;)
    {
      try
      {
        if (!this.b.isEmpty())
        {
          Iterator localIterator = this.b.iterator();
          if ((localIterator != null) && (localIterator.hasNext()))
          {
            a locala = (a)localIterator.next();
            localIterator.remove();
            if (!this.b.isEmpty()) {
              this.m.sendEmptyMessage(1);
            }
            this.i.writeLock().unlock();
            if (locala != null)
            {
              if (this.e.getActiveCount() + 4 <= this.j) {
                a(true);
              }
              this.e.execute(locala);
              localIterator = b().iterator();
              if (localIterator.hasNext())
              {
                ((i.a)localIterator.next()).a(locala.a(), this.e.getActiveCount());
                continue;
              }
            }
            return;
          }
        }
      }
      finally
      {
        this.i.writeLock().unlock();
      }
      Object localObject2 = null;
    }
  }
  
  private boolean h()
  {
    return this.p;
  }
  
  private void i()
  {
    if (this.q == null) {
      this.q = new g();
    }
  }
  
  private void j() {}
  
  public HandlerThread a(String paramString, int paramInt, long paramLong)
  {
    j();
    return e.a(paramString, paramInt, paramLong);
  }
  
  public ArrayList<i.b> a()
  {
    ArrayList localArrayList = new ArrayList();
    this.f.readLock().lock();
    try
    {
      localArrayList.addAll(this.g);
      return localArrayList;
    }
    finally
    {
      this.f.readLock().unlock();
    }
  }
  
  public void a(int paramInt, Runnable paramRunnable, String paramString, long paramLong)
  {
    a(paramInt, paramRunnable, paramString, paramLong, false, null);
  }
  
  public void a(int paramInt, Runnable paramRunnable, String paramString, long paramLong, Object paramObject)
  {
    a(paramInt, paramRunnable, paramString, paramLong, true, paramObject);
  }
  
  public void a(int paramInt, Runnable paramRunnable, String paramString, long paramLong, boolean paramBoolean, Object paramObject)
  {
    this.i.writeLock().lock();
    try
    {
      paramRunnable = new a(paramInt, paramRunnable, paramString, paramLong, paramBoolean, paramObject);
      this.b.add(paramRunnable);
      this.c.add(paramRunnable);
      this.m.sendEmptyMessage(1);
      return;
    }
    finally
    {
      this.i.writeLock().unlock();
    }
  }
  
  public void a(Object paramObject)
  {
    b(paramObject);
  }
  
  public void a(Runnable paramRunnable, String paramString, long paramLong)
  {
    a(paramRunnable, paramString, paramLong, false, null);
  }
  
  public void a(Runnable paramRunnable, String paramString, long paramLong, Object paramObject)
  {
    a(paramRunnable, paramString, paramLong, true, paramObject);
  }
  
  public void a(Runnable paramRunnable, String paramString, long paramLong, boolean paramBoolean, Object paramObject)
  {
    a(5, paramRunnable, paramString, paramLong, paramBoolean, paramObject);
  }
  
  public void a(final Runnable paramRunnable, Throwable paramThrowable)
  {
    this.i.writeLock().lock();
    try
    {
      paramRunnable = (a)paramRunnable;
      paramThrowable = this.d.keySet().iterator();
      while ((paramThrowable != null) && (paramThrowable.hasNext()))
      {
        a locala = (a)paramThrowable.next();
        if ((locala != null) && (locala.equals(paramRunnable)))
        {
          paramThrowable.remove();
          i1 = 1;
          break label79;
        }
      }
      int i1 = 0;
      label79:
      this.i.writeLock().unlock();
      if (i1 != 0)
      {
        long l1 = System.currentTimeMillis();
        long l2 = paramRunnable.a().f;
        paramRunnable.a().f = (l1 - l2);
        l1 = Debug.threadCpuTimeNanos();
        l2 = paramRunnable.a().g;
        paramRunnable.a().g = (l1 - l2);
        this.m.post(new Runnable()
        {
          public void run()
          {
            c.a(c.this).writeLock().lock();
            try
            {
              Iterator localIterator = c.b(c.this).iterator();
              while (localIterator.hasNext()) {
                ((i.a)localIterator.next()).b(paramRunnable.a());
              }
              c.a(c.this).writeLock().unlock();
              if (c.this.e.getActiveCount() + 4 <= c.c(c.this)) {
                c.a(c.this, true);
              }
              return;
            }
            finally
            {
              c.a(c.this).writeLock().unlock();
            }
          }
        });
      }
      return;
    }
    finally
    {
      this.i.writeLock().unlock();
    }
  }
  
  /* Error */
  public void a(Thread paramThread, final Runnable paramRunnable)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 77	com/tencent/token/global/taiji/c:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   4: invokevirtual 195	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   7: invokevirtual 200	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   10: aload_0
    //   11: getfield 91	com/tencent/token/global/taiji/c:c	Ljava/util/ArrayList;
    //   14: invokevirtual 237	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   17: astore 7
    //   19: iconst_0
    //   20: istore 4
    //   22: aload 7
    //   24: ifnull +64 -> 88
    //   27: aload_2
    //   28: checkcast 18	com/tencent/token/global/taiji/c$a
    //   31: astore 6
    //   33: iload 4
    //   35: istore_3
    //   36: aload 6
    //   38: astore_2
    //   39: aload 7
    //   41: invokeinterface 212 1 0
    //   46: ifeq +47 -> 93
    //   49: aload 7
    //   51: invokeinterface 216 1 0
    //   56: checkcast 18	com/tencent/token/global/taiji/c$a
    //   59: astore_2
    //   60: aload_2
    //   61: ifnull -28 -> 33
    //   64: aload_2
    //   65: aload 6
    //   67: invokevirtual 303	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   70: ifeq -37 -> 33
    //   73: aload 7
    //   75: invokeinterface 219 1 0
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
    //   94: getfield 77	com/tencent/token/global/taiji/c:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   97: invokevirtual 195	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   100: invokevirtual 226	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   103: iload_3
    //   104: ifne +4 -> 108
    //   107: return
    //   108: aload_2
    //   109: invokevirtual 242	com/tencent/token/global/taiji/c$a:a	()Lcom/tencent/token/global/taiji/i$c;
    //   112: invokestatic 308	java/lang/System:currentTimeMillis	()J
    //   115: putfield 312	com/tencent/token/global/taiji/i$c:f	J
    //   118: aload_2
    //   119: invokevirtual 242	com/tencent/token/global/taiji/c$a:a	()Lcom/tencent/token/global/taiji/i$c;
    //   122: invokestatic 317	android/os/Debug:threadCpuTimeNanos	()J
    //   125: putfield 319	com/tencent/token/global/taiji/i$c:g	J
    //   128: aload_0
    //   129: getfield 77	com/tencent/token/global/taiji/c:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   132: invokevirtual 195	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   135: invokevirtual 200	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   138: aload_0
    //   139: getfield 96	com/tencent/token/global/taiji/c:d	Ljava/util/HashMap;
    //   142: aload_2
    //   143: aload_1
    //   144: invokevirtual 331	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   147: pop
    //   148: aload_0
    //   149: getfield 77	com/tencent/token/global/taiji/c:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   152: invokevirtual 195	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   155: invokevirtual 226	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   158: aload_2
    //   159: invokevirtual 242	com/tencent/token/global/taiji/c$a:a	()Lcom/tencent/token/global/taiji/i$c;
    //   162: getfield 333	com/tencent/token/global/taiji/i$c:d	I
    //   165: istore 4
    //   167: iload 4
    //   169: iconst_1
    //   170: if_icmpge +8 -> 178
    //   173: iconst_1
    //   174: istore_3
    //   175: goto +16 -> 191
    //   178: iload 4
    //   180: istore_3
    //   181: iload 4
    //   183: bipush 10
    //   185: if_icmple +6 -> 191
    //   188: bipush 10
    //   190: istore_3
    //   191: aload_1
    //   192: iload_3
    //   193: invokevirtual 338	java/lang/Thread:setPriority	(I)V
    //   196: aload_1
    //   197: aload_2
    //   198: invokevirtual 242	com/tencent/token/global/taiji/c$a:a	()Lcom/tencent/token/global/taiji/i$c;
    //   201: getfield 341	com/tencent/token/global/taiji/i$c:c	Ljava/lang/String;
    //   204: invokevirtual 344	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   207: aload_2
    //   208: invokevirtual 242	com/tencent/token/global/taiji/c$a:a	()Lcom/tencent/token/global/taiji/i$c;
    //   211: aload_1
    //   212: invokevirtual 347	java/lang/Thread:getId	()J
    //   215: putfield 349	com/tencent/token/global/taiji/i$c:k	J
    //   218: aload_0
    //   219: getfield 100	com/tencent/token/global/taiji/c:k	Z
    //   222: istore 5
    //   224: aload_0
    //   225: getfield 149	com/tencent/token/global/taiji/c:m	Lcom/tencent/token/global/taiji/c$b;
    //   228: new 10	com/tencent/token/global/taiji/c$1
    //   231: dup
    //   232: aload_0
    //   233: iload 5
    //   235: aload_2
    //   236: invokespecial 352	com/tencent/token/global/taiji/c$1:<init>	(Lcom/tencent/token/global/taiji/c;ZLcom/tencent/token/global/taiji/c$a;)V
    //   239: invokevirtual 326	com/tencent/token/global/taiji/c$b:post	(Ljava/lang/Runnable;)Z
    //   242: pop
    //   243: aload_0
    //   244: iconst_1
    //   245: putfield 100	com/tencent/token/global/taiji/c:k	Z
    //   248: return
    //   249: astore_1
    //   250: aload_0
    //   251: getfield 77	com/tencent/token/global/taiji/c:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   254: invokevirtual 195	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   257: invokevirtual 226	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   260: aload_1
    //   261: athrow
    //   262: astore_1
    //   263: aload_0
    //   264: getfield 77	com/tencent/token/global/taiji/c:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   267: invokevirtual 195	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   270: invokevirtual 226	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   273: aload_1
    //   274: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	275	0	this	c
    //   0	275	1	paramThread	Thread
    //   0	275	2	paramRunnable	Runnable
    //   35	158	3	i1	int
    //   20	166	4	i2	int
    //   222	12	5	bool	boolean
    //   31	52	6	locala	a
    //   17	57	7	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   138	148	249	finally
    //   10	19	262	finally
    //   27	33	262	finally
    //   39	60	262	finally
    //   64	80	262	finally
  }
  
  public boolean a(long paramLong)
  {
    this.i.readLock().lock();
    try
    {
      Iterator localIterator = this.d.keySet().iterator();
      boolean bool1 = false;
      boolean bool2 = false;
      a locala;
      if (localIterator != null) {
        for (;;)
        {
          bool1 = bool2;
          if (!localIterator.hasNext()) {
            break;
          }
          locala = (a)localIterator.next();
          if ((locala.a() != null) && (paramLong == locala.a().b)) {
            bool2 = true;
          }
        }
      }
      bool2 = bool1;
      if (!bool1)
      {
        localIterator = this.c.iterator();
        bool2 = bool1;
        if (localIterator != null) {
          for (;;)
          {
            bool2 = bool1;
            if (!localIterator.hasNext()) {
              break;
            }
            locala = (a)localIterator.next();
            if (locala.a() != null)
            {
              long l1 = locala.a().b;
              if (paramLong == l1) {
                bool1 = true;
              }
            }
          }
        }
      }
      return bool2;
    }
    finally
    {
      this.i.readLock().unlock();
    }
  }
  
  public boolean a(Runnable paramRunnable)
  {
    boolean bool2 = false;
    if (paramRunnable == null) {
      return false;
    }
    this.i.writeLock().lock();
    try
    {
      Iterator localIterator = this.c.iterator();
      boolean bool1 = bool2;
      if (localIterator != null)
      {
        a locala;
        do
        {
          bool1 = bool2;
          if (!localIterator.hasNext()) {
            break;
          }
          locala = (a)localIterator.next();
        } while ((locala == null) || (locala.a() == null) || (!paramRunnable.equals(locala.a().i)));
        localIterator.remove();
        this.e.remove(locala);
        bool1 = true;
      }
      return bool1;
    }
    finally
    {
      this.i.writeLock().unlock();
    }
  }
  
  public ArrayList<i.a> b()
  {
    ArrayList localArrayList = new ArrayList();
    this.f.readLock().lock();
    try
    {
      localArrayList.addAll(this.h);
      return localArrayList;
    }
    finally
    {
      this.f.readLock().unlock();
    }
  }
  
  public void b(long paramLong)
  {
    this.i.writeLock().lock();
    try
    {
      this.p = true;
      o = System.currentTimeMillis();
      n = paramLong;
      return;
    }
    finally
    {
      this.i.writeLock().unlock();
    }
  }
  
  public void b(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    this.i.writeLock().lock();
    try
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if ((locala != null) && (locala.a().h) && (paramObject.equals(locala.a().j))) {
          localIterator.remove();
        }
      }
      return;
    }
    finally
    {
      this.i.writeLock().unlock();
    }
  }
  
  public void b(Runnable paramRunnable)
  {
    Thread localThread = f(paramRunnable);
    if (localThread != null)
    {
      localThread.interrupt();
      return;
    }
    a(paramRunnable);
  }
  
  public void b(Runnable paramRunnable, String paramString, long paramLong)
  {
    b(paramRunnable, paramString, paramLong, false, null);
  }
  
  public void b(Runnable paramRunnable, String paramString, long paramLong, Object paramObject)
  {
    b(paramRunnable, paramString, paramLong, true, paramObject);
  }
  
  public void b(final Runnable paramRunnable, String paramString, long paramLong, boolean paramBoolean, Object paramObject)
  {
    paramRunnable = new a(2147483647, paramRunnable, paramString, paramLong, paramBoolean, paramObject);
    this.i.writeLock().lock();
    try
    {
      this.c.add(paramRunnable);
      this.i.writeLock().unlock();
      this.m.post(new Runnable()
      {
        public void run()
        {
          c.this.e.execute(paramRunnable);
          if ((c.this.e.getActiveCount() >= c.c(c.this)) && (c.this.e.getCorePoolSize() < 18))
          {
            c.this.e.setCorePoolSize(c.this.e.getCorePoolSize() + 1);
            c.this.e.setMaximumPoolSize(c.this.e.getCorePoolSize() + 1);
          }
          else
          {
            c.a(c.this, false);
          }
          Iterator localIterator = c.this.b().iterator();
          while (localIterator.hasNext()) {
            ((i.a)localIterator.next()).a(paramRunnable.a(), c.this.e.getActiveCount());
          }
        }
      });
      return;
    }
    finally
    {
      this.i.writeLock().unlock();
    }
  }
  
  public Looper c(long paramLong)
  {
    j();
    return e.a(paramLong);
  }
  
  public void c()
  {
    this.i.writeLock().lock();
    try
    {
      this.p = false;
      o = 0L;
      n = 0L;
      return;
    }
    finally
    {
      this.i.writeLock().unlock();
    }
  }
  
  public void c(Runnable paramRunnable, String paramString, long paramLong)
  {
    c(paramRunnable, paramString, paramLong, false, null);
  }
  
  public void c(final Runnable paramRunnable, String paramString, long paramLong, boolean paramBoolean, Object paramObject)
  {
    paramRunnable = new a(2147483647, paramRunnable, paramString, paramLong, paramBoolean, paramObject);
    this.i.writeLock().lock();
    try
    {
      this.c.add(paramRunnable);
      this.i.writeLock().unlock();
      this.m.post(new Runnable()
      {
        public void run()
        {
          if (c.this.e.getCorePoolSize() < 18)
          {
            c.this.e.execute(paramRunnable);
            c.this.e.setCorePoolSize(c.this.e.getCorePoolSize() + 1);
            c.this.e.setMaximumPoolSize(c.this.e.getCorePoolSize() + 1);
          }
          else
          {
            c.a.b(paramRunnable).d = 5;
            c.this.e.execute(paramRunnable);
          }
          Iterator localIterator = c.this.b().iterator();
          while (localIterator.hasNext()) {
            ((i.a)localIterator.next()).a(paramRunnable.a(), c.this.e.getActiveCount());
          }
        }
      });
      return;
    }
    finally
    {
      this.i.writeLock().unlock();
    }
  }
  
  public boolean c(Runnable paramRunnable)
  {
    return f(paramRunnable) != null;
  }
  
  public Thread d(Runnable paramRunnable, String paramString, long paramLong)
  {
    i();
    return this.q.a(paramRunnable, paramString, paramLong);
  }
  
  public boolean d(Runnable paramRunnable)
  {
    this.i.readLock().lock();
    try
    {
      Iterator localIterator = this.c.iterator();
      if (localIterator != null) {
        while (localIterator.hasNext())
        {
          a locala = (a)localIterator.next();
          if ((locala != null) && (locala.a() != null))
          {
            bool = paramRunnable.equals(locala.a().i);
            if (bool)
            {
              bool = true;
              break label79;
            }
          }
        }
      }
      boolean bool = false;
      label79:
      return bool;
    }
    finally
    {
      this.i.readLock().unlock();
    }
  }
  
  public boolean e(Runnable paramRunnable)
  {
    this.i.readLock().lock();
    try
    {
      if (!c(paramRunnable))
      {
        bool = d(paramRunnable);
        if (!bool)
        {
          bool = false;
          break label38;
        }
      }
      boolean bool = true;
      label38:
      return bool;
    }
    finally
    {
      this.i.readLock().unlock();
    }
  }
  
  public Thread f(Runnable paramRunnable)
  {
    Object localObject2 = null;
    if (paramRunnable == null) {
      return null;
    }
    this.i.readLock().lock();
    for (;;)
    {
      try
      {
        Iterator localIterator = this.d.keySet().iterator();
        Object localObject1 = localObject2;
        if (localIterator != null)
        {
          if (!localIterator.hasNext()) {
            break label133;
          }
          localObject1 = (a)localIterator.next();
          if ((localObject1 == null) || (((a)localObject1).a() == null) || (!paramRunnable.equals(((a)localObject1).a().i))) {
            continue;
          }
          paramRunnable = (Runnable)localObject1;
          localObject1 = localObject2;
          if (paramRunnable != null) {
            localObject1 = (Thread)this.d.get(paramRunnable);
          }
        }
        return localObject1;
      }
      finally
      {
        this.i.readLock().unlock();
      }
      label133:
      paramRunnable = null;
    }
  }
  
  class a
    implements Comparable<a>, Runnable
  {
    private i.c b = new i.c();
    
    public a(int paramInt, Runnable paramRunnable, String paramString, long paramLong, boolean paramBoolean, Object paramObject)
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
      paramString = this.b;
      paramString.a = 1;
      paramString.d = paramInt;
      paramString.c = c.this;
      paramString.b = paramLong;
      paramString.i = paramRunnable;
      paramString.h = paramBoolean;
      paramString.j = paramObject;
      paramString.e = System.currentTimeMillis();
    }
    
    public int a(a parama)
    {
      int k = (int)(Math.abs(System.currentTimeMillis() - this.b.e) / 200L);
      int j = this.b.d;
      int i = j;
      if (k > 0) {
        i = j + k;
      }
      return parama.b.d - i;
    }
    
    public i.c a()
    {
      return this.b;
    }
    
    public void run()
    {
      i.c localc = this.b;
      if ((localc != null) && (localc.i != null)) {
        this.b.i.run();
      }
    }
  }
  
  class b
    extends Handler
  {
    public b(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      if (paramMessage.what != 1) {
        return;
      }
      removeMessages(paramMessage.what);
      if (c.d(c.this))
      {
        long l = System.currentTimeMillis();
        if ((c.d() > 0L) && (Math.abs(c.e() - l) > c.d())) {
          c.this.c();
        }
        sendEmptyMessageDelayed(1, 1000L);
        return;
      }
      c.e(c.this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.global.taiji.c
 * JD-Core Version:    0.7.0.1
 */