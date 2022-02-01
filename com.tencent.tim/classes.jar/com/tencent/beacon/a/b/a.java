package com.tencent.beacon.a.b;

import android.os.Handler;
import android.support.annotation.NonNull;
import java.util.concurrent.ScheduledExecutorService;

public abstract class a
{
  protected static volatile a a;
  
  public static a a()
  {
    try
    {
      if (a == null) {
        a = new f();
      }
      a locala = a;
      return locala;
    }
    finally {}
  }
  
  public static void a(@NonNull ScheduledExecutorService paramScheduledExecutorService)
  {
    try
    {
      if (a == null) {
        a = new f(paramScheduledExecutorService);
      }
      return;
    }
    finally
    {
      paramScheduledExecutorService = finally;
      throw paramScheduledExecutorService;
    }
  }
  
  public static a b()
  {
    return a.a;
  }
  
  public abstract Handler a(int paramInt);
  
  public abstract void a(int paramInt, long paramLong1, long paramLong2, @NonNull Runnable paramRunnable);
  
  public abstract void a(int paramInt, boolean paramBoolean);
  
  public abstract void a(long paramLong, @NonNull Runnable paramRunnable);
  
  public abstract void a(@NonNull Runnable paramRunnable);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void b(int paramInt);
  
  public abstract void c();
  
  static class a
  {
    static final a a = new f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.a.b.a
 * JD-Core Version:    0.7.0.1
 */