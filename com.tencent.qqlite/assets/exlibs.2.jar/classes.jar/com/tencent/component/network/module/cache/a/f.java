package com.tencent.component.network.module.cache.a;

import android.content.Context;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.component.network.utils.thread.ThreadPool.Job;
import com.tencent.component.network.utils.thread.ThreadPool.JobContext;
import java.util.Collection;
import java.util.Iterator;

final class f
  implements ThreadPool.Job<Object>
{
  f(e parame, boolean paramBoolean, Context paramContext) {}
  
  public final Object run(ThreadPool.JobContext paramJobContext)
  {
    paramJobContext.setMode(1);
    paramJobContext = e.a(this.a).a();
    int i;
    int j;
    if (paramJobContext != null)
    {
      paramJobContext = paramJobContext.iterator();
      i = 0;
      j = 0;
      if (paramJobContext.hasNext()) {
        break label73;
      }
      if (i > 0) {
        break label179;
      }
    }
    label179:
    for (float f = 3.4028235E+38F;; f = j / i)
    {
      if (f < 0.1F) {
        e.a(this.a, this.c);
      }
      return null;
      label73:
      b localb = (b)paramJobContext.next();
      int k = localb.b(this.b);
      int m = localb.a(this.b);
      e locale = this.a;
      int n = e.a(k, m);
      localb.a(this.b, n);
      Const.c("downloader", "clear cache service:" + localb + ": remain=" + n);
      j += m;
      i += k;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.module.cache.a.f
 * JD-Core Version:    0.7.0.1
 */