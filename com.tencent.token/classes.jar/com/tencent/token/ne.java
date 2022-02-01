package com.tencent.token;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class ne
  extends BroadcastReceiver
{
  ne(nd paramnd) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    try
    {
      kx.a().a(new nd.b(this.a, paramIntent));
      return;
    }
    catch (Throwable paramContext) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ne
 * JD-Core Version:    0.7.0.1
 */