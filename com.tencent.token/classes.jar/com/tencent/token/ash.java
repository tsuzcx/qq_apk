package com.tencent.token;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;

final class ash
  extends Handler
{
  ash(asg paramasg, Looper paramLooper)
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
      localObject1 = (asi)???[0];
      ((asi)localObject1).f.a(((asi)localObject1).g, ((asi)localObject1).b, ((Integer)???[1]).intValue(), ((Integer)???[2]).intValue(), ((asi)localObject1).d);
      return;
    }
    asg.a(this.a).removeMessages(1);
    Object localObject1 = new asj(this.a, (byte)0);
    synchronized (asg.b(this.a))
    {
      Iterator localIterator = asg.b(this.a).iterator();
      while (localIterator.hasNext())
      {
        asi localasi = (asi)localIterator.next();
        if ((localasi.e & 0x40000000) == 0)
        {
          if (!localasi.h.a)
          {
            int i = localasi.g;
            ((asj)localObject1).a.put(Integer.valueOf(i), localasi);
          }
        }
        else {
          ((asj)localObject1).b.add(localasi);
        }
      }
      asg.b(this.a).clear();
      asg.c(this.a).submit((Runnable)localObject1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ash
 * JD-Core Version:    0.7.0.1
 */