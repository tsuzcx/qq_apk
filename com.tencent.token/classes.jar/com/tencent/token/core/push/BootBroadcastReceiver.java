package com.tencent.token.core.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;

public class BootBroadcastReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    g.c("android boot completed");
    if (paramIntent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
      l.i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.push.BootBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */