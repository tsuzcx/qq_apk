package com.tencent.component.network.utils.thread;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class AsyncTask<Params, Progress, Result>
{
  public static final Executor SERIAL_EXECUTOR;
  public static final Executor THREAD_POOL_EXECUTOR;
  private static final ThreadFactory a = new a();
  private static final BlockingQueue<Runnable> b = new LinkedBlockingQueue(10);
  private static volatile Executor c;
  private final e<Params, Result> d = new b(this);
  private final FutureTask<Result> e = new c(this, this.d);
  private volatile Status f = Status.PENDING;
  private final AtomicBoolean g = new AtomicBoolean();
  private final AtomicBoolean h = new AtomicBoolean();
  
  static
  {
    THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(1, 128, 1L, TimeUnit.SECONDS, b, a);
    d locald = new d((byte)0);
    SERIAL_EXECUTOR = locald;
    c = locald;
  }
  
  private Result a(Result paramResult)
  {
    b.a.obtainMessage(1, new a(this, new Object[] { paramResult })).sendToTarget();
    return paramResult;
  }
  
  public static void execute(Runnable paramRunnable)
  {
    c.execute(paramRunnable);
  }
  
  public final boolean cancel(boolean paramBoolean)
  {
    this.g.set(true);
    return this.e.cancel(paramBoolean);
  }
  
  protected abstract Result doInBackground(Params... paramVarArgs);
  
  public final AsyncTask<Params, Progress, Result> execute(Params... paramVarArgs)
  {
    return executeOnExecutor(c, paramVarArgs);
  }
  
  public final AsyncTask<Params, Progress, Result> executeOnExecutor(Executor paramExecutor, Params... paramVarArgs)
  {
    if (this.f != Status.PENDING) {}
    switch (a()[this.f.ordinal()])
    {
    default: 
      this.f = Status.RUNNING;
      onPreExecute();
      this.d.a = paramVarArgs;
      paramExecutor.execute(this.e);
      return this;
    case 2: 
      throw new IllegalStateException("Cannot execute task: the task is already running.");
    }
    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
  }
  
  public final Result get()
    throws InterruptedException, ExecutionException
  {
    return this.e.get();
  }
  
  public final Result get(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException, ExecutionException, TimeoutException
  {
    return this.e.get(paramLong, paramTimeUnit);
  }
  
  public final Status getStatus()
  {
    return this.f;
  }
  
  public final boolean isCancelled()
  {
    return this.g.get();
  }
  
  protected void onCancelled() {}
  
  protected void onCancelled(Result paramResult)
  {
    onCancelled();
  }
  
  protected void onPostExecute(Result paramResult) {}
  
  protected void onPreExecute() {}
  
  protected void onProgressUpdate(Progress... paramVarArgs) {}
  
  protected final void publishProgress(Progress... paramVarArgs)
  {
    if (!isCancelled()) {
      b.a.obtainMessage(2, new a(this, paramVarArgs)).sendToTarget();
    }
  }
  
  public static enum Status {}
  
  static final class a<Data>
  {
    final AsyncTask a;
    final Data[] b;
    
    a(AsyncTask paramAsyncTask, Data... paramVarArgs)
    {
      this.a = paramAsyncTask;
      this.b = paramVarArgs;
    }
  }
  
  static final class b
  {
    static final AsyncTask.c a;
    
    static
    {
      if (Looper.getMainLooper() != null) {}
      for (Looper localLooper = Looper.getMainLooper();; localLooper = Looper.myLooper())
      {
        a = new AsyncTask.c(localLooper);
        return;
      }
    }
  }
  
  static final class c
    extends Handler
  {
    public c(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AsyncTask.a locala = (AsyncTask.a)paramMessage.obj;
      switch (paramMessage.what)
      {
      default: 
        return;
      case 1: 
        AsyncTask.a(locala.a, locala.b[0]);
        return;
      }
      locala.a.onProgressUpdate(locala.b);
    }
  }
  
  static final class d
    implements Executor
  {
    private com.tencent.component.network.utils.thread.a.a<Runnable> a = new com.tencent.component.network.utils.thread.a.a();
    private Runnable b;
    
    protected final void a()
    {
      try
      {
        Runnable localRunnable = (Runnable)this.a.poll();
        this.b = localRunnable;
        if (localRunnable != null) {
          AsyncTask.THREAD_POOL_EXECUTOR.execute(this.b);
        }
        return;
      }
      finally {}
    }
    
    public final void execute(Runnable paramRunnable)
    {
      try
      {
        this.a.offer(new d(this, paramRunnable));
        if (this.b == null) {
          a();
        }
        return;
      }
      finally
      {
        paramRunnable = finally;
        throw paramRunnable;
      }
    }
  }
  
  static abstract class e<Params, Result>
    implements Callable<Result>
  {
    Params[] a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.utils.thread.AsyncTask
 * JD-Core Version:    0.7.0.1
 */