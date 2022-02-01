package com.huawei.hmf.tasks;

import com.huawei.hmf.tasks.a.c;
import java.util.Iterator;
import java.util.List;

public class CancellationTokenSource
{
  private c impl = new c();
  
  public void cancel()
  {
    Object localObject2 = this.impl;
    if (!((c)localObject2).c) {
      synchronized (((c)localObject2).b)
      {
        ((c)localObject2).c = true;
        localObject2 = ((c)localObject2).a.iterator();
        if (((Iterator)localObject2).hasNext()) {
          ((Runnable)((Iterator)localObject2).next()).run();
        }
      }
    }
  }
  
  public CancellationToken getToken()
  {
    return this.impl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hmf.tasks.CancellationTokenSource
 * JD-Core Version:    0.7.0.1
 */