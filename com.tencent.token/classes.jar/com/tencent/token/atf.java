package com.tencent.token;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;

final class atf
  extends Handler
{
  atf(ate paramate, Looper paramLooper)
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
      localObject1 = (atg)???[0];
      ((atg)localObject1).f.a(((atg)localObject1).g, ((atg)localObject1).b, ((Integer)???[1]).intValue(), ((Integer)???[2]).intValue(), ((atg)localObject1).d);
      return;
    }
    ate.a(this.a).removeMessages(1);
    Object localObject1 = new ath(this.a, (byte)0);
    synchronized (ate.b(this.a))
    {
      Iterator localIterator = ate.b(this.a).iterator();
      while (localIterator.hasNext())
      {
        atg localatg = (atg)localIterator.next();
        if ((localatg.e & 0x40000000) == 0)
        {
          if (!localatg.h.a)
          {
            int i = localatg.g;
            ((ath)localObject1).a.put(Integer.valueOf(i), localatg);
          }
        }
        else {
          ((ath)localObject1).b.add(localatg);
        }
      }
      ate.b(this.a).clear();
      ate.c(this.a).submit((Runnable)localObject1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.atf
 * JD-Core Version:    0.7.0.1
 */