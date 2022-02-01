package com.tencent.map.sdk.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class ol
{
  private static ScheduledExecutorService a = Executors.newScheduledThreadPool(10);
  private static ExecutorService b = new ThreadPoolExecutor(1, 2147483647, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
  private static final b c = new b("dispatch_default");
  private static final Handler d = new Handler(Looper.getMainLooper());
  
  static
  {
    os.b("DispatchUtil");
  }
  
  public static <T> b a(e<T> parame)
  {
    os.a("DispatchUtil").a();
    c.a(parame);
    return c;
  }
  
  public static abstract class a<T>
    implements ft<T>, Runnable
  {
    public abstract void a(T paramT);
    
    public void run() {}
  }
  
  public static final class b
    extends HandlerThread
  {
    private boolean a;
    private boolean b;
    private Handler c;
    private ConcurrentLinkedQueue<ol.e> d = new ConcurrentLinkedQueue();
    private Set<a> e = new HashSet();
    private Set<a> f = new HashSet();
    
    public b(String paramString)
    {
      super();
    }
    
    public final <T> a<T> a(ol.c<T> paramc)
    {
      ol.e locale = (ol.e)this.d.poll();
      if (locale == null) {
        return null;
      }
      os.a locala = os.a("DispatchUtil");
      new StringBuilder("dispatchHandler:").append(this.c).toString();
      locala.a();
      paramc = new a(this.c, paramc, locale);
      paramc.a(new b(paramc));
      if (this.c == null) {
        this.f.add(paramc);
      }
      return paramc;
    }
    
    final void a(ol.e parame)
    {
      try
      {
        os.a locala = os.a("DispatchUtil");
        new StringBuilder("prepared:").append(this.a).toString();
        locala.a();
        if ((!this.a) && (!this.b))
        {
          start();
          this.b = true;
        }
        this.d.add(parame);
        return;
      }
      finally {}
    }
    
    protected final void onLooperPrepared()
    {
      super.onLooperPrepared();
      this.a = true;
      this.c = new ol.b.1(this, getLooper());
      os.a("DispatchUtil").a();
      if (!this.f.isEmpty())
      {
        os.a("DispatchUtil").a();
        Iterator localIterator = this.f.iterator();
        while (localIterator.hasNext())
        {
          a locala = (a)localIterator.next();
          locala.g = this.c;
          os.a locala1 = os.a("DispatchUtil");
          new StringBuilder("to active:").append(locala.j).toString();
          locala1.a();
          if (!locala.j) {
            locala.b(locala.d);
          }
        }
        this.f.clear();
      }
    }
    
    public final class a<T>
    {
      boolean a;
      ol.c<T> b;
      ol.e<T> c;
      ol.a<T> d;
      Future<T> e;
      T f;
      Handler g;
      Handler h;
      Message i;
      boolean j;
      int k = 0;
      private ol.a<T> m;
      
      a(ol.c<T> paramc, ol.e<T> parame)
      {
        this.g = paramc;
        this.b = parame;
        Object localObject;
        this.c = localObject;
      }
      
      public final void a()
      {
        if (this.g == null)
        {
          this.j = false;
          os.a("DispatchUtil").a();
          return;
        }
        this.j = true;
        Object localObject = Message.obtain();
        ((Message)localObject).obj = this;
        this.g.sendMessageDelayed((Message)localObject, this.k);
        localObject = os.a("DispatchUtil");
        new StringBuilder("delay:").append(this.k).toString();
        ((os.a)localObject).a();
      }
      
      final void a(Message paramMessage, Handler paramHandler, long paramLong)
      {
        os.a locala = os.a("DispatchUtil");
        new StringBuilder("count:").append(ol.b.a(ol.b.this).size()).toString();
        "msg:".concat(String.valueOf(paramMessage));
        locala.a();
        if ((this.m != null) && (paramHandler != null) && (paramMessage != null))
        {
          this.g = paramHandler;
          this.i = Message.obtain(this.g, this.m);
          this.i.copyFrom(paramMessage);
          this.g.sendMessageDelayed(this.i, paramLong);
        }
      }
      
      final void a(ol.a<T> parama)
      {
        this.m = parama;
        ol.e.a(this.c, this.m);
      }
      
      final void a(T paramT)
      {
        os.a locala = os.a("DispatchUtil");
        new StringBuilder("count:").append(ol.b.a(ol.b.this).size()).toString();
        "result:".concat(String.valueOf(paramT));
        new StringBuilder("userCallback:").append(this.d).toString();
        locala.a();
        this.f = paramT;
        if (this.g != null) {
          this.g.removeCallbacks(this.m);
        }
        if (this.d != null) {
          this.d.a(this.f);
        }
        ol.b.a(ol.b.this).remove(this);
      }
      
      public final void b(ol.a<T> parama)
      {
        this.d = parama;
        a();
      }
    }
    
    final class b<T>
      extends ol.a<T>
    {
      ol.b.a<T> a;
      
      b()
      {
        Object localObject;
        this.a = localObject;
      }
      
      public final void a(T paramT)
      {
        if (Thread.currentThread() != this.a.g.getLooper().getThread())
        {
          os.a("DispatchUtil").a();
          this.a.f = paramT;
          this.a.a(this.a.i, this.a.g, this.a.k);
          return;
        }
        os.a("DispatchUtil").a();
        this.a.a(paramT);
      }
      
      public final void run()
      {
        if ((this.a.e != null) && (!this.a.a))
        {
          if (this.a.e.isDone())
          {
            os.a locala = os.a("DispatchUtil");
            new StringBuilder("future:").append(this.a.e).toString();
            locala.a();
            try
            {
              if (this.a.f != null)
              {
                a(this.a.f);
                return;
              }
              a(this.a.e.get());
              return;
            }
            catch (ExecutionException localExecutionException)
            {
              Log.wtf("DispatchUtil", localExecutionException);
              return;
            }
            catch (InterruptedException localInterruptedException)
            {
              Log.wtf("DispatchUtil", localInterruptedException);
              Thread.currentThread().interrupt();
              return;
            }
          }
          if (this.a.e.isCancelled())
          {
            os.a("DispatchUtil").a();
            this.a.g.removeCallbacks(this);
            return;
          }
          os.a("DispatchUtil").a();
          this.a.a(this.a.i, this.a.g, this.a.k);
        }
      }
    }
  }
  
  public static abstract interface c<T>
  {
    public abstract Future<T> a(ol.e<T> parame);
  }
  
  public static final class d<T>
    implements ol.c<T>
  {
    T a;
    
    public d(T paramT)
    {
      this.a = paramT;
    }
    
    public final Future<T> a(ol.e<T> parame)
    {
      return ol.b().submit(parame, this.a);
    }
  }
  
  public static abstract class e<T>
    implements Runnable, Callable<T>
  {
    private ol.a<T> a;
    
    public final void run()
    {
      try
      {
        Object localObject = call();
        if (this.a != null) {
          this.a.a(localObject);
        }
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.ol
 * JD-Core Version:    0.7.0.1
 */