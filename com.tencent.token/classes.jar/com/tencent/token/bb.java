package com.tencent.token;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.halley.common.a;
import com.tencent.halley.common.c;

final class bb
  extends BroadcastReceiver
{
  bb(ax paramax) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    c.a("AccessSchedulerTrigger", "onAccessSchedulerTriggered by timer, curTime:" + System.currentTimeMillis());
    a.a().a(new ay(this.a, (byte)0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.bb
 * JD-Core Version:    0.7.0.1
 */