package com.tencent.token;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class nz
  extends BroadcastReceiver
{
  nz(nx paramnx) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = new StringBuilder("onAccessSchedulerTriggered by timer, curTime:");
    paramContext.append(System.currentTimeMillis());
    mc.a("AccessSchedulerTrigger", paramContext.toString());
    lr.a().a(new nx.a(this.a, (byte)0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.nz
 * JD-Core Version:    0.7.0.1
 */