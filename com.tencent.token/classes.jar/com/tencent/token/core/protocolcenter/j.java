package com.tencent.token.core.protocolcenter;

import com.tencent.token.ev;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

class j
  implements Runnable
{
  j(i parami, ev paramev) {}
  
  public void run()
  {
    Object localObject = null;
    switch (this.a.b)
    {
    }
    for (;;)
    {
      if (localObject != null)
      {
        localObject = f.b(this.b.a).submit((Callable)localObject);
        i.a(this.b).put(this.a, localObject);
      }
      return;
      localObject = q.a(this.a);
      continue;
      localObject = o.a(this.a);
      continue;
      localObject = c.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.j
 * JD-Core Version:    0.7.0.1
 */