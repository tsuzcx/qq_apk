package com.tencent.token;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import tmsdk.common.d.a.c.j;

final class arl
  extends Handler
{
  private boolean b = false;
  
  arl(aso paramaso, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if (aso.c(this.a).a()) {
      return;
    }
    paramMessage = (ary)aso.c(this.a).c();
    if (paramMessage == null) {
      return;
    }
    if (!aso.d(this.a).c())
    {
      aso.f(this.a).a(aso.e(this.a));
      localObject = aso.d(this.a);
      boolean bool;
      if (aqz.a()) {
        bool = false;
      } else {
        bool = ((ate)localObject).b.a(((ate)localObject).c, ((ate)localObject).d);
      }
      if (!bool)
      {
        aso.a(this.a, paramMessage, -2);
        return;
      }
    }
    this.b = paramMessage.d;
    Object localObject = paramMessage.e;
    aj localaj = aso.a(this.a, paramMessage.b);
    if (localaj == null)
    {
      aso.a(this.a, paramMessage, -609);
      return;
    }
    localaj.b = paramMessage.a;
    int i;
    if (localObject == null)
    {
      i = aso.d(this.a).a(localaj);
    }
    else
    {
      ((aik)localObject).a(1);
      if (((aik)localObject).a) {
        return;
      }
      i = aso.d(this.a).a(localaj);
      ((aik)localObject).a(2);
    }
    if (i != 0)
    {
      aso.a(this.a, paramMessage, i - 3);
      return;
    }
    if (!this.b)
    {
      paramMessage = aso.d(this.a);
      if (paramMessage.f)
      {
        paramMessage = paramMessage.g;
        asp.a(paramMessage.a, "com.tencent.tmsdk.HeartBeatPlot.ACTION_HEARTBEAT_PLOT_ALARM_CYCLE");
        asp.a(paramMessage.a, "com.tencent.tmsdk.HeartBeatPlot.ACTION_HEARTBEAT_PLOT_ALARM_CYCLE", paramMessage.c);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.arl
 * JD-Core Version:    0.7.0.1
 */