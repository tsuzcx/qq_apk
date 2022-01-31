package com.tencent.turingfd.sdk.base;

import android.content.Context;
import java.util.concurrent.atomic.AtomicReference;

public class bj
  implements Runnable
{
  public bj(bm parambm, Context paramContext, boolean paramBoolean, AtomicReference paramAtomicReference1, AtomicReference paramAtomicReference2, Object paramObject) {}
  
  public void run()
  {
    int i = 0;
    for (;;)
    {
      if (i < bm.a(this.f).d)
      {
        ??? = bm.a(this.f, this.a, this.b);
        this.c.set(???);
        if (((bg)???).d != 0) {
          break label64;
        }
      }
      synchronized (this.e)
      {
        label64:
        do
        {
          this.e.notifyAll();
          return;
        } while ((((bg)???).d == -30014) || (((Boolean)this.d.get()).booleanValue()));
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.bj
 * JD-Core Version:    0.7.0.1
 */