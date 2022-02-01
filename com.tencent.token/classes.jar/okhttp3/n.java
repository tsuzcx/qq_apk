package okhttp3;

import com.tencent.token.fc;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public final class n
{
  private int a = 64;
  private int b = 5;
  @Nullable
  private Runnable c;
  @Nullable
  private ExecutorService d;
  private final Deque<w.a> e = new ArrayDeque();
  private final Deque<w.a> f = new ArrayDeque();
  private final Deque<w> g = new ArrayDeque();
  
  private <T> void a(Deque<T> paramDeque, T paramT, boolean paramBoolean)
  {
    try
    {
      if (!paramDeque.remove(paramT)) {
        throw new AssertionError("Call wasn't in-flight!");
      }
    }
    finally {}
    if (paramBoolean) {
      c();
    }
    int i = b();
    paramDeque = this.c;
    if ((i == 0) && (paramDeque != null)) {
      paramDeque.run();
    }
  }
  
  private int c(w.a parama)
  {
    Iterator localIterator = this.f.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      w.a locala = (w.a)localIterator.next();
      if (!locala.b().d)
      {
        if (!locala.a().equals(parama.a())) {
          break label67;
        }
        i += 1;
      }
    }
    label67:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  private void c()
  {
    if (this.f.size() >= this.a) {}
    do
    {
      Iterator localIterator;
      do
      {
        return;
        while (this.e.isEmpty()) {}
        localIterator = this.e.iterator();
      } while (!localIterator.hasNext());
      w.a locala = (w.a)localIterator.next();
      if (c(locala) < this.b)
      {
        localIterator.remove();
        this.f.add(locala);
        a().execute(locala);
      }
    } while (this.f.size() < this.a);
  }
  
  public ExecutorService a()
  {
    try
    {
      if (this.d == null) {
        this.d = new ThreadPoolExecutor(0, 2147483647, 60L, TimeUnit.SECONDS, new SynchronousQueue(), fc.a("OkHttp Dispatcher", false));
      }
      ExecutorService localExecutorService = this.d;
      return localExecutorService;
    }
    finally {}
  }
  
  /* Error */
  void a(w.a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 33	okhttp3/n:f	Ljava/util/Deque;
    //   6: invokeinterface 100 1 0
    //   11: aload_0
    //   12: getfield 24	okhttp3/n:a	I
    //   15: if_icmpge +39 -> 54
    //   18: aload_0
    //   19: aload_1
    //   20: invokespecial 105	okhttp3/n:c	(Lokhttp3/w$a;)I
    //   23: aload_0
    //   24: getfield 26	okhttp3/n:b	I
    //   27: if_icmpge +27 -> 54
    //   30: aload_0
    //   31: getfield 33	okhttp3/n:f	Ljava/util/Deque;
    //   34: aload_1
    //   35: invokeinterface 110 2 0
    //   40: pop
    //   41: aload_0
    //   42: invokevirtual 113	okhttp3/n:a	()Ljava/util/concurrent/ExecutorService;
    //   45: aload_1
    //   46: invokeinterface 119 2 0
    //   51: aload_0
    //   52: monitorexit
    //   53: return
    //   54: aload_0
    //   55: getfield 31	okhttp3/n:e	Ljava/util/Deque;
    //   58: aload_1
    //   59: invokeinterface 110 2 0
    //   64: pop
    //   65: goto -14 -> 51
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	n
    //   0	73	1	parama	w.a
    // Exception table:
    //   from	to	target	type
    //   2	51	68	finally
    //   54	65	68	finally
  }
  
  public int b()
  {
    try
    {
      int i = this.f.size();
      int j = this.g.size();
      return i + j;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void b(w.a parama)
  {
    a(this.f, parama, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.n
 * JD-Core Version:    0.7.0.1
 */