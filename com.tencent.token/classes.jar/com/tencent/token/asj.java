package com.tencent.token;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import tmsdk.common.d.a.c.j;

final class asj
  extends Handler
{
  private boolean b = false;
  
  asj(atm paramatm, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if (atm.c(this.a).a()) {
      return;
    }
    paramMessage = (asw)atm.c(this.a).c();
    if (paramMessage == null) {
      return;
    }
    if (!atm.d(this.a).c())
    {
      atm.f(this.a).a(atm.e(this.a));
      localObject = atm.d(this.a);
      boolean bool;
      if (arx.a()) {
        bool = false;
      } else {
        bool = ((auc)localObject).b.a(((auc)localObject).c, ((auc)localObject).d);
      }
      if (!bool)
      {
        atm.a(this.a, paramMessage, -2);
        return;
      }
    }
    this.b = paramMessage.d;
    Object localObject = paramMessage.e;
    ax localax = atm.a(this.a, paramMessage.b);
    if (localax == null)
    {
      atm.a(this.a, paramMessage, -609);
      return;
    }
    localax.b = paramMessage.a;
    int i;
    if (localObject == null)
    {
      i = atm.d(this.a).a(localax);
    }
    else
    {
      ((ajk)localObject).a(1);
      if (((ajk)localObject).a) {
        return;
      }
      i = atm.d(this.a).a(localax);
      ((ajk)localObject).a(2);
    }
    if (i != 0)
    {
      atm.a(this.a, paramMessage, i - 3);
      return;
    }
    if (!this.b)
    {
      paramMessage = atm.d(this.a);
      if (paramMessage.f)
      {
        paramMessage = paramMessage.g;
        atn.a(paramMessage.a, "com.tencent.tmsdk.HeartBeatPlot.ACTION_HEARTBEAT_PLOT_ALARM_CYCLE");
        atn.a(paramMessage.a, "com.tencent.tmsdk.HeartBeatPlot.ACTION_HEARTBEAT_PLOT_ALARM_CYCLE", paramMessage.c);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.asj
 * JD-Core Version:    0.7.0.1
 */