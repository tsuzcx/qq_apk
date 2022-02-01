package com.tencent.halley.common;

import android.util.SparseArray;
import java.util.concurrent.ScheduledExecutorService;

public abstract class a
{
  private static a a;
  
  public static a a()
  {
    try
    {
      if (a == null) {
        a = new a();
      }
      a locala = a;
      return locala;
    }
    finally {}
  }
  
  public abstract void a(Runnable paramRunnable);
  
  static final class a
    extends a
  {
    private ScheduledExecutorService a = null;
    private boolean b = false;
    
    public a()
    {
      new SparseArray();
    }
    
    public final void a(Runnable paramRunnable)
    {
      if (paramRunnable == null) {}
      try
      {
        b.d("AsyncTaskHandlerAbs", "task runner should not be null");
        return;
      }
      finally {}
      this.a.execute(paramRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.common.a
 * JD-Core Version:    0.7.0.1
 */