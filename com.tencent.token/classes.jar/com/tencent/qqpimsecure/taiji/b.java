package com.tencent.qqpimsecure.taiji;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import taiji.cl;

class b
  extends BroadcastReceiver
{
  b(a parama) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    cl.b("TaijiDao", "on receive ACTION_ON_GOT_ADS");
    if ("act_got_ads".equals(paramIntent.getAction())) {
      a.a(this.a, f.a().a(a.a(this.a), "tj", a.b(this.a)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.qqpimsecure.taiji.b
 * JD-Core Version:    0.7.0.1
 */