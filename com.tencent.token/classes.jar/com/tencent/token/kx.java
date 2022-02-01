package com.tencent.token;

import android.util.SparseArray;
import java.util.concurrent.ScheduledExecutorService;

public abstract class kx
{
  private static kx a;
  
  public static kx a()
  {
    try
    {
      if (a == null) {
        a = new a();
      }
      kx localkx = a;
      return localkx;
    }
    finally {}
  }
  
  public abstract void a(Runnable paramRunnable);
  
  static final class a
    extends kx
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
 * Qualified Name:     com.tencent.token.kx
 * JD-Core Version:    0.7.0.1
 */