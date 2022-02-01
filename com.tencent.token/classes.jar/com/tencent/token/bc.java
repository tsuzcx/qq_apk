package com.tencent.token;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class bc
  extends bd
{
  private final Object a = new Object();
  private ExecutorService b = Executors.newFixedThreadPool(2);
  private volatile Handler c;
  
  public final void a(Runnable paramRunnable)
  {
    this.b.execute(paramRunnable);
  }
  
  public final void b(Runnable paramRunnable)
  {
    if (this.c == null) {
      synchronized (this.a)
      {
        if (this.c == null) {
          this.c = new Handler(Looper.getMainLooper());
        }
      }
    }
    this.c.post(paramRunnable);
  }
  
  public final boolean b()
  {
    return Looper.getMainLooper().getThread() == Thread.currentThread();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.bc
 * JD-Core Version:    0.7.0.1
 */