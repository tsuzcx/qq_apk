package com.tencent.token.core.protocolcenter;

import android.os.Handler;
import android.os.Message;
import com.tencent.token.ev;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

class l
  implements Runnable
{
  l(i parami, String paramString) {}
  
  public void run()
  {
    Iterator localIterator = i.a(this.b).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (Map.Entry)localIterator.next();
      Object localObject4 = (Future)((Map.Entry)localObject1).getValue();
      localObject1 = (ev)((Map.Entry)localObject1).getKey();
      if ((((ev)localObject1).i != null) && (this.a != null) && (((ev)localObject1).i.contains(this.a)))
      {
        localIterator.remove();
        ((Future)localObject4).cancel(true);
        Object localObject3 = new f();
        try
        {
          localObject4 = (f)((Future)localObject4).get();
          if (!((ev)localObject1).e)
          {
            localObject3 = ((ev)localObject1).d.obtainMessage(2002);
            ((Message)localObject3).arg1 = ((f)localObject4).a;
            ((Message)localObject3).obj = localObject4;
            ((Message)localObject3).sendToTarget();
            ((ev)localObject1).e = true;
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          h.b("task interrupted because cancel, tag=" + ((ev)localObject1).i);
          ((f)localObject3).b(10024);
          if (!((ev)localObject1).e)
          {
            Message localMessage1 = ((ev)localObject1).d.obtainMessage(2002);
            localMessage1.arg1 = ((f)localObject3).a;
            localMessage1.obj = localObject3;
            localMessage1.sendToTarget();
            ((ev)localObject1).e = true;
          }
        }
        catch (ExecutionException localExecutionException)
        {
          ((f)localObject3).a(10000, "Exception:" + localExecutionException.toString());
          if (!((ev)localObject1).e)
          {
            Message localMessage2 = ((ev)localObject1).d.obtainMessage(2002);
            localMessage2.arg1 = ((f)localObject3).a;
            localMessage2.obj = localObject3;
            localMessage2.sendToTarget();
            ((ev)localObject1).e = true;
          }
        }
        catch (CancellationException localCancellationException)
        {
          h.b("task cancelled because cancel, tag=" + ((ev)localObject1).i);
          ((f)localObject3).b(10024);
          if (!((ev)localObject1).e)
          {
            Message localMessage3 = ((ev)localObject1).d.obtainMessage(2002);
            localMessage3.arg1 = ((f)localObject3).a;
            localMessage3.obj = localObject3;
            localMessage3.sendToTarget();
            ((ev)localObject1).e = true;
          }
        }
        catch (Exception localException)
        {
          ((f)localObject3).a(10000, "Exception:" + localException.toString());
          if (!((ev)localObject1).e)
          {
            localMessage4 = ((ev)localObject1).d.obtainMessage(2002);
            localMessage4.arg1 = ((f)localObject3).a;
            localMessage4.obj = localObject3;
            localMessage4.sendToTarget();
            ((ev)localObject1).e = true;
          }
        }
        finally
        {
          Message localMessage4;
          if (!((ev)localObject1).e)
          {
            localMessage4 = ((ev)localObject1).d.obtainMessage(2002);
            localMessage4.arg1 = ((f)localObject3).a;
            localMessage4.obj = localObject3;
            localMessage4.sendToTarget();
            ((ev)localObject1).e = true;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.l
 * JD-Core Version:    0.7.0.1
 */