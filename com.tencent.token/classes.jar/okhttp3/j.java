package okhttp3;

import com.tencent.token.fc;
import com.tencent.token.gc;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.internal.connection.c;
import okhttp3.internal.connection.d;
import okhttp3.internal.connection.f;
import okhttp3.internal.connection.f.a;

public final class j
{
  private static final Executor d = new ThreadPoolExecutor(0, 2147483647, 60L, TimeUnit.SECONDS, new SynchronousQueue(), fc.a("OkHttp ConnectionPool", true));
  final d a = new d();
  boolean b;
  private final int e;
  private final long f;
  private final Runnable g = new Runnable()
  {
    public void run()
    {
      for (;;)
      {
        long l1 = j.this.a(System.nanoTime());
        if (l1 == -1L) {
          return;
        }
        long l2;
        if (l1 > 0L) {
          l2 = l1 / 1000000L;
        }
        try
        {
          synchronized (j.this)
          {
            j.this.wait(l2, (int)(l1 - 1000000L * l2));
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          label65:
          break label65;
        }
      }
      throw localObject;
    }
  };
  private final Deque<c> h = new ArrayDeque();
  
  public j()
  {
    this(5, 5L, TimeUnit.MINUTES);
  }
  
  public j(int paramInt, long paramLong, TimeUnit paramTimeUnit)
  {
    this.e = paramInt;
    this.f = paramTimeUnit.toNanos(paramLong);
    if (paramLong > 0L) {
      return;
    }
    paramTimeUnit = new StringBuilder();
    paramTimeUnit.append("keepAliveDuration <= 0: ");
    paramTimeUnit.append(paramLong);
    throw new IllegalArgumentException(paramTimeUnit.toString());
  }
  
  private int a(c paramc, long paramLong)
  {
    List localList = paramc.d;
    int i = 0;
    while (i < localList.size())
    {
      Object localObject1 = (Reference)localList.get(i);
      if (((Reference)localObject1).get() != null)
      {
        i += 1;
      }
      else
      {
        localObject1 = (f.a)localObject1;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("A connection to ");
        ((StringBuilder)localObject2).append(paramc.a().a().a());
        ((StringBuilder)localObject2).append(" was leaked. Did you forget to close a response body?");
        localObject2 = ((StringBuilder)localObject2).toString();
        gc.c().a((String)localObject2, ((f.a)localObject1).a);
        localList.remove(i);
        paramc.a = true;
        if (localList.isEmpty())
        {
          paramc.e = (paramLong - this.f);
          return 0;
        }
      }
    }
    return localList.size();
  }
  
  long a(long paramLong)
  {
    try
    {
      Iterator localIterator = this.h.iterator();
      long l1 = -9223372036854775808L;
      Object localObject1 = null;
      int i = 0;
      int j = 0;
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        if (a(localc, paramLong) > 0)
        {
          j += 1;
        }
        else
        {
          int k = i + 1;
          long l2 = paramLong - localc.e;
          i = k;
          if (l2 > l1)
          {
            localObject1 = localc;
            l1 = l2;
            i = k;
          }
        }
      }
      if ((l1 < this.f) && (i <= this.e))
      {
        if (i > 0)
        {
          paramLong = this.f;
          return paramLong - l1;
        }
        if (j > 0)
        {
          paramLong = this.f;
          return paramLong;
        }
        this.b = false;
        return -1L;
      }
      this.h.remove(localObject1);
      fc.a(localObject1.b());
      return 0L;
    }
    finally {}
  }
  
  @Nullable
  Socket a(a parama, f paramf)
  {
    if ((!c) && (!Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if ((localc.a(parama, null)) && (localc.d()) && (localc != paramf.c())) {
        return paramf.a(localc);
      }
    }
    return null;
  }
  
  @Nullable
  c a(a parama, f paramf, ab paramab)
  {
    if ((!c) && (!Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if (localc.a(parama, paramab))
      {
        paramf.a(localc, true);
        return localc;
      }
    }
    return null;
  }
  
  void a(c paramc)
  {
    if ((!c) && (!Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    if (!this.b)
    {
      this.b = true;
      d.execute(this.g);
    }
    this.h.add(paramc);
  }
  
  boolean b(c paramc)
  {
    if ((!c) && (!Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    if ((!paramc.a) && (this.e != 0))
    {
      notifyAll();
      return false;
    }
    this.h.remove(paramc);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.j
 * JD-Core Version:    0.7.0.1
 */