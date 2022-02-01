package com.tencent.token;

import android.content.Context;
import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicReference;

public final class ady
  implements Runnable
{
  public ady(aec paramaec, Context paramContext, int paramInt) {}
  
  public final void run()
  {
    aec localaec = this.d;
    ??? = this.a;
    boolean bool2 = this.b;
    int j = this.c;
    localaec.g.getClass();
    Object localObject3 = aef.a((Context)???, "403");
    try
    {
      if (!TextUtils.isEmpty((CharSequence)localObject3))
      {
        bool1 = Boolean.valueOf((String)localObject3).booleanValue();
        break label65;
      }
    }
    finally {}
    boolean bool1 = true;
    label65:
    int i = 0;
    while (i < localaec.d.s)
    {
      localObject3 = localaec.a((Context)???, bool2, bool1, j);
      localaec.a((adt)localObject3, true);
      int k = ((adt)localObject3).d;
      if ((k == 0) || (k == -30014)) {
        break;
      }
      i += 1;
    }
    if (bool1)
    {
      localObject3 = localaec.g;
      localObject3.getClass();
      ((aef)localObject3).a((Context)???, "403", "false", true);
    }
    synchronized (localaec.j)
    {
      localaec.j.set(Boolean.FALSE);
      localaec.j.notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ady
 * JD-Core Version:    0.7.0.1
 */