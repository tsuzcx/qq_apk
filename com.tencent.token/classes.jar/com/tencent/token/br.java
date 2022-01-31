package com.tencent.token;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

final class br
  implements Runnable
{
  br(bq parambq, fs paramfs) {}
  
  public final void run()
  {
    Object localObject = null;
    switch (this.a.b)
    {
    }
    for (;;)
    {
      if (localObject != null)
      {
        localObject = bn.b(this.b.a).submit((Callable)localObject);
        bq.a(this.b).put(this.a, localObject);
      }
      return;
      localObject = new bz(this.a);
      continue;
      localObject = new bx(this.a);
      continue;
      localObject = bj.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.br
 * JD-Core Version:    0.7.0.1
 */