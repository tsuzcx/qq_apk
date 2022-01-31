package com.tencent.qqpimsecure.pg;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class v
  extends BroadcastReceiver
{
  v(r paramr) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    r.a(this.a, paramIntent.getIntegerArrayListExtra("up"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.qqpimsecure.pg.v
 * JD-Core Version:    0.7.0.1
 */