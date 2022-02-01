package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.CancellationToken;
import java.util.ArrayList;
import java.util.List;

public final class c
  extends CancellationToken
{
  public final List<Runnable> a = new ArrayList();
  public final Object b = new Object();
  public boolean c = false;
  
  public final boolean isCancellationRequested()
  {
    return this.c;
  }
  
  public final CancellationToken register(Runnable paramRunnable)
  {
    synchronized (this.b)
    {
      if (this.c)
      {
        paramRunnable.run();
        return this;
      }
      this.a.add(paramRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hmf.tasks.a.c
 * JD-Core Version:    0.7.0.1
 */