package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

final class aqy
  extends Handler
{
  private WeakReference a = null;
  
  public aqy(aqu paramaqu)
  {
    super(paramaqu.a.getMainLooper());
    this.a = new WeakReference(paramaqu);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    paramMessage = (aqu)this.a.get();
    if (paramMessage == null) {
      return;
    }
    if (paramMessage.d != null) {
      paramMessage.d.e();
    }
    aqt.a(paramMessage.a, "com.tencent.tmsdk.HeartBeatPlot.ACTION_HEARTBEAT_PLOT_ALARM_CYCLE", paramMessage.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aqy
 * JD-Core Version:    0.7.0.1
 */