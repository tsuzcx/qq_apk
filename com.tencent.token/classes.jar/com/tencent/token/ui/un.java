package com.tencent.token.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class un
  extends BroadcastReceiver
{
  un(RealNameActivity paramRealNameActivity) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent.getAction().equals("com.tencent.token.realname.AUDIT_INTERVAL4");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.un
 * JD-Core Version:    0.7.0.1
 */