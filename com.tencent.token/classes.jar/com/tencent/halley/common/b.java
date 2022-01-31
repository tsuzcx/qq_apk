package com.tencent.halley.common;

import android.util.SparseArray;
import java.util.concurrent.ScheduledExecutorService;

final class b
  extends a
{
  private ScheduledExecutorService a = null;
  private boolean b = false;
  
  public b()
  {
    new SparseArray();
  }
  
  public final void a(Runnable paramRunnable)
  {
    if (paramRunnable == null) {}
    for (;;)
    {
      try
      {
        c.d("AsyncTaskHandlerAbs", "task runner should not be null");
        return;
      }
      finally {}
      this.a.execute(paramRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.common.b
 * JD-Core Version:    0.7.0.1
 */