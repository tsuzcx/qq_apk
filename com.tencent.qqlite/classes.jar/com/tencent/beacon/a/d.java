package com.tencent.beacon.a;

import android.util.SparseArray;
import com.tencent.beacon.d.a;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public abstract class d
{
  public static boolean a = true;
  private static d b;
  
  public static d a()
  {
    try
    {
      if (b == null) {
        b = new a();
      }
      d locald = b;
      return locald;
    }
    finally {}
  }
  
  public abstract void a(int paramInt, Runnable paramRunnable, long paramLong1, long paramLong2);
  
  public abstract void a(int paramInt, boolean paramBoolean);
  
  public abstract void a(Runnable paramRunnable);
  
  public abstract void a(Runnable paramRunnable, long paramLong);
  
  static final class a
    extends d
  {
    private ScheduledExecutorService b = null;
    private SparseArray<ScheduledFuture<?>> c = null;
    private boolean d = false;
    
    public final void a(int paramInt, Runnable paramRunnable, long paramLong1, long paramLong2)
    {
      long l = 0L;
      if (paramRunnable == null) {}
      try
      {
        a.d("task runner should not be null", new Object[0]);
        return;
      }
      finally {}
      if (paramLong1 > 0L) {
        l = paramLong1;
      }
      if (a) {
        if (paramLong2 > 10000L) {
          break label129;
        }
      }
      for (;;)
      {
        a(paramInt, true);
        paramRunnable = this.b.scheduleAtFixedRate(paramRunnable, l, paramLong1, TimeUnit.MILLISECONDS);
        if (paramRunnable == null) {
          break;
        }
        a.b("add a new future! taskId: %d , periodTime: %d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong1) });
        this.c.put(paramInt, paramRunnable);
        break;
        paramLong2 = 10000L;
        break label129;
        paramLong1 = paramLong2;
        continue;
        label129:
        paramLong1 = paramLong2;
      }
    }
    
    public final void a(int paramInt, boolean paramBoolean)
    {
      try
      {
        ScheduledFuture localScheduledFuture = (ScheduledFuture)this.c.get(paramInt);
        if ((localScheduledFuture != null) && (!localScheduledFuture.isCancelled()))
        {
          a.b("cancel a old future!", new Object[0]);
          localScheduledFuture.cancel(true);
        }
        this.c.remove(paramInt);
        return;
      }
      finally {}
    }
    
    public final void a(Runnable paramRunnable)
    {
      if (paramRunnable == null) {}
      for (;;)
      {
        try
        {
          a.d("task runner should not be null", new Object[0]);
          return;
        }
        finally {}
        this.b.execute(paramRunnable);
      }
    }
    
    public final void a(Runnable paramRunnable, long paramLong)
    {
      if (paramRunnable == null) {}
      try
      {
        a.d("task runner should not be null", new Object[0]);
        return;
      }
      finally {}
      if (paramLong > 0L) {}
      for (;;)
      {
        this.b.schedule(paramRunnable, paramLong, TimeUnit.MILLISECONDS);
        break;
        paramLong = 0L;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.beacon.a.d
 * JD-Core Version:    0.7.0.1
 */