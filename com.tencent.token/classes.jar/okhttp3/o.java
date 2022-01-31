package okhttp3;

import com.tencent.token.gn;
import com.tencent.token.ih;
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
import okhttp3.internal.connection.g;
import okhttp3.internal.connection.h;

public final class o
{
  private static final Executor d;
  final d a = new d();
  boolean b;
  private final int e;
  private final long f;
  private final Runnable g = new p(this);
  private final Deque h = new ArrayDeque();
  
  static
  {
    if (!o.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      c = bool;
      d = new ThreadPoolExecutor(0, 2147483647, 60L, TimeUnit.SECONDS, new SynchronousQueue(), gn.a("OkHttp ConnectionPool", true));
      return;
    }
  }
  
  public o()
  {
    this(5, 5L, TimeUnit.MINUTES);
  }
  
  public o(int paramInt, long paramLong, TimeUnit paramTimeUnit)
  {
    this.e = paramInt;
    this.f = paramTimeUnit.toNanos(paramLong);
    if (paramLong <= 0L) {
      throw new IllegalArgumentException("keepAliveDuration <= 0: " + paramLong);
    }
  }
  
  private int a(c paramc, long paramLong)
  {
    List localList = paramc.d;
    int i = 0;
    while (i < localList.size())
    {
      Object localObject = (Reference)localList.get(i);
      if (((Reference)localObject).get() != null)
      {
        i += 1;
      }
      else
      {
        localObject = (h)localObject;
        String str = "A connection to " + paramc.a().a().a() + " was leaked. Did you forget to close a response body?";
        ih.c().a(str, ((h)localObject).a);
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
    Object localObject1 = null;
    long l1 = -9223372036854775808L;
    for (;;)
    {
      int j;
      int i;
      try
      {
        Iterator localIterator = this.h.iterator();
        j = 0;
        i = 0;
        if (localIterator.hasNext())
        {
          c localc = (c)localIterator.next();
          if (a(localc, paramLong) > 0)
          {
            i += 1;
            continue;
          }
          long l2 = paramLong - localc.e;
          if (l2 <= l1) {
            break label184;
          }
          localObject1 = localc;
          l1 = l2;
          break label184;
        }
        if ((l1 >= this.f) || (j > this.e))
        {
          this.h.remove(localObject1);
          gn.a(localObject1.b());
          return 0L;
        }
        if (j > 0)
        {
          paramLong = this.f;
          return paramLong - l1;
        }
      }
      finally {}
      if (i > 0)
      {
        paramLong = this.f;
        return paramLong;
      }
      this.b = false;
      return -1L;
      label184:
      j += 1;
    }
  }
  
  @Nullable
  Socket a(a parama, g paramg)
  {
    if ((!c) && (!Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if ((localc.a(parama, null)) && (localc.d()) && (localc != paramg.c())) {
        return paramg.a(localc);
      }
    }
    return null;
  }
  
  @Nullable
  c a(a parama, g paramg, ax paramax)
  {
    if ((!c) && (!Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if (localc.a(parama, paramax))
      {
        paramg.a(localc, true);
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
    if ((paramc.a) || (this.e == 0))
    {
      this.h.remove(paramc);
      return true;
    }
    notifyAll();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.o
 * JD-Core Version:    0.7.0.1
 */