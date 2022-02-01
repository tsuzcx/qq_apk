package tmsdk.common.d.a.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.token.ee;
import com.tencent.token.eh;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;

class s
  extends Handler
{
  s(r paramr, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message arg1)
  {
    switch (???.what)
    {
    default: 
      return;
    case 1: 
      r.a(this.a).removeMessages(1);
      u localu = new u(this.a, null);
      for (;;)
      {
        t localt2;
        synchronized (r.b(this.a))
        {
          Iterator localIterator = r.b(this.a).iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          localt2 = (t)localIterator.next();
          if ((localt2.e & 0x40000000) == 0)
          {
            if (localt2.h.a()) {
              continue;
            }
            localu.a(Integer.valueOf(localt2.g), localt2);
          }
        }
        localRunnable.a.add(localt2);
      }
      r.b(this.a).clear();
      r.c(this.a).submit(localRunnable);
      return;
    }
    ??? = (Object[])???.obj;
    t localt1 = (t)???[0];
    localt1.f.a(localt1.g, localt1.b, ((Integer)???[1]).intValue(), ((Integer)???[2]).intValue(), localt1.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.d.a.b.s
 * JD-Core Version:    0.7.0.1
 */