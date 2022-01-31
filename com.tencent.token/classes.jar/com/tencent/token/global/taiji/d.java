package com.tencent.token.global.taiji;

import android.os.Debug;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class d
  implements c, q
{
  private static long n = 0L;
  private static long o = 0L;
  protected CustomPriorityBlockingQueue a = new CustomPriorityBlockingQueue(5);
  protected LinkedList b = new LinkedList();
  protected ArrayList c = new ArrayList();
  protected HashMap d = new HashMap();
  protected b e = null;
  private ReentrantReadWriteLock f = new ReentrantReadWriteLock();
  private ArrayList g = new ArrayList();
  private ArrayList h = new ArrayList();
  private ReentrantReadWriteLock i = new ReentrantReadWriteLock();
  private int j = f();
  private boolean k = false;
  private HandlerThread l;
  private j m;
  private volatile boolean p = false;
  private o q;
  private r r = null;
  
  public d()
  {
    this.e.a(this);
    this.l = new HandlerThread("TMS_THREAD_POOL_HANDLER");
    this.l.start();
    this.m = new j(this, this.l.getLooper());
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
    int i1 = Runtime.getRuntime().availableProcessors();
    if (i1 < 4) {
      return 4;
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
            i locali = (i)localIterator.next();
            localIterator.remove();
            if (!this.b.isEmpty()) {
              this.m.sendEmptyMessage(1);
            }
            this.i.writeLock().unlock();
            if (locali != null)
            {
              if (this.e.getActiveCount() + 4 <= this.j) {
                a(true);
              }
              this.e.execute(locali);
              localIterator = b().iterator();
              if (localIterator.hasNext())
              {
                ((r)localIterator.next()).a(locali.a(), this.e.getActiveCount());
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
      this.q = new o();
    }
  }
  
  private void j() {}
  
  public HandlerThread a(String paramString, int paramInt, long paramLong)
  {
    j();
    return l.a(paramString, paramInt, paramLong);
  }
  
  public ArrayList a()
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
      paramRunnable = new i(this, paramInt, paramRunnable, paramString, paramLong, paramBoolean, paramObject);
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
  
  public void a(Runnable paramRunnable, Throwable paramThrowable)
  {
    this.i.writeLock().lock();
    for (;;)
    {
      try
      {
        paramRunnable = (i)paramRunnable;
        paramThrowable = this.d.keySet().iterator();
        if ((paramThrowable != null) && (paramThrowable.hasNext()))
        {
          i locali = (i)paramThrowable.next();
          if ((locali == null) || (!locali.equals(paramRunnable))) {
            continue;
          }
          paramThrowable.remove();
          i1 = 1;
          this.i.writeLock().unlock();
          if (i1 != 0)
          {
            long l1 = System.currentTimeMillis();
            long l2 = paramRunnable.a().f;
            paramRunnable.a().f = (l1 - l2);
            l1 = Debug.threadCpuTimeNanos();
            l2 = paramRunnable.a().g;
            paramRunnable.a().g = (l1 - l2);
            this.m.post(new f(this, paramRunnable));
          }
          return;
        }
      }
      finally
      {
        this.i.writeLock().unlock();
      }
      int i1 = 0;
    }
  }
  
  public void a(Thread paramThread, Runnable paramRunnable)
  {
    this.i.writeLock().lock();
    for (;;)
    {
      try
      {
        Iterator localIterator = this.c.iterator();
        if (localIterator == null) {
          break label261;
        }
        paramRunnable = (i)paramRunnable;
        if (!localIterator.hasNext()) {
          break label256;
        }
        i locali = (i)localIterator.next();
        if ((locali == null) || (!locali.equals(paramRunnable))) {
          continue;
        }
        localIterator.remove();
        i1 = 1;
        this.i.writeLock().unlock();
        if (i1 == 0) {
          return;
        }
      }
      finally
      {
        this.i.writeLock().unlock();
      }
      paramRunnable.a().f = System.currentTimeMillis();
      paramRunnable.a().g = Debug.threadCpuTimeNanos();
      this.i.writeLock().lock();
      for (;;)
      {
        int i2;
        try
        {
          this.d.put(paramRunnable, paramThread);
          this.i.writeLock().unlock();
          i2 = paramRunnable.a().d;
          if (i2 < 1)
          {
            i1 = 1;
            paramThread.setPriority(i1);
            paramThread.setName(paramRunnable.a().c);
            paramRunnable.a().k = paramThread.getId();
            boolean bool = this.k;
            this.m.post(new e(this, bool, paramRunnable));
            this.k = true;
            return;
          }
        }
        finally
        {
          this.i.writeLock().unlock();
        }
        i1 = i2;
        if (i2 > 10) {
          i1 = 10;
        }
      }
      label256:
      int i1 = 0;
      continue;
      label261:
      paramRunnable = null;
      i1 = 0;
    }
  }
  
  public boolean a(long paramLong)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    this.i.readLock().lock();
    for (;;)
    {
      try
      {
        Iterator localIterator = this.d.keySet().iterator();
        i locali;
        if (localIterator != null)
        {
          bool1 = bool2;
          if (localIterator.hasNext())
          {
            locali = (i)localIterator.next();
            if ((locali.a() == null) || (paramLong != locali.a().b)) {
              break label201;
            }
            bool1 = true;
            break label205;
          }
        }
        bool2 = bool1;
        if (!bool1)
        {
          localIterator = this.c.iterator();
          bool2 = bool1;
          if (localIterator != null)
          {
            bool2 = bool1;
            if (localIterator.hasNext())
            {
              locali = (i)localIterator.next();
              if (locali.a() == null) {
                break label198;
              }
              long l1 = locali.a().b;
              if (paramLong != l1) {
                break label198;
              }
              bool1 = true;
              continue;
            }
          }
        }
        return bool2;
      }
      finally
      {
        this.i.readLock().unlock();
      }
      label198:
      continue;
      label201:
      bool1 = bool2;
      label205:
      bool2 = bool1;
    }
  }
  
  public boolean a(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return false;
    }
    this.i.writeLock().lock();
    for (;;)
    {
      try
      {
        Iterator localIterator = this.c.iterator();
        if ((localIterator != null) && (localIterator.hasNext()))
        {
          i locali = (i)localIterator.next();
          if ((locali == null) || (locali.a() == null) || (!paramRunnable.equals(locali.a().i))) {
            continue;
          }
          localIterator.remove();
          this.e.remove(locali);
          bool = true;
          return bool;
        }
      }
      finally
      {
        this.i.writeLock().unlock();
      }
      boolean bool = false;
    }
  }
  
  public ArrayList b()
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
        i locali = (i)localIterator.next();
        if ((locali != null) && (locali.a().h) && (paramObject.equals(locali.a().j))) {
          localIterator.remove();
        }
      }
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
  
  public void b(Runnable paramRunnable, String paramString, long paramLong, boolean paramBoolean, Object paramObject)
  {
    paramRunnable = new i(this, 2147483647, paramRunnable, paramString, paramLong, paramBoolean, paramObject);
    this.i.writeLock().lock();
    try
    {
      this.c.add(paramRunnable);
      this.i.writeLock().unlock();
      this.m.post(new g(this, paramRunnable));
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
    return l.a(paramLong);
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
  
  public void c(Runnable paramRunnable, String paramString, long paramLong, boolean paramBoolean, Object paramObject)
  {
    paramRunnable = new i(this, 2147483647, paramRunnable, paramString, paramLong, paramBoolean, paramObject);
    this.i.writeLock().lock();
    try
    {
      this.c.add(paramRunnable);
      this.i.writeLock().unlock();
      this.m.post(new h(this, paramRunnable));
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
    for (;;)
    {
      try
      {
        Iterator localIterator = this.c.iterator();
        if (localIterator != null) {
          if (localIterator.hasNext())
          {
            i locali = (i)localIterator.next();
            if ((locali == null) || (locali.a() == null)) {
              continue;
            }
            bool = paramRunnable.equals(locali.a().i);
            if (!bool) {
              continue;
            }
            bool = true;
            return bool;
          }
        }
      }
      finally
      {
        this.i.readLock().unlock();
      }
      boolean bool = false;
    }
  }
  
  public boolean e(Runnable paramRunnable)
  {
    boolean bool1 = false;
    this.i.readLock().lock();
    try
    {
      if (!c(paramRunnable))
      {
        boolean bool2 = d(paramRunnable);
        if (!bool2) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
    finally
    {
      this.i.readLock().unlock();
    }
  }
  
  public Thread f(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return null;
    }
    this.i.readLock().lock();
    for (;;)
    {
      try
      {
        Iterator localIterator = this.d.keySet().iterator();
        if (localIterator != null)
        {
          if (!localIterator.hasNext()) {
            break label125;
          }
          i locali = (i)localIterator.next();
          if ((locali == null) || (locali.a() == null) || (!paramRunnable.equals(locali.a().i))) {
            continue;
          }
          paramRunnable = locali;
          if (paramRunnable != null)
          {
            paramRunnable = (Thread)this.d.get(paramRunnable);
            return paramRunnable;
          }
        }
      }
      finally
      {
        this.i.readLock().unlock();
      }
      paramRunnable = null;
      continue;
      label125:
      paramRunnable = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.global.taiji.d
 * JD-Core Version:    0.7.0.1
 */