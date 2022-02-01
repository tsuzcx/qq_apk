package com.tencent.token;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.halley.common.a;

final class at
  extends BroadcastReceiver
{
  at(as paramas) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    try
    {
      a.a().a(new as.b(this.a, paramIntent));
      return;
    }
    catch (Throwable paramContext) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.at
 * JD-Core Version:    0.7.0.1
 */