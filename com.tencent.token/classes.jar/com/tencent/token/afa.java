package com.tencent.token;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.turingfd.sdk.qps.Peach;
import java.util.concurrent.atomic.AtomicReference;

public final class afa
  implements Runnable
{
  public afa(afc paramafc, Context paramContext, int paramInt) {}
  
  public final void run()
  {
    afc localafc = this.d;
    ??? = this.a;
    boolean bool2 = this.b;
    int j = this.c;
    localafc.h.getClass();
    Object localObject3 = Peach.b((Context)???, "403");
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
    while (i < localafc.e.u)
    {
      localObject3 = localafc.a((Context)???, bool2, bool1, j);
      localafc.a((aew)localObject3, true);
      int k = ((aew)localObject3).d;
      if ((k == 0) || (k == -30014)) {
        break;
      }
      i += 1;
    }
    if (bool1)
    {
      localObject3 = localafc.h;
      localObject3.getClass();
      ((Peach)localObject3).a((Context)???, "403", "false", true);
    }
    synchronized (localafc.k)
    {
      localafc.k.set(Boolean.FALSE);
      localafc.k.notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.afa
 * JD-Core Version:    0.7.0.1
 */