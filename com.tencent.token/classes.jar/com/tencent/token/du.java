package com.tencent.token;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public final class du
{
  final Object a = new Object();
  HandlerThread b;
  Handler c;
  final int d;
  private int e;
  private Handler.Callback f = new Handler.Callback()
  {
    public final boolean handleMessage(Message arg1)
    {
      switch (???.what)
      {
      default: 
        return true;
      case 1: 
        du localdu1 = du.this;
        ((Runnable)???.obj).run();
        synchronized (localdu1.a)
        {
          localdu1.c.removeMessages(0);
          localdu1.c.sendMessageDelayed(localdu1.c.obtainMessage(0), localdu1.d);
          return true;
        }
      }
      du localdu2 = du.this;
      synchronized (localdu2.a)
      {
        if (localdu2.c.hasMessages(1)) {
          return true;
        }
        localdu2.b.quit();
        localdu2.b = null;
        localdu2.c = null;
        return true;
      }
    }
  };
  private final int g;
  private final String h;
  
  public du(String paramString)
  {
    this.h = paramString;
    this.g = 10;
    this.d = 10000;
    this.e = 0;
  }
  
  public final <T> T a(final Callable<T> paramCallable, int paramInt)
  {
    localReentrantLock = new ReentrantLock();
    final Condition localCondition = localReentrantLock.newCondition();
    final AtomicReference localAtomicReference = new AtomicReference();
    final AtomicBoolean localAtomicBoolean = new AtomicBoolean(true);
    a(new Runnable()
    {
      public final void run()
      {
        try
        {
          localAtomicReference.set(paramCallable.call());
          label16:
          localReentrantLock.lock();
          try
          {
            localAtomicBoolean.set(false);
            localCondition.signal();
            return;
          }
          finally
          {
            localReentrantLock.unlock();
          }
        }
        catch (Exception localException)
        {
          break label16;
        }
      }
    });
    localReentrantLock.lock();
    label104:
    do
    {
      try
      {
        if (!localAtomicBoolean.get())
        {
          paramCallable = localAtomicReference.get();
          return paramCallable;
        }
        l1 = TimeUnit.MILLISECONDS.toNanos(paramInt);
      }
      finally
      {
        long l1;
        long l2;
        localReentrantLock.unlock();
      }
      try
      {
        l2 = localCondition.awaitNanos(l1);
        l1 = l2;
      }
      catch (InterruptedException paramCallable)
      {
        break label104;
      }
      if (!localAtomicBoolean.get())
      {
        paramCallable = localAtomicReference.get();
        localReentrantLock.unlock();
        return paramCallable;
      }
    } while (l1 > 0L);
    throw new InterruptedException("timeout");
  }
  
  final void a(Runnable paramRunnable)
  {
    synchronized (this.a)
    {
      if (this.b == null)
      {
        this.b = new HandlerThread(this.h, this.g);
        this.b.start();
        this.c = new Handler(this.b.getLooper(), this.f);
        this.e += 1;
      }
      this.c.removeMessages(0);
      this.c.sendMessage(this.c.obtainMessage(1, paramRunnable));
      return;
    }
  }
  
  public static abstract interface a<T>
  {
    public abstract void a(T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.du
 * JD-Core Version:    0.7.0.1
 */