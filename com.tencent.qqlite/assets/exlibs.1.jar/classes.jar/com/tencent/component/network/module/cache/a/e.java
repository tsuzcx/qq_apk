package com.tencent.component.network.module.cache.a;

import android.os.Handler;
import android.os.Looper;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.component.network.utils.thread.Future;
import com.tencent.component.network.utils.thread.PriorityThreadPool;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

public final class e
  implements b.b
{
  private static final Handler a = new Handler(Looper.getMainLooper());
  private final a b;
  private final AtomicInteger c = new AtomicInteger(0);
  private Future d;
  private long e;
  private int f;
  
  public e(a parama)
  {
    this.b = parama;
  }
  
  public final void a(b paramb, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (this.c.getAndIncrement() < 2) {
      return;
    }
    this.c.set(0);
    Const.d("downloader", "low storage: totalSize=" + paramLong1 + ", availableSize=" + paramLong2 + ", external=" + paramBoolean);
    try
    {
      if ((this.d != null) && (!this.d.isDone())) {
        return;
      }
    }
    finally {}
    paramb = paramb.a();
    this.d = PriorityThreadPool.getDefault().submit(new f(this, paramBoolean, paramb));
  }
  
  public static abstract interface a
  {
    public abstract Collection<b> a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.module.cache.a.e
 * JD-Core Version:    0.7.0.1
 */