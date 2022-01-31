package com.tencent.turingfd.sdk.base;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class bb
  extends Handler
{
  public bb(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {}
    do
    {
      return;
      paramMessage = paramMessage.obj;
    } while ((paramMessage == null) || (!(paramMessage instanceof bc)));
    bc localbc = (bc)paramMessage;
    Iterator localIterator = ba.c.iterator();
    while (localIterator.hasNext())
    {
      at localat = (at)localIterator.next();
      if (localat.e.equals(localbc.m))
      {
        if (localbc.g <= 0)
        {
          bool = true;
          label89:
          localat.f = bool;
          if (Build.VERSION.SDK_INT >= 14) {
            if (localbc.h != 0) {
              break label226;
            }
          }
        }
        label226:
        for (boolean bool = true;; bool = false)
        {
          localat.g = bool;
          switch (localbc.f)
          {
          default: 
            break;
          case 0: 
            localat.a();
            localat.b = System.currentTimeMillis();
            paramMessage = new as(localat.h, 0, localbc.i, localbc.j, localbc.k, localbc.l);
            localat.d.add(paramMessage);
            break;
            bool = false;
            break label89;
          }
        }
        localat.a();
        continue;
        int i;
        if (localat.b != -1L)
        {
          i = 1;
          label253:
          if (i == 0) {
            break label311;
          }
          paramMessage = new as(localat.h, 2, localbc.i, localbc.j, localbc.k, localbc.l);
        }
        for (;;)
        {
          localat.d.add(paramMessage);
          break;
          i = 0;
          break label253;
          label311:
          localat.a();
          paramMessage = new as(localat.h, 0, localbc.i, localbc.j, localbc.k, localbc.l);
          localat.b = System.currentTimeMillis();
        }
        long l = localat.b;
        localat.c = (System.currentTimeMillis() - l);
        paramMessage = new as(localat.h, 1, localbc.i, localbc.j, localbc.k, localbc.l);
        localat.d.add(paramMessage);
        paramMessage = aq.a(localat.h, localat.d);
        paramMessage = aq.a(localat.h, localat.b, localat.c, paramMessage);
        if ((localat.f) || (localat.g)) {
          aq.a(localat.h, localat.e, localat.a, 2, paramMessage);
        }
        for (;;)
        {
          localat.a();
          break;
          aq.a(localat.h, localat.e, localat.a, 1, paramMessage);
        }
      }
    }
    localbc.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.bb
 * JD-Core Version:    0.7.0.1
 */