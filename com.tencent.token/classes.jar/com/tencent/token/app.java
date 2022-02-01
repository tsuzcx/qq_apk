package com.tencent.token;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import tmsdk.common.d.a.c.j;

final class app
  extends Handler
{
  private boolean b = false;
  
  app(aqs paramaqs, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if (aqs.c(this.a).a()) {
      return;
    }
    paramMessage = (aqc)aqs.c(this.a).c();
    if (paramMessage == null) {
      return;
    }
    if (!aqs.d(this.a).c())
    {
      aqs.f(this.a).a(aqs.e(this.a));
      localObject = aqs.d(this.a);
      boolean bool;
      if (apd.a()) {
        bool = false;
      } else {
        bool = ((ari)localObject).b.a(((ari)localObject).c, ((ari)localObject).d);
      }
      if (!bool)
      {
        aqs.a(this.a, paramMessage, -2);
        return;
      }
    }
    this.b = paramMessage.d;
    Object localObject = paramMessage.e;
    aj localaj = aqs.a(this.a, paramMessage.b);
    if (localaj == null)
    {
      aqs.a(this.a, paramMessage, -609);
      return;
    }
    localaj.b = paramMessage.a;
    int i;
    if (localObject == null)
    {
      i = aqs.d(this.a).a(localaj);
    }
    else
    {
      ((agz)localObject).a(1);
      if (((agz)localObject).a) {
        return;
      }
      i = aqs.d(this.a).a(localaj);
      ((agz)localObject).a(2);
    }
    if (i != 0)
    {
      aqs.a(this.a, paramMessage, i - 3);
      return;
    }
    if (!this.b)
    {
      paramMessage = aqs.d(this.a);
      if (paramMessage.f)
      {
        paramMessage = paramMessage.g;
        aqt.a(paramMessage.a, "com.tencent.tmsdk.HeartBeatPlot.ACTION_HEARTBEAT_PLOT_ALARM_CYCLE");
        aqt.a(paramMessage.a, "com.tencent.tmsdk.HeartBeatPlot.ACTION_HEARTBEAT_PLOT_ALARM_CYCLE", paramMessage.c);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.app
 * JD-Core Version:    0.7.0.1
 */