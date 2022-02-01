package com.tencent.map.lib.thread;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.map.sdk.a.jk;
import com.tencent.map.sdk.a.jl;
import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class AsyncTask<Params, Progress, Result>
{
  private static final b a = new b(Looper.getMainLooper());
  public static final Executor sHighThreadExecutor;
  public static final Executor sHightSerialExecutor;
  public static final Executor sLowSerialExecutor;
  public static final Executor sLowThreadExecutor = new jl();
  private final e<Params, Result> b = new AsyncTask.1(this);
  private final FutureTask<Result> c = new AsyncTask.2(this, this.b);
  private volatile d d = d.a;
  private final AtomicBoolean e = new AtomicBoolean();
  private final AtomicBoolean f = new AtomicBoolean();
  private boolean g = true;
  
  static
  {
    sHighThreadExecutor = new jk();
    sLowSerialExecutor = new c((byte)0);
    sHightSerialExecutor = new c((byte)0);
  }
  
  private Result a(Result paramResult)
  {
    Message localMessage = a.obtainMessage(1, new a(this, new Object[] { paramResult }));
    if (this.g)
    {
      localMessage.sendToTarget();
      return paramResult;
    }
    a.sendMessageAtFrontOfQueue(localMessage);
    return paramResult;
  }
  
  public static void execute(Runnable paramRunnable)
  {
    sLowThreadExecutor.execute(paramRunnable);
  }
  
  public static void init()
  {
    a.getLooper();
  }
  
  public final boolean cancel(boolean paramBoolean)
  {
    this.e.set(true);
    return this.c.cancel(paramBoolean);
  }
  
  protected abstract Result doInBackground(Params... paramVarArgs);
  
  public final AsyncTask<Params, Progress, Result> execute(boolean paramBoolean, Params... paramVarArgs)
  {
    this.g = paramBoolean;
    if (this.g) {
      return executeOnExecutor(sLowThreadExecutor, paramVarArgs);
    }
    return executeOnExecutor(sHighThreadExecutor, paramVarArgs);
  }
  
  public final AsyncTask<Params, Progress, Result> execute(Params... paramVarArgs)
  {
    return execute(true, paramVarArgs);
  }
  
  public final void execute(long paramLong, Params... paramVarArgs)
  {
    new Handler(Looper.getMainLooper()).postDelayed(new AsyncTask.3(this, paramVarArgs), paramLong);
  }
  
  public final AsyncTask<Params, Progress, Result> executeOnExecutor(Executor paramExecutor, Params... paramVarArgs)
  {
    if (this.d != d.a) {}
    switch (AsyncTask.4.a[this.d.ordinal()])
    {
    default: 
      this.d = d.b;
      onPreExecute();
      this.b.b = paramVarArgs;
      paramExecutor.execute(this.c);
      return this;
    case 1: 
      throw new IllegalStateException("Cannot execute task: the task is already running.");
    }
    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
  }
  
  public final Result get()
    throws InterruptedException, ExecutionException
  {
    return this.c.get();
  }
  
  public final Result get(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException, ExecutionException, TimeoutException
  {
    return this.c.get(paramLong, paramTimeUnit);
  }
  
  public final d getStatus()
  {
    return this.d;
  }
  
  public final boolean isCancelled()
  {
    return this.e.get();
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
      a.obtainMessage(2, new a(this, paramVarArgs)).sendToTarget();
    }
  }
  
  static final class a<Data>
  {
    final AsyncTask<?, ?, ?> a;
    final Data[] b;
    
    a(AsyncTask<?, ?, ?> paramAsyncTask, Data... paramVarArgs)
    {
      this.a = paramAsyncTask;
      this.b = paramVarArgs;
    }
  }
  
  static final class b
    extends Handler
  {
    public b(Looper paramLooper)
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
        AsyncTask.c(locala.a, locala.b[0]);
        return;
      }
      locala.a.onProgressUpdate(locala.b);
    }
  }
  
  static final class c
    implements Executor
  {
    final LinkedList<Runnable> a = new LinkedList();
    Runnable b;
    
    protected final void a()
    {
      try
      {
        Runnable localRunnable = (Runnable)this.a.poll();
        this.b = localRunnable;
        if (localRunnable != null) {
          AsyncTask.sHighThreadExecutor.execute(this.b);
        }
        return;
      }
      finally {}
    }
    
    public final void execute(Runnable paramRunnable)
    {
      try
      {
        this.a.offer(new AsyncTask.c.1(this, paramRunnable));
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
  
  public static enum d
  {
    private d() {}
  }
  
  static abstract class e<Params, Result>
    implements Callable<Result>
  {
    Params[] b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.lib.thread.AsyncTask
 * JD-Core Version:    0.7.0.1
 */