package com.tencent.token;

import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

final class bt
  implements Runnable
{
  bt(bq parambq, String paramString) {}
  
  public final void run()
  {
    Iterator localIterator = bq.a(this.b).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (Map.Entry)localIterator.next();
      Object localObject4 = (Future)((Map.Entry)localObject1).getValue();
      localObject1 = (fs)((Map.Entry)localObject1).getKey();
      if ((((fs)localObject1).i != null) && (this.a != null) && (((fs)localObject1).i.contains(this.a)))
      {
        localIterator.remove();
        ((Future)localObject4).cancel(true);
        Object localObject3 = new d((byte)0);
        try
        {
          localObject4 = (d)((Future)localObject4).get();
          if (!((fs)localObject1).e)
          {
            localObject3 = ((fs)localObject1).d.obtainMessage(2002);
            ((Message)localObject3).arg1 = ((d)localObject4).a;
            ((Message)localObject3).obj = localObject4;
            ((Message)localObject3).sendToTarget();
            ((fs)localObject1).e = true;
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          e.b("task interrupted because cancel, tag=" + ((fs)localObject1).i);
          ((d)localObject3).a(10024, null, null);
          if (!((fs)localObject1).e)
          {
            Message localMessage1 = ((fs)localObject1).d.obtainMessage(2002);
            localMessage1.arg1 = ((d)localObject3).a;
            localMessage1.obj = localObject3;
            localMessage1.sendToTarget();
            ((fs)localObject1).e = true;
          }
        }
        catch (ExecutionException localExecutionException)
        {
          ((d)localObject3).a(10000, "Exception:" + localExecutionException.toString(), null);
          if (!((fs)localObject1).e)
          {
            Message localMessage2 = ((fs)localObject1).d.obtainMessage(2002);
            localMessage2.arg1 = ((d)localObject3).a;
            localMessage2.obj = localObject3;
            localMessage2.sendToTarget();
            ((fs)localObject1).e = true;
          }
        }
        catch (CancellationException localCancellationException)
        {
          e.b("task cancelled because cancel, tag=" + ((fs)localObject1).i);
          ((d)localObject3).a(10024, null, null);
          if (!((fs)localObject1).e)
          {
            Message localMessage3 = ((fs)localObject1).d.obtainMessage(2002);
            localMessage3.arg1 = ((d)localObject3).a;
            localMessage3.obj = localObject3;
            localMessage3.sendToTarget();
            ((fs)localObject1).e = true;
          }
        }
        catch (Exception localException)
        {
          ((d)localObject3).a(10000, "Exception:" + localException.toString(), null);
          if (!((fs)localObject1).e)
          {
            localMessage4 = ((fs)localObject1).d.obtainMessage(2002);
            localMessage4.arg1 = ((d)localObject3).a;
            localMessage4.obj = localObject3;
            localMessage4.sendToTarget();
            ((fs)localObject1).e = true;
          }
        }
        finally
        {
          Message localMessage4;
          if (!((fs)localObject1).e)
          {
            localMessage4 = ((fs)localObject1).d.obtainMessage(2002);
            localMessage4.arg1 = ((d)localObject3).a;
            localMessage4.obj = localObject3;
            localMessage4.sendToTarget();
            ((fs)localObject1).e = true;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.bt
 * JD-Core Version:    0.7.0.1
 */