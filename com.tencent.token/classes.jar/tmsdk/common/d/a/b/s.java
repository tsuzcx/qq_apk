package tmsdk.common.d.a.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.token.eh;
import com.tencent.token.ek;
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
    case 2: 
      ??? = (Object[])???.obj;
      localObject1 = (t)???[0];
      ((t)localObject1).f.a(((t)localObject1).g, ((t)localObject1).b, ((Integer)???[1]).intValue(), ((Integer)???[2]).intValue(), ((t)localObject1).d);
      return;
    }
    r.a(this.a).removeMessages(1);
    Object localObject1 = new u(this.a, null);
    synchronized (r.b(this.a))
    {
      Iterator localIterator = r.b(this.a).iterator();
      while (localIterator.hasNext())
      {
        t localt = (t)localIterator.next();
        if ((localt.e & 0x40000000) == 0)
        {
          if (!localt.h.a()) {
            ((u)localObject1).a(Integer.valueOf(localt.g), localt);
          }
        }
        else {
          ((u)localObject1).a.add(localt);
        }
      }
      r.b(this.a).clear();
      r.c(this.a).submit((Runnable)localObject1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.d.a.b.s
 * JD-Core Version:    0.7.0.1
 */