package com.tencent.token;

import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

final class bs
  implements Runnable
{
  bs(bq parambq, fs paramfs) {}
  
  public final void run()
  {
    Object localObject2 = (Future)bq.a(this.b).remove(this.a);
    if (localObject2 == null) {}
    for (;;)
    {
      return;
      ((Future)localObject2).cancel(true);
      Object localObject1 = new d((byte)0);
      try
      {
        localObject2 = (d)((Future)localObject2).get();
        try
        {
          if ((this.a.e) || (this.a.d == null)) {
            continue;
          }
          localObject1 = this.a.d.obtainMessage(this.a.f);
          ((Message)localObject1).arg1 = ((d)localObject2).a;
          ((Message)localObject1).obj = localObject2;
          ((Message)localObject1).sendToTarget();
          this.a.e = true;
          return;
        }
        catch (Exception localException1)
        {
          return;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException = localInterruptedException;
        e.b("task interrupted because timeout, tag=" + this.a.i);
        localException1.a(200, null, null);
        try
        {
          if ((this.a.e) || (this.a.d == null)) {
            continue;
          }
          Message localMessage1 = this.a.d.obtainMessage(this.a.f);
          localMessage1.arg1 = localException1.a;
          localMessage1.obj = localException1;
          localMessage1.sendToTarget();
          this.a.e = true;
          return;
        }
        catch (Exception localException2)
        {
          return;
        }
      }
      catch (ExecutionException localExecutionException)
      {
        localExecutionException = localExecutionException;
        e.b("task interrupted because local bug, tag=" + this.a.i);
        localException2.a(10000, "Exception:" + localExecutionException.toString(), null);
        try
        {
          if ((this.a.e) || (this.a.d == null)) {
            continue;
          }
          Message localMessage2 = this.a.d.obtainMessage(this.a.f);
          localMessage2.arg1 = localException2.a;
          localMessage2.obj = localException2;
          localMessage2.sendToTarget();
          this.a.e = true;
          return;
        }
        catch (Exception localException3)
        {
          return;
        }
      }
      catch (CancellationException localCancellationException)
      {
        localCancellationException = localCancellationException;
        e.b("task cancelled because timeout, tag=" + this.a.i);
        localException3.a(200, null, null);
        try
        {
          if ((this.a.e) || (this.a.d == null)) {
            continue;
          }
          Message localMessage3 = this.a.d.obtainMessage(this.a.f);
          localMessage3.arg1 = localException3.a;
          localMessage3.obj = localException3;
          localMessage3.sendToTarget();
          this.a.e = true;
          return;
        }
        catch (Exception localException4)
        {
          return;
        }
      }
      catch (Exception localException7)
      {
        localException7 = localException7;
        e.b("task interrupted because local bug, tag=" + this.a.i);
        localException4.a(10000, "Exception:" + localException7.toString(), null);
        try
        {
          if ((this.a.e) || (this.a.d == null)) {
            continue;
          }
          Message localMessage4 = this.a.d.obtainMessage(this.a.f);
          localMessage4.arg1 = localException4.a;
          localMessage4.obj = localException4;
          localMessage4.sendToTarget();
          this.a.e = true;
          return;
        }
        catch (Exception localException5)
        {
          return;
        }
      }
      finally {}
      try
      {
        if (!this.a.e)
        {
          if (this.a.d == null) {
            continue;
          }
          Message localMessage5 = this.a.d.obtainMessage(this.a.f);
          localMessage5.arg1 = localException5.a;
          localMessage5.obj = localException5;
          localMessage5.sendToTarget();
          this.a.e = true;
        }
        label640:
        throw localObject3;
      }
      catch (Exception localException6)
      {
        break label640;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.bs
 * JD-Core Version:    0.7.0.1
 */