package com.tencent.token;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;

final class aql
  extends Handler
{
  aql(aqk paramaqk, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message arg1)
  {
    switch (???.what)
    {
    default: 
      return;
    case 2: 
      ??? = (Object[])???.obj;
      localObject1 = (aqm)???[0];
      ((aqm)localObject1).f.a(((aqm)localObject1).g, ((aqm)localObject1).b, ((Integer)???[1]).intValue(), ((Integer)???[2]).intValue(), ((aqm)localObject1).d);
      return;
    }
    aqk.a(this.a).removeMessages(1);
    Object localObject1 = new aqn(this.a, (byte)0);
    synchronized (aqk.b(this.a))
    {
      Iterator localIterator = aqk.b(this.a).iterator();
      while (localIterator.hasNext())
      {
        aqm localaqm = (aqm)localIterator.next();
        if ((localaqm.e & 0x40000000) == 0)
        {
          if (!localaqm.h.a)
          {
            int i = localaqm.g;
            ((aqn)localObject1).a.put(Integer.valueOf(i), localaqm);
          }
        }
        else {
          ((aqn)localObject1).b.add(localaqm);
        }
      }
      aqk.b(this.a).clear();
      aqk.c(this.a).submit((Runnable)localObject1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aql
 * JD-Core Version:    0.7.0.1
 */