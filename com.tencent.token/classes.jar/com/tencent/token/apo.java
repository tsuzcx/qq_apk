package com.tencent.token;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import tmsdk.common.d.a.c.j;

final class apo
  extends Handler
{
  private boolean b = false;
  
  apo(aqr paramaqr, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if (aqr.c(this.a).a()) {
      return;
    }
    paramMessage = (aqb)aqr.c(this.a).c();
    if (paramMessage == null) {
      return;
    }
    if (!aqr.d(this.a).c())
    {
      aqr.f(this.a).a(aqr.e(this.a));
      localObject = aqr.d(this.a);
      boolean bool;
      if (apc.a()) {
        bool = false;
      } else {
        bool = ((arh)localObject).b.a(((arh)localObject).c, ((arh)localObject).d);
      }
      if (!bool)
      {
        aqr.a(this.a, paramMessage, -2);
        return;
      }
    }
    this.b = paramMessage.d;
    Object localObject = paramMessage.e;
    aj localaj = aqr.a(this.a, paramMessage.b);
    if (localaj == null)
    {
      aqr.a(this.a, paramMessage, -609);
      return;
    }
    localaj.b = paramMessage.a;
    int i;
    if (localObject == null)
    {
      i = aqr.d(this.a).a(localaj);
    }
    else
    {
      ((agy)localObject).a(1);
      if (((agy)localObject).a) {
        return;
      }
      i = aqr.d(this.a).a(localaj);
      ((agy)localObject).a(2);
    }
    if (i != 0)
    {
      aqr.a(this.a, paramMessage, i - 3);
      return;
    }
    if (!this.b)
    {
      paramMessage = aqr.d(this.a);
      if (paramMessage.f)
      {
        paramMessage = paramMessage.g;
        aqs.a(paramMessage.a, "com.tencent.tmsdk.HeartBeatPlot.ACTION_HEARTBEAT_PLOT_ALARM_CYCLE");
        aqs.a(paramMessage.a, "com.tencent.tmsdk.HeartBeatPlot.ACTION_HEARTBEAT_PLOT_ALARM_CYCLE", paramMessage.c);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.apo
 * JD-Core Version:    0.7.0.1
 */