package com.tencent.token;

import android.util.SparseArray;
import java.util.concurrent.ScheduledExecutorService;

public abstract class lr
{
  private static lr a;
  
  public static lr a()
  {
    try
    {
      if (a == null) {
        a = new a();
      }
      lr locallr = a;
      return locallr;
    }
    finally {}
  }
  
  public abstract void a(Runnable paramRunnable);
  
  static final class a
    extends lr
  {
    private ScheduledExecutorService a = null;
    private boolean b = false;
    
    public a()
    {
      new SparseArray();
    }
    
    public final void a(Runnable paramRunnable)
    {
      try
      {
        this.a.execute(paramRunnable);
        return;
      }
      finally
      {
        paramRunnable = finally;
        throw paramRunnable;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.lr
 * JD-Core Version:    0.7.0.1
 */