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
      if (paramDeque.remove(paramT))
      {
        if (paramBoolean) {
          c();
        }
        int i = b();
        paramDeque = this.c;
        if ((i == 0) && (paramDeque != null)) {
          paramDeque.run();
        }
        return;
      }
      throw new AssertionError("Call wasn't in-flight!");
    }
    finally {}
  }
  
  private int c(w.a parama)
  {
    Iterator localIterator = this.f.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      w.a locala = (w.a)localIterator.next();
      if ((!locala.b().d) && (locala.a().equals(parama.a()))) {
        i += 1;
      }
    }
    return i;
  }
  
  private void c()
  {
    if (this.f.size() >= this.a) {
      return;
    }
    if (this.e.isEmpty()) {
      return;
    }
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      w.a locala = (w.a)localIterator.next();
      if (c(locala) < this.b)
      {
        localIterator.remove();
        this.f.add(locala);
        a().execute(locala);
      }
      if (this.f.size() >= this.a) {}
    }
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
  
  void a(w.a parama)
  {
    try
    {
      if ((this.f.size() < this.a) && (c(parama) < this.b))
      {
        this.f.add(parama);
        a().execute(parama);
      }
      else
      {
        this.e.add(parama);
      }
      return;
    }
    finally {}
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