package com.tencent.token;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class nk
  extends BroadcastReceiver
{
  nk(nj paramnj) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    try
    {
      ld.a().a(new nj.b(this.a, paramIntent));
      return;
    }
    catch (Throwable paramContext) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.nk
 * JD-Core Version:    0.7.0.1
 */