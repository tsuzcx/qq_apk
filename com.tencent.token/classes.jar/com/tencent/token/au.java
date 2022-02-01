package com.tencent.token;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.halley.common.a;

final class au
  extends BroadcastReceiver
{
  au(at paramat) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    try
    {
      a.a().a(new at.b(this.a, paramIntent));
      return;
    }
    catch (Throwable paramContext) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.au
 * JD-Core Version:    0.7.0.1
 */