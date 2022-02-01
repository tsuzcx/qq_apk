package com.tencent.token;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.halley.common.a;
import com.tencent.halley.common.b;

final class av
  extends BroadcastReceiver
{
  av(at paramat) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = new StringBuilder("onAccessSchedulerTriggered by timer, curTime:");
    paramContext.append(System.currentTimeMillis());
    b.a("AccessSchedulerTrigger", paramContext.toString());
    a.a().a(new at.a(this.a, (byte)0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.av
 * JD-Core Version:    0.7.0.1
 */