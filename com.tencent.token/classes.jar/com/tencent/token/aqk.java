package com.tencent.token;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;

final class aqk
  extends Handler
{
  aqk(aqj paramaqj, Looper paramLooper)
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
      localObject1 = (aql)???[0];
      ((aql)localObject1).f.a(((aql)localObject1).g, ((aql)localObject1).b, ((Integer)???[1]).intValue(), ((Integer)???[2]).intValue(), ((aql)localObject1).d);
      return;
    }
    aqj.a(this.a).removeMessages(1);
    Object localObject1 = new aqm(this.a, (byte)0);
    synchronized (aqj.b(this.a))
    {
      Iterator localIterator = aqj.b(this.a).iterator();
      while (localIterator.hasNext())
      {
        aql localaql = (aql)localIterator.next();
        if ((localaql.e & 0x40000000) == 0)
        {
          if (!localaql.h.a)
          {
            int i = localaql.g;
            ((aqm)localObject1).a.put(Integer.valueOf(i), localaql);
          }
        }
        else {
          ((aqm)localObject1).b.add(localaql);
        }
      }
      aqj.b(this.a).clear();
      aqj.c(this.a).submit((Runnable)localObject1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aqk
 * JD-Core Version:    0.7.0.1
 */