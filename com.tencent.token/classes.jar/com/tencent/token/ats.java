package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

final class ats
  extends Handler
{
  private WeakReference a = null;
  
  public ats(ato paramato)
  {
    super(paramato.a.getMainLooper());
    this.a = new WeakReference(paramato);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    paramMessage = (ato)this.a.get();
    if (paramMessage == null) {
      return;
    }
    if (paramMessage.d != null) {
      paramMessage.d.e();
    }
    atn.a(paramMessage.a, "com.tencent.tmsdk.HeartBeatPlot.ACTION_HEARTBEAT_PLOT_ALARM_CYCLE", paramMessage.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ats
 * JD-Core Version:    0.7.0.1
 */