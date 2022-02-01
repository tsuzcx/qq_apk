package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

final class asu
  extends Handler
{
  private WeakReference a = null;
  
  public asu(asq paramasq)
  {
    super(paramasq.a.getMainLooper());
    this.a = new WeakReference(paramasq);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    paramMessage = (asq)this.a.get();
    if (paramMessage == null) {
      return;
    }
    if (paramMessage.d != null) {
      paramMessage.d.e();
    }
    asp.a(paramMessage.a, "com.tencent.tmsdk.HeartBeatPlot.ACTION_HEARTBEAT_PLOT_ALARM_CYCLE", paramMessage.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.asu
 * JD-Core Version:    0.7.0.1
 */