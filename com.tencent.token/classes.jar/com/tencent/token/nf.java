package com.tencent.token;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class nf
  extends BroadcastReceiver
{
  nf(nd paramnd) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = new StringBuilder("onAccessSchedulerTriggered by timer, curTime:");
    paramContext.append(System.currentTimeMillis());
    li.a("AccessSchedulerTrigger", paramContext.toString());
    kx.a().a(new nd.a(this.a, (byte)0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.nf
 * JD-Core Version:    0.7.0.1
 */