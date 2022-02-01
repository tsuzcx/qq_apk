package com.tencent.token;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;

final class asr
  extends BroadcastReceiver
{
  asr(asq paramasq) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {
      return;
    }
    if (paramContext.equals("com.tencent.tmsdk.HeartBeatPlot.ACTION_HEARTBEAT_PLOT_ALARM_CYCLE")) {
      this.a.b.sendEmptyMessage(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.asr
 * JD-Core Version:    0.7.0.1
 */