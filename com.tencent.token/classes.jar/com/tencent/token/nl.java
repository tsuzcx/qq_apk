package com.tencent.token;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class nl
  extends BroadcastReceiver
{
  nl(nj paramnj) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = new StringBuilder("onAccessSchedulerTriggered by timer, curTime:");
    paramContext.append(System.currentTimeMillis());
    lo.a("AccessSchedulerTrigger", paramContext.toString());
    ld.a().a(new nj.a(this.a, (byte)0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.nl
 * JD-Core Version:    0.7.0.1
 */