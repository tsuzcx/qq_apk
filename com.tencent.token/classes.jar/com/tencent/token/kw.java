package com.tencent.token;

import android.util.SparseArray;
import java.util.concurrent.ScheduledExecutorService;

public abstract class kw
{
  private static kw a;
  
  public static kw a()
  {
    try
    {
      if (a == null) {
        a = new a();
      }
      kw localkw = a;
      return localkw;
    }
    finally {}
  }
  
  public abstract void a(Runnable paramRunnable);
  
  static final class a
    extends kw
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
 * Qualified Name:     com.tencent.token.kw
 * JD-Core Version:    0.7.0.1
 */