package com.tencent.token;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class ne
  extends BroadcastReceiver
{
  ne(nc paramnc) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = new StringBuilder("onAccessSchedulerTriggered by timer, curTime:");
    paramContext.append(System.currentTimeMillis());
    lh.a("AccessSchedulerTrigger", paramContext.toString());
    kw.a().a(new nc.a(this.a, (byte)0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ne
 * JD-Core Version:    0.7.0.1
 */